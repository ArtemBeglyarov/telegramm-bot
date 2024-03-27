package ru.telegram.bot.servise;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.telegram.bot.domain.Pack;
import ru.telegram.bot.repository.PackRepository;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class MessageProcessing {

    private final ServiceBot serviceBot;

    public PartialBotApiMethod<Message> getCommand(Update update) {
        String message = ObjectUtils.allNotNull(update.hasMessage(), update.getMessage().hasText())
                ? update.getMessage().getText().toLowerCase() : null;

        String chatId = update.getMessage().getChatId().toString();
        String firstName = update.getMessage().getFrom().getUserName();

        switch (message) {
            case "/start":
                return serviceBot.startCommand(chatId, update.getMessage().getChat().getFirstName());
            case "/rat":
                return serviceBot.spinRat(chatId);
            case "/frog":
                return serviceBot.spinFrog(chatId);
            case "/latch":
                return serviceBot.latch(chatId);
            case "/scream":
                return serviceBot.scream(chatId);
        }
        return null;
    }

}
