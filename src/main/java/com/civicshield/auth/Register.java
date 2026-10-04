package com.civicshield.auth;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Register {

    public static void main(String[] args) {

        JFrame frame = new JFrame("CivicShield - Registration");

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 40, 100, 30);
        frame.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(150, 40, 180, 30);
        frame.add(nameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 90, 100, 30);
        frame.add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds(150, 90, 180, 30);
        frame.add(emailField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 140, 100, 30);
        frame.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(150, 140, 180, 30);
        frame.add(passwordField);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(140, 200, 120, 35);
        frame.add(registerButton);

        registerButton.addActionListener(e -> {

            String name = nameField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());

            String url = "jdbc:mysql://localhost:3306/civicshield_db";
            String username = "root";
            String dbPassword = "ramdev@123";

            String sql = "INSERT INTO users (name, email, password, role) VALUES (?, ?, ?, ?)";

            try {
                Connection connection = DriverManager.getConnection(
                        url, username, dbPassword
                );

                PreparedStatement statement = connection.prepareStatement(sql);

                statement.setString(1, name);
                statement.setString(2, email);
                statement.setString(3, password);
                statement.setString(4, "USER");

                statement.executeUpdate();

                JOptionPane.showMessageDialog(
                        frame,
                        "Registration Successful!"
                );

                connection.close();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(
                        frame,
                        "Registration Failed: " + ex.getMessage()
                );
            }
        });

        frame.setVisible(true);
    }
}