
import java.util.ArrayList;
import java.io.FileNotFoundException;

/**
 * Class that reads in the information from the csv file
 *
 * @author Aine
 * @author Orla
 * @version 27/11/2021
 */
public class CreateHotels {

    private Hotel hotel5;
    private Hotel hotel4;
    private Hotel hotel3;

    /**
     * Constructor that takes in a 2D array of information about the three
     * hotels to be created
     *
     * @param temp
     * @throws FileNotFoundException
     */
    public CreateHotels(String temp[][]) throws FileNotFoundException {
        this.hotel5 = new Hotel("5-STAR HOTEL", 5);
        this.hotel4 = new Hotel("4-STAR HOTEL", 3);
        this.hotel3 = new Hotel("3-STAR HOTEL", 4);

        Room[] fiveStarRooms = createFiveStar(temp);
        hotel5.setRoomsAvailable(fiveStarRooms);

        Room[] fourStarRooms = createFourStar(temp);
        hotel4.setRoomsAvailable(fourStarRooms);

        Room[] threeStarRooms = createThreeStar(temp);
        hotel3.setRoomsAvailable(threeStarRooms);

    }

    /**
     * Method that creates the five star rooms based off the info from the 2D
     * array
     *
     * @param temp
     * @return Room[]
     */
    public Room[] createFiveStar(String[][] temp) {

        Room[] fiveStarRooms = new Room[4];
        for (int i = 1; i < 5; i++) {
            String type = temp[i][1];
            int noOfRooms = Integer.parseInt(temp[i][2]);
            int min = Integer.parseInt(temp[i][3]);
            int max = Integer.parseInt(temp[i][4]);
            int[] weeklyRates = new int[7];
            for (int a = 0; a < 7; a++) {
                weeklyRates[a] = Integer.parseInt(temp[i][a + 5]);
            }
            Room room = new Room(type, noOfRooms, min, max,
                    weeklyRates);
            fiveStarRooms[i - 1] = room;
        }
        return fiveStarRooms;
    }

    /**
     * Method that creates the four star rooms based off the info from the 2D
     * array
     *
     * @param temp
     * @return Room[]
     */
    public Room[] createFourStar(String[][] temp) {
        Room[] fourStarRooms = new Room[3];
        for (int i = 5; i < 8; i++) {
            String type = temp[i][1];
            int noOfRooms = Integer.parseInt(temp[i][2]);
            int min = Integer.parseInt(temp[i][3]);
            int max = Integer.parseInt(temp[i][4]);
            int[] weeklyRates = new int[7];
            for (int a = 0; a < 7; a++) {
                weeklyRates[a] = Integer.parseInt(temp[i][a + 5]);
            }
            Room room = new Room(type, noOfRooms, min, max,
                    weeklyRates);
            fourStarRooms[i - 5] = room;
        }
        return fourStarRooms;
    }

    /**
     * Method that creates the three star rooms based off the info from the 2D
     * array
     *
     * @param temp
     * @return Room[]
     */
    public Room[] createThreeStar(String[][] temp) {
        Room[] threeStarRooms = new Room[3];
        for (int i = 8; i < 11; i++) {
            String type = temp[i][1];
            int noOfRooms = Integer.parseInt(temp[i][2]);
            int min = Integer.parseInt(temp[i][3]);
            int max = Integer.parseInt(temp[i][4]);
            int[] weeklyRates = new int[7];
            for (int a = 0; a < 7; a++) {
                weeklyRates[a] = Integer.parseInt(temp[i][a + 5]);
            }
            Room room = new Room(type, noOfRooms, min, max,
                    weeklyRates);
            threeStarRooms[i - 8] = room;

        }
        return threeStarRooms;
    }

    /**
     * Method that returns a five star hotel
     *
     * @return Hotel
     */
    public Hotel getHotel5() {
        return hotel5;
    }

    /**
     * Method that returns a four star hotel
     *
     * @return Hotel
     */
    public Hotel getHotel4() {
        return hotel4;
    }

    /**
     * Method that returns a three star hotel
     *
     * @return Hotel
     */
    public Hotel getHotel3() {
        return hotel3;
    }
}

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
