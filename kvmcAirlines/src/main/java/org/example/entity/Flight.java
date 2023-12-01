package org.example.entity;

public class Flight {
    private int flightID;
    private String flightName;
    private String destination;
    private String origin;
    private Date date_leave;
    private Aircraft aircraft;
    private int crewID;

    public void setFlightID(int id){
        this.flightID = id;
    }

    public void setFlightName(String flight){
        this.flightName = flight;
    }

    public void setDestination(String des){
        this.destination = des;
    }

    public void setOrigin(String ori){
        this.origin = ori;
    }

    public void setDate(Date date){
        this.date_leave = date;
    }

    public void setAircraftID(Aircraft air){
        this.aircraft = air;
    }

    public void setCrewID(int id){
        this.crewID = id;
    }

    public int getFlightID(){
        return this.flightID;
    }

    public String getFlightName(){
        return this.flightName;
    }

    public String getDestination(){
        return this.destination;
    }

    public String getOrigin(){
        return this.origin;
    }

    public Date getDate(){
        return this.date_leave;
    }

    public Aircraft getAircraftID(){
        return this.aircraft;
    }

    public int getCrewID(){
        return this.crewID;
    }

    public Flight(int fID, String flName, String des, String ori, Date date, Aircraft air, int crewID){
        this.flightID = fID;
        this.flightName = flName;
        this.destination = des;
        this.origin = ori;
        this.date_leave = date;
        this.aircraft = air;
        this.crewID = crewID;
    }


}