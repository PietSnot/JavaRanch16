/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaranch16;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.TreeMap;
import java.util.stream.IntStream;

/**
 *
 * @author Piet
 */
public class LuiAlkaissi {
    public static void main(String... args) {
        int[] array = { 5, 32, 14, 3, 55, 56, 85, 57, 84, 64, 62 };
        var possible = IntStream.range(0, array.length)
            .filter(i -> Arrays.stream(array, 0, i + 1).max().equals(Arrays.stream(array, i, array.length).min()))
            .findFirst()
        ;
        System.out.println("index is: " + possible);
        possible.ifPresent(index -> System.out.println(array[index]));
        
        int minimum = array[array.length - 1], maximum = array[0];
        TreeMap<Integer, Integer> mini = new TreeMap<>(), maxi = new TreeMap<>();
        for (int left = 0, right = array.length - 1; left < array.length; left++, right--) {
            if (left == 0) {
                maxi.put(left, maximum);
                mini.put(right, minimum);
            }
            else {
                if (array[left] > maximum) maximum = array[left];
                if (array[right] < minimum) minimum = array[right];
                maxi.put(left, maximum);
                mini.put(right, minimum);
            }
        }
        for (int m = 0; m < array.length; m++) {
            if (maxi.get(m) == mini.get(m)) {
                System.out.println("index = " + m + "; value = " + array[m]);
            }
        }
        System.out.println("end of search");
    }
    
    
}
