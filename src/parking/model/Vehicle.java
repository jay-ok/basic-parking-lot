package parking.model;

public class Vehicle {
    String regNo;
    Color color;

    public Vehicle(String regNo,
                   Color color) {
        super();

        validateInputs(regNo);

        this.regNo = regNo;
        this.color = color;
    }


    private void validateInputs(String regNo) {
        if (regNo.length() != 4) {
            throw new RuntimeException(regNo + " Invalid Registration Number");
        }
    }


    public String getRegNo() {
        return regNo;
    }


    public Color getColor() {
        return color;
    }

}
