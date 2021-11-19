
import java.util.Date;

/**
 * A class that creates a reservation for one room
 *
 * @author Orla
 * @version 13/11/2021
 */
public class Reservation {

    private String reservationNumber;
    private String reservationName;
    private ReservationType rType;
    private Date checkIn;
    private Date checkOut;
    private String roomType;
    private int roomOccupancy;

    public Reservation() {

    }

    public Reservation(String reservationNumber, String reservationName,
            ReservationType rType, Date checkIn, Date checkOut, String roomType, int roomOccupancy) {
        this.reservationNumber = reservationNumber;
        this.reservationName = reservationName;
        this.rType = rType;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.roomType = roomType;
        this.roomOccupancy = roomOccupancy;

    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getRoomOccupancy() {
        return roomOccupancy;
    }

    public void setRoomOccupancy(int roomOccupancy) {
        this.roomOccupancy = roomOccupancy;
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

    /**
     * Overrides the object equals method
     * Checks whether two reservations have the same reservation number
     * Allows you to check if a room reservation is under the same booking
     * @param o
     * @return true or false
     */
    @Override
    public boolean equals(Object o) {
        boolean equals = false;
        if (o instanceof Reservation) {
            if (o != null) {
                String bookingNum1 = this.reservationNumber;
                String bookingNum2 = ((Reservation) o).getReservationNumber();
                if (bookingNum1.equals(bookingNum2)) {
                    equals = true;
                }
            }
        }
        return equals;
    }
   
        

    /**
     * Method that will get the cost of booking a room for a number of days
     * Need to change to a different date class
     *
     * @return cost
     */
    public double getCostReservation() {
        
        
        //for checkindate to checkoutdate   
       // find out what days of the week are being booked
        //get the price of the room on those days and add up
        
        double cost = 0;
        //must change to whatever type of date we are using
        //thi method is deprecated
        Date in = checkIn;
        Date out = checkOut;
        int inDay = checkIn.getDay();
        int outDay = checkOut.getDay();
        int diff = outDay - inDay;
        String[] daysBooked = new String[diff];

       // Creates an array of days that want to be booked
        for (int i = 0; i < diff; i++) {
            in.setDate(inDay + i);
            daysBooked[i] = in.getDayOfWeek();
        }
        return cost;
       }
   
}
