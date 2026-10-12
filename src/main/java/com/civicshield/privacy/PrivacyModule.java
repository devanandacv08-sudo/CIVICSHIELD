package com.civicshield.privacy;

public class PrivacyModule {

    public void start() {

        System.out.println();
        System.out.println("===== CIVICSHIELD PRIVACY & CONSENT MODULE =====");
        System.out.println("Privacy module is ready.");
        System.out.println();

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

        auditTrail.recordAction(
                "Consent recorded for Email - College Scholarship App"
        );

        manager.displayConsentRecords();

        System.out.println();

        history.displayHistory();

        System.out.println();

        auditTrail.displayAuditTrail();

        int sharedDataCount = 4;
        String riskLevel = riskCalculator.calculateRisk(sharedDataCount);

        System.out.println();
        System.out.println("===== DATA EXPOSURE RISK =====");
        System.out.println("Shared Data Count: " + sharedDataCount);
        System.out.println("Risk Level: " + riskLevel);

        riskAlert.showAlert(riskLevel);

        DataSharingRecord sharingRecord = new DataSharingRecord(
                "USER001",
                "College Scholarship App",
                "Email",
                true
        );

        System.out.println();
        System.out.println("===== DATA SHARING RECORD =====");
        System.out.println("User ID: " + sharingRecord.getUserId());
        System.out.println("Service: " + sharingRecord.getServiceName());
        System.out.println("Data Type: " + sharingRecord.getDataType());
        System.out.println("Data Shared: " + sharingRecord.isShared());

        record1.withdrawConsent();

        auditTrail.recordAction(
                "Consent withdrawn for Email - College Scholarship App"
        );

        System.out.println();
        System.out.println("===== CONSENT WITHDRAWAL =====");
        System.out.println("User USER001 withdrew consent for Email.");
        System.out.println("Consent Given: " + record1.isConsentGiven());

        System.out.println();
        System.out.println("===== PRIVACY MODULE READY =====");
    }
}