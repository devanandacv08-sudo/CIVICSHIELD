package com.civicshield;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/civicshield_db";
        String username = "root";
        String password = "ramdev@123";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            System.out.println("Database Connected Successfully!");

            connection.close();

        } catch (Exception e) {
            System.out.println("Database Connection Failed!");
            e.printStackTrace();
        }
    }
}