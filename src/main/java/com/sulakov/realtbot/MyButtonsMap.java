package com.sulakov.realtbot;

import java.util.ArrayList;
import java.util.HashMap;

public class MyButtonsMap {
    private static HashMap<Integer, MyInlineKeyboardButton> typeMap = new HashMap<Integer, MyInlineKeyboardButton>();
    private static HashMap<Integer, MyInlineKeyboardButton> mikroraionMap = new HashMap<Integer, MyInlineKeyboardButton>();
    private static HashMap<Integer, MyInlineKeyboardButton> roomNumbersMap = new HashMap<Integer, MyInlineKeyboardButton>();
    private static HashMap<Integer, MyInlineKeyboardButton> floorNumbersMap = new HashMap<Integer, MyInlineKeyboardButton>();
    private static HashMap<Integer, MyInlineKeyboardButton> totalFloorNumbersMap = new HashMap<Integer, MyInlineKeyboardButton>();

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
        mikroraionMap.put(0, new MyInlineKeyboardButton("1", "mikro_1"));
        mikroraionMap.put(1, new MyInlineKeyboardButton("2", "mikro_2"));
        mikroraionMap.put(2, new MyInlineKeyboardButton("3", "mikro_3"));
        mikroraionMap.put(3, new MyInlineKeyboardButton("4", "mikro_4"));
        mikroraionMap.put(4, new MyInlineKeyboardButton("4б", "mikro_4b"));
        mikroraionMap.put(5, new MyInlineKeyboardButton("5", "mikro_5"));
        mikroraionMap.put(6, new MyInlineKeyboardButton("5а", "mikro_5a"));
        mikroraionMap.put(7, new MyInlineKeyboardButton("6", "mikro_6"));
        mikroraionMap.put(8, new MyInlineKeyboardButton("7", "mikro_7"));
        mikroraionMap.put(9, new MyInlineKeyboardButton("8", "mikro_8"));
        mikroraionMap.put(10, new MyInlineKeyboardButton("8а", "mikro_8a"));
        mikroraionMap.put(11, new MyInlineKeyboardButton("9", "mikro_9"));
        mikroraionMap.put(12, new MyInlineKeyboardButton("9а", "mikro_9a"));
        mikroraionMap.put(13, new MyInlineKeyboardButton("10", "mikro_10"));
        mikroraionMap.put(14, new MyInlineKeyboardButton("11", "mikro_11"));
        mikroraionMap.put(15, new MyInlineKeyboardButton("21", "mikro_21"));
        mikroraionMap.put(16, new MyInlineKeyboardButton("Своё значение", "m_hand"));

        //заполним клавиатуру микрорайонов
        roomNumbersMap.put(0, new MyInlineKeyboardButton("1", "r1"));
        roomNumbersMap.put(1, new MyInlineKeyboardButton("2", "r2"));
        roomNumbersMap.put(2, new MyInlineKeyboardButton("3", "r3"));
        roomNumbersMap.put(3, new MyInlineKeyboardButton("4", "r4"));
        roomNumbersMap.put(4, new MyInlineKeyboardButton("5", "r5"));
        roomNumbersMap.put(5, new MyInlineKeyboardButton("Своё значение", "room_hand"));

        //заполним клавиатуру этажей
        floorNumbersMap.put(0, new MyInlineKeyboardButton("0", "f0"));
        floorNumbersMap.put(1, new MyInlineKeyboardButton("1", "f1"));
        floorNumbersMap.put(2, new MyInlineKeyboardButton("2", "f2"));
        floorNumbersMap.put(3, new MyInlineKeyboardButton("3", "f3"));
        floorNumbersMap.put(4, new MyInlineKeyboardButton("4", "f4"));
        floorNumbersMap.put(5, new MyInlineKeyboardButton("5", "f5"));
        floorNumbersMap.put(6, new MyInlineKeyboardButton("6", "f6"));
        floorNumbersMap.put(7, new MyInlineKeyboardButton("7", "f7"));
        floorNumbersMap.put(8, new MyInlineKeyboardButton("8", "f8"));
        floorNumbersMap.put(9, new MyInlineKeyboardButton("9", "f9"));
        floorNumbersMap.put(10, new MyInlineKeyboardButton("10", "f10"));
        floorNumbersMap.put(11, new MyInlineKeyboardButton("11", "f11"));
        floorNumbersMap.put(12, new MyInlineKeyboardButton("12", "f12"));
        floorNumbersMap.put(13, new MyInlineKeyboardButton("13", "f13"));
        floorNumbersMap.put(14, new MyInlineKeyboardButton("14", "f14"));
        floorNumbersMap.put(15, new MyInlineKeyboardButton("15", "f15"));
        floorNumbersMap.put(16, new MyInlineKeyboardButton("16", "f16"));
        floorNumbersMap.put(17, new MyInlineKeyboardButton("Своё значение", "floor_hand"));

        //заполним клавиатуру Всего этажей
//        totalFloorNumbersMap.put(0, new MyInlineKeyboardButton(0, ))

    }

    public static HashMap<Integer, MyInlineKeyboardButton> getButtonsMap(String param) {
        HashMap<Integer, MyInlineKeyboardButton> tmpMap = null;
        if (param.equals("type")) {
            tmpMap = typeMap;
        } else if (param.equals("mikro")) {
            tmpMap = mikroraionMap;
        } else if (param.equals("room")) {
            tmpMap = roomNumbersMap;
        } else if (param.equals("floor")) {
            tmpMap = floorNumbersMap;
        }
        return tmpMap;
    }

    public static ArrayList<String> getMapValues(String param) {
        ArrayList<String> toReturn = new ArrayList<>();
        HashMap<Integer, MyInlineKeyboardButton> tmpMap = null;
        if (param.equals("mikro")) {
            tmpMap = mikroraionMap;
        } else if (param.equals("room")) {
            tmpMap = roomNumbersMap;
        } else if (param.equals("floor")) {
            tmpMap = floorNumbersMap;
        }
        for (MyInlineKeyboardButton s : tmpMap.values()) {
            String callData = s.getCallbackData();
            if (!callData.contains("hand")) {
                toReturn.add(callData);
            }
        }
        return toReturn;
    }
}
