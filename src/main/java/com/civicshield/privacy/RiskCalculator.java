package com.civicshield.privacy;

public class RiskCalculator {

    public String calculateRisk(int sharedDataCount) {

        if (sharedDataCount <= 1) {
            return "LOW";
        } else if (sharedDataCount <= 3) {
            return "MEDIUM";
        } else {
            return "HIGH";
        }
    }
}