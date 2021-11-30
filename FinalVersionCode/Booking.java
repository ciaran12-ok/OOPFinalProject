
import java.util.ArrayList;
import java.util.Random;

/**
 * A class that creates several reservations if a customers wants to book
 * multiple type of rooms
 *
 * @author Orla
 * @version 13/11/2021
 */
public class Booking {

    private String reservationNumber;
    private String reservationName;
    private ReservationType rType;
    private ResDate checkIn;
    private ResDate checkOut;
    private double bookingCost;
    //allows one customer to book several different rooms for different amounts of people
    private Reservation[] roomsToReserve;
    private Room[] roomsToBook;
    private int bookingNo;

    /**
     * No arg constructor that creates a unique reservation number for each
     * booking
     */
    public Booking() {
        bookingNo = 0;

    }

    /**
     * Returns an array of reservations
     *
     * @return
     */
    public Reservation[] getRoomsToReserve() {
        return roomsToReserve;
    }

    /**
     * Sets the rooms to be reserved
     *
     * @param roomsToReserve
     */
    public void setRoomsToReserve(Reservation[] roomsToReserve) {
        this.roomsToReserve = roomsToReserve;
    }

    /**
     * Returns a room array of rooms that are booked for a reservation
     *
     * @return
     */
    public Room[] getRoomsToBook() {
        return roomsToBook;
    }

    /**
     * Sets the room to be booked
     *
     * @param roomsToBook
     */
    public void setRoomsToBook(Room[] roomsToBook) {
        this.roomsToBook = roomsToBook;
    }

    /**
     * Method that returns the room type
     *
     * @return String
     */
    public ReservationType getrType() {
        return rType;
    }

    /**
     * Method that sets the room type
     *
     * @param roomType
     */
    public void setrType(ReservationType rType) {
        this.rType = rType;
    }

    /**
     * Method that makes a new reservation number if the one already created is
     * not unique
     *
     * @return
     */
    public String setNewReservationNumber() {

        bookingNo += 1;
        return String.valueOf(bookingNo);
    }

    /**
     * Returns the reservation number
     *
     * @return
     */
    public String getReservationNumber() {
        reservationNumber = String.valueOf(bookingNo);
        return reservationNumber;

    }

    /**
     * Gets the reservation name
     *
     * @return
     */
    public String getReservationName() {
        return reservationName;
    }

    /**
     * Sets the reservation name
     *
     * @param reservationName
     */
    public void setReservationName(String reservationName) {
        this.reservationName = reservationName;
    }

    /**
     * Gets the check in date
     *
     * @return
     */
    public ResDate getCheckIn() {
        return checkIn;
    }

    /**
     * Sets the check in date
     *
     * @param checkIn
     */
    public void setCheckIn(ResDate checkIn) {
        this.checkIn = checkIn;
    }

    /**
     * Gets the check out date
     *
     * @return
     */
    public ResDate getCheckOut() {
        return checkOut;
    }

    /**
     * Sets the check out date
     *
     * @param checkOut
     */
    public void setCheckOut(ResDate checkOut) {
        this.checkOut = checkOut;
    }

    /**
     * Books each room in the booking
     *
     * @param calender
     */
    public void bookRooms(Calender calender) {

        for (Reservation r : roomsToReserve) {
            String roomType = r.getRoomType();
            int occupancy = r.getRoomOccupancy();
            Reservation res = new Reservation(reservationNumber, reservationName, rType, checkIn, checkOut, roomType, occupancy);
            calender.addToCalender(res);
        }

    }

    /**
     * Gets the total booking cost NEEDS TO BE FIXED
     *
     * @param reservationNumber
     * @param c
     * @return
     */
    public double getBookingCost(String reservationNumber, Calender c) {

        double totalCost = 0;
        double discount = rType.getDiscount();

        Reservation res = c.lookBooking(reservationNumber);

        for (Room room : roomsToBook) {
            totalCost += res.getCostReservation(room);
        }

        bookingCost = totalCost - totalCost * discount;
        return totalCost;
    }

    /**
     * Method that checks whether a booking is refundable Need to fix dates
     *
     * @return
     */
    public double getRefundAmount(ResDate cancellationDate, Calender calender) {
        double refundAmount = 0;
        if (rType.isRefundable() == true) {
            if (checkIn.getDay() - cancellationDate.getDay() > 2) {
                refundAmount = bookingCost;
            } else {
                refundAmount = 0;
            }
        }
        return refundAmount;
    }

    /**
     * Gets the rooms for the room menu
     *
     * @return
     */

    public String getRoomForCom() {

        String rooms = "Rooms: ";
        for (Reservation r : roomsToReserve) {
            String roomType = r.getRoomType();
            int occupancy = r.getRoomOccupancy();
            rooms += "Room type: " + roomType + " Occupancy: " + occupancy;
        }
        String cost = "\nTotal Cost: " + bookingCost;

        return rooms;

    }

    public double getBookingCost() {
        return bookingCost;
    }

    public void setBookingCost(double bookingCost) {
        this.bookingCost = bookingCost;
    }

    public int getBookingNo() {
        return bookingNo;
    }

    public void setBookingNo(int bookingNo) {
        this.bookingNo = bookingNo;
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
                + roomsToReserve.length;
        String rooms = "Rooms: ";
        for (Reservation r : roomsToReserve) {
            String roomType = r.getRoomType();
            int occupancy = r.getRoomOccupancy();
            rooms += "Room type: " + roomType + " Occupancy: " + occupancy;
        }
        String cost = "\nTotal Cost: " + bookingCost;

        return booking + rooms + cost;
    }
}
