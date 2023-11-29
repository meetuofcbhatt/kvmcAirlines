package src.entities;

public class Flight {
    private int flightID;
    private String flightName;
    private String destination;
    private String origin;
    private String date_leave;
    private int aircraftID;
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

    public void setDate(String date){
        this.date_leave = date;
    }

    public void setAircraftID(int id){
        this.aircraftID = id;
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

    public String getDate(){
        return this.date_leave;
    }

    public int getAircraftID(){
        return this.aircraftID;
    }

    public int getCrewID(){
        return this.crewID;
    }

    public Flight(int fID, String flName, String des, String ori, String date, int aricraftID, int crewID){
        this.flightID = fID;
        this.flightName = flName;
        this.destination = des;
        this.origin = ori;
        this.date_leave = date;
        this.aircraftID = aricraftID;
        this.crewID = crewID;
    }

    
}


