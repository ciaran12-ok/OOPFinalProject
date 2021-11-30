import java.util.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * A class to represent a Calender that holds reservations
 *
 * @author Nabel Sodipe
 * @date 13/11/2021
 */
public class Calender {

    private ArrayList<Reservation> reservations;

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
     * Method that gets todays date
     * 
     * @return Date
     * @author Aine
     */
    public Date todaysDate(){
        Date today = Calendar.getInstance().getTime();
        return today;
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
     * Method that finds a booking and all it's reservations based off it's reservation number
     * 
     * @param reservationNumber
     * @return an array of reservations under a booking
     */
    public Reservation[] findBooking(String reservationNumber) {

        ArrayList<Integer> index = new ArrayList<Integer>();
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

        return reservationsFound;
    }
    
    /**
     * Method that writes the reservation onto a csv file from reservations
     * ArrayList
     * 
     * @author Aine
     * @throws java.io.IOException
     */
    
    public void writeFile() throws IOException{
       
        File file = new File("Reservations.csv");
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        
        bw.write("Reservation Number, Reservation Name, Reservation Type,"
                + "Check In, Check Out, Room Type, Room Occupancy, Number of Stars");
        
        bw.newLine();
//        int clearFileYear = todaysDate().getYear() - 7;
//        int clearFileMonth = todaysDate().getMonth();
//        int clearFileDay = todaysDate().getDate();
//        
//        ResDate clearDate = new ResDate(clearFileDay,clearFileMonth,clearFileYear);
//        
        for (Reservation r: reservations){
//            ResDate resDateTest = new ResDate(r.getCheckOut());
//            System.out.println(clearDate);
//            int result = resDateTest.compareTo(clearDate);
//            System.out.println(result);
//                if((r.getCheckOut().getYear()-7) > (clearDate.getYear())){
                        bw.write(r.getReservationNumber() + ",");
                        bw.write(r.getReservationName() + ",");
                        bw.write(r.getRType() + ",");
                        bw.write(r.getCheckIn() + ",");
                        bw.write(r.getCheckOut() + ",");
                        bw.write(r.getRoomType() + ",");
                        bw.write(r.getRoomOccupancy() + ",");
                        bw.write(r.getStar() + ",");
                        bw.newLine();
//                        }
//                else{
//                    bw.write("cancelled");
//                }
                   }
                
            
        bw.close();
        fw.close();
        
    }

}

/**
 * Class to test that the Calender class is working as expected
 *
 * @author Orla
 * @author Aine
 * @version 28/11/2021
 */
class TestCalender {

    public static void main(String[] args) {
        Calender myCalender = new Calender();

        /*
        Test 1: checking to see whether all reservations are added to the calender
         */
        Reservation res1 = new Reservation(5,"2023", "John", new ReservationType("AP"), new ResDate("20/11/2021"),
                new ResDate("23/11/2021"), "Single", 1);
        Reservation res2 = new Reservation(4,"2033", "Mary", new ReservationType("S"), new ResDate("19/11/2021"),
                new ResDate("25/11/2021"), "Double", 2);
        Reservation res3 = new Reservation(5,"2044", "Joe", new ReservationType("S"), new ResDate("18/10/2021"),
                new ResDate("20/10/2021"), "Double", 1);
        Reservation res4 = new Reservation(3,"2023", "John", new ReservationType("S"), new ResDate("21/11/2021"),
                new ResDate("23/11/2021"), "Single", 1);
        Reservation res5 = new Reservation(4,"2023", "John", new ReservationType("S"), new ResDate("22/11/2013"),
                new ResDate("24/11/2013"), "Single", 2);

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
        Reservation[] r = myCalender.findBooking("2023");
        for (int i = 0; i < r.length; i++) {
            System.out.println(r[i]);
        }

        /*
        Test 4 : check to see whether the writeFile method works
        */
        System.out.println();
        System.out.println("Test 4");
        try {
            myCalender.writeFile();
        } catch (IOException e){
            System.err.println("This did not work");
        }
        System.out.println("Test Passed");
    }
}