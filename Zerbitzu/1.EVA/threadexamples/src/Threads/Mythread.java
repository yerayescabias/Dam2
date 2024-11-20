package Threads;

import Runnable.RunnableExamples;

public class Mythread extends Thread {
    public Mythread(RunnableExamples myExamples) {
       
    }

    public Mythread() {
       
    }

    @Override
    public void run(){
        for (int i = 1; i <=5; i++) {
            System.out.println("Thread"+i);
        }
    }
}
