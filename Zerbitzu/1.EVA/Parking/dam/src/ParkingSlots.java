public class ParkingSlots {
    
   private int[] ocupado;
   private int comprobacion;
   private boolean isFull;
   private boolean isEmpty;
   private int cochenumero;
   int availableSpaces;

    public ParkingSlots(int parkings,int numeroCoche) {
        ocupado = new int[parkings];
        isFull= false;
        cochenumero=numeroCoche;
        availableSpaces=parkings;
    }
    
    /*
     * Pa la proxima centrarse en que hay q sincronizar
     */
     public synchronized void entrada(){
        /*
         * mirar todas las posiciones del array
         * y si hay una libre ocuparla
         */
        for (int i = 0; i < ocupado.length; i++) {
            comprobacion=comprobacion+ocupado[i];
        }
        
        while (comprobacion==15) {
            try {
                wait();
            } catch (Exception e) {} 

        }

        for (int i = 0; i < ocupado.length; i++) {
            if(ocupado[i]==0){
                ocupado[i]=cochenumero;
                
            }
        }
        
     }
     public synchronized void salida(){
        /*
         * la posicion de parking libre
         * notifyall para que entre el siguiente
         */
        for (int i = 0; i < ocupado.length; i++) {
            if(ocupado[i]==cochenumero){
                ocupado[i]=cochenumero;
            }
            comprobacion=comprobacion+ocupado[i];
            
        }

        notifyAll();
     }
     

   


}
