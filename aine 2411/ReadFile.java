/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Áine
 */
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFile {
    private String[][] temp;
    
    /*
    reads in csv file, splits each line using comma delimiter
    */
    public String[][] readCsvFile() throws FileNotFoundException{
        java.io.File file = new java.io.File("l4Hotels.csv");
        Scanner input = new Scanner(file);
        
        String line;
        this.temp = new String[12][12];
        int i = 0;
        while(input.hasNext()){
            line = input.nextLine();
            this.temp[i] = line.split(",");
            i++;
        }
        input.close();
        return temp;
    }
}
