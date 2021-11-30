
import java.time.LocalDate;
import java.util.Date;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

/**
 * A class that creates a reservation for one room
 *
 * @author Orla
 * @version 13/11/2021
 */
public class Reservation {

    private int star;
    private String reservationNumber;
    private String reservationName;
    private ReservationType rType;
    private ResDate checkIn;
    private ResDate checkOut;
    private String roomType;
    private int roomOccupancy;
    private ArrayList<String> reservation = new ArrayList<>();

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
    public Reservation(int star,String reservationNumber, String reservationName,
            ReservationType rType, ResDate checkIn, ResDate checkOut, String roomType, int roomOccupancy) {
        this.star = star;
        this.reservationNumber = reservationNumber;
        this.reservationName = reservationName;
        this.rType = rType;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.roomType = roomType;
        this.roomOccupancy = roomOccupancy;

    }
    /**
     * Method that sets the number of stars the hotel has
     * @param star 
     */
    public void setStar(int star){
        this.star = star;
    }
    
    /**
     * method that returns the number of stars the hotel has
     * @return int
     */
    public int getStar(){
        return star;
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
     * @param checkOut
     */
    public void setCheckOut(ResDate checkOut) {
        this.checkOut = checkOut;
    }
    /**
     * Method that gets the reservation Type
     * 
     * @return ReservationType
     */
    public ReservationType getRType() {
        return rType;
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
     * Method that will get the cost of booking a room for a number of days
     *
     * NEEDS TO BE FIXED
     *
     * @return cost
     */
    public double getCostReservation(Room room) {

        double cost = 0;

        LocalDate dateIn = checkIn.convertToLocal();
        int dayOfYearIn = dateIn.getDayOfYear();

        LocalDate dateOut = checkOut.convertToLocal();
        int dayOfYearOut = dateOut.getDayOfYear();

        int difference = dayOfYearOut - dayOfYearIn;

        // Creates an array of days that want to be booked    
        for (int i = 0; i < difference; i++) {
            //Increases the day and keeps the months etc valid
            dateIn.plusDays(i);
            ResDate date = new ResDate(dateIn.getYear(), dateIn.getMonthValue(), dateIn.getDayOfMonth());

            int dayOfWeek = date.getDayOfWeek();
            cost += room.getWeeklyRates()[dayOfWeek];

        }

        return cost;
    }

    /**
     * Method that returns a string representation of a reservation
     *
     * @return
     */
    @Override
    public String toString() {
        return "Reservation; " + "reservationNumber:" + reservationNumber + ", "
                + "reservationName:" + reservationName + ", rType:" + rType.toString()
                + ", checkIn:" + checkIn + ", checkOut:" + checkOut + ", roomType:"
                + roomType + ", roomOccupancy:" + roomOccupancy;
    }
    
    

}
