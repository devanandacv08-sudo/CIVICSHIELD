package com.civicshield.auth;

import javax.swing.*;

public class UserDashboard {

    public static void main(String[] args) {

        JFrame frame = new JFrame("CivicShield - User Dashboard");

        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel title = new JLabel("Welcome to CivicShield!");
        title.setBounds(200, 40, 250, 30);
        frame.add(title);

        JButton privacyButton = new JButton("Privacy & Consent");
        privacyButton.setBounds(180, 100, 220, 40);
        frame.add(privacyButton);

        JButton complaintButton = new JButton("Complaints");
        complaintButton.setBounds(180, 160, 220, 40);
        frame.add(complaintButton);

        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(180, 220, 220, 40);
        frame.add(logoutButton);

        logoutButton.addActionListener(e -> {
            frame.dispose();
        });

        frame.setVisible(true);
    }
}