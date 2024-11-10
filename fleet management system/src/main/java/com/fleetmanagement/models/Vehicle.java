package com.fleetmanagement.models;

public class Vehicle {
    private int id;
    private String name;
    private String status;
    private double latitude;
    private double longitude;

    public Vehicle(int id, String name, String status, double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Getters and Setters
}
