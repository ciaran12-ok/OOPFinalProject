
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
    private double bookingCost;
    //allows one customer to book several different rooms for different amounts of people
    private Reservation[] roomsToBook;

    public Booking() {

        //Creates a unique reservation number for each booking
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

    public Reservation[] getRoomsToBook() {
        return roomsToBook;
    }

    public void setRoomsToBook(Reservation[] roomsToBook) {
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
     * Books each room in the booking
     *
     * @param calender
     */
    public void bookRooms(Calender calender) {

        for (Reservation r : roomsToBook) {
            String roomType = r.getRoomType();
            int occupancy = r.getRoomOccupancy();
            Reservation res = new Reservation(reservationNumber, reservationName, rType, checkIn, checkOut, roomType, occupancy);
            calender.addToCalender(res);
        }

    }

    /**
     * Gets the total booking cost
     *
     * @param reservationNumber
     * @param c
     * @return
     */
    public double getBookingCost(String reservationNumber, Calender c) {

        double totalCost = 0;
        double discount = rType.getDiscount();
        for (Reservation res : c.getReservations()) {
            if (res.getReservationNumber().equals(reservationNumber)) {
                totalCost += res.getCostReservation();
            }

        }
        bookingCost = totalCost - totalCost * discount;
        return totalCost;
    }

    /**
     * Method that checks whether a booking is refundable Need to fix dates
     *
     * @return
     */
    public double getRefundAmount(Date cancellationDate, Calender calender) {
        double refundAmount = 0;
        if (rType.isRefundableFromType() == true) {
            if (checkIn.getDay() - cancellationDate.getDay() > 2) {
                refundAmount = bookingCost;
            } else {
                refundAmount = 0;
            }
        }
        return refundAmount;
    }

    /**
     * Displays all the details about a booking that a customer would want to
     * know
     *
     * @return
     */
    public String diplayBooking() {
        String booking = "\nReservation name: " + reservationName + "\nReservation type: "
                + "\nCheck in date: " + checkIn + "\nCheck out date: " + checkOut + "\nNumber of rooms booked: "
                + roomsToBook.length;
        String rooms = "";
        for (Reservation r : roomsToBook) {
            String roomType = r.getRoomType();
            int occupancy = r.getRoomOccupancy();
            rooms += "Room type: " + roomType + " Occupancy: " + occupancy;
        }
        String cost = "\nTotal Cost: " + bookingCost;

        return booking + rooms + cost;
    }
}
