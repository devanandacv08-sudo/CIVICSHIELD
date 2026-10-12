
package com.civicshield.auth;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login {

    private JFrame frame;

    // CivicShield colors
    private final Color DARK_BLUE = new Color(5, 32, 72);
    private final Color BLUE = new Color(0, 110, 230);
    private final Color LIGHT_BLUE = new Color(235, 245, 255);
    private final Color TEXT_DARK = new Color(20, 40, 70);
    private final Color GRAY = new Color(100, 120, 145);

    public Login() {
        frame = new JFrame("CivicShield - Login");

        frame.setSize(900, 600);
        frame.setMinimumSize(new Dimension(850, 550));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        // LEFT PANEL
        GradientPanel leftPanel =
                new GradientPanel(DARK_BLUE, new Color(0, 105, 220));

        leftPanel.setPreferredSize(new Dimension(390, 600));
        leftPanel.setLayout(null);

        JLabel shield = new JLabel("🛡");
        shield.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 70));
        shield.setForeground(Color.WHITE);
        shield.setBounds(55, 55, 90, 80);
        leftPanel.add(shield);

        JLabel logoTitle = new JLabel("CivicShield");
        logoTitle.setFont(new Font("Segoe UI", Font.BOLD, 36));
        logoTitle.setForeground(Color.WHITE);
        logoTitle.setBounds(145, 65, 220, 45);
        leftPanel.add(logoTitle);

        JLabel tagline =
                new JLabel("Stronger Communities. Safer Tomorrow.");
        tagline.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        tagline.setForeground(Color.WHITE);
        tagline.setBounds(148, 108, 230, 25);
        leftPanel.add(tagline);

        JLabel feature1Icon = new JLabel("◆");
        feature1Icon.setFont(new Font("Segoe UI", Font.BOLD, 24));
        feature1Icon.setForeground(Color.WHITE);
        feature1Icon.setBounds(50, 245, 35, 35);
        leftPanel.add(feature1Icon);

        JLabel feature1Title = new JLabel("Report Issues");
        feature1Title.setFont(new Font("Segoe UI", Font.BOLD, 16));
        feature1Title.setForeground(Color.WHITE);
        feature1Title.setBounds(95, 235, 200, 30);
        leftPanel.add(feature1Title);

        JLabel feature1Text =
                new JLabel("Make your community better");
        feature1Text.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        feature1Text.setForeground(new Color(220, 235, 255));
        feature1Text.setBounds(95, 265, 220, 25);
        leftPanel.add(feature1Text);

        JLabel feature2Icon = new JLabel("●");
        feature2Icon.setFont(new Font("Segoe UI", Font.BOLD, 24));
        feature2Icon.setForeground(Color.WHITE);
        feature2Icon.setBounds(50, 320, 35, 35);
        leftPanel.add(feature2Icon);

        JLabel feature2Title = new JLabel("Stay Informed");
        feature2Title.setFont(new Font("Segoe UI", Font.BOLD, 16));
        feature2Title.setForeground(Color.WHITE);
        feature2Title.setBounds(95, 310, 200, 30);
        leftPanel.add(feature2Title);

        JLabel feature2Text = new JLabel("Get real-time updates");
        feature2Text.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        feature2Text.setForeground(new Color(220, 235, 255));
        feature2Text.setBounds(95, 340, 220, 25);
        leftPanel.add(feature2Text);

        JLabel feature3Icon = new JLabel("🔒");
        feature3Icon.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 25));
        feature3Icon.setForeground(Color.WHITE);
        feature3Icon.setBounds(50, 395, 35, 35);
        leftPanel.add(feature3Icon);

        JLabel feature3Title = new JLabel("Your Privacy Matters");
        feature3Title.setFont(new Font("Segoe UI", Font.BOLD, 16));
        feature3Title.setForeground(Color.WHITE);
        feature3Title.setBounds(95, 385, 220, 30);
        leftPanel.add(feature3Title);

        JLabel feature3Text =
                new JLabel("Your data is always protected");
        feature3Text.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        feature3Text.setForeground(new Color(220, 235, 255));
        feature3Text.setBounds(95, 415, 220, 25);
        leftPanel.add(feature3Text);

        JLabel bottomText = new JLabel(
                "<html><center>Together for a cleaner,<br>" +
                "safer and better community.</center></html>"
        );
        bottomText.setFont(new Font("Segoe UI", Font.ITALIC, 14));
        bottomText.setForeground(Color.WHITE);
        bottomText.setHorizontalAlignment(SwingConstants.CENTER);
        bottomText.setBounds(45, 500, 300, 55);
        leftPanel.add(bottomText);

        // RIGHT PANEL
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setLayout(new GridBagLayout());

        JPanel loginCard = new JPanel();
        loginCard.setBackground(Color.WHITE);
        loginCard.setPreferredSize(new Dimension(390, 500));
        loginCard.setLayout(null);
        loginCard.setBorder(new EmptyBorder(20, 25, 20, 25));

        JLabel cardShield = new JLabel("🛡");
        cardShield.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 55));
        cardShield.setHorizontalAlignment(SwingConstants.CENTER);
        cardShield.setBounds(145, 10, 100, 65);
        loginCard.add(cardShield);

        JLabel welcomeTitle = new JLabel("CivicShield");
        welcomeTitle.setFont(new Font("Segoe UI", Font.BOLD, 30));
        welcomeTitle.setForeground(TEXT_DARK);
        welcomeTitle.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeTitle.setBounds(70, 75, 250, 40);
        loginCard.add(welcomeTitle);

        JLabel welcome = new JLabel("Welcome Back!");
        welcome.setFont(new Font("Segoe UI", Font.BOLD, 22));
        welcome.setForeground(TEXT_DARK);
        welcome.setHorizontalAlignment(SwingConstants.CENTER);
        welcome.setBounds(70, 120, 250, 35);
        loginCard.add(welcome);

        JLabel subtitle = new JLabel("Login to your account");
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        subtitle.setForeground(GRAY);
        subtitle.setHorizontalAlignment(SwingConstants.CENTER);
        subtitle.setBounds(70, 153, 250, 30);
        loginCard.add(subtitle);

        // EMAIL FIELD
        JLabel emailIcon = new JLabel("✉");
        emailIcon.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 20));
        emailIcon.setForeground(GRAY);
        emailIcon.setBounds(35, 205, 30, 35);
        loginCard.add(emailIcon);

        JTextField emailField = new JTextField();
        emailField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        emailField.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(205, 220, 240)),
                        BorderFactory.createEmptyBorder(5, 40, 5, 10)
                )
        );
        emailField.setBounds(25, 200, 340, 45);
        loginCard.add(emailField);

        // PASSWORD FIELD
        JLabel passwordIcon = new JLabel("🔒");
        passwordIcon.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
        passwordIcon.setForeground(GRAY);
        passwordIcon.setBounds(35, 270, 30, 35);
        loginCard.add(passwordIcon);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        passwordField.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(205, 220, 240)),
                        BorderFactory.createEmptyBorder(5, 40, 5, 10)
                )
        );
        passwordField.setBounds(25, 265, 340, 45);
        loginCard.add(passwordField);

        // LOGIN BUTTON
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(BLUE);
        loginButton.setFocusPainted(false);
        loginButton.setBorderPainted(false);
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginButton.setBounds(25, 330, 340, 48);
        loginCard.add(loginButton);

        // OR
        JLabel orLabel = new JLabel("OR");
        orLabel.setFont(new Font("Segoe UI", Font.BOLD, 13));
        orLabel.setForeground(GRAY);
        orLabel.setHorizontalAlignment(SwingConstants.CENTER);
        orLabel.setBounds(155, 385, 80, 25);
        loginCard.add(orLabel);

        // REGISTER
        JLabel registerText = new JLabel("New to CivicShield?");
        registerText.setFont(new Font("Segoe UI", Font.BOLD, 14));
        registerText.setForeground(TEXT_DARK);
        registerText.setHorizontalAlignment(SwingConstants.CENTER);
        registerText.setBounds(90, 410, 210, 25);
        loginCard.add(registerText);

        JButton registerButton = new JButton("Register");
        registerButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
        registerButton.setForeground(BLUE);
        registerButton.setBackground(Color.WHITE);
        registerButton.setFocusPainted(false);
        registerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        registerButton.setBorder(
                BorderFactory.createLineBorder(BLUE, 1)
        );
        registerButton.setBounds(25, 440, 340, 42);
        loginCard.add(registerButton);

        // LOGIN ACTION
        loginButton.addActionListener(e -> {
            String email = emailField.getText().trim();
            String password = new String(passwordField.getPassword());

            if (email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(
                        frame,
                        "Please enter email and password.",
                        "Login",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            String url =
                    "jdbc:mysql://localhost:3306/civicshield_db";
            String username = "root";

            // Read database password from environment variable.
            String dbPassword =
                    System.getenv("CIVICSHIELD_DB_PASSWORD");

            if (dbPassword == null || dbPassword.isBlank()) {
                JOptionPane.showMessageDialog(
                        frame,
                        "Database password is not configured. " +
                        "Please set CIVICSHIELD_DB_PASSWORD.",
                        "Database Configuration",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            String sql =
                    "SELECT user_id, name FROM users " +
                    "WHERE email = ? AND password = ?";

            try (
                    Connection connection =
                            DriverManager.getConnection(
                                    url, username, dbPassword);
                    PreparedStatement statement =
                            connection.prepareStatement(sql)
            ) {
                statement.setString(1, email);
                statement.setString(2, password);

                try (ResultSet result = statement.executeQuery()) {
                    if (result.next()) {
                        int userId = result.getInt("user_id");
                        String name = result.getString("name");

                        JOptionPane.showMessageDialog(
                                frame,
                                "Login Successful!",
                                "CivicShield",
                                JOptionPane.INFORMATION_MESSAGE
                        );

                        frame.dispose();
                        new UserDashboard(userId, name);

                    } else {
                        JOptionPane.showMessageDialog(
                                frame,
                                "Invalid email or password!",
                                "Login Failed",
                                JOptionPane.ERROR_MESSAGE
                        );
                    }
                }

            } catch (Exception ex) {
                ex.printStackTrace();

                JOptionPane.showMessageDialog(
                        frame,
                        "Login failed. Check your database " +
                        "connection and configuration.",
                        "Database Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });

        // REGISTER ACTION
        registerButton.addActionListener(e -> {
            new Register();
            frame.dispose();
        });

        // ADD PANELS
        rightPanel.add(loginCard);
        frame.add(leftPanel, BorderLayout.WEST);
        frame.add(rightPanel, BorderLayout.CENTER);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // GRADIENT PANEL
    static class GradientPanel extends JPanel {

        private final Color color1;
        private final Color color2;

        public GradientPanel(Color color1, Color color2) {
            this.color1 = color1;
            this.color2 = color2;
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g.create();

            int width = getWidth();
            int height = getHeight();

            GradientPaint gradient = new GradientPaint(
                    0, 0, color1,
                    width, height, color2
            );

            g2.setPaint(gradient);
            g2.fillRect(0, 0, width, height);
            g2.dispose();
        }
    }

    // MAIN
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Login());
    }
}
