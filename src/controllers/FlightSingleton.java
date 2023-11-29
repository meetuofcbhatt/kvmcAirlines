package src.controllers;

import src.entities.Flight;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class FlightSingleton {
	private static FlightSingleton onlyInstance;
    private ArrayList<Flight> flights; 

    private FlightSingleton() throws Exception{
        //here get the flights from the data base.
        String url = "jdbc:mysql://localhost:3306/kvmcairlines"; //url for connection; kvmcairlines is the database
        String uname = "root";
        String pass = "Mmysql#123";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, uname, pass);
        Statement st = con.createStatement();

        String query = "select * from FLIGHTS;";
        ResultSet rs = st.executeQuery(query);

        //add each flights from database into the flight ArrayList.
        flights = new ArrayList<Flight>();
        while(rs.next()){
            int fId = rs.getInt("flightID");
            String fName = rs.getString("flightName");
            String des = rs.getString("destination");
            String ori = rs.getString("origin");
            String date = rs.getString("date_leaves");
            int airId = rs.getInt("aircraftID");
            int crewId = rs.getInt("crewID");

            Flight obj = new Flight(fId, fName, des, ori, date, airId, crewId);
            flights.add(obj);
        }


        
    }

    public static FlightSingleton getOnlyInstance() throws Exception{
        if (onlyInstance == null){
            onlyInstance = new FlightSingleton();
        }
        return onlyInstance;
    }

    public void add(Flight f) {
    	flights.add(f);
    }

    public ArrayList<Flight> getFlights(){
        return flights;
    }

    public static void main(String[] args) throws Exception
    {
        // Flight obj = new Flight(2, "name", "yes", "no", "31-d", 3, 4);
        // System.out.println(obj.getOrigin());

        FlightSingleton Flist = FlightSingleton.getOnlyInstance();
        ArrayList<Flight> flights = Flist.getFlights();
        for(Flight obj : flights)
        {
            System.out.println(obj.getDate());
        }
    }
}

