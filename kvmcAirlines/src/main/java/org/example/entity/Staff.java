package org.example.entity;

public class Staff {
    private int staffID;
    private int crewID;
    private String firstName;
    private String lastName;
    private String stafftype;

    public Staff(int staffID, int crewID, String firstName, String lastName, String stafftype) {
        this.staffID = staffID;
        this.crewID = crewID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.stafftype = stafftype;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public int getCrewID() {
        return crewID;
    }

    public void setCrewID(int crewID) {
        this.crewID = crewID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStafftype() {
        return stafftype;
    }

    public void setStafftype(String stafftype) {
        this.stafftype = stafftype;
    }





}

