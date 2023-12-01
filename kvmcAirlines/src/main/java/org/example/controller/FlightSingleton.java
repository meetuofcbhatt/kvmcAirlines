package org.example.controller;

import org.example.entity.Date;
import org.example.entity.Flight;
import org.example.entity.Aircraft;

import java.sql.*;
import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class FlightSingleton {
    private static FlightSingleton onlyInstance;
    private ArrayList<Flight> flights;
    public static void main(String[] args) throws Exception {
        // Flight obj = new Flight(2, "name", "yes", "no", "31-d", 3, 4);
        // System.out.println(obj.getOrigin());

        FlightSingleton Flist = FlightSingleton.getOnlyInstance();
        ArrayList<Flight> flights = Flist.getFlights();
        for(Flight obj : flights)
        {
            System.out.println(obj.getFlightName() + " " + obj.getAircraftID().getModel() + " " + obj.getAircraftID().getAircraftID());
        }

        Flight fli = new Flight(90, "Fly1", "Toronto", "Calgary", new Date(12, 5, 2024), new Aircraft(5, "Boeing 775"), 7);
        flights.add(fli);
//        for(Flight obj : flights)
//        {
//            System.out.println(obj.getFlightName() + " " + obj.getAircraftID().getModel() + " " + obj.getAircraftID().getAircraftID());
//        }
        ConnectionSingleton single = ConnectionSingleton.getOnlyInstance();
        Connection con = single.getCon();
        Statement st = con.createStatement();
        String query = "select * from flights;";

        ResultSet rs = st.executeQuery(query);

        while(rs.next())
        {
            System.out.println(rs.getString("flightName") + " " + rs.getString("destination"));
        }
    }
    private FlightSingleton() throws Exception{
        //here get the flights from the data base.
        ConnectionSingleton single = ConnectionSingleton.getOnlyInstance();
        Connection con = single.getCon();
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
            String date_leave = rs.getString("date_leaves");
            int airId = rs.getInt("aircraftID");
            int crewId = rs.getInt("crewID");

            //get date obj
            int year = Integer.parseInt(date_leave.substring(0,3));
            int month = Integer.parseInt(date_leave.substring(5,6));
            int day = Integer.parseInt(date_leave.substring(8,9));
            Date date = new Date(month, day, year);

            //get aircraft ob
//            String query1 = "select * from aircrafts where aircraftID = " + String.valueOf(airId) + ";";
//            ResultSet rs1 = st.executeQuery(query1);
            Aircraft aircraft = new Aircraft(airId, "");
//            while(rs1.next())
//            {
//                aircraft.setAircraftID(rs1.getInt(1));
//                aircraft.setModel(rs1.getString(2));
//
//            }
            Flight obj = new Flight(fId, fName, des, ori, date, aircraft, crewId);
            flights.add(obj);
        }

        for(Flight element: flights)
        {
            int aircraftID = element.getAircraftID().getAircraftID();
            String query1 = "select * from aircrafts where aircraftID = " + String.valueOf(aircraftID) + ";";
            ResultSet rs1 = st.executeQuery(query1);

            while(rs1.next())
            {
                element.getAircraftID().setModel(rs1.getString(2));
            }
        }

    }

    public static FlightSingleton getOnlyInstance() throws Exception{
        if (onlyInstance == null){
            onlyInstance = new FlightSingleton();
        }
        return onlyInstance;
    }

    public void addFlight(Flight f) throws Exception{
        //add to the arrayList
        flights.add(f);
        //add to the database now
        ConnectionSingleton single = ConnectionSingleton.getOnlyInstance();
        Connection con = single.getCon();
        Statement st = con.createStatement();

        String setup = "insert into flights(flightName, destination, origin, date_leaves, aircraftID, crewID) values ";
//        String val = "('" + f.getFlightName() + "', '" + f.getDestination() + "', '" + f.getOrigin() + "', '" +
//                                f.getDate().toString() + "', '" + f.getAircraftID() + "', " + f.getCrewID() + "');";
        String val = "(?, ?, ?, ?, ?, ?)";
        String query = setup + val;

        PreparedStatement preparedStmt = con.prepareStatement(query);//add to the database as well.
        preparedStmt.setString(1, f.getFlightName());
        preparedStmt.setString(2, f.getDestination());
        preparedStmt.setString(3, f.getOrigin());

        String dateString = f.getDate().toString();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            // Parse the string to get a java.util.Date object
            java.util.Date utilDate = dateFormat.parse(dateString);

            // Convert java.util.Date to java.sql.Date
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            preparedStmt.setDate(4, sqlDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }


        preparedStmt.setInt(5, f.getAircraftID().getAircraftID());
        preparedStmt.setInt(6, f.getCrewID());
        preparedStmt.execute();
        System.out.println(query);

    }

    public void removeFlight(Flight f){
        flights.remove(f);
    }
    public ArrayList<Flight> getFlights(){
        return flights;
    }


}

