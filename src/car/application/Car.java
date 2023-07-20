package car.application;

public class Car {
    private String type;
    private int hoursParked;

    public Car(String type) {
        this.type = type;
        this.hoursParked = 0;
    }

    public String getType() {
        return type;
    }

    public int getHoursParked() {
        return hoursParked;
    }

    public void setHoursParked(int hoursParked) {
        this.hoursParked = hoursParked;
    }
}

