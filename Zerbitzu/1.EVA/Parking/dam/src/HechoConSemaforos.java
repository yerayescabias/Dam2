import java.util.Random;
import java.util.concurrent.Semaphore;

public class HechoConSemaforos {

    private final ParkingControl control;
    private final int numCars;

    public HechoConSemaforos(int numSpaces, int numCars) {
        this.control = new ParkingControl(numSpaces);
        this.numCars = numCars;
    }

    public void startParking() {
        for (int i = 0; i < numCars; i++) {
            new Thread(new Car(control), "Car " + (i + 1)).start();
        }
    }

    public static void main(String[] args) {
        int numSpaces = 5;  // Number of parking spaces
        int numCars = 10;   // Number of cars

        HechoConSemaforos parking = new HechoConSemaforos(numSpaces, numCars);
        parking.startParking();
    }
}

class Car implements Runnable {
    private final ParkingControl control;
    private final Random random = new Random();

    public Car(ParkingControl control) {
        this.control = control;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Attempt to enter the parking lot
                control.enterParking();
                System.out.println(Thread.currentThread().getName() + " has parked.");

                // Simulate random time spent parked
                Thread.sleep(random.nextInt(3000) + 1000);

                // Leave the parking lot
                control.exitParking();
                System.out.println(Thread.currentThread().getName() + " has left the parking lot.");

                // Wait for a random time before attempting to re-enter
                Thread.sleep(random.nextInt(5000) + 1000);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(Thread.currentThread().getName() + " was interrupted.");
                break;
            }
        }
    }
}

class ParkingControl {
    private final Semaphore availableSpaces;

    public ParkingControl(int numSpaces) {
        this.availableSpaces = new Semaphore(numSpaces, true);  // "true" for fair ordering
    }

    public void enterParking() throws InterruptedException {
        availableSpaces.acquire();  // Wait for a space to become available
    }

    public void exitParking() {
        availableSpaces.release();  // Release the parking space for another car
    }
}

