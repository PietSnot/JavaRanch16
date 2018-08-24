/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaranch16;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

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
        var map3 = Map.of("a", List.of(3, 4, 5), "b", List.of(10));
        var mapTotal = List.of(map1, map2, map3);
        Map<String, List<Integer>> result = compressMap2(mapTotal);
        System.out.println("****** the final map, incorrect ************");
        result.entrySet().forEach(System.out::println);
    }
    
    public static <T, S> Map<T, List<S>> compressMap2(List<Map<T, List<S>>> maps) {
        List<Entry<T, List<S>>> temp = maps.stream().collect(
            () -> new ArrayList<>(), 
            (list, map) -> list.addAll(map.entrySet()), 
            (list1, list2) -> list1.addAll(list2)
        );
        System.out.println("******** The combined listt of the entries************");
        temp.forEach(System.out::println);
        System.out.println("******************************************************");
        Map<T, List<S>> result = temp.stream()
            .collect(
                groupingBy(
                    Entry::getKey, 
                    reducing(
                        new ArrayList<>(),
                        Entry::getValue,
                        (list1, list2) -> {list1.addAll(list2); return list1;}
                    )
                )
            )    
        ;
        return result;
    }
}
