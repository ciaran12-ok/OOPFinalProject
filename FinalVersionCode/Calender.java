
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * A class to represent a Calender that holds reservations
 *
 * @author Nabel Sodipe
 * @date 13/11/2021
 */
public class Calender {

    private static ArrayList<Reservation> reservations;

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
     * Method that returns the number of reservations on a particular date
     * @param day
     * @return int
     */
    public int reservationsOnDayForRoomType(ResDate day, Room room) {
        int countRes = 0;
        for (Reservation res : reservations) {
            if (res.equals(res.getCheckIn())) {
                if(res.getRoomType().equals(room.getType())){
                countRes++;
                }
            }
        }
        return countRes;
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

    /**
     * Method that writes the reservation onto a csv file from reservations
     * ArrayList
     *
     * @author Aine
     * @throws java.io.IOException
     */
    public void writeFile() throws IOException {

        File file = new File("Reservations.csv");
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write("Hotel Stars,Reservation Number, Reservation Name, Reservation Type,"
                + "Check In, Check Out, Room Type, Room Occupancy, Reservation Cost");

        bw.newLine();

        for (Reservation r : reservations) {
            //bw.write(r.getStar() + ",");
            bw.write("5" + ",");
            bw.write(r.getReservationNumber() + ",");
            bw.write(r.getReservationName() + ",");
            bw.write(r.getRType() + ",");
            bw.write(r.getCheckIn() + ",");
            bw.write(r.getCheckOut() + ",");
            bw.write(r.getRoomType() + ",");
            bw.write(r.getRoomOccupancy() + ",");
            // bw.write(r.getCostOfReservation());
            bw.write("100" + ",");
            bw.newLine();
        }
        bw.close();
        fw.close();

    }

}

