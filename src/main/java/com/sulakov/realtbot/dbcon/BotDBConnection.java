package com.sulakov.realtbot.dbcon;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by anton on 24.06.17.
 */
abstract class BotDBConnection implements Connection {
    static Connection getConnection() throws URISyntaxException, SQLException {
//        URI dbUri = new URI(System.getenv("DATABASE_URL"));
//
//        String username = dbUri.getUserInfo().split(":")[0];
//        String password = dbUri.getUserInfo().split(":")[1];
//        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
//
//        return DriverManager.getConnection(dbUrl, username, password);
        URI dbUri = new URI("postgres://jrfhnnvofjymnq:d3e1bc9a2939250eb08320b09da848e5405e81eedf5e2d77e7f7582f058a02d7@ec2-54-246-108-119.eu-west-1.compute.amazonaws.com:5432/d377cs21mc63o2");

        Properties props = new Properties();
        props.setProperty("user",dbUri.getUserInfo().split(":")[0]);
        props.setProperty("password",dbUri.getUserInfo().split(":")[1]);
        props.setProperty("sslmode","require");
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
        return DriverManager.getConnection(dbUrl, props);
    }

}
