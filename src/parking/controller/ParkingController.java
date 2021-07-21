package parking.controller;

import parking.model.Color;
import parking.service.ParkingService;

public class ParkingController {

    static ParkingService ps = null;

    public static void main(String[] args) {

        ps = ParkingService.createParkingLot(1, 5); // 5 slots per 1 floor

        int tId = testParkVehicle(Color.BLUE, "A120");
        testParkVehicle(Color.BLUE, "A1234");   // invalid request
        testParkVehicle(Color.BLUE, "A122");
        testParkVehicle(Color.BLUE, "A123");
        testParkVehicle(Color.RED, "A124");
        testParkVehicle(Color.BLUE, "A125");
        testParkVehicle(Color.BLUE, "A126");    //  no slots available

        ps.freeSlot(tId);   // free the slot
        testParkVehicle(Color.BLUE, "A127");    // now we can successfully park a new vehicle

        ps.addNewFloor(2, 2);       // add 2 new floors with 2 slots per the new floors
        testParkVehicle(Color.BLUE, "A128");
        testParkVehicle(Color.BLUE, "A129");
        testParkVehicle(Color.RED, "A130");
        testParkVehicle(Color.BLUE, "A131");
        testParkVehicle(Color.BLUE, "A132");

        testfetchSlotsByColor(Color.BLUE);
        testfetchSlotsByColor(Color.RED);
        testfetchSlotsByColor(Color.GREEN);

        System.out.println(ps.fetchSlotsByRegdNo("A127"));

        System.out.println(ps.fetchRegistrationNoByColor(Color.BLUE));
        System.out.println(ps.fetchRegistrationNoByColor(Color.RED));

    }

    private static int testParkVehicle(Color c, String reg) {
         try {
             int tId = ps.bookSlot(c, reg);

             System.out.println(reg + " Succesfully parked with ticket " + tId);
             System.out.println();
             return tId;
         } catch (Exception e) {
             //e.printStackTrace();
             System.out.println(e.getMessage());
        }

        return 0;
    }

    private static void testfetchSlotsByColor(Color col) {
        try {
            System.out.println(ps.fetchSlotsByColor(col));
            System.out.println();
        }catch (Exception e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
       }
    }

}
