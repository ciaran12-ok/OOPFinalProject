
import java.util.ArrayList;

/**
 * A class to represent a room
 *
 * @author ciaranokeeffe
 * @author Orla
 * @version 13/11/2021
 */
public class Room {

    private String type;
    private int noOfRooms;
    private int min;
    private int max;
    private int[] weeklyRates;

    /**
     * No arg constructor
     * Only used for testing purposes
     */
    public Room() {

    }

    /**
     * Constructor that sets all the info about the room
     *
     * @param type
     * @param noOfRooms
     * @param min
     * @param max
     * @param weeklyRates
     */
    public Room(String type, int noOfRooms, int min, int max, int[] weeklyRates) {
        this.type = type;
        this.noOfRooms = noOfRooms;
        this.min = min;
        this.max = max;
        this.weeklyRates = weeklyRates;
    }

    /**
     * Gets the room type
     *
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the room type
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the number of rooms that will be available
     *
     * @return noOfRooms
     */
    public int getNoOfRooms() {
        return noOfRooms;
    }

    /**
     * Sets the number of rooms that will be available
     *
     * @param NoOfRooms
     */
    public void setNoOfRooms(int noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    /**
     * Gets a rooms minimum occupancy
     *
     * @return
     */
    public int getMin() {
        return min;
    }

    /**
     * Sets a rooms minimum occupancy
     *
     * @return
     */
    public void setMin(int min) {
        this.min = min;
    }

    /**
     * Gets a rooms maximum occupancy
     *
     * @return
     */
    public int getMax() {
        return max;
    }

    /**
     * Sets a rooms maximum occupancy
     *
     * @return
     */
    public void setMax(int max) {
        this.max = max;
    }

    /**
     * Returns an array of rates for a room where Sundays price is stored at
     * element 0, and so on
     *
     * @return
     */
    public int[] getWeeklyRates() {
        return weeklyRates;
    }

    /**
     * Creates an array of weekly rates
     *
     * @param weeklyRates
     */
    public void setWeeklyRates(int[] weeklyRates) {
        this.weeklyRates = weeklyRates;
    }

    /**
     * Returns a String representation of a room
     *
     * @return String
     */
    @Override
    public String toString() {
        String ratesArray = "";
        for (int i = 0; i < weeklyRates.length - 1; i++) {
            ratesArray += weeklyRates[i] + ",";
        }
        ratesArray += weeklyRates[weeklyRates.length - 1];

        return "Room; Type:" + type + " NoOfRooms:" + noOfRooms + " Min:"
                + min + " Max:" + max + " WeeklyRates:" + ratesArray;
    }

}

/**
 * A test class to make sure the room class is working as expected
 *
 * @author Orla
 */
class TestRoom {

    public static void main(String[] args) {
        /*
        Test 1
        Testing the get methods vs the constructor using a toString()
         */

        //Creating the room using the constructor
        int[] rates1 = {75, 75, 75, 80, 90, 90, 75};
        Room room1 = new Room("Double Room", 35, 1, 2, rates1);

        //Creating a string of expected output using the get methods
        String expectedOutput = "";
        String ratesArray = "";
        for (int i = 0; i < room1.getWeeklyRates().length - 1; i++) {
            ratesArray += room1.getWeeklyRates()[i] + ",";
        }
        ratesArray += room1.getWeeklyRates()[room1.getWeeklyRates().length - 1];

        expectedOutput = "\nRoom; Type:" + room1.getType() + " NoOfRooms:" + room1.getNoOfRooms()
                + " Min:" + room1.getMin() + " Max:" + room1.getMax() + " WeeklyRates:" + ratesArray;
        String actualOutput = room1.toString();

        //Comparing the two strings to see if they're the same
        //Run the main method to find out whether the test passed
        if (expectedOutput.equals(actualOutput)) {
            System.out.println("True: Test 1 Passed");
        } else {
            System.out.println("Test 1 Failed");
        }

        /*
        Test 2
         Testing the set methods vs the constructor using a toString()
         */
        //Creating a room using a constructor
        int[] rates2 = {75, 75, 75, 50, 90, 10, 5};
        Room room2 = new Room("Single Room", 35, 1, 2, rates2);

        //Creating a room using the set methods
        Room room3 = new Room();
        room3.setType("Single Room");
        room3.setNoOfRooms(35);
        room3.setMin(1);
        room3.setMax(2);
        int[] rates3 = {75, 75, 75, 50, 90, 10, 5};
        room3.setWeeklyRates(rates3);

        //Comparing the two strings to see if they're the same
        //Run the main method to find out whether the test passed
        if (room2.toString().equals(room3.toString())) {
            System.out.println("True: Test 2 Passed");
        } else {
            System.out.println("Test 2 Failed");
        }

    }
}
