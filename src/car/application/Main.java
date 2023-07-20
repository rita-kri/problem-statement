package car.application;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(10, 20); // Adjust the capacity as needed

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Car Entry");
            System.out.println("2. Car Exit");
            System.out.println("3. Show All Parked Cars");
            System.out.println("4. Exit Application");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter car type (SUV/Hatchback): ");
                    String type = scanner.next();
                    parkingLot.enterCar(type);
                    break;
                case 2:
                    parkingLot.showAllParkedCars();
                    System.out.print("Enter the index of the car to exit: ");
                    int index = scanner.nextInt();
                    if (index >= 0 && index < parkingLot.getParkedCars().size()) {
                        Car car = parkingLot.getParkedCars().get(index);
                        System.out.print("Enter hours parked: ");
                        int hours = scanner.nextInt();
                        car.setHoursParked(hours);
                        int payment = parkingLot.calculatePayment(car);
                        System.out.println("Total payment: " + payment + " rupees.");
                        parkingLot.exitCar(car);
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;
                case 3:
                    parkingLot.showAllParkedCars();
                    break;
                case 4:
                    System.out.println("Exiting application...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

