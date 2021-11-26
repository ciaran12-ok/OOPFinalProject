
import java.util.ArrayList;
import java.io.FileNotFoundException;

/**
 * Class that reads in the information in the csv file
 *
 * @author Orla
 * @version 18/11/2021
 */
public class CreateHotels {
 
    private Hotel hotel5;
    private Hotel hotel4;
    private Hotel hotel3;
    /*
    CreateHotels constructor creates the 3 hotels
    */
    public CreateHotels(String temp[][]) throws FileNotFoundException{
        hotel3.setRoomsAvailable(createThreeStar(temp));
        hotel4.setRoomsAvailable(createFourStar(temp));
        hotel5.setRoomsAvailable(createFiveStar(temp));
        
    }

    public CreateHotels() {
    }
    
    
    
    public Room[] createFiveStar(String[][] temp){
        Room[] fiveStar = new Room[4];
        for (int i = 1; i < 5; i ++){
            String type = temp[i][1];
            int noOfRooms = Integer.parseInt(temp[i][2]);
            int min = Integer.parseInt(temp[i][3]);
            int max = Integer.parseInt(temp[i][4]);
            int[] weeklyRates = new int[7];
            for(int a = 0; a < 7; a ++){
                weeklyRates[a] = Integer.parseInt(temp[i][a+5]);
            }
            for (int b = 0;b < noOfRooms; b ++){
                Room room = new Room(type, noOfRooms, min, max,
                weeklyRates);
                fiveStar[b] = room;
            }
            
        } return fiveStar;
    }
    
    public Room[] createFourStar(String[][] temp){
        Room[] fourStar = new Room[3];
        for (int i = 5; i < 8; i ++){
            String type = temp[i][1];
            int noOfRooms = Integer.parseInt(temp[i][2]);
            int min = Integer.parseInt(temp[i][3]);
            int max = Integer.parseInt(temp[i][4]);
            int[] weeklyRates = new int[7];
            for(int a = 0; a < 7; a ++){
                weeklyRates[a] = Integer.parseInt(temp[i][a+5]);
            }
            for (int b = 0;b < noOfRooms; b ++){
                Room room = new Room(type, noOfRooms, min, max,
                weeklyRates);
                fourStar[b] = room;
            }
        } return fourStar;
    } 
    
     public Room[] createThreeStar(String[][] temp){
         Room[] threeStar = new Room[3];
        for (int i = 8; i < 11; i ++){
            String type = temp[i][1];
            int noOfRooms = Integer.parseInt(temp[i][2]);
            int min = Integer.parseInt(temp[i][3]);
            int max = Integer.parseInt(temp[i][4]);
            int[] weeklyRates = new int[7];
            for(int a = 0; a < 7; a ++){
                weeklyRates[a] = Integer.parseInt(temp[i][a+5]);
            }
            for (int b = 0;b < noOfRooms; b ++){
                Room room = new Room(type, noOfRooms, min, max,
                weeklyRates);
                threeStar[b] = room;
            }
        }return threeStar;
    }

     public Hotel getHotel5(){
         return hotel5;
     }
     
     public Hotel getHotel4(){
         return hotel4;
     }
     
     public Hotel getHotel3(){
         return hotel3;
     }
     
     
}
