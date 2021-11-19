
import java.util.ArrayList;
import java.util.Random;

/**
 * Class that reads in the information in the csv file
 *
 * @author Orla
 * @version 18/11/2021
 */
public class CreateHotels {

    public Hotel hotel5 ;
    public Hotel hotel4;
    public Hotel hotel3;
    public Calender calender;

    public void readInHotels() {
        //should be a method that reads in all the info from the csv files
        //and enters it like this

        //Creates all the rooms that can be booked
        int[] r1 = {75, 75, 75, 80, 90, 90, 75};
        Room deluxeDouble = new Room("Deluxe Double", 35, 1, 2, r1);

        int[] r2 = {75, 75, 75, 80, 90, 90, 75};
        Room deluxeTwin = new Room("Deluxe Twin", 25, 1, 2, r2);

        int[] r3 = {70, 70, 70, 75, 80, 80, 65};
        Room deluxeSingle = new Room("Deluxe Single", 10, 1, 2, r3);

        int[] r4 = {80, 80, 80, 80, 100, 100, 80};
        Room deluxeFamily = new Room("Deluxe Family", 10, 1, 3, r4);

        int[] r5 = {70, 70, 70, 70, 80, 85, 85};
        Room executiveDouble = new Room("Executive Double", 40, 1, 2, r5);

        int[] r6 = {70, 70, 70, 70, 80, 85, 85};
        Room executiveTwin = new Room("Executive Twin", 32, 1, 2, r6);

        int[] r7 = {65, 65, 65, 65, 70, 75, 80};
        Room executiveSingle = new Room("Executive Single", 12, 1, 1, r7);

        int[] r8 = {65, 65, 70, 70, 75, 80, 65};
        Room classicDouble = new Room("Classic Double", 45, 1, 2, r8);

        int[] r9 = {65, 65, 70, 70, 80, 85, 65};
        Room classicTwin = new Room("Classic Twin", 45, 1, 2, r9);

        //Create the hotels that can be stayed in
        //Create three hotels to be used
        Hotel hotel5 = new Hotel("5-STAR HOTEL", 5);
        Hotel hotel4 = new Hotel("4-STAR HOTEL", 3);
        Hotel hotel3 = new Hotel("3-STAR HOTEL", 4);

        Room[] fiveStarRooms = {deluxeDouble, deluxeTwin, deluxeSingle, deluxeFamily};
        hotel5.setRoomsAvailable(fiveStarRooms);
        Room[] fourStarRooms = {executiveDouble, executiveTwin, executiveSingle};
        hotel4.setRoomsAvailable(fourStarRooms);
        Room[] threeStarRooms = {classicDouble, classicTwin};
        hotel3.setRoomsAvailable(threeStarRooms);
    }
    
}

