package ru.telegram.bot.config;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 *
 */
@Configuration
@Data
public class BotConfig {

    @Value("${bot.name}")
    public String name;

    @Value("${bot.token}")
    public String token;
}
