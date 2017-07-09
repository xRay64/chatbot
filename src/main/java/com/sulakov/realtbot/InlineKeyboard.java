package com.sulakov.realtbot;

import com.vdurmont.emoji.EmojiParser;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Антон on 13.06.2017.
 */
class InlineKeyboard {
    private static InlineKeyboardMarkup markupInline;
    private static List<List<InlineKeyboardButton>> rowsInline;
    private static List<InlineKeyboardButton> rowInline;

    public static InlineKeyboardMarkup get(String button1, String data1, String button2, String data2 ) {
        markupInline = new InlineKeyboardMarkup();
        rowsInline = new ArrayList<>();
        rowInline = new ArrayList<>();

        rowInline.add(new InlineKeyboardButton().setText(EmojiParser.parseToUnicode(button1)).setCallbackData(data1));
        rowInline.add(new InlineKeyboardButton().setText(EmojiParser.parseToUnicode(button2)).setCallbackData(data2));
        rowsInline.add(rowInline);
        markupInline.setKeyboard(rowsInline);


        return markupInline;
    }
    public static InlineKeyboardMarkup get(String button1, String data1, String button2, String data2, String button3, String data3 ) {
        markupInline = new InlineKeyboardMarkup();
        rowsInline = new ArrayList<>();
        rowInline = new ArrayList<>();

        rowInline.add(new InlineKeyboardButton().setText(EmojiParser.parseToUnicode(button1)).setCallbackData(data1));
        rowInline.add(new InlineKeyboardButton().setText(EmojiParser.parseToUnicode(button2)).setCallbackData(data2));
        rowInline.add(new InlineKeyboardButton().setText(EmojiParser.parseToUnicode(button3)).setCallbackData(data3));
        rowsInline.add(rowInline);
        markupInline.setKeyboard(rowsInline);

        return markupInline;
    }
    public static InlineKeyboardMarkup get(String button1, String data1, String button2, String data2, String button3, String data3,
                                           String button4, String data4 ) {
        markupInline = new InlineKeyboardMarkup();
        rowsInline = new ArrayList<>();
        rowInline = new ArrayList<>();

        rowInline.add(new InlineKeyboardButton().setText(EmojiParser.parseToUnicode(button1)).setCallbackData(data1));
        rowInline.add(new InlineKeyboardButton().setText(EmojiParser.parseToUnicode(button2)).setCallbackData(data2));
        rowInline.add(new InlineKeyboardButton().setText(EmojiParser.parseToUnicode(button3)).setCallbackData(data3));
        rowsInline.add(rowInline);
        rowInline = new ArrayList<>();
        rowInline.add(new InlineKeyboardButton().setText(EmojiParser.parseToUnicode(button4)).setCallbackData(data4));
        rowsInline.add(rowInline);
        markupInline.setKeyboard(rowsInline);

        return markupInline;
    }
    public static InlineKeyboardMarkup get(String button1, String data1, String button2, String data2, String button3, String data3,
                                           String button4, String data4, String button5, String data5 ) {
        markupInline = new InlineKeyboardMarkup();
        rowsInline = new ArrayList<>();
        rowInline = new ArrayList<>();

        rowInline.add(new InlineKeyboardButton().setText(EmojiParser.parseToUnicode(button1)).setCallbackData(data1));
        rowInline.add(new InlineKeyboardButton().setText(EmojiParser.parseToUnicode(button2)).setCallbackData(data2));
        rowInline.add(new InlineKeyboardButton().setText(EmojiParser.parseToUnicode(button3)).setCallbackData(data3));
        rowsInline.add(rowInline);
        rowInline = new ArrayList<>();
        rowInline.add(new InlineKeyboardButton().setText(EmojiParser.parseToUnicode(button4)).setCallbackData(data4));
        rowInline.add(new InlineKeyboardButton().setText(EmojiParser.parseToUnicode(button5)).setCallbackData(data5));
        rowsInline.add(rowInline);
        markupInline.setKeyboard(rowsInline);

        return markupInline;
    }
    public static InlineKeyboardMarkup get(String button1, String data1, String button2, String data2, String button3, String data3,
                                           String button4, String data4, String button5, String data5, String button6, String data6 ) {
        markupInline = new InlineKeyboardMarkup();
        rowsInline = new ArrayList<>();
        rowInline = new ArrayList<>();

        rowInline.add(new InlineKeyboardButton().setText(EmojiParser.parseToUnicode(button1)).setCallbackData(data1));
        rowInline.add(new InlineKeyboardButton().setText(EmojiParser.parseToUnicode(button2)).setCallbackData(data2));
        rowInline.add(new InlineKeyboardButton().setText(EmojiParser.parseToUnicode(button3)).setCallbackData(data3));
        rowsInline.add(rowInline);
        rowInline = new ArrayList<>();
        rowInline.add(new InlineKeyboardButton().setText(EmojiParser.parseToUnicode(button4)).setCallbackData(data4));
        rowInline.add(new InlineKeyboardButton().setText(EmojiParser.parseToUnicode(button5)).setCallbackData(data5));
        rowInline.add(new InlineKeyboardButton().setText(EmojiParser.parseToUnicode(button6)).setCallbackData(data6));
        rowsInline.add(rowInline);
        markupInline.setKeyboard(rowsInline);

        return markupInline;
    }

    public static InlineKeyboardMarkup get(String button1, String data1, String button2, String data2, String button3, String data3,
                                           String button4, String data4, String button5, String data5, String button6, String data6,
                                           String button7, String data7) {
        markupInline = new InlineKeyboardMarkup();
        rowsInline = new ArrayList<>();
        rowInline = new ArrayList<>();

        rowInline.add(new InlineKeyboardButton().setText(EmojiParser.parseToUnicode(button1)).setCallbackData(data1));
        rowInline.add(new InlineKeyboardButton().setText(EmojiParser.parseToUnicode(button2)).setCallbackData(data2));
        rowInline.add(new InlineKeyboardButton().setText(EmojiParser.parseToUnicode(button3)).setCallbackData(data3));
        rowsInline.add(rowInline);
        rowInline = new ArrayList<>();
        rowInline.add(new InlineKeyboardButton().setText(EmojiParser.parseToUnicode(button4)).setCallbackData(data4));
        rowInline.add(new InlineKeyboardButton().setText(EmojiParser.parseToUnicode(button5)).setCallbackData(data5));
        rowInline.add(new InlineKeyboardButton().setText(EmojiParser.parseToUnicode(button6)).setCallbackData(data6));
        rowsInline.add(rowInline);
        rowInline = new ArrayList<>();
        rowInline.add(new InlineKeyboardButton().setText(EmojiParser.parseToUnicode(button7)).setCallbackData(data7));
        markupInline.setKeyboard(rowsInline);

        return markupInline;
    }
    public static InlineKeyboardMarkup get(String button1, String data1, String button2, String data2, String button3, String data3,
                                           String button4, String data4, String button5, String data5, String button6, String data6,
                                           String button7, String data7, String button8, String data8) {
        markupInline = new InlineKeyboardMarkup();
        rowsInline = new ArrayList<>();
        rowInline = new ArrayList<>();

        rowInline.add(new InlineKeyboardButton().setText(EmojiParser.parseToUnicode(button1)).setCallbackData(data1));
        rowInline.add(new InlineKeyboardButton().setText(EmojiParser.parseToUnicode(button2)).setCallbackData(data2));
        rowInline.add(new InlineKeyboardButton().setText(EmojiParser.parseToUnicode(button3)).setCallbackData(data3));
        rowsInline.add(rowInline);
        rowInline = new ArrayList<>();
        rowInline.add(new InlineKeyboardButton().setText(EmojiParser.parseToUnicode(button4)).setCallbackData(data4));
        rowInline.add(new InlineKeyboardButton().setText(EmojiParser.parseToUnicode(button5)).setCallbackData(data5));
        rowInline.add(new InlineKeyboardButton().setText(EmojiParser.parseToUnicode(button6)).setCallbackData(data6));
        rowsInline.add(rowInline);
        rowInline = new ArrayList<>();
        rowInline.add(new InlineKeyboardButton().setText(EmojiParser.parseToUnicode(button7)).setCallbackData(data7));
        rowInline.add(new InlineKeyboardButton().setText(EmojiParser.parseToUnicode(button8)).setCallbackData(data8));
        markupInline.setKeyboard(rowsInline);

        return markupInline;
    }
}

