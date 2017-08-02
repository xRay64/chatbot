package com.sulakov.realtbot;

import java.util.Date;

/**
 * Created by Антон on 10.07.2017.
 */
public class MyRealtObject {

    private String name;         //Имя объекта
    private int type;            //1 - квартира
    //2 - дом
    //3 - комната
    //4 - новостройка
    //5 - земельные участок
    //6 - гараж
    //7 - дача
    //8 - комерческая недвижимость
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


    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

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

    public String getMikroraion() {
        return mikroraion;
    }

    public String getStreet() {
        return street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public int getAptNumber() {
        return aptNumber;
    }

    public int getRooms() {
        return rooms;
    }

    public int getFloor() {
        return floor;
    }

    public int getFloorInHouse() {
        return floorInHouse;
    }

    public int getTotalArea() {
        return totalArea;
    }

    public String getBath() {
        return bath;
    }

    public String getHouseType() {
        return houseType;
    }

    public String getBalcony() {
        return balcony;
    }

    public int getPrice() {
        return price;
    }

    public int getPhone() {
        return phone;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public int getDeposit() {
        return deposit;
    }

    public Date getDepositDateFrom() {
        return depositDateFrom;
    }

    public Date getDepositDateTo() {
        return depositDateTo;
    }

    @Override
    public String toString() {
        String toReturn = "Объект: \n";
        if (type != 0) {
            String typeToString = "";
            if (type == 1) {
                typeToString = "Квартира";
            } else if (type == 2) {
                typeToString = "Дом";
            } else if (type == 3) {
                typeToString = "Комната";
            } else if (type == 4) {
                typeToString = "Новостройка";
            } else if (type == 5) {
                typeToString = "Земельный участок";
            } else if (type == 6) {
                typeToString = "Гараж";
            } else if (type == 7) {
                typeToString = "Дача";
            } else if (type == 8) {
                typeToString = "Комерческая недвижимость";
            } else {
                System.out.println("ERROR: В методе toString объекта MyRealtObject. Не верный тип объекта.");
            }
            toReturn += "Тип: " + typeToString + "\n";
        }
        if (mikroraion != null) {
            toReturn += "Микрорайон: " + mikroraion + "\n";
        }
        if (street != null) {
            toReturn += "Улица: " + street + "\n";
        }
        if (houseNumber != 0) {
            toReturn += "Номер дома: " + houseNumber + "\n";
        }
        if (aptNumber != 0) {
            toReturn += "Номер квартиры: " + aptNumber + "\n";
        }
        if (rooms != 0) {
            toReturn += "Количество комнат: " + rooms + "\n";
        }
        if (floor != 0) {
            toReturn += "Этаж: " + floor + "\n";
        }
        if (floorInHouse != 0) {
            toReturn += "Этажей в здании: " + floorInHouse + "\n";
        }
        if (totalArea != 0) {
            toReturn += "Общая площадь: " + totalArea + "\n";
        }
        if (bath != null) {
            toReturn += "Сан.узел: " + bath + "\n";
        }
        if (houseType != null) {
            toReturn += "Тип дома: " + houseType + "\n";
        }
        if (balcony != null) {
            toReturn += "Балкон: " + balcony + "\n";
        }
        if (price != 0) {
            toReturn += "Цена: " + price + "\n";
        }
        if (phone != 0) {
            toReturn += "Телефон собственника: " + phone + "\n";
        }
        if (ownerName != null) {
            toReturn += "Имя собственника: " + ownerName + "\n";
        }
        if (deposit != 0) {
            toReturn += "Данные о задатке: " + deposit + "\n";
        }
        if (depositDateFrom != null) {
            toReturn += "Дата взятия задатка: " + depositDateFrom + "\n";
        }
        if (depositDateTo != null) {
            toReturn += "Дата окончания задатка: " + depositDateTo + "\n";
        }
        if (!toReturn.equals("")) {
            toReturn += "---------- \n";
        }
        return toReturn;
    }
}
