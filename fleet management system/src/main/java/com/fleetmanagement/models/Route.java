package com.fleetmanagement.models;

public class Route {
    private int id;
    private String startLocation;
    private String endLocation;
    private double distance;

    public Route(int id, String startLocation, String endLocation, double distance) {
        this.id = id;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.distance = distance;
    }

    // Getters and Setters
}
