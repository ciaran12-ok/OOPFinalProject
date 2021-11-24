
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

    public Hotel(String name, int star) {
        this.name = name;
        this.star = star;

    }

    public Hotel(int star) {
        this.star = star;

    }

    public Room[] getRoomsAvailable() {
        return roomsAvailable;
    }

    public void setRoomsAvailable(Room[] roomsAvailable) {
        this.roomsAvailable = roomsAvailable;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    
    /**
     *
     * @param h
     * @return
     * @author Orla
     * @version 13/11/2021
     */
    public ArrayList<String> getRoomOptions() {
        ArrayList<String> rooms = new ArrayList<>();
        if (this.star == 5) {
            rooms.add("1) Deluxe Double");
            rooms.add("2) Deluxe Twin");
            rooms.add("3) Deluxe Single");
            rooms.add("4) Deluxe Family");
        }
        if (this.star == 4) {
            rooms.add("1) Executive Double");
            rooms.add("2) Executive Twin");
            rooms.add("3) Executive Single");

        }
        if (this.star == 3) {
            rooms.add("1) Classic Double");
            rooms.add("2) Classic Twin");

        }

        return rooms;
    }

}


