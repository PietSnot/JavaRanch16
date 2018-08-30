/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaranch16;

import java.util.IdentityHashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author Piet
 */
public class JosephSoler {

}

class gender_and_height {

    public static void main(String[] args) {
        
        Map<Integer, String> map = new IdentityHashMap<>();
Integer one1 = new Integer(1);
Integer one2 = new Integer(1);
 
map.put(one1, "one1");
map.put(one2, "one1");
 
System.out.println(map);
System.out.println(map.get(one1));
System.out.println(map.get(one2));

//        String gender = "";
//        
//        var i1 = new Integer(1);
//        var i2 = new Integer(1);
//        
//        System.out.println("i1 == i2 ? " + (i1 == i2));
//        System.out.println("i1 equals i2 ? " + i1.equals(i2));
//        System.out.println("hashcode gelijk ? " + (i1.hashCode() == i2.hashCode()));

//        do {
//
//            gender = JOptionPane.showInputDialog("Gender? (H/M)");
//
//        } while (gender.equalsIgnoreCase("H") == false && gender.equalsIgnoreCase("M") == false);
//
//        String height = "";
//
//        int height2;
//        do {
//
//            height = JOptionPane.showInputDialog("height?");
//            height2 = Integer.parseInt(height);
//
//        } while (height2 >= 201); //the error is there: "height2 cannot be resolved to a variable " 

    }
}
