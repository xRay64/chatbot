package com.sulakov.realtbot;

import com.vdurmont.emoji.EmojiParser;
import org.telegram.telegrambots.api.methods.BotApiMethod;
import org.telegram.telegrambots.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendPhoto;
import org.telegram.telegrambots.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.*;

/**
 * Created by Антон Сулаков on 08.06.2017.
 */
public class testBot extends TelegramLongPollingBot {

    Map<Long, String> settingsMap = new HashMap<Long, String>();
    Map<Long, MyRealtObject> objectMap = new HashMap<Long, MyRealtObject>();

    public void onUpdateReceived(Update update) {
        System.out.println(update);
        PartialBotApiMethod messageToSend = null; //инициализируем переменную для сообщения которое будем отправлять
        long chatId; //пишем ChatId в переменную
        String messageText = null; //пишем текст сообщения в переменную
        long message_id;
        long user_id = 0;

        if (update.hasMessage()) {

            if (update.getMessage().hasText()) {
                chatId = update.getMessage().getChatId();
                messageText = update.getMessage().getText();
                message_id = update.getMessage().getMessageId();
                System.out.println(message_id);


                //ручной ввод микрорайона
                if (settingsMap.containsKey(chatId) && settingsMap.get(chatId).equals("mikroraion_hand")) {
                    settingsMap.put(chatId, "");
                    MyRealtObject tmpO = objectMap.get(chatId);
                    tmpO.setMikroraion(messageText);
                    messageToSend = new SendMessage()
                            .setChatId(chatId)
                            .setText(objectMap.get(chatId) + "Введите улицу");
                    settingsMap.put(chatId, "street_hand");
                }
                //ручной ввод улицы
                else if (settingsMap.containsKey(chatId) && settingsMap.get(chatId).equals("street_hand")) {
                    settingsMap.put(chatId, "");
                    MyRealtObject tmpO = objectMap.get(chatId);
                    tmpO.setStreet(messageText);
                    messageToSend = new SendMessage()
                            .setChatId(chatId)
                            .setText(objectMap.get(chatId) + "Введите номер дома");
                    settingsMap.put(chatId, "houseNumber_hand");
                } else {
                    if (messageText.toUpperCase().contains("ПРИВЕТ")) {
                        messageToSend = new SendMessage(chatId, "Привет, " + update.getMessage().getChat().getFirstName()
                                + " "
                                + update.getMessage().getChat().getLastName());
                    } else if (messageText.equals("/start")) {
                        //Creating custom keyboard
                        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
                        List<KeyboardRow> keyboard = new ArrayList<KeyboardRow>();
                        KeyboardRow row = new KeyboardRow();
                        //adding first row
                        row.add("/pic");
                        row.add("/добавить_объект");
                        row.add("Row 1 Button 3");
                        keyboard.add(row);
                        //adding second row
                        row = new KeyboardRow();
                        // Set each button for the second line
                        row.add("Row 2 Button 1");
                        row.add("Row 2 Button 2");
                        row.add("/скрыть клавиатуру");
                        // Add the second row to the keyboard
                        keyboard.add(row);
                        // Set the keyboard to the markup
                        keyboardMarkup.setKeyboard(keyboard);
                        // Create messageToSend and add markup to the message
//                        messageToSend = new SendMessage()
//                                .setChatId(chatId)
//                                .setText("Клавиатура добавлена")
//                                .setReplyMarkup(keyboardMarkup);
                        MySendMessage("msg", new SendMessage()
                                                    .setChatId(chatId)
                                                    .setText("Клавиатура добавлена")
                                                    .setReplyMarkup(keyboardMarkup));

                    } else if (messageText.equals("/добавить_объект")) {
                        //заполняем HashMap кнопками
                        messageToSend = new SendMessage()
                                .setReplyMarkup(MyInlineKeyboardCreator.getInlineKeyboardMarkup(MyButtonsMap.getTypeMap()))
                                .setChatId(chatId)
                                .setText("Добавить объект в базу");
                    } else {
                        if (messageText.equals("/скрыть клавиатуру")) {
                            messageToSend = new SendMessage()
                                    .setChatId(chatId)
                                    .setText("Клавиатура скрыта")
                                    .setReplyMarkup(new ReplyKeyboardRemove());
                        } else {
                            messageToSend = new SendMessage() // Create a SendMessage object with mandatory fields
                                    .setChatId(update.getMessage().getChatId())
                                    .setText("Остальной функционал в разработке =(");
                        }
                    }

                }
            }

        }
        else if (update.hasCallbackQuery()) {
            chatId = update.getCallbackQuery().getMessage().getChatId();
            String call_data = update.getCallbackQuery().getData();
            message_id = update.getCallbackQuery().getMessage().getMessageId(); //пишем message_id в переменную
            System.out.println(message_id);

            if (/*MyButtonsMap.getTypeMap().containsValue(call_data)*/call_data.equals("flat") || call_data.equals("house") || call_data.equals("room") || call_data.equals("new_build") || call_data.equals("area") || call_data.equals("garage")
                    || call_data.equals("cottage") || call_data.equals("commerce")) {
                System.out.println("Внутри обработчика типа объекта");
                MyRealtObject realtTmp = new MyRealtObject();
                if (call_data.equals("flat")) {
                    realtTmp.setType(1);
                } else if (call_data.equals("house")) {
                    realtTmp.setType(2);
                } else if (call_data.equals("room")) {
                    realtTmp.setType(3);
                } else if (call_data.equals("new_build")) {
                    realtTmp.setType(4);
                } else if (call_data.equals("area")) {
                    realtTmp.setType(5);
                } else if (call_data.equals("garage")) {
                    realtTmp.setType(6);
                } else if (call_data.equals("cottage")) {
                    realtTmp.setType(7);
                } else if (call_data.equals("commerce")) {
                    realtTmp.setType(8);
                } else {
                    System.out.println("ERROR: realt type wrong!");
                }
                objectMap.put(chatId, realtTmp);

                //готовим сообщеине для отправки
                messageToSend = new EditMessageText()
                        .setText(objectMap.get(chatId) + "Какой райн?")
                        .setChatId(chatId)
                        .setMessageId((int)message_id)
                        .setReplyMarkup(MyInlineKeyboardCreator.getInlineKeyboardMarkup(MyButtonsMap.getMikroraionMap()));
            } else if (MyButtonsMap.getMikroraionMapValues().contains(call_data)) {
                System.out.println("Внутри обработчика микрорайона");
                MyRealtObject realtTmp = objectMap.get(chatId);
                if (call_data.equals("m1")) {
                    realtTmp.setMikroraion("1");
                } else if (call_data.equals("m2")) {
                    realtTmp.setMikroraion("2");
                } else if (call_data.equals("m3")) {
                    realtTmp.setMikroraion("3");
                } else if (call_data.equals("m4")) {
                    realtTmp.setMikroraion("4");
                } else if (call_data.equals("m4b")) {
                    realtTmp.setMikroraion("4б");
                } else if (call_data.equals("m5")) {
                    realtTmp.setMikroraion("5");
                } else if (call_data.equals("m5a")) {
                    realtTmp.setMikroraion("5а");
                } else if (call_data.equals("m6")) {
                    realtTmp.setMikroraion("6");
                } else if (call_data.equals("m7")) {
                    realtTmp.setMikroraion("7");
                } else if (call_data.equals("m8")) {
                    realtTmp.setMikroraion("8");
                } else if (call_data.equals("m9")) {
                    realtTmp.setMikroraion("9");
                } else if (call_data.equals("m9a")) {
                    realtTmp.setMikroraion("9а");
                } else if (call_data.equals("m10")) {
                    realtTmp.setMikroraion("10");
                } else if (call_data.equals("m11")) {
                    realtTmp.setMikroraion("11");
                } else if (call_data.equals("m21")) {
                    realtTmp.setMikroraion("21");
                } else {
                    System.out.println("ERROR: realt mikroraion wrong!");
                }
                objectMap.put(chatId, realtTmp);

                //готовим сообщеине для отправки
                messageToSend = new EditMessageText()
                        .setText(objectMap.get(chatId) + "Введите улицу")
                        .setChatId(chatId)
                        .setMessageId((int)message_id);
                settingsMap.put(chatId, "street_hand");
            } else if (call_data.equals("m_hand")) {
                settingsMap.put(chatId, "mikroraion_hand");
                messageToSend = new EditMessageText()
                        .setText(objectMap.get(chatId) + "Введите район")
                        .setChatId(chatId)
                        .setMessageId((int) message_id);
//            } else if (MyButtonsMap.getMikroraionMap().containsValue(call_data)/*call_data.equals("m1") || call_data.equals("m2") || call_data.equals("m3") || call_data.equals("m4") || call_data.equals("m4b") || call_data.equals("m5") || call_data.equals("m5a") || call_data.equals("m6")
//                    || call_data.equals("m7") || call_data.equals("m8") || call_data.equals("m8a") || call_data.equals("m9") || call_data.equals("m9a") || call_data.equals("m11") || call_data.equals("m21")*/) {
//                System.out.println("Внутри микрорайона");

                //готовим сообщеине для отправки
//                messageToSend = new EditMessageText()
//                        .setText("Сколько комнат?")
//                        .setChatId(update.getMessage().getChat().getId())
//                        .setMessageId((int) message_id)
//                        .setReplyMarkup(MyInlineKeyboardCreator.get(":one:", "1", ":two:", "2", ":three:", "3", ":four:", "4"));
            } else if (call_data.equals("1") || call_data.equals("2") || call_data.equals("3") || call_data.equals("4")) {
                messageToSend = new SendMessage()
                        .setChatId(update.getMessage().getChat().getId())
                        .setText("Объект добавлен!");
            }



        }
        try {
            if (Objects.equals(messageToSend.getClass(), new SendMessage().getClass())) {
                System.out.println(messageToSend);
                sendMessage((SendMessage) messageToSend); // Call method to botSend the message
            } else if (Objects.equals(messageToSend.getClass(), new SendPhoto().getClass())) {
                System.out.println(messageToSend);
                sendPhoto((SendPhoto) messageToSend);
            } else if (Objects.equals(messageToSend.getClass(), new EditMessageText().getClass())) {
                System.out.println(messageToSend);
                editMessageText((EditMessageText) messageToSend);
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    //необходимо для работы бота
    public String getBotUsername() {
        return Main.botName;
    }

    public String getBotToken() {
        return Main.botToken;
    }

    private void MySendMessage(String type, PartialBotApiMethod message) {
        try {
            if (type.equals("msg")) {
                sendMessage((SendMessage) message);
            } else if (type.equals("photo")) {
                sendPhoto((SendPhoto) message);
            } else if (type.equals("edit")) {
                editMessageText((EditMessageText) message);
            } else System.out.println("Error in MySendMessage");
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}

