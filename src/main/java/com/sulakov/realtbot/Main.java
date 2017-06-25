package com.sulakov.realtbot;

import com.sulakov.realtbot.dbcon.GetBotParam;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.net.URISyntaxException;
import java.sql.SQLException;

public class Main {
    static String botName = null;
    static String botToken = null;

    public static void main(String[] args) {
        try {
            botName = GetBotParam.getParam("botName");
            botToken =  GetBotParam.getParam("botToken");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

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
