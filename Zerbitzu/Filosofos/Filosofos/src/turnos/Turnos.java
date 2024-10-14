package turnos;
import thread.FilosfosThread;

public class Turnos {

    private static boolean eatingStop = true;
    private int[] palillosPosicion = { 1, 2, 3, 4, 5 };
    

    public synchronized void FilosfosThread() {
        // Esperas a que termine de comer si no termina Bucle
        while (!eatingStop /*nunca va a entrar en el bucle */) {
            try {
                // Espera 
                wait();
            } catch (Exception e) {
            }
        }

        // Ha terminado de comer por lo que le toca al siguiente
        for (int i = 0; i <=palillosPosicion.length; i++) {

            // palillo derecho es Posicion del Filosofo + 1 ; si el filo=1, el palo=2
            int palilloDer = (palillosPosicion[i+1])==palillosPosicion.length+1?palillosPosicion[0]:palillosPosicion[i+1] ;
            /*
             *  palillo izquierda es Posicion del Filosofo - 1 ; si el filo=1, el palo=5
             *  No se puede hacer con array.length porq si haces posicion-1 el primero te va a dar 5
             *  pero el segundo te va a dar 4 y el valor q buscas es el 2.
             * 
             *  Metodo Ignacio haces la posicion, tu filosofo +1 en este caso 2-1 q su hondarra
             *  es el mismo numero
             */
            
            int palilloIzq =((palillosPosicion[i]-1)%palillosPosicion.length)==0? palillosPosicion.length:(palillosPosicion[i]-1)%palillosPosicion.length ;
           
            
            /*
             * Instacias al madafaka FilosofoThread con los valores de los palillos que
             * tiene q coger
             */
            FilosfosThread filosofoComeindo = new FilosfosThread(palilloDer, palilloIzq);
            // Creas el thread y lo inicias
            Thread t1 = new Thread(filosofoComeindo);
            t1.start();

            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    // Aqui llega pero no sirve de nada
    public synchronized void signal() {
        notifyAll();
    }
}
