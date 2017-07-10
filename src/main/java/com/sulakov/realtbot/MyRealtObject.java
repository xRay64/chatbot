package com.sulakov.realtbot;

import java.util.Date;

/**
 * Created by Антон on 10.07.2017.
 */
public class MyRealtObject {

    private String mikroraion;   //1. Микрорайон
    private String street;       //2. Улица
    private int houseNumber;     //3. Номер дома
    private int aptNumber;       //4. Номер квартиры
    private int rooms;           //5. Кол-во комнат
    private int floor;           //6. Этаж
    private int floorInHouse;    //7. Всего этажей в доме
    private int totalArea;       //8. Общая площадь
    private String bath;         //9. Санузел (совмещенный/раздельный)
    private String houseType;    //10. Тип дома (панельный/кирпичный)
    private String balcony;      //11. Тип балкона (балкон/лоджия /без балкона)
    private int price;           //12. Стоимость
    private int phone;           //13. Номер телефона собственника
    private String ownerName;    //14. Имя хозяина
    private int deposit;         //15. Данные о задатке (если есть задаток, то дата когда он был передан и срок его окончания)
    private Date depositDateFrom;//16. дата взятия задатка
    private Date depositDateTo;  //17. срок окончания задатка
    //16. Ну и фотографии

    public void setMikroraion(String mikroraion) {

        this.mikroraion = mikroraion;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setAptNumber(int aptNumber) {
        this.aptNumber = aptNumber;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setFloorInHouse(int floorInHouse) {
        this.floorInHouse = floorInHouse;
    }

    public void setTotalArea(int totalArea) {
        this.totalArea = totalArea;
    }

    public void setBath(String bath) {
        this.bath = bath;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public void setBalcony(String balcony) {
        this.balcony = balcony;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public void setDepositDateFrom(Date depositDateFrom) {
        this.depositDateFrom = depositDateFrom;
    }

    public void setDepositDateTo(Date depositDateTo) {
        this.depositDateTo = depositDateTo;
    }

}
