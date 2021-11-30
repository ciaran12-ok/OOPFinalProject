import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;

/**
 * Allows you to run the roomMenu and catches any exception that can be thrown
 *
 * @author Orla
 * @version 27//11/2021
 */
public class ReservationSystem {

    public static void main(String[] args)
            throws IOException {
        try {
            RoomMenu menu = new RoomMenu();
            menu.run();
        } catch (FileNotFoundException ex) {

            System.err.println("File not found, try again");

        } catch (InputMismatchException ex) {
            System.err.println("Unexpected entry");
        }

    }
}