package com.civicshield.privacy;

import java.util.ArrayList;
import java.util.List;

public class AuditTrail {

    private List<String> auditEntries = new ArrayList<>();

    public void recordAction(String action) {
        auditEntries.add(action);
    }

    public void displayAuditTrail() {

        System.out.println("===== AUDIT TRAIL =====");

        for (String entry : auditEntries) {
            System.out.println(entry);
        }
    }
}