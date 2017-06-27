package com.sulakov.realtbot;

import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendPhoto;
import org.telegram.telegrambots.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.Objects;

/**
 * Created by Антон on 25.06.2017.
 */
public class BotSend {
    private void botSend(Object messageToSend) {
        try {
            if (Objects.equals(messageToSend.getClass(), new SendMessage().getClass())) {
                System.out.println(messageToSend.getClass());
                System.out.println("In msg: " + messageText + " Out msg: " + messageToSend + "\n\n");
                sendMessage((SendMessage) messageToSend); // Call method to botSend the message
                Log.logAnswerWrite(messageToSend.toString());
            } else if (Objects.equals(messageToSend.getClass(), new SendPhoto().getClass())) {
                System.out.println("In msg: " + messageText + " Out msg: " + messageToSend + "\n\n");
                sendPhoto((SendPhoto) messageToSend);
                Log.logAnswerWrite(messageToSend.toString());
            } else if (Objects.equals(messageToSend.getClass(), new EditMessageText().getClass())) {
                System.out.println("In msg: " + messageText + " Out msg: " + messageToSend + "\n\n");
                editMessageText((EditMessageText) messageToSend);
                Log.logAnswerWrite(messageToSend.toString());
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
