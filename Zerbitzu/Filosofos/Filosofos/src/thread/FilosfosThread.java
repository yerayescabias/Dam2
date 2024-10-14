package thread;

import turnos.Turnos;

public class FilosfosThread implements Runnable {

    private int posicionPalillos1;
    private int posicionPalillos2;
    private static Turnos tuno = new Turnos();

    // Filosofo con sus posiciones de palillos
    public FilosfosThread(int posicionPalillos1, int posicionPalillos2) {
        this.posicionPalillos1 = posicionPalillos1;
        this.posicionPalillos2 = posicionPalillos2;
    }

    @Override
    public void run() {

        try {
            System.out.println("El Filosofo numero" + (posicionPalillos1-1) + " esta comiendo con los palillos "
                    + posicionPalillos1 + " y " + posicionPalillos2 + " y los demas estan pesando");
            Thread.sleep(5000);
            System.out.println("El filosofo ha dejado de comer y se pone a pensar");
            tuno.signal();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
