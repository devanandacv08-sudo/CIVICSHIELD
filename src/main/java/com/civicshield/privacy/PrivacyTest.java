package com.civicshield.privacy;

public class PrivacyTest {

    public static void main(String[] args) {

        ConsentManager manager = new ConsentManager();
        ConsentHistory history = new ConsentHistory();
        AuditTrail auditTrail = new AuditTrail();
        RiskCalculator riskCalculator = new RiskCalculator();
        RiskAlert riskAlert = new RiskAlert();

        ConsentRecord record1 = new ConsentRecord(
                "USER001",
                "College Scholarship App",
                "Email",
                true
        );

        ConsentRecord record2 = new ConsentRecord(
                "USER001",
                "College Scholarship App",
                "Phone",
                false
        );

        manager.recordConsent(record1);
        manager.recordConsent(record2);

        history.addRecord(record1);
        history.addRecord(record2);

        manager.displayConsentRecords();
        auditTrail.recordAction("Consent recorded for Email - College Scholarship App");

        System.out.println();

        history.displayHistory();
        auditTrail.displayAuditTrail();

        int sharedDataCount = 4;
        String riskLevel = riskCalculator.calculateRisk(sharedDataCount);

        System.out.println();
        System.out.println("===== DATA EXPOSURE RISK =====");
        System.out.println("Shared Data Count: " + sharedDataCount);
        System.out.println("Risk Level: " + riskLevel);
        riskAlert.showAlert(riskLevel);

        System.out.println();

        DataSharingRecord sharingRecord = new DataSharingRecord(
                "USER001",
                "College Scholarship App",
                "Email",
                true
        );

        System.out.println("===== DATA SHARING RECORD =====");
        System.out.println("User ID: " + sharingRecord.getUserId());
        System.out.println("Service: " + sharingRecord.getServiceName());
        System.out.println("Data Type: " + sharingRecord.getDataType());
        System.out.println("Data Shared: " + sharingRecord.isShared());

        record1.withdrawConsent();
        auditTrail.recordAction("Consent withdrawn for Email - College Scholarship App");
        auditTrail.displayAuditTrail();

        System.out.println("===== CONSENT WITHDRAWAL =====");
        System.out.println("User USER001 withdrew consent for Email.");
        System.out.println("Consent Given: " + record1.isConsentGiven());
    }
}