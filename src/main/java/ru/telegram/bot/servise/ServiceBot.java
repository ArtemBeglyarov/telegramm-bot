package ru.telegram.bot.servise;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendAnimation;
import org.telegram.telegrambots.meta.api.methods.send.SendAudio;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import ru.telegram.bot.domain.JavaSubject;
import ru.telegram.bot.domain.Subject;

import java.io.File;

@Component
@RequiredArgsConstructor
public class ServiceBot {


    public SendMessage startCommand(String chatId, String firstName) {
        String start = "Hello " + firstName;
         return sendMessage(chatId, start);
    }

    @SneakyThrows
    public SendAnimation spinRat(String chatId) {
        SendAnimation sendAnimation = new SendAnimation();
        File file = new File("src\\main\\resources\\image\\rat-spinning.gif");
        InputFile inputFile = new InputFile(file);
        sendAnimation.setAnimation(inputFile);
        sendAnimation.setChatId(chatId);
        return sendAnimation;
    }

    @SneakyThrows
    public SendAnimation spinFrog(String chatId) {
        SendAnimation sendAnimation = new SendAnimation();
        File file = new File("src\\main\\resources\\image\\frog-spin-frog.gif");
        InputFile inputFile = new InputFile(file);
        sendAnimation.setAnimation(inputFile);
        sendAnimation.setChatId(chatId);
        return sendAnimation;
    }

    @SneakyThrows
    public SendAudio latch(String chatId) {
        SendAudio audio = new SendAudio();
        File file = new File("src\\main\\resources\\static\\ух ты бля.mp3");
        InputFile inputFile = new InputFile(file);
        audio.setAudio(inputFile);
        audio.setChatId(chatId);
        return audio;
    }

    @SneakyThrows
    public SendAudio scream(String chatId) {
        SendAudio audio = new SendAudio();
        File file = new File("src\\main\\resources\\static\\scream.mp3");
        InputFile inputFile = new InputFile(file);
        audio.setAudio(inputFile);
        audio.setChatId(chatId);
        return audio;
    }
    @SneakyThrows
    public SendMessage sendMessage(String chatId, String textToSend) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);
        return message;
    }
}
