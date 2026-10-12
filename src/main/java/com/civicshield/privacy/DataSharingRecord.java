package com.civicshield.privacy;

public class DataSharingRecord {

    private String userId;
    private String serviceName;
    private String dataType;
    private boolean shared;

    public DataSharingRecord(String userId, String serviceName,
                             String dataType, boolean shared) {
        this.userId = userId;
        this.serviceName = serviceName;
        this.dataType = dataType;
        this.shared = shared;
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

    public boolean isShared() {
        return shared;
    }
}