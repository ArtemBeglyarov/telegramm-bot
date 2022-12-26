package ru.telegram.bot.servise;

import lombok.SneakyThrows;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.methods.send.SendAnimation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.telegram.bot.config.BotConfig;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


@Component
public class TelegramBot extends TelegramLongPollingBot {


    final BotConfig botConfig;

    public TelegramBot(BotConfig botConfig) {
        this.botConfig = botConfig;
        List<BotCommand> listCommand = new ArrayList<>();
        listCommand.add(new BotCommand("/rat","spin Rat"));
        listCommand.add(new BotCommand("/frog","spin frog"));
        listCommand.add(new BotCommand("/comissar","spin comissar"));
        try {
            this.execute(new SetMyCommands(listCommand, new BotCommandScopeDefault(), null));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

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


        String message = ObjectUtils.allNotNull(update.hasMessage(), update.getMessage().hasText())
                ? update.getMessage().getText().toLowerCase() : null;

        String chatId = update.getMessage().getChatId().toString();

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
            case "/comissar":
                сomissar(chatId);
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
        File file = new File("C:\\Users\\abeglyarov\\Documents\\telegramm-bot\\src\\main\\resources\\image\\rat-spinning.gif");
        InputFile inputFile = new InputFile(file);
        sendAnimation.setAnimation(inputFile);
        sendAnimation.setChatId(chatId);
        execute(sendAnimation);
    }

    @SneakyThrows
    private void spinFrog(String chatId) {
        SendAnimation sendAnimation = new SendAnimation();
        File file = new File("C:\\Users\\abeglyarov\\Documents\\telegramm-bot\\src\\main\\resources\\image\\frog-spin-frog.gif");
        InputFile inputFile = new InputFile(file);
        sendAnimation.setAnimation(inputFile);
        sendAnimation.setChatId(chatId);
        execute(sendAnimation);

    }
    @SneakyThrows
    private void сomissar(String chatId) {
        SendAnimation sendAnimation = new SendAnimation();
        File file = new File("C:\\Users\\abeglyarov\\Documents\\telegramm-bot\\src\\main\\resources\\image\\сomissar.gif");
        InputFile inputFile = new InputFile(file);
        sendAnimation.setAnimation(inputFile);
        sendAnimation.setChatId(chatId);
        execute(sendAnimation);
    }

    private void sendMessage(String chatId, String textToSend) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }
}
