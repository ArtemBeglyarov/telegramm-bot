package ru.telegram.bot.servise;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.telegram.bot.config.BotConfig;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;


@Component
@RequiredArgsConstructor
public class TelegramBot extends TelegramLongPollingBot {

    private final BotConfig botConfig;
    private final MessageProcessing messageProcessing;

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

        Map<String, Class<?>> classForCommand = new HashMap<>();

        CompletableFuture.runAsync(() -> {
            var command = messageProcessing.getCommand(update).getMethod();
//            var b = (classForCommand.get(command)) messageProcessing.getCommand(update);
            System.out.println();
        });
    }
}
