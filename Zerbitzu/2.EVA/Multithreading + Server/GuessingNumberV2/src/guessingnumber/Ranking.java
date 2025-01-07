/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guessingnumber;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Administrador
 */
public class Ranking {
    public Semaphore sem = new Semaphore(1);
    public boolean[] answered;
    public int attenders;
    public Integer[] info;
    public boolean respondido=false;
    public Ranking(int attenders){
        answered = new boolean[attenders];
        this.attenders=attenders;
        info = new Integer[attenders];
    }
    
    public String texto(int numerosdefallos) throws InterruptedException{
        sem.acquire();
        for(int i : info){
            if(i==0)i=numerosdefallos;
        }
        sem.release();
        Arrays.sort(info,Collections.reverseOrder());
        
        String ranking ="";
        int count=1;
        for(int a: info){
            switch(a){
                case 7 -> ranking+="0 points\n";
                case 6 -> ranking+="1 points\n";
                case 5 -> ranking+="2 points\n";
                case 4 -> ranking+="3 points\n";
                case 3 -> ranking+="4 points\n";
                case 2 -> ranking+="5 points\n";
                case 1 -> ranking+="6 points\n";
                
            }
        }
        return ranking;
    }
    
    
    
    
    public void ranking(boolean terminado) {
    while(!respondido){
    for (int i = 0; i < answered.length; i++) {
        if (!answered[i]) {
            answered[i] = terminado;
            break;
        }
    }

   
    int count = 0;
    for (boolean a : answered) {
        if (a) {
            count++;
        }
    }
    respondido = (count == attenders);
    }
}

}
