
import java.util.Date;

/**
 * A class that creates a reservation for one room
 *
 * @author Orla
 * @version 13/11/2021
 */

//ADDED TOSTRING METHOD FOR INVOICE CLASS AND CSV FILE
// line 73 to 77

public class Reservation {

    private String reservationNumber;
    private String reservationName;
    private ReservationType rType;
    private Date checkIn;
    private Date checkOut;
    private Room room;

    public Reservation(String reservationNumber, String reservationName,
            ReservationType rType, Date checkIn, Date checkOut, Room room) {
        this.reservationNumber = reservationNumber;
        this.reservationName = reservationName;
        this.rType = rType;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.room = room;
    }

    public String getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(String reservationNumber) {
        this.reservationNumber = reservationNumber;
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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
    
    @Override
    public String toString(){
        return reservationNumber + reservationName + rType +
                checkIn + checkOut + room;
    }

    /**
     * Method that will return true if a room is successfully booked
     *
     * @return true/false
     */
    public boolean reserveRoom() {
        //check available
        //if available is true
        //add the reservation to the calender/ arraylist of reservations
        //add the reservation to the csv files
    }

    /**
     * Method that will get the cost of booking a room for a number of days
     *
     * @return cost
     */
    public double getCostReservation() {
        
        
        //for checkindate to checkoutdate   
        //find out what days of the week are being booked
        //get the price of the room on those days and add up
        
        double cost;
        //must change to whatever type of date we are using
        //thi method is deprecated
        Date in = checkIn;
        Date out = checkOut;
        int inDay = checkIn.getDay();
        int outDay = checkOut.getDay();
        int diff = outDay - inDay;
        String[] daysBooked = new String[diff];

        //Creates an array of days that want to be booked
        for (int i = 0; i < diff; i++) {
            in.setDate(inDay + i);
            daysBooked[i] = in.getDayOfWeek();
        }

    }

}
