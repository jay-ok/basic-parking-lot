# basic-parking-lot

Notes: 1.5 for basic func + 20 mins to test and additional functionalities
  N - cars
  Reg_no
  Color
  single entry/exit
  Multiple => Single storey
  Nearest slot

**Functional**
  Allocate slots
  Free slots
  Get registrations by color
  getSlotByRegNo
  getSlotsByColor
  createParkingLot(s-slots, l-lvls)

**Non-Functional**
  get Free Slots
  Exception if no slots found for color/regNo
  Exception if no slots are avialable
  Nearest slot
  regNo: 4digit
  Color validation

**Design**
1.Java Main method for ip/op aka controller here for saving some time
2.ParkingStore: 
    freeSlots: TreeSet<Slots>
    Ticket: Map<tickId, Ticket>
3.Slot: 
    Id: int, sorting of treeset

4. Vehicle: 
    regNo: String
    color: Color enum
    constructor/validator
5. Color: RED, BLUE, GREEN
6.Ticket: 
  Id, slot, vehicle
7.TicketingService: 
    bookSlot( vehicle): ticketId
    freeSlot(ticketId): void
  
8.Parking Service: 
    + bookSlot(colorVehicle, regNoVehicle): ticketId
    + freeSlot(ticketId): void
    + fetchRegistrationNoByColor(color): List<Integer>
    + fetchSlotsByColor(color): List<Slots>
    + fetchSlotsByRegdNo(int reg):  List<Slots>
    + createParkingLot(int noOfSlots)
