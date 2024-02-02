package ru.telegram.bot.servise;

import lombok.SneakyThrows;
import org.telegram.telegrambots.meta.api.methods.send.SendAnimation;
import org.telegram.telegrambots.meta.api.methods.send.SendAudio;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import ru.telegram.bot.config.BotConfig;

import java.io.File;

public class ServiceBot extends TelegramBot {
    public ServiceBot(BotConfig botConfig) {
        super(botConfig);
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
    private void �ommissar(String chatId) {
        SendAnimation sendAnimation = new SendAnimation();
        File file = new File("src\\main\\resources\\image\\�omissar.gif");
        InputFile inputFile = new InputFile(file);
        sendAnimation.setAnimation(inputFile);
        sendAnimation.setChatId(chatId);
        execute(sendAnimation);
    }

    @SneakyThrows
    private void latch(String chatId) {
        SendAudio audio = new SendAudio();
        File file = new File("src\\main\\resources\\static\\�� �� ���.mp3");
        InputFile inputFile = new InputFile(file);
        audio.setAudio(inputFile);
        audio.setChatId(chatId);
        execute(audio);
    }

    @SneakyThrows
    private void surrender(String chatId, String name) {
//        String sur = "@" + name + " �� ���������� �������";
        String sur = "������������ @" + name + " ���������� ������";
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
