package org.example;

import org.example.bot.MyFirstBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

/**
 * @author 1ommy
 * @version 23.11.2023
 */
public class Main {
    public static void main(String[] args) {
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new MyFirstBot());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}