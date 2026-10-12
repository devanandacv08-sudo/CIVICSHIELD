
package com.civicshield.auth;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Register extends JFrame {

    private static final Color BLUE = new Color(35, 91, 190);
    private final JTextField nameField = new JTextField(20);
    private final JTextField emailField = new JTextField(20);
    private final JPasswordField passwordField = new JPasswordField(20);
    private final JPasswordField confirmPasswordField = new JPasswordField(20);

    public Register() {
        setTitle("CivicShield - Register");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(450, 500);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(25, 35, 25, 35));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(7, 0, 7, 0);

        JLabel title = new JLabel("Create Your Account", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(BLUE);

        addRow(panel, gbc, title);
        addRow(panel, gbc, new JLabel("Full Name"));
        addRow(panel, gbc, nameField);
        addRow(panel, gbc, new JLabel("Email"));
        addRow(panel, gbc, emailField);
        addRow(panel, gbc, new JLabel("Password"));
        addRow(panel, gbc, passwordField);
        addRow(panel, gbc, new JLabel("Confirm Password"));
        addRow(panel, gbc, confirmPasswordField);

        JButton registerButton = new JButton("Create Account");
        registerButton.setBackground(BLUE);
        registerButton.setForeground(Color.WHITE);
        registerButton.setFocusPainted(false);
        registerButton.addActionListener(e -> registerUser());
        addRow(panel, gbc, registerButton);

        JButton loginButton = new JButton("Back to Login");
        loginButton.addActionListener(e -> {
            dispose();
            new Login();
        });
        addRow(panel, gbc, loginButton);

        setContentPane(panel);
        setVisible(true);
    }

    private void addRow(JPanel panel, GridBagConstraints gbc,
                        Component component) {
        gbc.gridy = gbc.gridy + 1;
        panel.add(component, gbc);
    }

    private void registerUser() {
        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        String password = new String(passwordField.getPassword());
        String confirmPassword =
                new String(confirmPasswordField.getPassword());

        if (name.isEmpty() || email.isEmpty()
                || password.isEmpty() || confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please fill in all fields.");
            return;
        }

        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            JOptionPane.showMessageDialog(this,
                    "Please enter a valid email address.");
            return;
        }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this,
                    "Passwords do not match.");
            return;
        }

        String dbPassword = System.getenv("CIVICSHIELD_DB_PASSWORD");

        if (dbPassword == null || dbPassword.isBlank()) {
            JOptionPane.showMessageDialog(this,
                    "Database password is not configured.");
            return;
        }

        String url = "jdbc:mysql://localhost:3306/civicshield_db";

        String checkSql =
                "SELECT user_id FROM users WHERE email = ?";
        String insertSql =
                "INSERT INTO users (name, email, password, role) "
                + "VALUES (?, ?, ?, ?)";

        try (Connection connection =
                     DriverManager.getConnection(url, "root", dbPassword);
             PreparedStatement check =
                     connection.prepareStatement(checkSql)) {

            check.setString(1, email);

            try (java.sql.ResultSet result = check.executeQuery()) {
                if (result.next()) {
                    JOptionPane.showMessageDialog(this,
                            "An account with this email already exists.");
                    return;
                }
            }

            try (PreparedStatement insert =
                         connection.prepareStatement(insertSql)) {
                insert.setString(1, name);
                insert.setString(2, email);
                insert.setString(3, password);
                insert.setString(4, "user");
                insert.executeUpdate();
            }

            JOptionPane.showMessageDialog(this,
                    "Account created successfully! Please log in.");
            dispose();
            new Login();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    "Registration failed: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Register::new);
    }
}
