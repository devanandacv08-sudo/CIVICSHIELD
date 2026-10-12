
package com.civicshield.auth;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class Complaints {

    private final int userId;

    public Complaints(int userId) {
        this.userId = userId;
        showComplaintForm();
    }

    private void showComplaintForm() {

        JFrame frame = new JFrame("CivicShield - Submit a Complaint");
        frame.setSize(650, 700);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(
                BorderFactory.createEmptyBorder(20, 25, 20, 25)
        );

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(7, 6, 7, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        JLabel heading = new JLabel(
                "Submit a Complaint",
                SwingConstants.CENTER
        );
        heading.setFont(new Font("Arial", Font.BOLD, 23));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(heading, gbc);
        gbc.gridwidth = 1;

        JComboBox<String> categoryBox = new JComboBox<>(
                new String[]{
                        "Institution",
                        "Living Surroundings",
                        "Public Properties",
                        "Public Services",
                        "Other"
                }
        );

        JTextField institutionField = new JTextField(22);
        JTextField emailField = new JTextField(22);
        JTextField titleField = new JTextField(22);

        JTextArea descriptionArea = new JTextArea(5, 22);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);

        JComboBox<String> severityBox = new JComboBox<>(
                new String[]{"LOW", "MEDIUM", "HIGH"}
        );

        JComboBox<String> urgencyBox = new JComboBox<>(
                new String[]{"LOW", "MEDIUM", "HIGH"}
        );

        JLabel institutionNameLabel =
                new JLabel("Institution Name:");

        int row = 1;

        addRow(panel, gbc, row++, "Category:", categoryBox);

        addRow(
                panel, gbc, row++,
                institutionNameLabel, institutionField
        );

        addRow(panel, gbc, row++, "Recipient Email:", emailField);
        addRow(panel, gbc, row++, "Complaint Title:", titleField);

        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.weightx = 0;
        panel.add(new JLabel("Description:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        panel.add(new JScrollPane(descriptionArea), gbc);
        row++;

        addRow(panel, gbc, row++, "Severity:", severityBox);
        addRow(panel, gbc, row++, "Urgency:", urgencyBox);

        // Update the name label according to the selected category.
        categoryBox.addActionListener(e -> {
            String selectedCategory =
                    (String) categoryBox.getSelectedItem();

            if (selectedCategory == null) {
                return;
            }

            switch (selectedCategory) {
                case "Institution":
                    institutionNameLabel.setText("Institution Name:");
                    break;

                case "Living Surroundings":
                    institutionNameLabel.setText(
                            "Living Surroundings Name:"
                    );
                    break;

                case "Public Properties":
                    institutionNameLabel.setText(
                            "Public Property Name:"
                    );
                    break;

                case "Public Services":
                    institutionNameLabel.setText(
                            "Public Service Name:"
                    );
                    break;

                default:
                    institutionNameLabel.setText("Name:");
                    break;
            }
        });

        JButton submitButton = new JButton("Submit Complaint");
        JButton closeButton = new JButton("Close");

        JPanel buttons = new JPanel(
                new FlowLayout(FlowLayout.CENTER, 15, 5)
        );
        buttons.add(submitButton);
        buttons.add(closeButton);

        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.gridwidth = 2;
        panel.add(buttons, gbc);

        closeButton.addActionListener(e -> frame.dispose());

        submitButton.addActionListener(e -> {

            String category =
                    (String) categoryBox.getSelectedItem();

            String institution =
                    institutionField.getText().trim();

            String email = emailField.getText().trim();
            String title = titleField.getText().trim();
            String description = descriptionArea.getText().trim();

            String severity =
                    (String) severityBox.getSelectedItem();

            String urgency =
                    (String) urgencyBox.getSelectedItem();

            // Validate required fields.
            if (category == null
                    || institution.isEmpty()
                    || email.isEmpty()
                    || title.isEmpty()
                    || description.isEmpty()) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Please complete all required fields."
                );
                return;
            }

            // Validate recipient email format.
            if (!email.matches(
                    "^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Please enter a valid recipient email address."
                );
                return;
            }

            // Calculate priority from severity and urgency.
            String priority;

            if ("HIGH".equals(severity)
                    && "HIGH".equals(urgency)) {
                priority = "HIGH";
            } else if ("HIGH".equals(severity)
                    || "HIGH".equals(urgency)) {
                priority = "MEDIUM";
            } else {
                priority = "LOW";
            }

            // Initial authority-assignment rules.
            // Confirm real authority names with the project team.
            String authority;

            switch (category) {
                case "Institution":
                    authority = institution;
                    break;

                case "Living Surroundings":
                    authority = "Local Municipal Authority";
                    break;

                case "Public Properties":
                    authority = "Property Maintenance Authority";
                    break;

                case "Public Services":
                    authority = "Relevant Public Service Department";
                    break;

                default:
                    authority = "General Grievance Authority";
                    break;
            }

            // Read the database password from the environment.
            String dbPassword =
                    System.getenv("CIVICSHIELD_DB_PASSWORD");

            if (dbPassword == null || dbPassword.isBlank()) {
                JOptionPane.showMessageDialog(
                        frame,
                        "Database password is not configured. "
                                + "Set CIVICSHIELD_DB_PASSWORD "
                                + "in your terminal before running the app.",
                        "Database Configuration",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            String url =
                    "jdbc:mysql://localhost:3306/civicshield_db";

            String username = "root";

            String sql =
                    "INSERT INTO complaints "
                            + "(user_id, category, institution_name, "
                            + "recipient_email, title, description, severity, "
                            + "urgency, priority, status, created_at, "
                            + "escalation_level, assigned_authority) "
                            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (
                    Connection connection =
                            DriverManager.getConnection(
                                    url, username, dbPassword
                            );

                    PreparedStatement statement =
                            connection.prepareStatement(sql)
            ) {

                statement.setInt(1, userId);
                statement.setString(2, category);
                statement.setString(3, institution);
                statement.setString(4, email);
                statement.setString(5, title);
                statement.setString(6, description);
                statement.setString(7, severity);
                statement.setString(8, urgency);
                statement.setString(9, priority);
                statement.setString(10, "SUBMITTED");
                statement.setObject(11, LocalDateTime.now());
                statement.setInt(12, 0);
                statement.setString(13, authority);

                statement.executeUpdate();

                JOptionPane.showMessageDialog(
                        frame,
                        "Complaint submitted successfully!\n"
                                + "Assigned Authority: " + authority
                                + "\nPriority: " + priority
                                + "\nStatus: SUBMITTED"
                );

                frame.dispose();

            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Complaint submission failed. "
                                + "Check the database connection and schema.",
                        "Database Error",
                        JOptionPane.ERROR_MESSAGE
                );

                ex.printStackTrace();
            }
        });

        frame.add(new JScrollPane(panel));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void addRow(
            JPanel panel,
            GridBagConstraints gbc,
            int row,
            String label,
            JComponent component) {

        addRow(panel, gbc, row, new JLabel(label), component);
    }

    private void addRow(
            JPanel panel,
            GridBagConstraints gbc,
            int row,
            JLabel label,
            JComponent component) {

        gbc.gridy = row;
        gbc.gridx = 0;
        gbc.weightx = 0;
        panel.add(label, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        panel.add(component, gbc);
    }
}