package org.example.entity;

import java.util.ArrayList;

public class Crew {
    public ArrayList<Staff> staff;
    public int crewid;

    public int getCrewid() {
        return crewid;
    }

    public void setCrewid(int crewid) {
        this.crewid = crewid;
    }

    public Crew(ArrayList<Staff> staff, int id) {
        this.staff = staff;
        this.crewid=id;
    }

    public ArrayList<Staff> getStaff() {
        return staff;
    }

    public void setStaff(ArrayList<Staff> staff) {
        this.staff = staff;
    }

    public void addStaff(Staff staffmember){
        staff.add(staffmember);
    }

    public void removeStaff(Staff staffmember){
        staff.remove(staffmember);
    }
}
