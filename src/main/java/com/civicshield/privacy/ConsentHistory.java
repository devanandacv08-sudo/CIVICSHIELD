package com.civicshield.privacy;

import java.util.ArrayList;
import java.util.List;

public class ConsentHistory {

    private List<ConsentRecord> history = new ArrayList<>();

    public void addRecord(ConsentRecord record) {
        history.add(record);
    }

    public List<ConsentRecord> getHistory() {
        return history;
    }

    public void displayHistory() {

        System.out.println("===== CONSENT HISTORY =====");

        for (ConsentRecord record : history) {

            System.out.println("User ID: " + record.getUserId());
            System.out.println("Service: " + record.getServiceName());
            System.out.println("Data Type: " + record.getDataType());
            System.out.println("Consent Given: " + record.isConsentGiven());
            System.out.println("---------------------------");
        }
    }
}