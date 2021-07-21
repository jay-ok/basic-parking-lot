package parking.service;

import java.util.concurrent.atomic.AtomicInteger;

import parking.model.ParkingStore;
import parking.model.Slot;
import parking.model.Ticket;
import parking.model.Vehicle;

public class TicketingService {
    AtomicInteger ticketIdGen = new AtomicInteger();

    public int bookSlot(Vehicle vehicle, ParkingStore parkingStore) {

        if (parkingStore.getFreeSlots().size() <= 0) {
            throw new RuntimeException("No free slots available");
        }

        Slot bookedSlot = parkingStore.getFreeSlots().pollFirst();

        int ticketId = ticketIdGen.incrementAndGet();

        Ticket bookedTicket = new Ticket(ticketId, bookedSlot, vehicle);

        parkingStore.getTickets().put(ticketId, bookedTicket);

        return ticketId;
    }

    public Vehicle freeSlot(int ticketId, ParkingStore parkingStore) {

        Ticket bookedTicket = parkingStore.getTickets().get(ticketId);

        if (bookedTicket != null) {
            parkingStore.getTickets().remove(ticketId);

            parkingStore.getFreeSlots().add(bookedTicket.getSlot());

            return bookedTicket.getVehicle();
        }

        throw new RuntimeException("No ticket found with ID " + ticketId);
    }

}
