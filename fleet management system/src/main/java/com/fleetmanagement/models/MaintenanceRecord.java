package com.fleetmanagement.models;

import java.sql.Date;

public class MaintenanceRecord {
    private int id;
    private int vehicleId;
    private String description;
    private Date date;

    public MaintenanceRecord(int id, int vehicleId, String description, Date date) {
        this.id = id;
        this.vehicleId = vehicleId;
        this.description = description;
        this.date = date;
    }

    // Getters and Setters
}
