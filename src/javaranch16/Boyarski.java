/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaranch16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import static java.util.stream.Collectors.toMap;

/**
 *
 * @author Piet
 */
public class Boyarski {
    public static void main(String... args) {
        Map<String, List<Integer>> map1 = new HashMap<>();
        map1.put("a", new ArrayList<>(List.of(1, 2, 3, 4)));
        map1.put("b", new ArrayList<>(List.of(5)));
        map1.put("c", new ArrayList<>(List.of(1,2)));
        Map<String, List<Integer>> map2 = new HashMap<>();
        map2.put("c", new ArrayList<>(List.of(10, 11)));
        List<Map<String, List<Integer>>> maps = new ArrayList<>();
        maps.add(map2);
//        maps.forEach(map -> 
//            map.forEach(
//                (k, v) -> map1.merge(k, v, (l1, l2) -> {l1.addAll(l2); return l1;})
//            )
//        );
//        map1.entrySet().forEach(System.out::println);
        maps.add(map1);
        List<Entry<String, List<Integer>>> flup = maps.stream().collect(
            () -> new ArrayList<>(), 
            (list, map) -> list.addAll(map.entrySet()), 
            (list1, list2) -> list1.addAll(list2)
        );
        flup.forEach(System.out::println);
        var result = flup.stream().collect(
            toMap(Entry::getKey, Entry::getValue, (a1, a2) -> {a1.addAll(a2); return a1;})
        );
        result.entrySet().forEach(System.out::println);
    }    
}