package parking.model;

import java.util.concurrent.atomic.AtomicInteger;

public class Ticket {

    int ticketId;
    Slot slot;
    Vehicle vehicle;

    public Ticket(int ticketId, Slot slot,
                  Vehicle vehicle) {
        super();
        this.ticketId = ticketId;
        this.slot = slot;
        this.vehicle = vehicle;
    }

    public int getTicketId() {
        return ticketId;
    }

    public Slot getSlot() {
        return slot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }


}
