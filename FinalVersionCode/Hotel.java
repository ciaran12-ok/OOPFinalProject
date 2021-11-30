
import java.util.ArrayList;

/**
 *
 * @author ciaranokeeffe
 * @author Orla
 */
public class Hotel {

    private String name;
    private int star;
    public Room[] roomsAvailable;

    /**
     * Constructor that allows a user to set the hotels name and star
     *
     * @param name
     * @param star
     */
    public Hotel(String name, int star) {
        this.name = name;
        this.star = star;

    }

    /**
     * No arg constructor Only used for testing purposes
     */
    public Hotel() {

    }

    /**
     * Returns an array of rooms available
     *
     * @return Room[]
     */
    public Room[] getRoomsAvailable() {
        return roomsAvailable;
    }

    /**
     * Sets the rooms available for a hotel
     *
     * @param roomsAvailable
     */
    public void setRoomsAvailable(Room[] roomsAvailable) {
        this.roomsAvailable = roomsAvailable;
    }

    /**
     * Gets the name of the hotel
     *
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the hotel
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the stars the hotel has
     *
     * @return int star
     */
    public int getStar() {
        return star;
    }

    /**
     * Sets the stars of the hotel
     *
     * @param star
     */
    public void setStar(int star) {
        this.star = star;
    }

    /**
     * Returns a String array of room options, this will be useful for the room
     * menu class
     *
     * @return String[]
     */
    public String[] getRoomOptions() {
        String[] rooms = new String[roomsAvailable.length];
        for (int i = 0; i < rooms.length; i++) {
            rooms[i] = i + ") " + roomsAvailable[i].toString();
        }
        return rooms;
    }

    /**
     * Returns a string representation of a hotel
     *
     * @return String
     */
    @Override
    public String toString() {
        String roomsArray = "";

        try {
            for (int i = 0; i < roomsAvailable.length - 1; i++) {
                roomsArray += roomsAvailable[i] + ",";
            }
            roomsArray += roomsAvailable[roomsAvailable.length - 1];
        } catch (NullPointerException ex) {
            System.err.print("Rooms available array is empty");
        }

        return "Hotel:" + " Name:" + name + " Star:" + star + " RoomsAvailable:" + roomsArray;
    }

}

