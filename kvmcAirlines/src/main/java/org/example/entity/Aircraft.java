package org.example.entity;

public class Aircraft {
    private int aircraftID;
    private String model;

    public Aircraft(int aircraftID, String model) {
        this.aircraftID = aircraftID;
        this.model = model;
    }

    public int getAircraftID() {
        return aircraftID;
    }

    public void setAircraftID(int aircraftID) {
        this.aircraftID = aircraftID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}

