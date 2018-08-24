/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaranch16;

import java.util.Arrays;
import java.util.Random;
import java.util.TreeSet;
import static java.util.stream.Collectors.toCollection;
import java.util.stream.IntStream;

/**
 *
 * @author Piet
 */
public class CarlAnton {
    
    public static void main(String... args) {
        
        int lessThan = 0;
        int arraySize = 50_000_000;
        int[] a = createArray(arraySize);
        long start, aantal;
        
        characterize(a);
        System.out.println("starting calculation");
        
        //------------------------------------------------------
        // method 1: direct binary search with possible
        //           correction if lessThan is present
        //------------------------------------------------------
        start = time();
        aantal = Arrays.binarySearch(a, lessThan);
        if (aantal > 0) {
            while (a[(int) (aantal - 1)] >= lessThan) aantal--;
        }
        else aantal = -aantal - 1;
        print(time(), start, aantal);
        
        //------------------------------------------------------
        // method 2: convert int[] to double[] and search for a
        //           guaranteed non-present value
        //------------------------------------------------------
        start = time();
        double[] b = Arrays.stream(a).mapToDouble(i -> i).toArray();
        aantal = Arrays.binarySearch(b, lessThan - 0.5);
        print(time(), start, -aantal - 1);
        
        //------------------------------------------------------
        // method 3: direct filter
        //------------------------------------------------------
        start = time();
        aantal = Arrays.stream(a).filter(i -> i < lessThan).count();
        print(time(), start, aantal);
        
        //------------------------------------------------------
        // method 4:inverted filter with findFirst
        //------------------------------------------------------
        start = System.currentTimeMillis();
        aantal = IntStream.range(0, a.length)
            .filter(i -> a[i] >= lessThan)
            .findFirst()
            .orElse(a.length)
        ;
        print(time(), start, aantal);
    }
    
    private static long time() {
        return System.currentTimeMillis();
    }
    
    private static void print(long end, long start, long aantal) {
        System.out.format("took: %.3f seconden, and the number is: %,d%n", (end - start) / 1000., aantal);
    }
    
    private static int[] createArray(int size) {
        System.out.format("Creating array of size: %,d%n", size);
        Random r = new Random();
        return r.ints(size).sorted().toArray();
    }
    
    private static void characterize(int[] a) {
        // wanted to do a grouping to get an indication of what a looks like,
        // but the range (Integer.MIN to Integer.MAX) is too big to do it 
        // in a short way
    }
}
