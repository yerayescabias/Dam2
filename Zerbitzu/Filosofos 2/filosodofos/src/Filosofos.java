 import java.util.Random;

public class Filosofos implements Runnable {
    private Random random= new Random();
    private Palillos palillos;
        private int filosofo;
           public Filosofos(Palillos palillos, int filosofo){
            this.palillos=palillos;
            this.filosofo=filosofo;
   }

    @Override
    public void run() {
        
        while (true){
            try {
                palillos.cogerpalillos(filosofo);
                System.out.println("Ha empezado a comer el filosofo"+filosofo);
                Thread.sleep(random.nextInt(10000));
                System.out.println("Ha dejado de comer el filosofo"+ filosofo);
               
                palillos.dejarPalillo(filosofo);
                System.out.println("Ha empezado a pensar el filosofo"+filosofo);
                Thread.sleep(random.nextInt(10000));
                System.out.println("Ha dejado de pensar el filosofo"+filosofo);
            } catch (Exception e) {}
        }     
    }    
} 