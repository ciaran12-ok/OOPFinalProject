
import java.util.ArrayList;

/**
 * A class to represent a Calender that holds reservations
 *
 * @author Nabel Sodipe
 * @date 13/11/2021
 */
public class Calender {

    private ArrayList<Reservation> reservations;
    private Reservation r1;

    //Used only for the find booking method
    private ArrayList<String> reservationNumbers;

    /**
     * No arg constructor that creates a calender
     */
    public Calender() {
        reservations = new ArrayList<Reservation>();
        reservationNumbers = new ArrayList<String>();
    }

    /**
     * Adds a booking to the calender
     *
     * @param r
     */
    public void addToCalender(Reservation r) {
        reservations.add(r);
        reservationNumbers.add(r.getReservationNumber());
    }

    /**
     * Removes a booking from a calender
     *
     * @param r
     */
    public void removeReservation(Reservation res) {
        int tempRes;
        tempRes = Integer.parseInt(res.getReservationNumber());
        for (tempRes = Integer.parseInt(res.getReservationNumber()); tempRes<= reservationNumbers.size(); tempRes++ ){
            
            reservationNumbers.set(tempRes+1, String.valueOf(tempRes));
        }
        reservations.remove(res);
        reservationNumbers.remove(res.getReservationNumber());
    }

    /**
     * Returns the array list of reservations
     *
     * @return
     */
    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public ArrayList<String> getReservationNumbers() {
        return reservationNumbers;
    }

    /**
     * Method that finds a booking and all it's reservations based off it's
     * reservation number
     *
     * @param reservationNumber
     * @return an array of reservations under a booking
     */
    
    
    /*
    public Reservation[] findBooking(String reservationNumber) {

        ArrayList<Integer> index = new ArrayList<>();
        if (reservationNumbers.contains(reservationNumber)) {
            for (String resNumbers : reservationNumbers) {
                if (resNumbers.equals(reservationNumber)) {
                    index.add(reservationNumbers.indexOf(resNumbers));
                }
            }
        } else {
            System.out.println("Invalid reservation number, please try again.");
        }

        Reservation[] reservationsFound = new Reservation[index.size()];
        for (Integer in : index) {
            reservationsFound[in.intValue()] = reservations.get(in.intValue());
        }

        return  reservationsFound;
    }
    */
    
    
    public Reservation lookBooking(String reservationNumber) {

        ArrayList<Integer> index = new ArrayList<Integer>();
        //Reservation r1
        if(!reservationNumbers.contains(reservationNumber)){
          System.out.print("Invalid");
        }
        System.out.println(reservations.get(Integer.parseInt(reservationNumber) -1));
        //System.out.print(reservations);
        //Reservation r = new Reservation (reservations.get(Integer.parseInt(reservationNumber) -1));
        return r1;
    }
}

    /**
     * Class to test that the Calender class is working as expected
     *
     * @author Orla
     * @version 28/11/2021
     */
    