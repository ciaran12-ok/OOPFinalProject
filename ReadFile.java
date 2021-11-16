/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Áine Sweeny
 */
import java.util.Scanner;
import java.util.ArrayList;
public class ReadFile {
    
    public static void main(String[] args) throws Exception{
        java.io.File file = new java.io.File("l4Hotels.csv");
        ArrayList<String[]> rooms = new ArrayList<String[]>();
        Scanner input = new Scanner(file);
        
        while(input.hasNext()){
            String line = input.nextLine();
            String[] LineParts = line.split(",");
            rooms.add(LineParts);
        }
        input.close();
        
        for (int i = 0;i < rooms.size(); i ++){
            for (int j = 0; j<rooms.get(i).length; j ++){
                System.out.printf("! " + rooms.get(i)[j]);
                System.out.println();
            }
        }
        // write get methods for all rooms depending on main menu
        // keep in this class or move to different one?
        for (int i = 0;i < rooms.size(); i ++){
                String type = rooms.get(i)[0];
                System.out.println(type);
                if(type.equals("5-star")){
                    for(int a = 2; a < 5; a ++){
                    String room = rooms.get(a)[1];
                    System.out.println(room);
                }// to be finished
            }
        
    }
    
}
}
