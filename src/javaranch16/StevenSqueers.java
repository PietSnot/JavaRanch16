/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaranch16;

/**
 *
 * @author Piet
 */
public class StevenSqueers {
    
}

class Whizlab{
    Integer I;
    public static void main(String...args){
         
        String s;
        try{
            s=new Whizlab().I.toString();
        } 
        catch (NullPointerException e) {
            System.out.println("NPE!!!!!!!!!!!!!!!!");
        }
        finally {
            try {
                int i=Integer.parseInt(args[0]);
            } 
            catch (NumberFormatException e){
                System.out.println("NumberFormat");        
            } 
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("AIOOBException"); 
            }
            finally {
                System.out.println("Fin2");        
            }       
            System.out.println("Fin 1");
        }
    }
}
