package parking.service;

import java.util.ArrayList;
import java.util.List;

import parking.model.Color;
import parking.model.ParkingStore;
import parking.model.Slot;
import parking.model.Ticket;
import parking.model.Vehicle;

public class ParkingService {

    static ParkingService simpleSingletonParkingService = null;     // used simple singleton bean, ideally will be autowired as singleton bean
    TicketingService  ticketService = new TicketingService();
    ParkingStore parkingStore = null;

    private ParkingService(int floorNo, int noOfSlots) {
        simpleSingletonParkingService = new ParkingService();

        parkingStore = new ParkingStore(floorNo, noOfSlots);     // It should not be passed on ideal system,
                                                        // where number of slots will be ideally passed from config params and
                                                        // will be used while creating beans
    }

    public ParkingService() {

    }

    public static ParkingService createParkingLot(int floorNo, int noOfSlots) {

        if (simpleSingletonParkingService == null) {
            return new ParkingService(floorNo, noOfSlots);
        }

        return simpleSingletonParkingService;
    }

    public void addNewFloor(int numberOfFloors, int noOfSlotsPerFloor) {
        parkingStore.addNewFloor(numberOfFloors, noOfSlotsPerFloor);
    }


    public int bookSlot(Color colorVehicle, String regNoVehicle) {
        Vehicle v = new Vehicle(regNoVehicle, colorVehicle);

        return ticketService.bookSlot(v, parkingStore);
    }

    public Vehicle freeSlot(int ticketId) {

        return ticketService.freeSlot(ticketId, parkingStore);
    }

    public List<Slot> fetchSlotsByColor(Color color) {

        List<Slot> result = new ArrayList<>();

        for(Ticket tick: parkingStore.getTickets().values()) {
            if (tick.getVehicle().getColor() == color) {
                result.add(tick.getSlot());
            }
        }

        if (result.isEmpty()) {
            throw new RuntimeException("No slots with color " + color);
        }

        return result;

    }

    public Slot fetchSlotsByRegdNo(String reg) {
        Slot result = null;

        for(Ticket tick: parkingStore.getTickets().values()) {
            if (tick.getVehicle().getRegNo() == reg) {
                return tick.getSlot();
            }
        }


       throw new RuntimeException("No slots with reg# " + reg);
    }

    public List<String> fetchRegistrationNoByColor(Color color) {

        List<String> result = new ArrayList<>();

        for(Ticket tick: parkingStore.getTickets().values()) {
            if (tick.getVehicle().getColor() == color) {
                result.add(tick.getVehicle().getRegNo());
            }
        }

        return result;
    }

}
