package Threads;
public class App {
    public static void main(String[] args) throws Exception {
        boolean cerrar= false;
        Mythread thread = new Mythread();
        Mythread thread2 = new Mythread();

        thread.start();
        thread2.start();
        
        try {
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
