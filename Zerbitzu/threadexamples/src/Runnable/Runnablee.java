package Runnable;

import Threads.Mythread;

public class Runnablee {
    
    public static void main(String[] args) {
        RunnableExamples myExamples = new RunnableExamples();
        Mythread tMythread = new Mythread(myExamples);

        tMythread.start();

        
    }
}
