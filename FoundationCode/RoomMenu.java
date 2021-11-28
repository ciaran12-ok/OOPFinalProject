
/**
 *
 * @author ciaranokeeffe
 * @author Orla
 */
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class RoomMenu {

    private Scanner in;

    public RoomMenu() {
        in = new Scanner(System.in);
    }

    public void run() throws FileNotFoundException {
        Calender calender = new Calender();
        ReadFile file = new ReadFile();
        String[][] input = file.readCsvFile();
        CreateHotels newHotel = new CreateHotels(input);

        Hotel hotel5 = newHotel.getHotel5();
        Hotel hotel4 = newHotel.getHotel4();
        Hotel hotel3 = newHotel.getHotel3();

        boolean more = true;

        while (more) {
            System.out.println("Welcome our Hotel system. \nWhat would you like to do today?"
                    + "\n1) Make a reservation \n2) View a reservation \n3) Cancel a reservation\n0) Exit");
            int entry1 = in.nextInt();
            if (entry1 == 1) {
                Booking booking = new Booking();

                System.out.println("Welcome to the reservation system.\n"
                        + "What type of Hotel would you like to stay in?\n"
                        + "1) 5-STAR  2) 4-STAR 3) 3-STAR 0) Exit");
                int command1 = in.nextInt();

                // 5-Star Hotel Choice tree
                if (command1 == 1) {

                    System.out.println("How many rooms would you like to book:");
                    int numOfRooms = in.nextInt();
                    Reservation[] roomsToBeBooked = new Reservation[numOfRooms];

                    //Takes in each room that they want to book and it's details
                    //Adds it to a roomsToBeBooked array
                    //The booking can now be created
                    for (int i = 0; i < numOfRooms; i++) {
                        System.out.println(" ");
                        System.out.println("Room number:" + (i + 1));
                        //Create an array of rooms to be booked
                        //setRooms to be booked with that arrya
                        Reservation reservation = new Reservation();

                        System.out.println("What type of room would you like to book:");
                        String[] rooms = hotel5.getRoomOptions();
                        for (String r : rooms) {
                            System.out.println(r);
                        }
                        int roomIndex = in.nextInt();
                        Room[] roomArray = hotel5.getRoomsAvailable();

                        Room room = roomArray[roomIndex];
                        String roomType = room.getType();
                        reservation.setRoomType(roomType);

                        System.out.println("For how many people: ");
                        int occupancy = in.nextInt();
                        while (occupancy > room.getMax()) {
                            System.out.println("Maximum occupancy is: " + room.getMax());
                            System.out.println("Please enter a valid occupancy:");
                            occupancy = in.nextInt();
                        }
                        reservation.setRoomOccupancy(occupancy);

                        roomsToBeBooked[i] = reservation;

                    }
                    booking.setRoomsToBook(roomsToBeBooked);
                    System.out.println("Please enter your name: ");
                    String name = in.next();
                    booking.setReservationName(name);
                    System.out.println("Please select a reservation type: ");
                    System.out.println("Enter AP for Advanced Purchase put info for AP");
                    System.out.println("Enter S for Standard Purchase put info for S");
                    String rTy = in.next();
                    ReservationType rType = new ReservationType(rTy);
                    booking.setrType(rType);

                    System.out.println("Please enter your check in date in the format dd/mm/yyyy");
                    String checkIn = in.next();
                    ResDate rIn = new ResDate(checkIn);
                    LocalDate localRin = LocalDate.of(rIn.getYear(), rIn.getMonth(), rIn.getDay());
                    System.out.println("Check in date is: " + checkIn);
                    booking.setCheckIn(rIn);

                    System.out.println("Please enter your check out date in the format of dd/mm/yyyy");
                    String checkOut = in.next();
                    ResDate rOut = new ResDate(checkOut);
                    LocalDate localROut = LocalDate.of(rOut.getYear(), rOut.getMonth(), rOut.getDay());
                    System.out.println("Check out is: " + checkOut);
                    booking.setCheckOut(rIn);

                    //Check if the booking number is unique before confirmation
                    //And change it if it's not
                    String bookingNum = booking.getReservationNumber();
                    boolean unique = false;
                    while (unique = false) {
                        ArrayList<String> bookingNumbers = calender.getReservationNumbers();
                        for (String num : bookingNumbers) {
                            if (num.equals(bookingNum)) {
                                unique = false;

                            } else {
                                unique = true;
                            }
                        }
                        booking.setNewReservationNumber();
                    }

                    System.out.println("Your booking information: ");
                    System.out.println(booking.diplayBooking());
                    System.out.println("1) Confirm \n2) Cancel");
                    int confirm = in.nextInt();
                    if (confirm == 1) {
                        booking.bookRooms(calender);
                        //add to the csv files for reservations
                        //show booking number and ask them tp save it for proof
                        System.out.println("Thank you for choosing to stay with us.\n"
                                + "Your booking number is: " + booking.getReservationNumber());
                        System.out.println("Please keep this number as proof of purchase");
                    } else if (confirm == 2) {
                        System.out.println("You have cancelled your booking");
                        more = false;
                    }

                }
                //4 Star hotel tree
                if (command1 == 2) {

                    System.out.println("How many rooms would you like to book:");
                    int numOfRooms = in.nextInt();
                    Reservation[] roomsToBeBooked = new Reservation[numOfRooms];

                    //Takes in each room that they want to book and it's details
                    //Adds it to a roomsToBeBooked array
                    //The booking can now be created
                    for (int i = 0; i < numOfRooms; i++) {
                        System.out.println(" ");
                        System.out.println("Room number:" + (i + 1));
                        //Create an array of rooms to be booked
                        //setRooms to be booked with that arrya
                        Reservation reservation = new Reservation();

                        System.out.println("What type of room would you like to book:");
                        String[] rooms = hotel4.getRoomOptions();
                        for (String r : rooms) {
                            System.out.println(r);
                        }
                        int roomIndex = in.nextInt();
                        Room[] roomArray = hotel4.getRoomsAvailable();
                        //Problem
                        Room room = roomArray[roomIndex];
                        String roomType = room.getType();
                        reservation.setRoomType(roomType);

                        System.out.println("For how many people: ");
                        int occupancy = in.nextInt();
                        while (occupancy > room.getMax()) {
                            System.out.println("Maximum occupancy is: " + room.getMax());
                            System.out.println("Please enter a valid occupancy:");
                            occupancy = in.nextInt();
                        }
                        reservation.setRoomOccupancy(occupancy);

                        roomsToBeBooked[i] = reservation;

                    }
                    System.out.println("Please enter your name: ");
                    String name = in.next();
                    booking.setReservationName(name);
                    System.out.println("Please select a reservation type: ");
                    System.out.println("Enter AP for Advanced Purchase put info for AP");
                    System.out.println("Enter S for Standard Purchase put info for S");
                    String rTy = in.next();
                    ReservationType rType = new ReservationType(rTy);
                    booking.setrType(rType);

                    System.out.println("Please enter your check in date in the format dd/mm/yyyy");
                    String checkIn = in.next();
                    ResDate rIn = new ResDate(checkIn);
                    LocalDate localRin = LocalDate.of(rIn.getYear(), rIn.getMonth(), rIn.getDay());
                    System.out.println("Check in date is: " + checkIn);
                    booking.setCheckIn(rIn);

                    System.out.println("Please enter your check out date in the format of dd/mm/yyyy");
                    String checkOut = in.next();
                    ResDate rOut = new ResDate(checkOut);
                    LocalDate localROut = LocalDate.of(rOut.getYear(), rOut.getMonth(), rOut.getDay());
                    System.out.println("Check out is: " + checkOut);
                    booking.setCheckOut(rIn);

                    //Check if the booking number is unique before confirmation
                    //And change it if it's not
                    String bookingNum = booking.getReservationNumber();
                    boolean unique = false;
                    while (unique = false) {
                        ArrayList<String> bookingNumbers = calender.getReservationNumbers();
                        for (String num : bookingNumbers) {
                            if (num.equals(bookingNum)) {
                                unique = false;

                            } else {
                                unique = true;
                            }
                        }
                        booking.setNewReservationNumber();
                    }

                    System.out.println("Your booking information: ");
                    System.out.println(booking.diplayBooking());
                    System.out.println("1) Confirm \n2) Cancel");
                    int confirm = in.nextInt();
                    if (confirm == 1) {
                        booking.bookRooms(calender);
                        //add to the csv files for reservations
                        //show booking number and ask them tp save it for proof
                        System.out.println("Thank you for choosing to stay with us.\n"
                                + "Your booking number is: " + booking.getReservationNumber());
                        System.out.println("Please keep this number as proof of purchase");
                    } else if (confirm == 2) {
                        System.out.println("You have cancelled your booking");
                        more = false;
                    }

                }
                //3 Star Hotel Tree
                if (command1 == 3) {

                    System.out.println("How many rooms would you like to book:");
                    int numOfRooms = in.nextInt();
                    Reservation[] roomsToBeBooked = new Reservation[numOfRooms];

                    //Takes in each room that they want to book and it's details
                    //Adds it to a roomsToBeBooked array
                    //The booking can now be created
                    for (int i = 0; i < numOfRooms; i++) {
                        System.out.println(" ");
                        System.out.println("Room number:" + (i + 1));
                        //Create an array of rooms to be booked
                        //setRooms to be booked with that arrya
                        Reservation reservation = new Reservation();

                        System.out.println("What type of room would you like to book:");
                        String[] rooms = hotel3.getRoomOptions();
                        for (String r : rooms) {
                            System.out.println(r);
                        }
                        int roomIndex = in.nextInt();
                        Room[] roomArray = hotel3.getRoomsAvailable();
                        //Problem
                        Room room = roomArray[roomIndex];
                        String roomType = room.getType();
                        reservation.setRoomType(roomType);

                        System.out.println("For how many people: ");
                        int occupancy = in.nextInt();
                        while (occupancy > room.getMax()) {
                            System.out.println("Maximum occupancy is: " + room.getMax());
                            System.out.println("Please enter a valid occupancy:");
                            occupancy = in.nextInt();
                        }
                        reservation.setRoomOccupancy(occupancy);

                        roomsToBeBooked[i] = reservation;

                    }
                    System.out.println("Please enter your name: ");
                    String name = in.next();
                    booking.setReservationName(name);
                    System.out.println("Please select a reservation type: ");
                    System.out.println("Enter AP for Advanced Purchase put info for AP");
                    System.out.println("Enter S for Standard Purchase put info for S");
                    String rTy = in.next();
                    ReservationType rType = new ReservationType(rTy);
                    booking.setrType(rType);

                    System.out.println("Please enter your check in date in the format dd/mm/yyyy");
                    String checkIn = in.next();
                    ResDate rIn = new ResDate(checkIn);
                    LocalDate localRin = LocalDate.of(rIn.getYear(), rIn.getMonth(), rIn.getDay());
                    System.out.println("Check in date is: " + checkIn);
                    booking.setCheckIn(rIn);

                    System.out.println("Please enter your check out date in the format of dd/mm/yyyy");
                    String checkOut = in.next();
                    ResDate rOut = new ResDate(checkOut);
                    LocalDate localROut = LocalDate.of(rOut.getYear(), rOut.getMonth(), rOut.getDay());
                    System.out.println("Check out is: " + checkOut);
                    booking.setCheckOut(rIn);

                    //Check if the booking number is unique before confirmation
                    //And change it if it's not
                    String bookingNum = booking.getReservationNumber();
                    boolean unique = false;
                    while (unique = false) {
                        ArrayList<String> bookingNumbers = calender.getReservationNumbers();
                        for (String num : bookingNumbers) {
                            if (num.equals(bookingNum)) {
                                unique = false;

                            } else {
                                unique = true;
                            }
                        }
                        booking.setNewReservationNumber();
                    }

                    System.out.println("Your booking information: ");
                    System.out.println(booking.diplayBooking());
                    System.out.println("1) Confirm \n2) Cancel");
                    int confirm = in.nextInt();
                    if (confirm == 1) {
                        booking.bookRooms(calender);
                        //add to the csv files for reservations
                        //show booking number and ask them tp save it for proof
                        System.out.println("Thank you for choosing to stay with us.\n"
                                + "Your booking number is: " + booking.getReservationNumber());
                        System.out.println("Please keep this number as proof of purchase");
                    } else if (confirm == 2) {
                        System.out.println("You have cancelled your booking");
                        more = false;
                    }

                }
                if (command1 == 0) {
                    System.exit(0);
                }

            }
            if (entry1 == 2) {
                System.out.println("Please enter your reservation number: ");
                String entry2 = in.next();
                Reservation[] reservationFound = calender.findReservation(entry2);
                for (int i = 0; i < reservationFound.length; i++) {
                    //should be displayBooking(reservationFound)
                    System.out.println(reservationFound[i]);
                }

            }
            if (entry1 == 3) {
                System.out.println("Please enter today's date:");
                String entry3 = in.next();
                System.out.println("Please enter your reservation number: ");
                String entry4 = in.next();

                //Look for their reservation in the reservation caledndar
                //cancel it
            }
            if (entry1 == 0) {
                System.exit(0);
            }
        }
    }

}
