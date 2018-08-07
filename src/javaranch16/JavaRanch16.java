/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaranch16;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author Piet
 */
public class JavaRanch16 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        var map1 = Map.of("a", List.of(1, 2, 3));
        var map2 = Map.of("a", List.of(2, 3, 4));
        var mapTotal = List.of(map1, map2);
        var result = compressMap(mapTotal);
        result.entrySet().forEach(System.out::println);
    }
    
    public static <T, S> Map<T, List<S>> compressMap(List<Map<T, List<S>>> maps) {
        Map<T, List<S>> result = maps.stream()
            .flatMap(map -> map.entrySet().stream())
            .collect(toList())
            .stream()
            .collect(
                groupingBy(
                    Entry::getKey, 
                    mapping(
                        Entry::getValue, 
                        reducing(
                            new ArrayList<>(), (a1, a2) -> {a1.addAll(a2); return a1;}
                        )
                    )
                )
            )      
        ;
        return result;
    }
}
