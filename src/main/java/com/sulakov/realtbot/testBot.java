package com.sulakov.realtbot;

import org.telegram.telegrambots.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendPhoto;
import org.telegram.telegrambots.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Антон Сулаков on 08.06.2017.
 */
public class testBot extends TelegramLongPollingBot {

    Map<Long, String> settingsMap = new HashMap<Long, String>();
    Map<Long, MyRealtObject> objectMap = new HashMap<Long, MyRealtObject>();
    public static final Pattern digPattern = Pattern.compile("\\d+");

    public void onUpdateReceived(Update update) {
        System.out.println("DEBUG:UPDATE_RESIVED\n" + update + "\nDEBUG:END_update");
        PartialBotApiMethod messageToSend = null; //инициализируем переменную для сообщения которое будем отправлять
        long chatId;
        String messageText = null;
        long message_id;

        if (update.hasMessage()) {

            if (update.getMessage().hasText()) {
                chatId = update.getMessage().getChatId();
                messageText = update.getMessage().getText();
                message_id = update.getMessage().getMessageId();
                System.out.println(message_id);

                //ручной ввод микрорайона
                if (settingsMap.containsKey(chatId) && settingsMap.get(chatId).equals("mikroraion_hand")) {
                    MyRealtObject tmpO = objectMap.get(chatId);
                    tmpO.setMikroraion(messageText);
                    MySendMessage(new SendMessage()
                            .setChatId(chatId)
                            .setText(objectMap.get(chatId) + "Введите улицу"));
                    settingsMap.put(chatId, "street_hand");
                }
                //ручной ввод улицы
                else if (settingsMap.containsKey(chatId) && settingsMap.get(chatId).equals("street_hand")) {
                    MyRealtObject tmpO = objectMap.get(chatId);
                    tmpO.setStreet(messageText);
                    MySendMessage(new SendMessage()
                            .setChatId(chatId)
                            .setText(objectMap.get(chatId) + "Введите номер дома"));
                    settingsMap.put(chatId, "houseNumber_hand");
                }
                //ручной ввод номера дома
                else if (settingsMap.containsKey(chatId) && settingsMap.get(chatId).equals("houseNumber_hand")) {
                    MyRealtObject tmpO = objectMap.get(chatId);
                    tmpO.setHouseNumber(messageText);
                    MySendMessage(new SendMessage()
                            .setChatId(chatId)
                            .setText(objectMap.get(chatId) + "Введите номер квартиры"));
                    settingsMap.put(chatId, "apt_hand");
                } else if (settingsMap.containsKey(chatId) && settingsMap.get(chatId).equals("apt_hand")) {
                    MyRealtObject tmpO = objectMap.get(chatId);
                    tmpO.setAptNumber(messageText);
                    MySendMessage(new SendMessage()
                            .setChatId(chatId)
                            .setReplyMarkup(MyInlineKeyboardCreator.getInlineKeyboardMarkup(MyButtonsMap.getButtonsMap("room")))
                            .setText(objectMap.get(chatId) + "Количество комнат"));
                } else if (settingsMap.containsKey(chatId) && settingsMap.get(chatId).equals("room_hand")) {
                    MyRealtObject tmpO = objectMap.get(chatId);
                    //Проверяем является ли введеное значение числом
                    Matcher matcher = digPattern.matcher(messageText);
                    if (!matcher.matches()) {
                        MySendMessage(new SendMessage()
                                .setChatId(chatId)
                                .setText("ОШИБКА: Значение должно быть числом\nПовторите ввод"));
                    } else {
                        System.out.println("Matcher false");
                        tmpO.setRooms(Integer.parseInt(messageText));
                        MySendMessage(new SendMessage()
                                .setChatId(chatId)
                                .setReplyMarkup(MyInlineKeyboardCreator.getInlineKeyboardMarkup(MyButtonsMap.getButtonsMap("floor")))
                                .setText(objectMap.get(chatId) + "Выберите этаж"));
                    }
                } else if (settingsMap.containsKey(chatId) && settingsMap.get(chatId).equals("floor_hand")) {
                    MyRealtObject tmpO = objectMap.get(chatId);
                    Matcher matcher = digPattern.matcher(messageText);
                    if (!matcher.matches()) {
                        MySendMessage(new SendMessage()
                                .setChatId(chatId)
                                .setText("ОШИБКА: Значение должно быть числом\nПовторите ввод"));
                    } else {
                        tmpO.setFloor(Integer.parseInt(messageText));
                        MySendMessage(new SendMessage()
                                .setChatId(chatId)
                                .setReplyMarkup(MyInlineKeyboardCreator.getInlineKeyboardMarkup(MyButtonsMap.getButtonsMap("floor")))
                                .setText(objectMap.get(chatId) + "Выберите общее количество этажей в доме"));
                    }
                }


                //-------**********----------
                else if (messageText.toUpperCase().contains("ПРИВЕТ")) {
                    MySendMessage(new SendMessage(chatId, "Привет, " + update.getMessage().getChat().getFirstName()
                            + " "
                            + update.getMessage().getChat().getLastName()));
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
                    MySendMessage(new SendMessage()
                            .setChatId(chatId)
                            .setText("Клавиатура добавлена")
                            .setReplyMarkup(keyboardMarkup));

                } else if (messageText.equals("/добавить_объект")) {
                    MySendMessage(new SendMessage()
                            .setReplyMarkup(MyInlineKeyboardCreator.getInlineKeyboardMarkup(MyButtonsMap.getButtonsMap("type")))
                            .setChatId(chatId)
                            .setText("Добавить объект в базу"));
                } else if (messageText.equals("/скрыть клавиатуру")) {
                    MySendMessage(new SendMessage()
                            .setChatId(chatId)
                            .setText("Клавиатура скрыта")
                            .setReplyMarkup(new ReplyKeyboardRemove()));
                } else {
                    MySendMessage(new SendMessage()
                            .setChatId(update.getMessage().getChatId())
                            .setText("Остальной функционал в разработке =("));
                }


            }

        }.. else if (update.hasCallbackQuery()) {
            chatId = update.getCallbackQuery().getMessage().getChatId();
            String call_data = update.getCallbackQuery().getData();
            message_id = update.getCallbackQuery().getMessage().getMessageId(); //пишем message_id в переменную
            System.out.println("DEBUG:MESSAGE_ID: " + message_id);

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
                MySendMessage(new EditMessageText()
                        .setText(objectMap.get(chatId) + "Выберите райн")
                        .setChatId(chatId)
                        .setMessageId((int) message_id)
                        .setReplyMarkup(MyInlineKeyboardCreator.getInlineKeyboardMarkup(MyButtonsMap.getButtonsMap("mikro"))));
            } else if (MyButtonsMap.getMapValues("mikro").contains(call_data)) {
                System.out.println("Внутри обработчика микрорайона");
                objectMap.get(chatId)
                        .setMikroraion(call_data.substring(1));
                //готовим сообщеине для отправки
                MySendMessage(new EditMessageText()
                        .setText(objectMap.get(chatId) + "Введите улицу")
                        .setChatId(chatId)
                        .setMessageId((int) message_id));
                settingsMap.put(chatId, "street_hand");
            } else if (call_data.equals("m_hand")) {
                settingsMap.put(chatId, "mikroraion_hand");
                MySendMessage(new EditMessageText()
                        .setText(objectMap.get(chatId) + "Введите район")
                        .setChatId(chatId)
                        .setMessageId((int) message_id));
            } else if (call_data.equals("room_hand")) {
                settingsMap.put(chatId, "room_hand");
                MySendMessage(new EditMessageText()
                        .setText(objectMap.get(chatId) + "Введите количество комнат")
                        .setChatId(chatId)
                        .setMessageId((int) message_id));
            } else if (MyButtonsMap.getMapValues("room").contains(call_data)) {
                System.out.println("Внутри обработчика количества комнат");
                objectMap.get(chatId)
                        .setRooms(Integer.parseInt(call_data.substring(1)));
                MySendMessage(new EditMessageText()
                        .setChatId(chatId)
                        .setMessageId((int) message_id)
                        .setReplyMarkup(MyInlineKeyboardCreator.getInlineKeyboardMarkup(MyButtonsMap.getButtonsMap("floor")))
                        .setText(objectMap.get(chatId) + "Выберите этаж"));
            } else if (call_data.equals("floor_hand")) {
                settingsMap.put(chatId, "floor_hand");
                MySendMessage(new EditMessageText()
                        .setText(objectMap.get(chatId) + "Введите этаж")
                        .setChatId(chatId)
                        .setMessageId((int) message_id));
            } else if (MyButtonsMap.getMapValues("floor").contains(call_data)) {
                System.out.println("Внутри обработчика этажа");
                objectMap.get(chatId)
                    .setFloor(Integer.parseInt(call_data.substring(1)));
                MySendMessage(new EditMessageText()
                        .setChatId(chatId)
                        .setMessageId((int) message_id)
                       // .setReplyMarkup(MyInlineKeyboardCreator.getInlineKeyboardMarkup(MyButtonsMap.getButtonsMap("floor")))
                        .setText(objectMap.get(chatId) + "Выберите этаж"));

            }
        }
    }


    //необходимо для работы бота
    public String getBotUsername() {
        return Main.botName;
    }

    public String getBotToken() {
        return Main.botToken;
    }

    //метод отправки сообщений
    private void MySendMessage(PartialBotApiMethod message) {
        try {
            if (message.getClass().equals(new SendMessage().getClass())) {
                sendMessage((SendMessage) message);
            } else if (message.getClass().equals(new SendPhoto().getClass())) {
                sendPhoto((SendPhoto) message);
            } else if (message.getClass().equals(new EditMessageText().getClass())) {
                editMessageText((EditMessageText) message);
            } else System.out.println("Error in MySendMessage");
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}

