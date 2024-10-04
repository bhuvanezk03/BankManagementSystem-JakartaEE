package com.bankapp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver"); // Oracle JDBC driver
                connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "your_username", "your_password");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                throw new SQLException("Error connecting to the database.");
            }
        }
        return connection;
    }
}
