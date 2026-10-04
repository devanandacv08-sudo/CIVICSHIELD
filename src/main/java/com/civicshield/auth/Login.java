package com.civicshield.auth;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login {

    public static void main(String[] args) {

        JFrame frame = new JFrame("CivicShield - Login");

        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 50, 100, 30);
        frame.add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds(150, 50, 180, 30);
        frame.add(emailField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 100, 100, 30);
        frame.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(150, 100, 180, 30);
        frame.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(140, 160, 120, 35);
        frame.add(loginButton);

        loginButton.addActionListener(e -> {

            String email = emailField.getText();
            String password = new String(passwordField.getPassword());

            String url = "jdbc:mysql://localhost:3306/civicshield_db";
            String username = "root";
            String dbPassword = "ramdev@123";

            String sql = "SELECT * FROM users WHERE email = ? AND password = ?";

            try {

                Connection connection =
                        DriverManager.getConnection(url, username, dbPassword);

                PreparedStatement statement =
                        connection.prepareStatement(sql);

                statement.setString(1, email);
                statement.setString(2, password);

                ResultSet result = statement.executeQuery();

                if (result.next()) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Login Successful!"
                    );

                } else {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Invalid email or password!"
                    );
                }

                connection.close();

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Login Failed: " + ex.getMessage()
                );
            }
        });

        frame.setVisible(true);
    }
}