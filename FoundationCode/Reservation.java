
import java.time.LocalDate;
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
    private ResDate checkIn;
    private ResDate checkOut;
    private String roomType;
    private int roomOccupancy;

    /**
     * No arg constructor
     */
    public Reservation() {

    }

    /**
     * Full constructor that allows a user to set all values of a reservation
     *
     * @param reservationNumber
     * @param reservationName
     * @param rType
     * @param checkIn
     * @param checkOut
     * @param roomType
     * @param roomOccupancy
     */
    public Reservation(String reservationNumber, String reservationName,
            ReservationType rType, ResDate checkIn, ResDate checkOut, String roomType, int roomOccupancy) {
        this.reservationNumber = reservationNumber;
        this.reservationName = reservationName;
        this.rType = rType;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.roomType = roomType;
        this.roomOccupancy = roomOccupancy;

    }

    /**
     * Method that returns the room type
     *
     * @return String
     */
    public String getRoomType() {
        return roomType;
    }

    /**
     * Method that sets the room type
     *
     * @param roomType
     */
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    /**
     * Method that gets the room occupancy
     *
     * @return
     */
    public int getRoomOccupancy() {
        return roomOccupancy;
    }

    /**
     * Method that sets the room occupancy
     *
     * @param roomOccupancy
     */
    public void setRoomOccupancy(int roomOccupancy) {
        this.roomOccupancy = roomOccupancy;
    }

    /**
     * Method that gets the reservation number
     *
     * @return String
     */
    public String getReservationNumber() {
        return reservationNumber;
    }

    /**
     * Method that gets the reservation name
     *
     * @return String
     */
    public String getReservationName() {
        return reservationName;
    }

    /**
     * Method that sets the reservation name
     *
     * @param reservationName
     */
    public void setReservationName(String reservationName) {
        this.reservationName = reservationName;
    }

    /**
     * Method that gets the check in date
     *
     * @return ResDate
     */
    public ResDate getCheckIn() {
        return checkIn;
    }

    /**
     * Method that sets the check in date
     *
     * @param checkIn
     */
    public void setCheckIn(ResDate checkIn) {
        this.checkIn = checkIn;
    }

    /**
     * Method that gets the check out date
     *
     * @return ResDate
     */
    public ResDate getCheckOut() {
        return checkOut;
    }

    /**
     * Method that sets the check out date
     *
     * @param checkIn
     */
    public void setCheckOut(ResDate checkOut) {
        this.checkOut = checkOut;
    }

    /**
     * Overrides the object equals method Checks whether two reservations have
     * the same reservation number Allows you to check if a room reservation is
     * under the same booking
     *
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
     * Method that will get the cost of booking a room for a number of days Need
     * to change to a different date class
     *
     * NEEDS TO BE FIXED
     *
     * @return cost
     */
    public double getCostReservation() {

        double cost = 0;

        int inDay = checkIn.getDay();
        int inMonth = checkIn.getMonth();
        int inYear = checkIn.getYear();
        LocalDate dateIn = LocalDate.of(inYear, inMonth, inDay);
        int dayOfYearIn = dateIn.getDayOfYear();

        int outDay = checkOut.getDay();
        int outMonth = checkOut.getMonth();
        int outYear = checkOut.getYear();
        LocalDate dateOut = LocalDate.of(outYear, outMonth, outDay);
        int dayOfYearOut = dateOut.getDayOfYear();

        int difference = dayOfYearOut - dayOfYearIn;
        ResDate[] daysBooked = new ResDate[difference];
        
        // Creates an array of days that want to be booked
        for (int i = 0; i < difference; i++) {
           
            ResDate d = new ResDate(inDay + i,inMonth,inYear );
            int dayOfWeek = d.getDayOfWeek();
            //get the cost of that day 
            // cost += ''
        }
        
        
        return cost;
    }

    @Override
    public String toString() {
        return "Reservation; " + "reservationNumber:" + reservationNumber + ", "
                + "reservationName:" + reservationName + ", rType:" + rType.toString()
                + ", checkIn:" + checkIn + ", checkOut:" + checkOut + ", roomType:"
                + roomType + ", roomOccupancy:" + roomOccupancy;
    }

}
