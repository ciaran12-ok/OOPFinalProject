
import java.util.Random;

/**
 * Class that reads in the information in the csv file
 *
 * @author Orla
 * @version 13/11/2021
 */
public class CreateHotels {

    public int[] deluxeDouble = {35, 1, 2, 75, 75, 75, 80, 90, 90, 75};
    int[] deluxeTwin = {25, 1, 2, 75, 75, 75, 80, 90, 90, 75};
    int[] deluxeSingle = {10, 1, 2, 70, 70, 70, 75, 80, 80, 65};
    int[] deluxeFamily = {10, 1, 3, 80, 80, 80, 80, 100, 100, 80};
    int[] excutiveDouble = {40, 1, 2, 70, 70, 70, 70, 80, 85, 85};
    int[] executiveTwin = {32, 1, 2, 70, 70, 70, 70, 80, 85, 85};
    int[] executiveSingle = {12, 1, 1, 65, 65, 65, 65, 70, 75, 80};
    int[] classicDouble = {45, 1, 2, 65, 65, 70, 70, 75, 80, 65};
    int[] classicTwin = {45, 1, 2, 65, 65, 70, 70, 80, 85, 65};

    public static void main(String[] args) {
        Random rng = new Random();
        int rNumber = 100000 + rng.nextInt(1000000);
        int i = 1;
        String s = String.valueOf(i);
        System.out.println(s);
    }
}
