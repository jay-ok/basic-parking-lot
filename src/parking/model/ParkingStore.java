package parking.model;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class ParkingStore {

    int noOfSlots = 0;
    int totalFloors = 0;

    TreeSet<Slot> freeSlots = null;
    Map<Integer, Ticket> tickets = new HashMap<>();

    public ParkingStore(int numberOfFloors, int noOfSlotsPerFloor) {

        this.freeSlots = new TreeSet<>();

        addNewFloor(numberOfFloors, noOfSlotsPerFloor);
    }

    public void addNewFloor(int numberOfFloors, int noOfSlotsPerFloor) {

        for (int f = 0; f < numberOfFloors; f++) {
            this.totalFloors++;

            for(int i=0; i < noOfSlotsPerFloor; i++) {
                freeSlots.add(new Slot(i, totalFloors));
            }

        }

        this.noOfSlots = this.noOfSlots + (noOfSlotsPerFloor * numberOfFloors);
    }

    public int getNoOfSlots() {
        return noOfSlots;
    }

    public Map<Integer, Ticket> getTickets() {
        return tickets;
    }

    public TreeSet<Slot> getFreeSlots() {
        return freeSlots;
    }


}
