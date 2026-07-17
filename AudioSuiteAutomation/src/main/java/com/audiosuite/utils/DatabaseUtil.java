package com.audiosuite.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.Logger;

import com.audiosuite.config.ConfigReader;

public class DatabaseUtil {

    private static Connection connection;
    private static final Logger log = LogUtil.getLogger(DatabaseUtil.class);

    public static void connect() {

        try {
            connection = DriverManager.getConnection(
                    ConfigReader.get("db.url"),
                    ConfigReader.get("db.username"),
                    ConfigReader.get("db.password"));

            log.info("Database connected successfully.");

        } catch (SQLException e) {
            log.error("Database connection failed.", e);
            throw new RuntimeException(e);
        }
    }

    public static ResultSet executeQuery(String query) {

        try {
            Statement statement = connection.createStatement();
            return statement.executeQuery(query);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int executeUpdate(String query) {

        try {
            Statement statement = connection.createStatement();
            return statement.executeUpdate(query);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void disconnect() {

        try {

            if (connection != null) {
                connection.close();
                log.info("Database connection closed.");
            }

        } catch (SQLException e) {
            log.error("Unable to close database connection.", e);
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}