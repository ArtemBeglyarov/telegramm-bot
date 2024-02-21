package ru.telegram.bot.servise;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendAnimation;
import org.telegram.telegrambots.meta.api.methods.send.SendAudio;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendSticker;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.telegram.bot.config.BotConfig;

import java.io.File;
import java.util.concurrent.CompletableFuture;


@Component
@AllArgsConstructor
public class TelegramBot extends TelegramLongPollingBot {

    private final BotConfig botConfig;

    @Override
    public String getBotUsername() {
        return botConfig.getName();
    }

    @Override
    public String getBotToken() {
        return botConfig.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {

        CompletableFuture.runAsync(() -> {
            getStringCommand(update);
        });


    }

    private void getStringCommand(Update update) {
        String message = ObjectUtils.allNotNull(update.hasMessage(), update.getMessage().hasText())
                ? update.getMessage().getText().toLowerCase() : null;

        String chatId = update.getMessage().getChatId().toString();
        String firstName = update.getMessage().getFrom().getUserName();


        switch (message) {

            case "/start":
                startCommand(chatId, update.getMessage().getChat().getFirstName());
                break;
            case "/rat":
                spinRat(chatId);
                break;
            case "/frog":
                spinFrog(chatId);
                break;
            case "/surrender":
                surrender(chatId, firstName);
                break;
            case "/latch":
                latch(chatId);
                break;
            case "/scream":
                scream(chatId);
                break;
        }
    }

    private void startCommand(String chatId, String firstName) {
        String start = "Hello " + firstName;
        sendMessage(chatId, start);
    }

    @SneakyThrows
    private void spinRat(String chatId) {
        SendAnimation sendAnimation = new SendAnimation();
        File file = new File("src\\main\\resources\\image\\rat-spinning.gif");
        InputFile inputFile = new InputFile(file);
        sendAnimation.setAnimation(inputFile);
        sendAnimation.setChatId(chatId);
        execute(sendAnimation);
    }

    @SneakyThrows
    private void spinFrog(String chatId) {
        SendAnimation sendAnimation = new SendAnimation();
        File file = new File("src\\main\\resources\\image\\frog-spin-frog.gif");
        InputFile inputFile = new InputFile(file);
        sendAnimation.setAnimation(inputFile);
        sendAnimation.setChatId(chatId);
        execute(sendAnimation);

    }

    @SneakyThrows
    private void latch(String chatId) {
        SendAudio audio = new SendAudio();
        File file = new File("src\\main\\resources\\static\\ух ты бля.mp3");
        InputFile inputFile = new InputFile(file);
        audio.setAudio(inputFile);
        audio.setChatId(chatId);
        execute(audio);
    }

    @SneakyThrows
    private void scream(String chatId) {
        SendAudio audio = new SendAudio();
        File file = new File("src\\main\\resources\\static\\scream.mp3");
        InputFile inputFile = new InputFile(file);
        audio.setAudio(inputFile);
        audio.setChatId(chatId);
        execute(audio);
    }

    @SneakyThrows
    private void surrender(String chatId, String name) {
//        String sur = "@" + name + " вы официально сдались";
        String sur = "Пользователь @" + name + " официально сдался";
        sendMessage(chatId, sur);
    }

    @SneakyThrows
    private void sendMessage(String chatId, String textToSend) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);
        execute(message);
    }
}
