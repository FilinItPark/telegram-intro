package org.example.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * @author 1ommy
 * @version 23.11.2023
 */
public class MyFirstBot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message messageFromUser = update.getMessage();

            if (messageFromUser.hasText()) {
                String text = messageFromUser.getText();

                switch (text) {
                    case "/start" ->
                            sendMessage("Привет, я бот, который показывает анекдоты! Для рандомного анекдота, введи /joke. " +
                                            "Чтобы увидеть весь список анекдотов, введи /jokes",
                                    messageFromUser.getChatId().toString());
                    case "/joke" -> sendMessage(Jokes.getJoke(), messageFromUser.getChatId().toString());
                    case "/jokes" -> {
                        for (String joke : Jokes.jokes) {
                            sendMessage(joke, messageFromUser.getChatId().toString());
                        }
                    }
                }
            }
        }
    }

    private void sendMessage(String text, String chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(text);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            System.out.println("чет пошло не так при отправке сообщения");
        }
    }

    @Override
    public String getBotUsername() {
        return "echojokesbot";
    }

    @Override
    public String getBotToken() {
        return "6772955714:AAHmhB4NwxMzto_S02X1JAxAAAbWiXzBUY4";
    }
}
