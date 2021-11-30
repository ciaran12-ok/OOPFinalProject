import java.util.ArrayList;
import java.io.FileNotFoundException;
/**
 *A class to convert the reservations read in from the csv file into
 * the reservations ArrayList
 * 
 * @author Aine
 */
public class CreateReservations {
    private ArrayList<Reservation> reservations1 = new ArrayList<>();
    
    public ArrayList<Reservation> makeAList(String[][] resTemp){
        for (int i = 1; i < resTemp.length; i ++){
            String reservationNumber = resTemp[i][0];
            String reservationName = resTemp[i][1];
            ReservationType rType = resTemp[i][2];
            ResDate checkIn = resTemp[i][3];
            ResDate checkOut = resTemp[i][4];
            String roomType = resTemp[i][5];
            int roomOccupancy = Integer.parseInt(resTemp[i][6]);
            int star = Integer.parseInt(resTemp[i][7]);
            
            for (int j = 0; j < resTemp.length; j ++){
                Reservation res = new Reservation(reservationNumber,
                reservationName, rType, checkIn, checkOut, roomType,
                roomOccupancy, star);
                reservations1.add(res);
            }
        }
    }
}
