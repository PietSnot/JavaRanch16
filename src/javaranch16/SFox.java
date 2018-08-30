/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaranch16;

import java.util.Arrays;
import java.util.Comparator;
import static java.util.Comparator.comparingInt;
import static java.util.Comparator.naturalOrder;
import java.util.List;

/**
 *
 * @author Piet
 */
public class SFox {
    public static void main(String... args) {
        var comp = comparingInt(String::length).thenComparing(naturalOrder());
        var list = Arrays.asList("File6", "File1", "File23");
        list.sort(comp);
        System.out.println(list);
    }
}