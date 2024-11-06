public class MainFilosofos {
    public static void main(String[] args) throws Exception {
       final int Palillos = 4;
       Thread[] threads = new Thread[Palillos];
       Palillos palillos = new Palillos(Palillos);
        //trhead
        

        for (int i = 0; i < 4; i++) {
            //SR
            
            Filosofos filosofos = new Filosofos(palillos,i);
            Thread thread= new Thread(filosofos);
            threads[i]=thread;
        }
        System.out.println("Los filosofos empiezan a comer");
        for (int j = 0; j < threads.length; j++) {
            threads[j].start();
        }
        
    }
} 

