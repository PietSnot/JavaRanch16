/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaranch16;

import java.util.stream.Stream;

/**
 *
 * @author Piet
 */
public class JikunZha {

    public static void main(String[] args) {
        Stream<Integer> nums = Stream.of(1, 2, 3, 4, 5);
var newStream = nums.filter(n -> n % 2 == 1);
newStream.forEach(p -> System.out.print(p));
System.out.println();
    }
}
