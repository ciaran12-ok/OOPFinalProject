
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 * A class that creates several reservations if a customers want to book
 * multiple type of rooms
 *
 * @author Orla
 * @version 13/11/2021
 */
public class Booking {

    private String reservationNumber;
    private String reservationName;
    private ReservationType rType;
    private Date checkIn;
    private Date checkOut;
    private int noOfRooms;
    private Room[] roomsToBook = new Room[noOfRooms];
    //The menu will need to be made so that the information about each room that is
    //wanted will be stored in an array of rooms

    public Booking(String reservationName, ReservationType rType, Date checkIn, Date checkOut, int noOfRooms, Room[] roomsToBook) {
        this.reservationName = reservationName;
        this.rType = rType;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.roomsToBook = roomsToBook;
    }

    public ReservationType getrType() {
        return rType;
    }

    public void setrType(ReservationType rType) {
        this.rType = rType;
    }

    public String getReservationNumber() {
        return reservationNumber;
    }

    /**
     * Creates a unique reservation number for each booking
     *
     * @param reservationNumber
     */
    public void setReservationNumber() {
        boolean unique = false;
        Random rng = new Random();
        int rNumber = 0;
        while (unique = false) {
            rNumber = 100000 + rng.nextInt(1000000);
            //search the arraylist of reservations for the same reseravtion number 
            //if it's not found unique = true

            unique = true;
            reservationNumber = String.valueOf(rNumber);
        }

    }

    public String getReservationName() {
        return reservationName;
    }

    public void setReservationName(String reservationName) {
        this.reservationName = reservationName;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    /**
     * For each room the customer wants to book, create a reservation for that
     * room, and book it
     *
     * @Orla
     */
    public void bookRooms() {
        for (Room r : roomsToBook) {
            Reservation res = new Reservation(reservationNumber, reservationName, rType, checkIn, checkOut, r);
            res.reserveRoom();
        }
    }

    /**
     * Gets the total cost of booking sevearl rooms Shoudl interact with the
     * reservation method getCostReservation()
     *
     * @return
     */
    public double getBookingCost() {
        //for every reservation under the reservationNumber in calendar
        //get the cos
        //add up
    }

    /**
     * Method to cancel a reservation
     *
     * @param cancellationDate
     * @return
     */
    public double cancel(Date cancellationDate) {
        //for each reservation under the reservationNumber in calendar
        //cancel reservation
        //check if refundable
        //return how much refundeed
    }

}
