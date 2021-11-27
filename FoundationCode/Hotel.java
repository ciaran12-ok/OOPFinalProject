
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
    public String[] getRoomOptions() {
      String[] rooms = new String[roomsAvailable.length];
      for(int i = 0;i<rooms.length; i++){
          rooms[i] = i+ ") " + roomsAvailable[i].toString();
      }
      return rooms;
    }

}

//  String[] rooms = new String[roomsAvailable.length];
//        if (this.star == 5) {
//           
//            rooms[0] = "1) Deluxe Double";
//            rooms[1] = "2) Deluxe Twin";
//            rooms[2] = "3) Deluxe Single";
//            rooms[3] = "4) Deluxe Family";
//        }
//        if (this.star == 4) {
//            rooms[0] = "1) Executive Double";
//            rooms[1] = "2) Executive Twin";
//            rooms[2] = "3) Executive Single";
//
//        }
//        if (this.star == 3) {
//            rooms[0] = "1) Classic Double";
//            rooms[1] = "2) Classic Twin";
//
//        }
//
//        return rooms;
