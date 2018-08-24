/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaranch16;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

/**
 *
 * @author Piet
 */
public class NajGul {

    public static void main(String... args) {
        var stream = Stream.of(
            new Student11(1, "A"), new Student11(2, "B"),
            new Student11(3, "C"), new Student11(4, "D")
        );

        ToIntFunction<Student11> func =  Student11::getId;
        Function<Student11, Integer> func2 = s -> s.getId();
        var v = stream.mapToInt(func);  //1 
//        var w = stream.mapToInt(func);  //1 
        v.forEach(s -> System.out.println(s)); //2 

        List<Integer> list = Arrays.asList(10, 25, 2, 18);
 
        System.out.println(list.stream().max((a, b) -> a > b ? a : b).get()); //10
        System.out.println(list.stream().max(Integer::compare).get()); //10
        System.out.println(list.stream().min((a, b) -> a > b ? a : b).get());  //2 
    }
}

class Student11 {
    int id;
    String letter;
    
    public Student11(int x, String s) {
        id = x;
        letter = s;
    }
    
    public int getId() {
        return id;
    }
}
