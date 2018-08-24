/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaranch16;

/**
 *
 * @author Piet
 */
public class ChaitanyaVaishampayan {
    
}

class LearningJava{
    static class Inner{
        public int monkey=10;
        public void show(String s){      
            System.out.println(s);
        }
    }
    public static void main(String args[]){
        Inner i = new Inner();
         
        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run(){
                synchronized(i){
                    System.out.println("Thread 1 Acquired LOCK :)");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException ex) {}
                     
                    i.show("Thread 1 ended");
                }
            }
        });
         
        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run(){
                synchronized(i) { 
                    try{
                        Thread.sleep(2000);
                    } catch(InterruptedException ex){}

                    System.out.println("Thread 2 - "+i.monkey);
                }
            }
        });
         
        t1.start();
        t2.start();
    }
}