/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaranch16;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;
import java.util.stream.IntStream;

/**
 *
 * @author Piet
 */
public class MikeLondon {
    public static void main(String... args) {
        Collection<String> strings = Arrays.asList("aap", "noot", "mies", "wim");
        Set<Integer> ints = IntStream.rangeClosed(1, 5).boxed().collect(toCollection(HashSet::new));
        List<Tuple<Object, Number>> result = Zip.zip(strings, ints);
        result.forEach(System.out::println);
    }
}

class Zip {
    public static <K, V, 
                   X extends K, Y extends V, 
                   A extends Collection<X>, B extends Collection<Y>> 
                  List<Tuple<K, V>> 
                  zip(A colX, B colY) {
        Iterator<X> itX = colX.iterator();
        Iterator<Y> itY = colY.iterator();
        List<Tuple<K, V>> result = IntStream.range(0, Math.max(colX.size(), colY.size()))
            .mapToObj(i -> new Tuple<>(itX.hasNext() ? (K) itX.next() : null, itY.hasNext() ? (V) itY.next() : null))
            .collect(toList())
        ;
        return result;
    }
}

class Tuple<K, V> {
    final K k;
    final V v;
    
    Tuple(K k, V v) {
        this.k = k;
        this.v = v;
    }
    
    // don't forget to include equals, hashCode, compareTo
    
    @Override
    public String toString() {
        return String.format("(%s, %s)", k, v);
    }
}