/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaranch16;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Piet
 */
public class EshwaraChaluvaiah {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main execution started");
        final var executor = Executors.newFixedThreadPool(2);
        var future = executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread execution started");

                var i = 0;
                while (true) {
                    System.out.println("i = " + i);
                    i++;
                    Thread.currentThread().interrupt();
                    if (Thread.interrupted()) System.out.println("Thread interrupted before thr try");
                    try {
                        Thread.sleep(500);
                    }
                    catch (InterruptedException e) {
                        System.out.println("Thread is interrupted");
                        return;
                    }
                }
//                System.out.println("Thread is interrupted!!");
            }
        });
          
//        List<Integer> flup = List.of(10, 25, 18, 2);
//        int max = flup.stream().mapToInt(i -> i).max().getAsInt();
//        System.out.println(max);
//        SimpleDateFormat format = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
//        System.out.println("start Main :  " + format.format(new Date()));
        Random r = new Random();
        TimeUnit.SECONDS.sleep(r.nextInt(6) + 2);
        executor.shutdown();
        future.cancel(true);
        executor.awaitTermination(5, TimeUnit.SECONDS);
////        executor.shutdownNow();
        System.out.println("is eecutor terminated? " + executor.isTerminated());
//        System.out.println("main execution completed : " + format.format(new Date()));
    }
}
