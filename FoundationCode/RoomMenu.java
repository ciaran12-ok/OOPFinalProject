
/**
 *
 * @author ciaranokeeffe
 * @author Orla
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
                    + "\n1) Make a reservation \n2) View a reservation \n3) "
                    + "Cancel a reservation\n4) Look at data analysis\n0) Exit");
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
                    Reservation[] roomsToBeReserved = new Reservation[numOfRooms];
                    Room[] roomsToBeBooked = new Room[numOfRooms];

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
                        roomsToBeBooked[i] = room;
                        roomsToBeReserved[i] = reservation;

                    }
                    booking.setRoomsToBook(roomsToBeBooked);
                    booking.setRoomsToReserve(roomsToBeReserved);
                    System.out.println("Please enter your name: ");
                    String name = in.next();
                    booking.setReservationName(name);
                    System.out.println("Please select a reservation type: ");
                    System.out.println("Enter AP for Advanced Purchase put info for AP");
                    System.out.println("Enter S for Standard Purchase put info for S");

                    String rTy = in.next();
                    //Checks the user enters the correct reservation type
                    boolean acceptableType = false;

                    while (acceptableType == false) {

                        if (rTy.equals("S") || rTy.equals("s")) {
                            acceptableType = true;
                        } else if (rTy.equals("AP") || rTy.equals("ap")) {
                            acceptableType = true;
                        } else {
                            System.out.println("Please enter a valid reservation type.");
                            rTy = in.next();
                            acceptableType = false;
                        }
                    }
                    ReservationType rType = new ReservationType(rTy);
                    booking.setrType(rType);

                    System.out.println("Please enter your check in date in the format dd/mm/yyyy");
                    String checkIn;
                    ResDate rIn;
                    try {
                        checkIn = in.next();
                        rIn = new ResDate(checkIn);
                        System.out.println("Check in date is: " + checkIn);
                        booking.setCheckIn(rIn);

                    } catch (ArrayIndexOutOfBoundsException ex) {
                        System.out.println("Please enter your check in date in the format dd/mm/yyyy");
                        checkIn = in.next();
                    }

                    System.out.println("Please enter your check out date in the format dd/mm/yyyy");

                    String checkOut;
                    ResDate rOut;
                    try {
                        checkOut = in.next();
                        rOut = new ResDate(checkOut);
                        System.out.println("Check out date is: " + checkOut);
                        booking.setCheckIn(rOut);

                    } catch (ArrayIndexOutOfBoundsException ex) {
                        System.out.println("Please enter your check out date in the format dd/mm/yyyy");
                        checkIn = in.next();
                    }

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
                    booking.getBookingCost(booking.getReservationNumber(), calender);
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
                    //Checks the user enters the correct reservation type
                    boolean acceptableType = false;

                    while (acceptableType == false) {

                        if (rTy.equals("S") || rTy.equals("s")) {
                            acceptableType = true;
                        }
                        if (rTy.equals("AP") || rTy.equals("ap")) {
                            acceptableType = true;
                        } else {
                            System.out.println("Please enter a valid reservation type.");
                            rTy = in.next();
                            acceptableType = false;
                        }
                    }
                    ReservationType rType = new ReservationType(rTy);
                    booking.setrType(rType);

                    System.out.println("Please enter your check in date in the format dd/mm/yyyy");
                    String checkIn;
                    ResDate rIn;
                    try {
                        checkIn = in.next();
                        rIn = new ResDate(checkIn);
                        System.out.println("Check in date is: " + checkIn);
                        booking.setCheckIn(rIn);

                    } catch (ArrayIndexOutOfBoundsException ex) {
                        System.out.println("Please enter your check in date in the format dd/mm/yyyy");
                        checkIn = in.next();
                    }

                    System.out.println("Please enter your check out date in the format dd/mm/yyyy");

                    String checkOut;
                    ResDate rOut;
                    try {
                        checkOut = in.next();
                        rOut = new ResDate(checkOut);
                        System.out.println("Check out date is: " + checkOut);
                        booking.setCheckIn(rOut);

                    } catch (ArrayIndexOutOfBoundsException ex) {
                        System.out.println("Please enter your check out date in the format dd/mm/yyyy");
                        checkIn = in.next();
                    }

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
                    // System.out.println(booking.diplayBooking());
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
                    //Checks the user enters the correct reservation type
                    boolean acceptableType = false;

                    while (acceptableType == false) {

                        if (rTy.equals("S") || rTy.equals("s")) {
                            acceptableType = true;
                        }
                        if (rTy.equals("AP") || rTy.equals("ap")) {
                            acceptableType = true;
                        } else {
                            System.out.println("Please enter a valid reservation type.");
                            rTy = in.next();
                            acceptableType = false;
                        }
                    }
                    ReservationType rType = new ReservationType(rTy);
                    booking.setrType(rType);

                    System.out.println("Please enter your check in date in the format dd/mm/yyyy");
                    String checkIn;
                    ResDate rIn;
                    try {
                        checkIn = in.next();
                        rIn = new ResDate(checkIn);
                        System.out.println("Check in date is: " + checkIn);
                        booking.setCheckIn(rIn);

                    } catch (ArrayIndexOutOfBoundsException ex) {
                        System.out.println("Please enter your check in date in the format dd/mm/yyyy");
                        checkIn = in.next();
                    }

                    System.out.println("Please enter your check out date in the format dd/mm/yyyy");

                    String checkOut;
                    ResDate rOut;
                    try {
                        checkOut = in.next();
                        rOut = new ResDate(checkOut);
                        System.out.println("Check out date is: " + checkOut);
                        booking.setCheckIn(rOut);

                    } catch (ArrayIndexOutOfBoundsException ex) {
                        System.out.println("Please enter your check out date in the format dd/mm/yyyy");
                        checkIn = in.next();
                    }
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

                try {

                    calender.writeFile();
                } catch (IOException ex) {
                    System.err.println("Error writing out calender");
                }

            }
            if (entry1 == 4) {
                DataAnalysis data = new DataAnalysis();
                ReadFile file1 = new ReadFile();
                String[][] reservationInfo = file1.Reservations();

                System.out.println("What would you like to see: ");
                System.out.println("1) Analysis for all Hotels\n2) Analysis"
                        + " for 5-Star Hotel\n3) Analysis for 4-Star Hotel\n4) "
                        + "Analysis for 3-Star Hotel\n5) Show all data gathered\n0) Exit");
                int analysisOption = in.nextInt();
                if (analysisOption == 1) {

                    /*
                         Data Analysis looking at all hotels at the same time
                     */
                    int[] hotelStars = data.countHotelsStars(reservationInfo);

                    System.out.println("Data Analysis for the l4 chain of Hotels: \n");
                    System.out.println("Number of five star hotels booked: " + hotelStars[2]);
                    System.out.println("Number of four star hotels booked: " + hotelStars[1]);
                    System.out.println("Number of three star hotles booked: " + hotelStars[0]);

                    int[] countRType = data.countReservationType(reservationInfo);
                    System.out.println("Number of AP reservations: " + countRType[0]);
                    System.out.println("Number of S reservations: " + countRType[1]);

                    double averageOccupancy = data.averageRoomOccupancy(reservationInfo);
                    System.out.printf("Average room occupancy: %.2f\n", averageOccupancy);

                    double avStay = data.averageStayLength(reservationInfo);
                    System.out.printf("Average stay length: %.1f days\n", avStay);

                    double grossIncome = data.grossIncome(reservationInfo);
                    System.out.printf("Gross Income: $%.2f\n", grossIncome);

                    double avResCost = data.averageReservationCost(reservationInfo);
                    System.out.printf("Average cost of a reservation: $%.2f\n", avResCost);

                }
                if (analysisOption == 2) {
                    /*
            Data Analysis looking at the 5 hotel
                     */
                    System.out.println("");
                    System.out.println("Data Analysis for the 5-Star Hotel: \n");
                    int[] count5RType = data.count5ReservationType(reservationInfo);
                    System.out.println("Number of 5-Star AP reservations: " + count5RType[0]);
                    System.out.println("Number of 5-Star S reservations: " + count5RType[1]);

                    double average5Occupancy = data.average5RoomOccupancy(reservationInfo);
                    System.out.printf("Average 5-Star room occupancy: %.2f\n", average5Occupancy);

                    double av5Stay = data.average5StayLength(reservationInfo);
                    System.out.printf("Average 5-Star stay length: %.1f days\n", av5Stay);

                    String most5PopRoom = data.most5PopularRoom(reservationInfo);
                    System.out.println("Most popular 5-Star Room: " + most5PopRoom);

                    String busiestDayOfWeeek = data.busiestDayOfWeek(reservationInfo);
                    System.out.println("Most popular day of the week for all hotels: " + busiestDayOfWeeek);

                    double gross5Income = data.gross5Income(reservationInfo);
                    System.out.printf("Gross Income for the 5-Star Hotel: $%.2f\n", gross5Income);

                    double av5ResCost = data.average5ReservationCost(reservationInfo);
                    System.out.printf("Average cost of a reservation in a 5-Star Hotel: $%.2f\n", av5ResCost);
                }
                if (analysisOption == 3) {

                    /*
            Data Analysis looking at the 4 star hotel
                     */
                    System.out.println("");
                    System.out.println("Data Analysis for the 4-Star Hotel: \n");
                    int[] count4RType = data.count4ReservationType(reservationInfo);
                    System.out.println("Number of 4-Star AP reservations: " + count4RType[0]);
                    System.out.println("Number of 4-Star S reservations: " + count4RType[1]);

                    double average4Occupancy = data.average4RoomOccupancy(reservationInfo);
                    System.out.printf("Average 4-Star room occupancy: %.2f\n", average4Occupancy);

                    double av4Stay = data.average4StayLength(reservationInfo);
                    System.out.printf("Average 4-Star stay length: %.1f days\n", av4Stay);

                    String most4PopRoom = data.most4PopularRoom(reservationInfo);
                    System.out.println("Most popular 4-Star Room: " + most4PopRoom);

                    double gross4Income = data.gross4Income(reservationInfo);
                    System.out.printf("Gross Income for the 4-Star Hotel: $%.2f\n", gross4Income);

                    double av4ResCost = data.average4ReservationCost(reservationInfo);
                    System.out.printf("Average cost of a reservation in a 4-Star Hotel: $%.2f\n", av4ResCost);
                }
                if (analysisOption == 4) {
                    /*
            Data Analysis looking at the 3 star hotel
                     */
                    System.out.println("");
                    System.out.println("Data Analysis for the 3-Star Hotel: \n");
                    int[] count3RType = data.count3ReservationType(reservationInfo);
                    System.out.println("Number of 3-Star AP reservations: " + count3RType[0]);
                    System.out.println("Number of 3-Star S reservations: " + count3RType[1]);

                    double average3Occupancy = data.average3RoomOccupancy(reservationInfo);
                    System.out.printf("Average 3-Star room occupancy: %.2f\n", average3Occupancy);

                    double av3Stay = data.average3StayLength(reservationInfo);
                    System.out.printf("Average 3-Star stay length: %.1f days\n", av3Stay);

                    String most3PopRoom = data.most3PopularRoom(reservationInfo);
                    System.out.println("Most popular 3-Star Room: " + most3PopRoom);

                    double gross3Income = data.gross3Income(reservationInfo);
                    System.out.printf("Gross Income for the 3-Star Hotel: $%.2f\n", gross3Income);

                    double av3ResCost = data.average3ReservationCost(reservationInfo);
                    System.out.printf("Average cost of a reservation in a 3-Star Hotel: $%.2f\n", av3ResCost);

                }
                if (analysisOption == 5) {


                    /*
            Data Analysis looking at all hotels at the same time
                     */
                    int[] hotelStars = data.countHotelsStars(reservationInfo);

                    System.out.println("Data Analysis for the l4 chain of Hotels: \n");
                    System.out.println("Number of five star hotels booked: " + hotelStars[2]);
                    System.out.println("Number of four star hotels booked: " + hotelStars[1]);
                    System.out.println("Number of three star hotles booked: " + hotelStars[0]);

                    int[] countRType = data.countReservationType(reservationInfo);
                    System.out.println("Number of AP reservations: " + countRType[0]);
                    System.out.println("Number of S reservations: " + countRType[1]);

                    double averageOccupancy = data.averageRoomOccupancy(reservationInfo);
                    System.out.printf("Average room occupancy: %.2f\n", averageOccupancy);

                    double avStay = data.averageStayLength(reservationInfo);
                    System.out.printf("Average stay length: %.1f days\n", avStay);

                    double grossIncome = data.grossIncome(reservationInfo);
                    System.out.printf("Gross Income: $%.2f\n", grossIncome);

                    double avResCost = data.averageReservationCost(reservationInfo);
                    System.out.printf("Average cost of a reservation: $%.2f\n", avResCost);

                    /*
            Data Analysis looking at the 5 hotel
                     */
                    System.out.println("");
                    System.out.println("Data Analysis for the 5-Star Hotel: \n");
                    int[] count5RType = data.count5ReservationType(reservationInfo);
                    System.out.println("Number of 5-Star AP reservations: " + count5RType[0]);
                    System.out.println("Number of 5-Star S reservations: " + count5RType[1]);

                    double average5Occupancy = data.average5RoomOccupancy(reservationInfo);
                    System.out.printf("Average 5-Star room occupancy: %.2f\n", average5Occupancy);

                    double av5Stay = data.average5StayLength(reservationInfo);
                    System.out.printf("Average 5-Star stay length: %.1f days\n", av5Stay);

                    String most5PopRoom = data.most5PopularRoom(reservationInfo);
                    System.out.println("Most popular 5-Star Room: " + most5PopRoom);

                    String busiestDayOfWeeek = data.busiestDayOfWeek(reservationInfo);
                    System.out.println("Most popular day of the week for all hotels: " + busiestDayOfWeeek);

                    double gross5Income = data.gross5Income(reservationInfo);
                    System.out.printf("Gross Income for the 5-Star Hotel: $%.2f\n", gross5Income);

                    double av5ResCost = data.average5ReservationCost(reservationInfo);
                    System.out.printf("Average cost of a reservation in a 5-Star Hotel: $%.2f\n", av5ResCost);

                    /*
            Data Analysis looking at the 4 star hotel
                     */
                    System.out.println("");
                    System.out.println("Data Analysis for the 4-Star Hotel: \n");
                    int[] count4RType = data.count4ReservationType(reservationInfo);
                    System.out.println("Number of 4-Star AP reservations: " + count4RType[0]);
                    System.out.println("Number of 4-Star S reservations: " + count4RType[1]);

                    double average4Occupancy = data.average4RoomOccupancy(reservationInfo);
                    System.out.printf("Average 4-Star room occupancy: %.2f\n", average4Occupancy);

                    double av4Stay = data.average4StayLength(reservationInfo);
                    System.out.printf("Average 4-Star stay length: %.1f days\n", av4Stay);

                    String most4PopRoom = data.most4PopularRoom(reservationInfo);
                    System.out.println("Most popular 4-Star Room: " + most4PopRoom);

                    double gross4Income = data.gross4Income(reservationInfo);
                    System.out.printf("Gross Income for the 4-Star Hotel: $%.2f\n", gross4Income);

                    double av4ResCost = data.average4ReservationCost(reservationInfo);
                    System.out.printf("Average cost of a reservation in a 4-Star Hotel: $%.2f\n", av4ResCost);

                    /*
            Data Analysis looking at the 3 star hotel
                     */
                    System.out.println("");
                    System.out.println("Data Analysis for the 3-Star Hotel: \n");
                    int[] count3RType = data.count3ReservationType(reservationInfo);
                    System.out.println("Number of 3-Star AP reservations: " + count3RType[0]);
                    System.out.println("Number of 3-Star S reservations: " + count3RType[1]);

                    double average3Occupancy = data.average3RoomOccupancy(reservationInfo);
                    System.out.printf("Average 3-Star room occupancy: %.2f\n", average3Occupancy);

                    double av3Stay = data.average3StayLength(reservationInfo);
                    System.out.printf("Average 3-Star stay length: %.1f days\n", av3Stay);

                    String most3PopRoom = data.most3PopularRoom(reservationInfo);
                    System.out.println("Most popular 3-Star Room: " + most3PopRoom);

                    double gross3Income = data.gross3Income(reservationInfo);
                    System.out.printf("Gross Income for the 3-Star Hotel: $%.2f\n", gross3Income);

                    double av3ResCost = data.average3ReservationCost(reservationInfo);
                    System.out.printf("Average cost of a reservation in a 3-Star Hotel: $%.2f\n", av3ResCost);

                }

                if (analysisOption == 0) {
                    System.exit(0);
                }

            }

            if (entry1 == 2) {
                System.out.println("Please enter your reservation number: ");
                String entry2 = in.next();
                //Reservation[] reservationFound = calender.findReservation(entry2);
//                for (int i = 0; i < reservationFound.length; i++) {
//                    //should be displayBooking(reservationFound)
//                    System.out.println(reservationFound[i]);
//                }

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
