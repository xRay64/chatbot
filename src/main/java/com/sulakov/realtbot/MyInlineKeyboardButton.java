package com.sulakov.realtbot;

import com.vdurmont.emoji.EmojiParser;

/**
 * Created by Антон on 10.07.2017.
 */
public class MyInlineKeyboardButton extends org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton {
    private String name;

    public MyInlineKeyboardButton(String name, String data) {
        this.name = name;
        super.setText(EmojiParser.parseToUnicode(name)).setCallbackData(data);
    }

    public int getNameSize() {
        int toReturn = 0;
        if (name.contains(":")) {
            toReturn = name.indexOf(':');
        }
        else toReturn = name.length();
        return toReturn;
    }
}
