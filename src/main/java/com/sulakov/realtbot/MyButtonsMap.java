package com.sulakov.realtbot;

import java.util.HashMap;

public class MyButtonsMap {
    private static HashMap<Integer, MyInlineKeyboardButton> typeMap = new HashMap<Integer, MyInlineKeyboardButton>();
    private static HashMap<Integer, MyInlineKeyboardButton> mikroraionMap = new HashMap<Integer, MyInlineKeyboardButton>();

    static {
        //заполним клавиатуру типов обхектов
        typeMap.put(0, new MyInlineKeyboardButton("Квартиру :door:", "flat"));
        typeMap.put(1, new MyInlineKeyboardButton("Дом :house:", "house"));
        typeMap.put(2, new MyInlineKeyboardButton("Комната :bedroom:", "room"));
        typeMap.put(3, new MyInlineKeyboardButton("Новостройка :new:", "new_build"));
        typeMap.put(4, new MyInlineKeyboardButton("Земельный участок :mount_fuji:", "area"));
        typeMap.put(5, new MyInlineKeyboardButton("Гараж :car:", "garage"));
        typeMap.put(6, new MyInlineKeyboardButton("Дача :house_with_garden:", "cottage"));
        typeMap.put(7, new MyInlineKeyboardButton("Комерческая недвижимость :office:", "commerce"));

        //заполним клавиатуру микрорайонов
        mikroraionMap.put(0, new MyInlineKeyboardButton("1", "m1"));
        mikroraionMap.put(1, new MyInlineKeyboardButton("2", "m2"));
        mikroraionMap.put(2, new MyInlineKeyboardButton("3", "m3"));
        mikroraionMap.put(3, new MyInlineKeyboardButton("4", "m4"));
        mikroraionMap.put(4, new MyInlineKeyboardButton("4б", "m4b"));
        mikroraionMap.put(5, new MyInlineKeyboardButton("5", "m5"));
        mikroraionMap.put(6, new MyInlineKeyboardButton("5а", "m5a"));
        mikroraionMap.put(7, new MyInlineKeyboardButton("6", "m6"));
        mikroraionMap.put(8, new MyInlineKeyboardButton("7", "m7"));
        mikroraionMap.put(9, new MyInlineKeyboardButton("8", "m8"));
        mikroraionMap.put(10, new MyInlineKeyboardButton("8а", "m8a"));
        mikroraionMap.put(11, new MyInlineKeyboardButton("9", "m9"));
        mikroraionMap.put(12, new MyInlineKeyboardButton("9а", "m9a"));
        mikroraionMap.put(13, new MyInlineKeyboardButton("11", "m11"));
        mikroraionMap.put(14, new MyInlineKeyboardButton("21", "m21"));
        mikroraionMap.put(14, new MyInlineKeyboardButton("Своё значение", "m_hand"));
    }

    public static HashMap<Integer, MyInlineKeyboardButton> getTypeMap() {
       return typeMap;
    }

    public static HashMap<Integer, MyInlineKeyboardButton> getMikroraionMap() {
        return mikroraionMap;
    }
}
