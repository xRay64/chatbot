package com.sulakov.realtbot.dbcon;


import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Антон on 25.06.2017.
 */
public class GetBotParam {
    public static String getParam(String param) throws URISyntaxException, SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        System.out.println("Драйвер подключен");
        Connection connection = BotDBConnection.getConnection();
        System.out.println("Соединение установлено");
        String res;
        Statement statement = null;
        statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT value FROM settings WHERE name like '" + param +"';");

        res = resultSet.getString("value");
        return res;
    }
}
