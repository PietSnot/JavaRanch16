/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaranch16;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 *
 * @author Piet
 */
public class VyacheslavBelenky {
    
}

class MemoryConsistencyErrorExample {
    private static volatile boolean sayHello = false;
 
    public static void main(String[] args) throws InterruptedException {
 
        Thread thread = new Thread(() -> {
            System.out.println("In Thread... waiting for sayHello to become true");
           while(!sayHello) {
           }
 
           System.out.println("sayHello has become true, now waiting for it to become false again...");
 
           while(sayHello) {
           }
 
           System.out.println("sayHello just became false, so... Good Bye!");
        });
 
        thread.start();
 
//        Thread.sleep(1000);
TimeUnit.SECONDS.sleep(5);
        System.out.println("Say Hello..");
        sayHello = true;
 
        Thread.sleep(5000);
        System.out.println("Say Bye..");
        sayHello = false;
    }
}
