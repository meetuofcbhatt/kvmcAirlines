package org.example.entity;

import java.util.ArrayList;

public class Booking {
    private Date datemade;
    private User user;
    private ArrayList<Ticket> tickets;

    public Booking(Date datemade, User user, ArrayList<Ticket> tickets) {
        this.datemade = datemade;
        this.user = user;
        this.tickets = tickets;
    }

    public Date getDatemade() {
        return datemade;
    }

    public void setDatemade(Date datemade) {
        this.datemade = datemade;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }
}

