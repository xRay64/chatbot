package com.sulakov.realtbot;

import com.vdurmont.emoji.EmojiParser;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Антон on 13.06.2017.
 */
class MyInlineKeyboardCreator {
    private static InlineKeyboardMarkup markupInline;
    private static List<List<InlineKeyboardButton>> rowsInline;
    private static List<InlineKeyboardButton> rowInline;


    public static InlineKeyboardMarkup getInlineKeyboardMarkup(HashMap<Integer, MyInlineKeyboardButton> buttonsMap) {
        markupInline = new InlineKeyboardMarkup();
        rowsInline = new ArrayList<>();
        rowInline = new ArrayList<>();
        int rowLength = 0;
        for (int i = 0; i < buttonsMap.size(); i++) {
            rowLength += buttonsMap.get(i).getNameSize();
            if (rowLength <= 7) {
                rowInline.add(buttonsMap.get(i));
            } else {
                rowsInline.add(rowInline);
                rowLength = buttonsMap.get(i).getNameSize();
                rowInline = new ArrayList<>();
                rowInline.add(buttonsMap.get(i));
            }
        }
        rowsInline.add(rowInline);
        markupInline.setKeyboard(rowsInline);
        return markupInline;
    }
}

