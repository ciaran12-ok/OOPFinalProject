import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *this version is supposed to read in an arraylist
 * @author Windows10
 */
public class FileWrite1 {
    public static void main(String[] args) throws IOException{
        ArrayList<String> test = new ArrayList<>();
        test.add("hi");
        test.add("my name is aine");
        
        File file = new File("test.csv");
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        
        bw.write("Test String");
        bw.newLine();
        for(int i = 0; i < test.size(); i ++){
            bw.write(test.get(i+1) + "," + test.get(i++));
            bw.newLine();
        }
        bw.write("\nRandom Text");
        bw.close();
        fw.close();
    }
}

