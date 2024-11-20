package Runnable;

public class RunnableExamples implements Runnable {

    @Override
    public void run() {
       for (int i = 1; i <=5; i++) {
                System.out.println("Thread"+i);
            }
    }
    
}
