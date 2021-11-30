
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.time.LocalDate;

/**
 * A class to represent a Calender that holds reservations
 *
 * @author Nabel Sodipe
 * @date 13/11/2021
 */
public class Calender {

    private ArrayList<Reservation> reservations;
    private Reservation r1;
    private int noOfRemove;

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
        for (tempRes = Integer.parseInt(res.getReservationNumber()); tempRes < reservationNumbers.size(); tempRes++) {

            reservationNumbers.set(tempRes, String.valueOf(tempRes));
            Reservation newRes = reservations.get(tempRes);
            newRes.setReservationNumber(String.valueOf(tempRes));

            reservations.set(tempRes, newRes);
        }
        reservations.remove(res);
        reservationNumbers.remove(res.getReservationNumber());
        noOfRemove++;
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
     * Gets todays date in localDate
     * @return 
     */
    public LocalDate nowToday() {

        LocalDate date = LocalDate.now();
        return date;
    }

    /**
     * Finds and returns a reservation of that res number 
     * @param reservationNumber
     * @return 
     */
    
    public Reservation lookBooking(String reservationNumber) {
        
        
        ArrayList<Integer> index = new ArrayList<Integer>();
        //If arrayList doesn't contain number print
        if(!reservationNumbers.contains(reservationNumber)){
          System.out.print("Invalid");
        }
        
        //Sets r1 to new element
        r1 = reservations.get(Integer.parseInt(reservationNumber));
      
        
        return r1;
    }

}

/**
 * Class to test that the Calender class is working as expected
 *
 * @author Orla
 * @version 28/11/2021
 */
class TestCalendar {

    public static void main(String[] args) {
        Calender myCalender = new Calender();

        /*
        Test 1: checking to see whether all reservations are added to the calender
         */
        Reservation res1 = new Reservation("1", "John", new ReservationType("AP"), new ResDate("20/11/2021"),
                new ResDate("23/11/2021"), "Single", 1);
        Reservation res2 = new Reservation("2", "Mary", new ReservationType("S"), new ResDate("19/11/2021"),
                new ResDate("25/11/2021"), "Double", 2);
        Reservation res3 = new Reservation("3", "Joe", new ReservationType("S"), new ResDate("18/10/2021"),
                new ResDate("20/10/2021"), "Double", 1);
        Reservation res4 = new Reservation("4", "John", new ReservationType("S"), new ResDate("21/11/2021"),
                new ResDate("23/11/2021"), "Single", 1);
        Reservation res5 = new Reservation("5", "John", new ReservationType("S"), new ResDate("22/11/2021"),
                new ResDate("23/11/2021"), "Single", 2);

        myCalender.addToCalender(res1);
        myCalender.addToCalender(res2);
        myCalender.addToCalender(res3);
        myCalender.addToCalender(res4);
        myCalender.addToCalender(res5);

        ArrayList<Reservation> reservations1 = new ArrayList<>();
        reservations1 = myCalender.getReservations();
        System.out.println("Test 1");
        for (Reservation r : reservations1) {
            System.out.println(r.toString());
        }
        System.out.println("Test 1 Passed");
        System.out.println("");

        /*
        Test 2 : checking to see whether a reservation is removed successfully
         */
        myCalender.removeReservation(res3);
        ArrayList<Reservation> reservations2 = new ArrayList<>();
        reservations2 = myCalender.getReservations();
        System.out.println("Test 2");
        for (Reservation r : reservations2) {
            System.out.println(r.toString());
        }
        System.out.println("Test 2 Passed");
        System.out.println("");

        /*
        Test 3 : checking to see whether the findReservation method works
        TEST IS CURRENTLY FAILING
         */
       // Reservation[] r = myCalender.findBooking("2023");
       // for (int i = 0; i < r.length; i++) {
       //     System.out.println(r[i]);
       // }

        
        Reservation r2 = myCalender.lookBooking("1");
        Reservation r3 = myCalender.lookBooking("4");
        System.out.println(r3);
        
       
        System.out.println(myCalender.nowToday());
        
    }
}
