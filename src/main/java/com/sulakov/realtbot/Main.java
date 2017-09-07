package com.sulakov.realtbot;

import com.sulakov.realtbot.dbcon.BotParam;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class Main {
    static String botName = null;
    static String botToken = null;

    public static void main(String[] args) {
        //получаем botNme и botToken из БД и храним их в переменных
        botName = BotParam.getParam("botName");
        botToken =  BotParam.getParam("botToken");

        ApiContextInitializer.init();

        TelegramBotsApi botsApi = new TelegramBotsApi();

        try {
            botsApi.registerBot(new testBot());
            System.out.println("Telegram bot successfully started!");
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
