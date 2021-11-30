
import java.io.FileNotFoundException;

/**
 * A class to test is the readFile working as expected
 *
 * @author Orla
 */
class TestReadFile {

    public static void main(String[] args) {
        /*
        Test 1: testing to ee if the l4Hotels.csv file is read in correctly
        */
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
        
        /*
        Test 2: testing to ee if the Reservations.csv file is read in correctly
        */
         ReadFile file1 = new ReadFile();
        try {
            String[][] input = file1.Reservations();
            System.out.println("");
            for (int i = 0; i < input.length; i++) {
                System.out.println("");
                for (int j = 0; j < input[i].length; j++) {
                    System.out.print(input[i][j] + " ");
                }
            }

        } catch (FileNotFoundException ex) {
            System.err.println("File not found, try again");
        }
    }
}
