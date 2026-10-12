package com.civicshield.privacy;

public class RiskAlert {

    public void showAlert(String riskLevel) {

        if (riskLevel.equals("HIGH")) {

            System.out.println("⚠️ HIGH RISK ALERT!");
            System.out.println("Your personal data exposure is high.");
            System.out.println("Please review your consent settings.");

        } else {

            System.out.println("No high-risk data exposure detected.");
        }
    }
}