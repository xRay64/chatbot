package com.sulakov.realtbot;

/**
 * Created by Антон on 09.06.2017.
 */
public class Options {
    private static final String botName = "SulakovTestBot";
    private static final String botToken = "228876811:AAFRn-vYfZlOD7CaiAWxkQu81s461j5wVXY";
    private static final String logFile = "log.txt";

    public static String getBotName() {
        return botName;
    }

    public static String getBotToken() {
        return botToken;
    }

    public static String getLogFile() {
        return logFile;
    }
}
