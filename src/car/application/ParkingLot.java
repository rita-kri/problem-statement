package car.application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private int suvRatePerHour = 20;
    private int hatchbackRatePerHour = 10;
    private int suvCapacity;
    private int hatchbackCapacity;
    private Map<String, Integer> carsCount;
    private List<Car> parkedCars;

    public ParkingLot(int suvCapacity, int hatchbackCapacity) {
        this.suvCapacity = suvCapacity;
        this.hatchbackCapacity = hatchbackCapacity;
        this.carsCount = new HashMap<>();
        this.parkedCars = new ArrayList<>();
    }
    

    public int getSuvRatePerHour() {
		return suvRatePerHour;
	}


	public void setSuvRatePerHour(int suvRatePerHour) {
		this.suvRatePerHour = suvRatePerHour;
	}


	public int getHatchbackRatePerHour() {
		return hatchbackRatePerHour;
	}


	public void setHatchbackRatePerHour(int hatchbackRatePerHour) {
		this.hatchbackRatePerHour = hatchbackRatePerHour;
	}


	public int getSuvCapacity() {
		return suvCapacity;
	}


	public void setSuvCapacity(int suvCapacity) {
		this.suvCapacity = suvCapacity;
	}


	public int getHatchbackCapacity() {
		return hatchbackCapacity;
	}


	public void setHatchbackCapacity(int hatchbackCapacity) {
		this.hatchbackCapacity = hatchbackCapacity;
	}


	public Map<String, Integer> getCarsCount() {
		return carsCount;
	}


	public void setCarsCount(Map<String, Integer> carsCount) {
		this.carsCount = carsCount;
	}


	public List<Car> getParkedCars() {
		return parkedCars;
	}


	public void setParkedCars(List<Car> parkedCars) {
		this.parkedCars = parkedCars;
	}


	public void enterCar(String type) {
        if (type.equalsIgnoreCase("suv") && carsCount.getOrDefault("suv", 0) < suvCapacity) {
            carsCount.put("suv", carsCount.getOrDefault("suv", 0) + 1);
            parkedCars.add(new Car("suv"));
        } else if (type.equalsIgnoreCase("hatchback") && carsCount.getOrDefault("hatchback", 0) < hatchbackCapacity) {
            carsCount.put("hatchback", carsCount.getOrDefault("hatchback", 0) + 1);
            parkedCars.add(new Car("hatchback"));
        } else if (type.equalsIgnoreCase("hatchback") && carsCount.getOrDefault("suv", 0) < suvCapacity) {
            carsCount.put("suv", carsCount.getOrDefault("suv", 0) + 1);
            parkedCars.add(new Car("suv"));
        } else {
            System.out.println("Parking is full for both categories.");
        }
    }

    public void exitCar(Car car) {
        parkedCars.remove(car);
        carsCount.put(car.getType(), carsCount.get(car.getType()) - 1);
    }

    public int calculatePayment(Car car) {
        int ratePerHour = (car.getType().equalsIgnoreCase("suv")) ? suvRatePerHour : hatchbackRatePerHour;
        return ratePerHour * car.getHoursParked();
    }

    public void showAllParkedCars() {
        System.out.println("List of parked cars:");
        for (Car car : parkedCars) {
            System.out.println("Type: " + car.getType() + ", Hours Parked: " + car.getHoursParked());
        }
    }
}
