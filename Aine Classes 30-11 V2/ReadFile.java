
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Class to read in all the information from the l4Hotel.csv file
 * @author Aine
 */
public class ReadFile {

    private String[][] temp;
    private String[][] resTemp;
   
    /**
     * Reads in csv file, splits each line using comma delimiter
     * @return String[][]
     * @throws FileNotFoundException 
     */
    public String[][] readCsvFile() throws FileNotFoundException {
        //NOTE: make sure you put the file l4Hotels.csv in the netBeans project
        //folder for this project so it can be found
        java.io.File file = new java.io.File("l4Hotels.csv");
        Scanner input = new Scanner(file);

        String line;
        this.temp = new String[11][12];
        int i = 0;
        while (input.hasNext()) {
            line = input.nextLine();
            this.temp[i] = line.split(",");
            i++;
        }
        input.close();
        return temp;
    }
    /**
     * A class to read preexisting reservations from a csv file, splits
     * lines using comma delimiter
     * 
     * @return String[][]
     * @throws FileNotFoundException 
     */
    
    public String[][] readReservations() throws FileNotFoundException{
        java.io.File file = new java.io.File("Reservations.csv");
        Scanner counter = new Scanner(file);
        String line;
        String a;
        int b = 0;
        
        while(counter.hasNext()){
            a = counter.nextLine();
            b++;
        }
        counter.close();
        
        Scanner input = new Scanner(file);
        this.resTemp = new String[b][8];
        int i = 0;
        while (input.hasNext()){
            line = input.nextLine();
            this.resTemp[i] = line.split(",");
            i ++;
        }
        input.close();
        return resTemp;
    }

}

/**
 * A class to test is the readFile working as expected
 *
 * @author Orla
 */
class TestReadFile {

    public static void main(String[] args) {
        ReadFile file = new ReadFile();
        try {
            String[][] input = file.readCsvFile();

            for (int i = 0; i < input.length; i++) {
                System.out.println("");
                for (int j = 0; j < input[i].length; j++) {
                    System.out.print(input[i][j] + " ");
                }
            }

        } catch (FileNotFoundException ex) {
            System.err.println("File not found, try again");
        }
        
        
        try {
            String[][] res1 = file.readReservations();
            
            for(int j = 0; j < res1.length; j ++){
                System.out.println();
                for (int i = 0; i < res1[j].length; i ++){
                    System.out.print(res1[j][i] + " ");
                }
            }
        }catch (FileNotFoundException e){
            System.err.println("File not found, try again");
        }
    }
}
