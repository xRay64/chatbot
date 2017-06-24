package com.sulakov.realtbot.dbcon;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by anton on 24.06.17.
 */
public class BotDBConnection {
    private static Connection getConnection() throws URISyntaxException, SQLException {
        URI dbUri = new URI(System.getenv("postgres://jrfhnnvofjymnq:d3e1bc9a2939250eb08320b09da848e5405e81eedf5e2d77e7f7582f058a02d7@ec2-54-246-108-119.eu-west-1.compute.amazonaws.com:5432/d377cs21mc63o2"));

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

        return DriverManager.getConnection(dbUrl, username, password);
    }

    public Connection BotDBConnection() throws URISyntaxException, SQLException {
        return getConnection();
    }
}
