import java.util.Random;

public class Coches implements Runnable {
    private ParkingSlots parkingSlots;
    private Random random = new Random();
    public Coches(ParkingSlots parkingSlots) {
        this.parkingSlots = parkingSlots;
    }
    @Override
    public void run() {
       while (true) {
        try {
            parkingSlots.entrada();
            System.out.println("ENTRANCE: " + Thread.currentThread().getName() + " parks in spot .");
            Thread.sleep(random.nextInt(1000));
            parkingSlots.salida();
            System.out.println("EXIT: " + Thread.currentThread().getName() + " exiting.");
            Thread.sleep(random.nextInt(1000));

        } catch (Exception e) {
            // TODO: handle exception
        }
       }
        


    }
    
}
