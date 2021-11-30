
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

        return "Room; Type:" + type;
    }

}

