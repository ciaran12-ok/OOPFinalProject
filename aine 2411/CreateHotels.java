
import java.util.ArrayList;
import java.io.FileNotFoundException;

/**
 * Class that reads in the information in the csv file
 *
 * @author Orla
 * @version 18/11/2021
 */
public class CreateHotels {

    private ArrayList<Room> threeStar = new ArrayList<>();
    private ArrayList<Room> fourStar = new ArrayList<>();
    private ArrayList<Room> fiveStar = new ArrayList<>();
    
    /*
    CreateHotels constructor creates the 3 hotels
    */
    public CreateHotels(String temp[][]) throws FileNotFoundException{
        createThreeStar(temp);
        createFourStar(temp);
        createFiveStar(temp);
    }
    
    public void createFiveStar(String[][] temp){
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
                fiveStar.add(room);
            }
        }
    }
    
    public void createFourStar(String[][] temp){
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
                fourStar.add(room);
            }
        }
    } 
    
     public void createThreeStar(String[][] temp){
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
                threeStar.add(room);
            }
        }
    }

     public ArrayList<Room> getThreeStar(){
         return threeStar;
     }
     
     public ArrayList<Room> getFourStar(){
         return fourStar;
     }
     
     public ArrayList<Room> getFiveStar(){
         return fiveStar;
     }
}
