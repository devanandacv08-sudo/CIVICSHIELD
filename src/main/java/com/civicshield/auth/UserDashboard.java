package com.civicshield.auth;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class UserDashboard {

    private JFrame frame;

    // CivicShield colors
    private final Color DARK_BLUE = new Color(5, 32, 72);
    private final Color BLUE = new Color(0, 110, 230);
    private final Color LIGHT_BLUE = new Color(235, 245, 255);
    private final Color TEXT_DARK = new Color(20, 40, 70);
    private final Color GRAY = new Color(100, 120, 145);
    private final Color WHITE = Color.WHITE;

    public UserDashboard() {

        frame = new JFrame("CivicShield - User Dashboard");

        frame.setSize(1100, 700);
        frame.setMinimumSize(new Dimension(950, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        // =========================================================
        // SIDEBAR
        // =========================================================

        JPanel sidebar = new JPanel();
        sidebar.setPreferredSize(new Dimension(250, 700));
        sidebar.setBackground(DARK_BLUE);
        sidebar.setLayout(null);

        // Logo
        JLabel shield = new JLabel("🛡");
        shield.setFont(
                new Font("Segoe UI Emoji", Font.PLAIN, 55)
        );
        shield.setForeground(Color.WHITE);
        shield.setBounds(25, 25, 70, 65);
        sidebar.add(shield);

        JLabel logo = new JLabel("CivicShield");
        logo.setFont(
                new Font("Segoe UI", Font.BOLD, 27)
        );
        logo.setForeground(Color.WHITE);
        logo.setBounds(85, 35, 150, 40);
        sidebar.add(logo);

        JLabel tagline =
                new JLabel("Stronger Communities. Safer Tomorrow.");

        tagline.setFont(
                new Font("Segoe UI", Font.PLAIN, 9)
        );
        tagline.setForeground(
                new Color(200, 220, 245)
        );
        tagline.setBounds(85, 68, 160, 25);
        sidebar.add(tagline);

        // =========================================================
        // SIDEBAR BUTTONS
        // =========================================================

        JButton dashboardButton =
                createSidebarButton("⌂   Dashboard");

        dashboardButton.setBounds(15, 140, 220, 48);
        sidebar.add(dashboardButton);

        JButton complaintButton =
                createSidebarButton("▣   Complaints");

        complaintButton.setBounds(15, 200, 220, 48);
        sidebar.add(complaintButton);

        JButton trackButton =
                createSidebarButton("◈   Track Status");

        trackButton.setBounds(15, 260, 220, 48);
        sidebar.add(trackButton);

        JButton privacyButton =
                createSidebarButton("⚙   Privacy & Consent");

        privacyButton.setBounds(15, 320, 220, 48);
        sidebar.add(privacyButton);

        JButton profileButton =
                createSidebarButton("♙   Profile");

        profileButton.setBounds(15, 380, 220, 48);
        sidebar.add(profileButton);

        JButton logoutButton =
                createSidebarButton("⇥   Logout");

        logoutButton.setBounds(15, 440, 220, 48);
        sidebar.add(logoutButton);

        // Sidebar footer
        JLabel footer =
                new JLabel(
                        "<html><center>Together for a cleaner,<br>" +
                        "safer and better community.</center></html>"
                );

        footer.setFont(
                new Font("Segoe UI", Font.ITALIC, 12)
        );

        footer.setForeground(
                new Color(200, 220, 245)
        );

        footer.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        footer.setBounds(20, 570, 210, 55);

        sidebar.add(footer);

        // =========================================================
        // MAIN PANEL
        // =========================================================

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(
                new Color(247, 250, 254)
        );

        mainPanel.setLayout(
                new BorderLayout()
        );

        // =========================================================
        // TOP BAR
        // =========================================================

        JPanel topBar = new JPanel();
        topBar.setBackground(WHITE);
        topBar.setPreferredSize(
                new Dimension(850, 70)
        );
        topBar.setLayout(null);

        JLabel topTitle =
                new JLabel("User Dashboard");

        topTitle.setFont(
                new Font("Segoe UI", Font.BOLD, 22)
        );

        topTitle.setForeground(TEXT_DARK);
        topTitle.setBounds(30, 20, 250, 35);
        topBar.add(topTitle);

        JLabel welcomeUser =
                new JLabel("👤  Welcome, Devu");

        welcomeUser.setFont(
                new Font("Segoe UI", Font.BOLD, 15)
        );

        welcomeUser.setForeground(TEXT_DARK);
        welcomeUser.setBounds(650, 20, 180, 35);
        topBar.add(welcomeUser);

        mainPanel.add(
                topBar,
                BorderLayout.NORTH
        );

        // =========================================================
        // CONTENT
        // =========================================================

        JPanel content = new JPanel();

        content.setBackground(
                new Color(247, 250, 254)
        );

        content.setBorder(
                new EmptyBorder(
                        25,
                        30,
                        25,
                        30
                )
        );

        content.setLayout(
                new BoxLayout(
                        content,
                        BoxLayout.Y_AXIS
                )
        );

        // =========================================================
        // WELCOME CARD
        // =========================================================

        JPanel welcomeCard =
                createCard();

        welcomeCard.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        100
                )
        );

        welcomeCard.setLayout(null);

        JLabel welcomeIcon =
                new JLabel("👤");

        welcomeIcon.setFont(
                new Font(
                        "Segoe UI Emoji",
                        Font.PLAIN,
                        45
                )
        );

        welcomeIcon.setBounds(
                25,
                20,
                60,
                55
        );

        welcomeCard.add(welcomeIcon);

        JLabel hello =
                new JLabel("Hello, Devu!");

        hello.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        25
                )
        );

        hello.setForeground(TEXT_DARK);
        hello.setBounds(
                90,
                18,
                300,
                35
        );

        welcomeCard.add(hello);

        JLabel welcomeText =
                new JLabel(
                        "Here's what's happening in your CivicShield account."
                );

        welcomeText.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14
                )
        );

        welcomeText.setForeground(GRAY);
        welcomeText.setBounds(
                90,
                52,
                500,
                25
        );

        welcomeCard.add(welcomeText);

        content.add(welcomeCard);

        content.add(
                Box.createVerticalStrut(20)
        );

        // =========================================================
        // SUMMARY CARDS
        // =========================================================

        JPanel summaryPanel =
                new JPanel(
                        new GridLayout(
                                1,
                                4,
                                15,
                                0
                        )
                );

        summaryPanel.setOpaque(false);

        summaryPanel.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        125
                )
        );

        summaryPanel.add(
                createSummaryCard(
                        "▣",
                        "Total Complaints",
                        "0",
                        BLUE
                )
        );

        summaryPanel.add(
                createSummaryCard(
                        "◷",
                        "In Progress",
                        "0",
                        new Color(230, 150, 20)
                )
        );

        summaryPanel.add(
                createSummaryCard(
                        "✓",
                        "Resolved",
                        "0",
                        new Color(20, 160, 100)
                )
        );

        summaryPanel.add(
                createSummaryCard(
                        "🛡",
                        "Your Privacy",
                        "Protected",
                        new Color(90, 70, 200)
                )
        );

        content.add(summaryPanel);

        content.add(
                Box.createVerticalStrut(20)
        );

        // =========================================================
        // LOWER SECTION
        // =========================================================

        JPanel lowerPanel =
                new JPanel(
                        new GridLayout(
                                1,
                                2,
                                20,
                                0
                        )
                );

        lowerPanel.setOpaque(false);

        // ---------------------------------------------------------
        // QUICK ACTIONS
        // ---------------------------------------------------------

        JPanel quickActions =
                createCard();

        quickActions.setLayout(null);

        JLabel quickTitle =
                new JLabel("Quick Actions");

        quickTitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        19
                )
        );

        quickTitle.setForeground(TEXT_DARK);
        quickTitle.setBounds(
                20,
                15,
                200,
                30
        );

        quickActions.add(quickTitle);

        JButton fileComplaint =
                createActionButton(
                        "▣  File a Complaint"
                );

        fileComplaint.setBounds(
                20,
                65,
                190,
                55
        );

        quickActions.add(fileComplaint);

        JButton privacyAction =
                createActionButton(
                        "🛡  Privacy & Consent"
                );

        privacyAction.setBounds(
                225,
                65,
                190,
                55
        );

        quickActions.add(privacyAction);

        JButton trackAction =
                createActionButton(
                        "◈  Track Status"
                );

        trackAction.setBounds(
                20,
                135,
                190,
                55
        );

        quickActions.add(trackAction);

        JButton profileAction =
                createActionButton(
                        "♙  Update Profile"
                );

        profileAction.setBounds(
                225,
                135,
                190,
                55
        );

        quickActions.add(profileAction);

        lowerPanel.add(quickActions);

        // ---------------------------------------------------------
        // RECENT ACTIVITY
        // ---------------------------------------------------------

        JPanel activity =
                createCard();

        activity.setLayout(null);

        JLabel activityTitle =
                new JLabel("Recent Activity");

        activityTitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        19
                )
        );

        activityTitle.setForeground(TEXT_DARK);
        activityTitle.setBounds(
                20,
                15,
                200,
                30
        );

        activity.add(activityTitle);

        JLabel activity1 =
                new JLabel("No recent activity");

        activity1.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14
                )
        );

        activity1.setForeground(GRAY);
        activity1.setBounds(
                25,
                75,
                300,
                30
        );

        activity.add(activity1);

        JLabel activity2 =
                new JLabel(
                        "Your complaint updates will appear here."
                );

        activity2.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        12
                )
        );

        activity2.setForeground(GRAY);
        activity2.setBounds(
                25,
                105,
                350,
                25
        );

        activity.add(activity2);

        lowerPanel.add(activity);

        content.add(lowerPanel);

        content.add(
                Box.createVerticalStrut(20)
        );

        // =========================================================
        // SAFETY BANNER
        // =========================================================

        JPanel safetyBanner =
                createCard();

        safetyBanner.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        85
                )
        );

        safetyBanner.setLayout(null);

        JLabel safetyIcon =
                new JLabel("🛡");

        safetyIcon.setFont(
                new Font(
                        "Segoe UI Emoji",
                        Font.PLAIN,
                        35
                )
        );

        safetyIcon.setBounds(
                20,
                20,
                50,
                45
        );

        safetyBanner.add(safetyIcon);

        JLabel safetyTitle =
                new JLabel(
                        "Your Safety, Our Priority"
                );

        safetyTitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        16
                )
        );

        safetyTitle.setForeground(BLUE);
        safetyTitle.setBounds(
                75,
                15,
                300,
                30
        );

        safetyBanner.add(safetyTitle);

        JLabel safetyText =
                new JLabel(
                        "Help us build a cleaner, safer and more transparent community."
                );

        safetyText.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13
                )
        );

        safetyText.setForeground(GRAY);
        safetyText.setBounds(
                75,
                45,
                650,
                25
        );

        safetyBanner.add(safetyText);

        content.add(safetyBanner);

        // Add content
        JScrollPane scrollPane =
                new JScrollPane(content);

        scrollPane.setBorder(null);

        scrollPane.getVerticalScrollBar()
                .setUnitIncrement(15);

        mainPanel.add(
                scrollPane,
                BorderLayout.CENTER
        );

        // =========================================================
        // BUTTON ACTIONS
        // =========================================================

        privacyButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    frame,
                    "Privacy & Consent module coming next!",
                    "Privacy & Consent",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        privacyAction.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    frame,
                    "Privacy & Consent module coming next!",
                    "Privacy & Consent",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        complaintButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    frame,
                    "Complaints module coming next!",
                    "Complaints",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        fileComplaint.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    frame,
                    "Complaint submission module coming next!",
                    "Complaints",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        trackButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    frame,
                    "Complaint tracking module coming next!",
                    "Track Status",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        trackAction.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    frame,
                    "Complaint tracking module coming next!",
                    "Track Status",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        profileButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    frame,
                    "Profile module coming next!",
                    "Profile",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        profileAction.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    frame,
                    "Profile module coming next!",
                    "Profile",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        logoutButton.addActionListener(e -> {

            int choice =
                    JOptionPane.showConfirmDialog(
                            frame,
                            "Are you sure you want to logout?",
                            "Logout",
                            JOptionPane.YES_NO_OPTION
                    );

            if (choice == JOptionPane.YES_OPTION) {

                frame.dispose();

                new Login();
            }
        });

        // =========================================================
        // ADD TO FRAME
        // =========================================================

        frame.add(
                sidebar,
                BorderLayout.WEST
        );

        frame.add(
                mainPanel,
                BorderLayout.CENTER
        );

        frame.setVisible(true);
    }

    // =============================================================
    // CREATE SIDEBAR BUTTON
    // =============================================================

    private JButton createSidebarButton(
            String text
    ) {

        JButton button =
                new JButton(text);

        button.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14
                )
        );

        button.setForeground(Color.WHITE);
        button.setBackground(DARK_BLUE);

        button.setHorizontalAlignment(
                SwingConstants.LEFT
        );

        button.setFocusPainted(false);
        button.setBorderPainted(false);

        button.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        return button;
    }

    // =============================================================
    // CREATE CARD
    // =============================================================

    private JPanel createCard() {

        JPanel panel =
                new JPanel();

        panel.setBackground(Color.WHITE);

        panel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(
                                        220,
                                        230,
                                        242
                                )
                        ),
                        new EmptyBorder(
                                10,
                                10,
                                10,
                                10
                        )
                )
        );

        return panel;
    }

    // =============================================================
    // SUMMARY CARD
    // =============================================================

    private JPanel createSummaryCard(
            String icon,
            String title,
            String value,
            Color accent
    ) {

        JPanel panel =
                createCard();

        panel.setLayout(null);

        JLabel iconLabel =
                new JLabel(icon);

        iconLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        25
                )
        );

        iconLabel.setForeground(accent);
        iconLabel.setBounds(
                20,
                15,
                45,
                40
        );

        panel.add(iconLabel);

        JLabel titleLabel =
                new JLabel(title);

        titleLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        12
                )
        );

        titleLabel.setForeground(GRAY);
        titleLabel.setBounds(
                20,
                55,
                150,
                25
        );

        panel.add(titleLabel);

        JLabel valueLabel =
                new JLabel(value);

        valueLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        20
                )
        );

        valueLabel.setForeground(accent);
        valueLabel.setBounds(
                20,
                80,
                170,
                30
        );

        panel.add(valueLabel);

        return panel;
    }

    // =============================================================
    // ACTION BUTTON
    // =============================================================

    private JButton createActionButton(
            String text
    ) {

        JButton button =
                new JButton(text);

        button.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        13
                )
        );

        button.setForeground(BLUE);
        button.setBackground(LIGHT_BLUE);

        button.setFocusPainted(false);

        button.setBorder(
                BorderFactory.createLineBorder(
                        new Color(
                                200,
                                220,
                                245
                        )
                )
        );

        button.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        return button;
    }

    // =============================================================
    // MAIN
    // =============================================================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                () -> new UserDashboard()
        );
    }
}