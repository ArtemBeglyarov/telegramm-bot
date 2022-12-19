package ru.telegram.bot.servise;

import lombok.SneakyThrows;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendAnimation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.telegram.bot.config.BotConfig;

import java.io.File;


@Component
public class TelegramBot extends TelegramLongPollingBot {


     final BotConfig botConfig;

    public TelegramBot(BotConfig botConfig) {
        this.botConfig = botConfig;
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
                ? update.getMessage().getText() : null;

        Long chatId = update.getMessage().getChatId();

        switch (message) {

            case "/start":
                startCommand(chatId, update.getMessage().getChat().getFirstName());
                break;
            case "/spin":
                spin(chatId);
                break;
        }
    }

    private void startCommand(Long chatId, String firstName) {
        String start = "Hello " + firstName;
        sendMessage(chatId, start);
    }

    @SneakyThrows
    private void spin(Long chatId) {
        SendAnimation sendAnimation = new SendAnimation();
        File file = new File("C:\\Users\\abeglyarov\\Documents\\telegramm-bot\\src\\main\\resources\\image\\rat-spinning.gif");
        InputFile inputFile = new InputFile(file);
        sendAnimation.setAnimation(inputFile);
        sendAnimation.setChatId(String.valueOf(chatId));
        execute(sendAnimation);

    }

    private void sendMessage(Long chatId, String textToSend) {
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
