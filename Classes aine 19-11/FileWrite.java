import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *this version overwrites the file every time, however
 * i have not figured out how to read in an arraylist
 * @author Windows10
 */
public class FileWrite {
    public static void main(String[] args){
        
        
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter("DataHotel.csv", false);
            
            fileWriter.write("hi");
            fileWriter.write("7");
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try{
                if (fileWriter != null){
                    fileWriter.flush();
                    fileWriter.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
