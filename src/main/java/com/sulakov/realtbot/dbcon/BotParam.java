package com.sulakov.realtbot.dbcon;


import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Антон on 25.06.2017.
 */
public class BotParam {
    public static String getParam(String param){
        Connection connection = null;
        String res = null;
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Драйвер подключен");
            connection = BotDBConnection.getConnection();
            System.out.println("Соединение установлено");
            Statement statement;
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT value FROM settings WHERE name like '" + param + "';");
            resultSet.next();
            res = resultSet.getString("value");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return res;
    }
}
