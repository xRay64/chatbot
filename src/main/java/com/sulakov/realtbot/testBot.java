package com.sulakov.realtbot;

import com.vdurmont.emoji.EmojiParser;
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

import java.util.*;

/**
 * Created by Антон Сулаков on 08.06.2017.
 */
public class testBot extends TelegramLongPollingBot {
    private PartialBotApiMethod messageToSend; //инициализируем переменную для сообщения которое будем отправлять
    private long chatId; //пишем ChatId в переменную
    private String messageText; //пишем текст сообщения в переменную
    private long message_id;
    private long user_Id;
    Map<Long, String> settingsMap = new HashMap<Long, String>();
    Map<Long, MyRealtObject> objectMap = new HashMap<Long, MyRealtObject>();

    public void onUpdateReceived(Update update) {
        // We check if the update has a message and the message has text


        if (update.hasMessage()) {

//            Log.logWrite(update); //пишем полученный апдейт в лог
            messageToSend = null;
            chatId = update.getMessage().getChatId();
            messageText = update.getMessage().getText();
            user_Id = update.getMessage().getChat().getId();


            if (update.getMessage().hasText()) {

                if (messageText.toUpperCase().contains("ПРИВЕТ")) {
                    messageToSend = new SendMessage(chatId,"Привет, " + update.getMessage().getChat().getFirstName()
                            + " "
                            + update.getMessage().getChat().getLastName() );
                } else if (messageText.equals("/pic")) {
                    messageToSend = new SendPhoto()
                            .setChatId(chatId)
                            .setPhoto("AgADAgADQ6gxG69H8Em8ZJNzmozVEHc6tw0ABN0Dz_Qupv3yrFwEAAEC") //AgADAgADQ6gxG69H8Em8ZJNzmozVEHc6tw0ABN0Dz_Qupv3yrFwEAAEC
                            .setCaption("Bite my shiny metal ass")
                            .setReplyToMessageId(update.getMessage().getMessageId());
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
                    messageToSend = new SendMessage()
                            .setChatId(chatId)
                            .setText("Клавиатура добавлена")
                            .setReplyMarkup(keyboardMarkup);

                } else if (messageText.equals("/добавить_объект")) {
                    //заполняем HashMap кнопками
                    HashMap<Integer, MyInlineKeyboardButton> buttonsMap = new HashMap<Integer, MyInlineKeyboardButton>();
                    buttonsMap.put(0, new MyInlineKeyboardButton("Квартиру :door:", "flat"));
                    buttonsMap.put(1, new MyInlineKeyboardButton("Дом :house:", "house"));
                    buttonsMap.put(2, new MyInlineKeyboardButton("Комната :bedroom:", "room"));
                    buttonsMap.put(3, new MyInlineKeyboardButton("Новостройка :new:", "new_build"));
                    buttonsMap.put(4, new MyInlineKeyboardButton("Земельный участок :mount_fuji:", "area"));
                    buttonsMap.put(5, new MyInlineKeyboardButton("Гараж :car:", "garage"));
                    buttonsMap.put(6, new MyInlineKeyboardButton( "Дача :house_with_garden:", "cottage"));
                    buttonsMap.put(7, new MyInlineKeyboardButton( "Комерческая недвижимость :office:", "commerce"));

                    //закончили заполнять HashMap кнопками
                    messageToSend = new SendMessage()
                            .setReplyMarkup(MyInlineKeyboardCreator.getInlineKeyboardMarkup(buttonsMap))
//                            .setReplyMarkup(MyInlineKeyboardCreator.get("Квартиру :door:", "flat", "Дом :house:", "house", "Комната :bedroom:", "room",
//                                                               "Новостройка :new:", "new_build", "Земельный участок :area:", "area", "Гараж :garage:", "garage",
//                                                                "Дача :cottage:", "cottage", "Комерческая недвижимость :commerce:", "commerce"))
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
                                .setText(EmojiParser.parseToUnicode((update.getMessage().getText().replaceAll("\\s+", "::")))
                                        + EmojiParser.parseToUnicode("\nHere is a smile emoji::smile:\n Here is alien emoji: :alien:"));
                    }
                }
                botSend(messageToSend);
            }

        }
        else if (update.hasCallbackQuery()) {
            String call_data = update.getCallbackQuery().getData();
            message_id = update.getCallbackQuery().getMessage().getMessageId(); //пишем message_id в переменную

            if (call_data.equals("flat") || call_data.equals("house") || call_data.equals("room") || call_data.equals("new_build") || call_data.equals("area") || call_data.equals("garage")
                    || call_data.equals("cottage") || call_data.equals("commerce")) {
                objectMap.put(chatId, new MyRealtObject());


                //готовим сообщеине для отправки
                messageToSend = new EditMessageText()
                        .setText("Какой райн?")
                        .setChatId(chatId)
                        .setMessageId((int)message_id)
                        .setReplyMarkup(MyInlineKeyboardCreator.get("Старый город", "жг", "Серединка", "серединка",
                                "Новые районы", "новые"));
            } else if (call_data.equals("жг") || call_data.equals("серединка") || call_data.equals("новые")) {
                messageToSend = new EditMessageText()
                        .setText("Сколько комнат?")
                        .setChatId(chatId)
                        .setMessageId((int)message_id)
                        .setReplyMarkup(MyInlineKeyboardCreator.get(":one:", "1", ":two:", "2", ":three:", "3", ":four:", "4"));
            } else if (call_data.equals("1") || call_data.equals("2") || call_data.equals("3") || call_data.equals("4")) {
                messageToSend = new SendMessage()
                        .setChatId(chatId)
                        .setText("Объект добавлен!");
            }


            botSend(messageToSend);
        }

    }

    public String getBotUsername() {
        return Main.botName;
    }

    public String getBotToken() {
        return Main.botToken;
    }


    //отправка сообщений
    private void botSend(Object messageToSend) {
        try {
            if (Objects.equals(messageToSend.getClass(), new SendMessage().getClass())) {
                System.out.println(messageToSend.getClass());
                System.out.println("In msg: " + messageText + " ,UserID:" + user_Id + " Out msg: " + messageToSend + "\n\n");
                sendMessage((SendMessage) messageToSend); // Call method to botSend the message
//                Log.logAnswerWrite(messageToSend.toString());
            } else if (Objects.equals(messageToSend.getClass(), new SendPhoto().getClass())) {
                System.out.println("In msg: " + messageText + " ,UserID:" + user_Id + " Out msg: " + messageToSend + "\n\n");
                sendPhoto((SendPhoto) messageToSend);
//                Log.logAnswerWrite(messageToSend.toString());
            } else if (Objects.equals(messageToSend.getClass(), new EditMessageText().getClass())) {
                System.out.println("In msg: " + messageText + " ,UserID:" + user_Id +  " Out msg: " + messageToSend + "\n\n");
                editMessageText((EditMessageText) messageToSend);
//                Log.logAnswerWrite(messageToSend.toString());
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}

