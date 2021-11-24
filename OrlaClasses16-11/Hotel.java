
import java.util.ArrayList;

/**
 *
 * @author ciaranokeeffe
 */
public class Hotel {

    private String name;
    private int star;

    public Hotel(String name, int star) {
        this.name = name;
        this.star = star;
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

    @Override
    public String toString() {
        return "Hotel{" + "name=" + name + ", star=" + star + '}';
    }

    /**
     *
     * @param h
     * @return
     * @author Orla
     * @version 13/11/2021
     */
    public ArrayList<String> getRoomOptions(Hotel h) {
        ArrayList<String> rooms = new ArrayList<>();
        if (h.getStar() == 5) {
            rooms.add("Deluxe Double");
            rooms.add("Deluxe Twin");
            rooms.add("Deluxe Single");
            rooms.add("Deluxe Family");
        }
        if (h.getStar() == 4) {
            rooms.add("Executive Double");
            rooms.add("Executive Twin");
            rooms.add("Executive Single");

        }
        if (h.getStar() == 3) {
            rooms.add("Classic Double");
            rooms.add("Classic Twin");

        }

        return rooms;
    }

}
