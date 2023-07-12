package model;

public class User {

    private String id;
    private Ticket ticket;
    private Vehicle vehicle;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
