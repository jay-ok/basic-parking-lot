package parking.model;

public class Slot implements Comparable<Slot>{

    int id;
    int floorNo;    // Floor was added later, not part of the initial problem statement


    public Slot(int id, int floorNo) {
        super();
        this.id = id;
        this.floorNo = floorNo;
    }


    public int getId() {
        return id;
    }

    public int getFloorNo() {
        return floorNo;
    }

    @Override
    public int compareTo(Slot o) {

        if (this.floorNo == o.floorNo) {
            return this.id - o.id;
        }

        if (this.floorNo < o.floorNo) {
            return -1;
        }

        return 1;
    }



    @Override
    public String toString() {
        return "Slot [id=" + id + ": floorNo=" + floorNo + "]";
    }



}
