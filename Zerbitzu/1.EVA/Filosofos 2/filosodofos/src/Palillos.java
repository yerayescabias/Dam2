import java.util.concurrent.Semaphore;

public class Palillos {
    boolean[] localizaciondepalillos;
    int palilloderech;
    Semaphore semaphore = new Semaphore(1, true);
    public Palillos(int palillostotales){
        localizaciondepalillos = new boolean[palillostotales];
        
        
    }

    public void cogerpalillos(int pallilloizquierdo) throws InterruptedException{
        palilloderech=(pallilloizquierdo==localizaciondepalillos.length-1)?0:pallilloizquierdo+1;
        //semaphore.acquire() intenta cogerlo si no lo cojo me quedo en la cola esperando en mi posicion
        if (semaphore.tryAcquire(1)) // intento cogerlo si no puedo me voy a dar una vueltita y pierdo la posicion
        {
            localizaciondepalillos[pallilloizquierdo]=true;
            localizaciondepalillos[palilloderech]=true;
        } 
         // lo he cogido lo he disfrutado ahora lo suelto para que otros tambien disfruten soy muy generoso
    }

    public void dejarPalillo(int pallilloizquierdo){
        palilloderech=(pallilloizquierdo==localizaciondepalillos.length-1)?0:pallilloizquierdo+1;
        localizaciondepalillos[pallilloizquierdo]=false;
        localizaciondepalillos[palilloderech]=false;
        semaphore.release();
    }

    /*public synchronized void cogerpalillos(int pallilloizquierdo){
       palilloderech=(pallilloizquierdo==localizaciondepalillos.length-1)?0:pallilloizquierdo+1;
        while(localizaciondepalillos[pallilloizquierdo]==true || localizaciondepalillos[palilloderech]== true ){
                try {
                    wait();
                } catch (Exception e) {}
        }
        
        localizaciondepalillos[pallilloizquierdo]=true;
        localizaciondepalillos[palilloderech]=true;
            
        

    }

    public synchronized void dejarPalillo(int pallilloizquierdo){
        palilloderech=(pallilloizquierdo==localizaciondepalillos.length-1)?0:pallilloizquierdo+1;
        localizaciondepalillos[pallilloizquierdo]=false;
        localizaciondepalillos[palilloderech]=false;
        notifyAll();

    }*/
} 

