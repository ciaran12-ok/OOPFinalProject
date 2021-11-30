
import java.io.FileNotFoundException;

/**
 * A test class to ensure the CreatHotels class is working as expected
 *
 * @author Orla
 */
class TestCreateHotels {

    public static void main(String[] args) {
        try {
            //Creating a five star hotel by reading in information from a csv file
            ReadFile file = new ReadFile();
            String[][] input = file.readCsvFile();
            CreateHotels newHotel = new CreateHotels(input);
            Hotel hotelA = newHotel.getHotel5();
            String actualOutput = hotelA.toString();

            //Creating a hotel the long way 
            Hotel hotelE = new Hotel("5-STAR HOTEL", 5);
            int[] r1 = {75, 75, 75, 80, 90, 90, 75};
            Room deluxeDouble = new Room("Deluxe Double", 35, 1, 2, r1);

            int[] r2 = {75, 75, 75, 80, 90, 90, 75};
            Room deluxeTwin = new Room("Deluxe Twin", 25, 1, 2, r2);

            int[] r3 = {70, 70, 70, 75, 80, 80, 65};
            Room deluxeSingle = new Room("Deluxe Single", 10, 1, 2, r3);

            int[] r4 = {80, 80, 80, 80, 100, 100, 80};
            Room deluxeFamily = new Room("Deluxe Family", 10, 1, 3, r4);
            Room[] fiveStarRooms = {deluxeDouble, deluxeTwin, deluxeSingle, deluxeFamily};
            hotelE.setRoomsAvailable(fiveStarRooms);
            String expectedOutput = hotelE.toString();

            if (expectedOutput.equals(actualOutput)) {
                System.out.println("Test Passed");
            } else {
                System.out.println("Test Failed");
            }

        } catch (FileNotFoundException ex) {
            System.err.print("An error has occured");
        }

    }
}
