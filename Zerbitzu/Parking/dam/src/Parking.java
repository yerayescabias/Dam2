public class Parking {
    public static void main(String[] args) {
       int espaciosParking= 5;
       
    Thread coche1 = new Thread(new Coches(new ParkingSlots(espaciosParking, 1)));
    Thread coche2 = new Thread(new Coches(new ParkingSlots(espaciosParking, 2)));
    Thread coche3 = new Thread(new Coches(new ParkingSlots(espaciosParking, 3)));
    Thread coche4 = new Thread(new Coches(new ParkingSlots(espaciosParking, 4)));
    Thread coche5 = new Thread(new Coches(new ParkingSlots(espaciosParking, 5))); 


    try {
        coche1.start();
        coche2.start();
        coche3.start();
        coche4.start();
        coche5.start();
    } catch (Exception ex ) {
        System.out.println(ex.getMessage());
    }
    
    }
   

}




