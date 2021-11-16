/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Windows10
 */
import java.util.ArrayList;
public class ManipulateFile {
    static String type;
    static String name;
    static int quantity;
    static int min;
    static int max;
    
    
    static void assignValues(ArrayList<String[]> a){
        for(String[] b: a){
            if(!(b[0].equals(null))){
                type = b[0];
                System.out.print(type);
            }
            if(!(b[1].equals(null))){
                name = b[1];
            }
            if(!(b[2].equals(null))){
                int i = Integer.parseInt(b[2]);
                quantity = i;
            }
            if(!(b[3].equals(null))){
                int j = Integer.parseInt(b[3]);
                min = j;
            }
            if (!(b[4].equals(null))){
                int k = Integer.parseInt(b[4]);
                max = k;
            }
        }
    }
    @Override
    public String toString(){
        return type + name + quantity + min + max;
    }
}
