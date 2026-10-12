package com.civicshield.privacy;

public class ConsentRecord {

	private String userId;
	private String serviceName;
	private String dataType;
	private boolean consentGiven;
	public void withdrawConsent() {
    this.consentGiven = false;
}

	public ConsentRecord(String userId, String serviceName,
						 String dataType, boolean consentGiven) {
		this.userId = userId;
		this.serviceName = serviceName;
		this.dataType = dataType;
		this.consentGiven = consentGiven;
	}

	public String getUserId() {
		return userId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public String getDataType() {
		return dataType;
	}

	public boolean isConsentGiven() {
		return consentGiven;
	}
}
