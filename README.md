# basic-parking-lot

Notes: 1.5 for basic func + 20 mins to test and additional functionalities<br />
  N - cars<br />
  Reg_no<br />
  Color<br />
  single entry/exit<br />
  Multiple => Single storey<br />
  Nearest slot<br />

**Functional**
  Allocate slots<br />
  Free slots<br />
  Get registrations by color<br />
  getSlotByRegNo<br />
  getSlotsByColor<br />
  createParkingLot(s-slots, l-lvls)<br />

**Non-Functional**
  get Free Slots<br />
  Exception if no slots found for color/regNo<br />
  Exception if no slots are avialable<br />
  Nearest slot<br />
  regNo: 4digit<br />
  Color validation<br />

**Design**
1.Java Main method for ip/op aka controller here for saving some time<br />
2.ParkingStore: <br />
    freeSlots: TreeSet<Slots><br />
    Ticket: Map<tickId, Ticket><br />
3.Slot: <br />
    Id: int, sorting of treeset<br />

4. Vehicle: <br />
    regNo: String<br />
    color: Color enum<br />
    constructor/validator<br />
5. Color: RED, BLUE, GREEN<br />
6.Ticket: <br />
  Id, slot, vehicle<br />
7.TicketingService: 
    bookSlot( vehicle): ticketId<br />
    freeSlot(ticketId): void<br />
  
8.Parking Service: 
    + bookSlot(colorVehicle, regNoVehicle): ticketId<br />
    + freeSlot(ticketId): void<br />
    + fetchRegistrationNoByColor(color): List<Integer><br />
    + fetchSlotsByColor(color): List<Slots><br />
    + fetchSlotsByRegdNo(int reg):  List<Slots><br />
    + createParkingLot(int noOfSlots)<br />
