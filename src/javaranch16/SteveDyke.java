/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaranch16;

import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toMap;

/**
 *
 * @author Piet
 */
public class SteveDyke {

}

class Main {

    public Main() {
        var itdsc = List.of("Grapes and Apples", "Grapes and Apples", "Only Bananas", "Apples, Grapes and Pears, and perhaps some Oranges as well");
        var checkList = List.of("Grapes", "Oranges", "Apples");
        var result = itdsc.stream().collect(
            toMap(s -> s, 
                  s -> intersection(s, checkList), 
                  (a, b) -> {a.addAll(b); return a;}
            )
        );
        result.entrySet().forEach(System.out::println);
        System.out.println("*************************8");
        var result2 = new TreeMap<String, Set<String>>();
        itdsc.forEach(s -> result2.computeIfAbsent(s, t -> new TreeSet<>()).addAll(intersection(s, checkList)));
        result2.entrySet().forEach(System.out::println);
        
    }

    public static void main(String... salvin) {
        new Main();
    }
    
    public static Set<String> intersection(String input, List<String> words) {
        return words.stream().filter(input::contains).collect(toCollection(TreeSet::new));
    }
}
