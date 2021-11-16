
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
    public void setNoOfRooms(int NoOfRooms) {
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
     * Method that will interact with the calendar class by counting the number
     * of the same room types that are booked, if it's greater than the
     * noOfRooms that are available then the room can't be booked
     *
     * @author Orla
     */
    public boolean checkAvailable() {
        boolean available = false;
        //Loop through the arrayList of reservations
        //Count the number of rooms under that type
        //Must be less than NoOfRooms to be booked
        return available;
    }

}
