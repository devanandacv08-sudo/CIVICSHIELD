package com.civicshield.privacy;

import java.util.ArrayList;
import java.util.List;

public class ConsentManager {

	private List<ConsentRecord> consentRecords = new ArrayList<>();

	public void recordConsent(ConsentRecord record) {
		consentRecords.add(record);
	}

	public List<ConsentRecord> getConsentRecords() {
		return consentRecords;
	}

	public void displayConsentRecords() {

		System.out.println("----- CONSENT RECORDS -----");

		for (ConsentRecord record : consentRecords) {

			System.out.println("User ID: " + record.getUserId());
			System.out.println("Service: " + record.getServiceName());
			System.out.println("Data Type: " + record.getDataType());
			System.out.println("Consent Given: " + record.isConsentGiven());
			System.out.println("---------------------------");
		}
	}
}
