/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ciaranokeeffe
 */
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Res2 {

    String name;
    int resNum;
    boolean resType;
    Date checkIn;
    Date checkOut;
    int numOfRooms;
    String roomType;
    int occupancy;
    double price;
    private Scanner in;

    private Room room;
    private Hotel hotel;
    private int hotelChoice;

    public Res2(String name, int resNum, boolean resType, Date checkIn, Date checkOut, int numOfRooms, String roomType, int occupancy, double price) {
        this.name = name;
        this.resNum = resNum;
        this.resType = resType;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.numOfRooms = numOfRooms;
        this.roomType = roomType;
        this.occupancy = occupancy;
        this.price = price;
    }

    public Res2() {

        in = new Scanner(System.in);
    }

    public void run() {

        boolean more = true;

        while (more) {

            System.out.println("Welcome to the reservation system.\n"
                    + "What type of Hotel would you like to stay in?\n"
                    + "A) 5-STAR  B) 4-STAR C) 3-STAR");
            String command1 = in.nextLine().toUpperCase();

            // 5-Star Hotel Choice tree
            if (command1.equals("A")) {
                System.out.println("What Hotel would you like to stay in?"
                        + "1) Balyfin House 2) Plaza Hotel 3) Quay Hotel");
                hotelChoice = in.nextInt() - 1;
                hotel.setName(hotel.fiveStar[hotelChoice]);

                if (command1.equals("A")) {
                    System.out.println("Which room would you like to book?"
                            + "1) Deluxe Double 2) Deluxe Twin 3) Deluxe Single 4) Deluxe Family");
                    int command2 = in.nextInt() - 1;
                    Room chosenRoom = room.fiveStarRooms[command2];
                    room.setType(chosenRoom.getType());

                    System.out.println("Amount of rooms available is" + chosenRoom.getNoOfRooms());
                    System.out.println("How many rooms would you like to book?");

                    numOfRooms = in.nextInt();
                    if (numOfRooms - chosenRoom.getNoOfRooms() < 0) {
                        System.out.println("Invalid number, try again");
                    }
                    if (numOfRooms > chosenRoom.getNoOfRooms()) {
                        System.out.println("Not enough rooms available");

                    } else {
                        chosenRoom.setNoOfRooms(chosenRoom.getNoOfRooms() - numOfRooms);
                    }
                }
            }

            // 4-Star Hotel Choice Tree
            if (command1.equals("B")) {
                System.out.println("What Hotel would you like to stay in?"
                        + "1)Ashdown Hotel  2)Amber Springs Hotel 3) Riverside Hotel");
                hotelChoice = in.nextInt() - 1;
                hotel.setName(hotel.fourStar[hotelChoice]);

                if (command1.equals("A")) {
                    System.out.println("Which room would you like to book?"
                            + "1) Executive Double 2) Executive Twin 3) Executive Single");
                    int command2 = in.nextInt() - 1;
                    Room chosenRoom = room.fourStarRooms[command2];
                    room.setType(chosenRoom.getType());

                    System.out.println("Amount of rooms available is" + chosenRoom.getNoOfRooms());
                    System.out.println("How many rooms would you like to book?");

                    numOfRooms = in.nextInt();
                    if (numOfRooms - chosenRoom.getNoOfRooms() < 0) {
                        System.out.println("Invalid number, try again");
                    }
                    if (numOfRooms > chosenRoom.getNoOfRooms()) {
                        System.out.println("Not enough rooms available");

                    } else {
                        chosenRoom.setNoOfRooms(chosenRoom.getNoOfRooms() - numOfRooms);
                    }
                }
            }
            if (command1.equals("C")) {
                System.out.println("What Hotel would you like to stay in?"
                        + "1) WoodenBridge Hotel, 2) Doonmore Hotel 3) Murphy's Hotel");
                hotelChoice = in.nextInt() - 1;
                hotel.setName(hotel.fourStar[hotelChoice]);

                if (command1.equals("A")) {
                    System.out.println("Which room would you like to book?"
                            + "1) Executive Double 2) Executive Twin 3) Executive Single");
                    int command2 = in.nextInt() - 1;
                    Room chosenRoom = room.fourStarRooms[command2];
                    room.setType(chosenRoom.getType());

                    System.out.println("Amount of rooms available is" + chosenRoom.getNoOfRooms());
                    System.out.println("How many rooms would you like to book?");

                    numOfRooms = in.nextInt();
                    if (numOfRooms - chosenRoom.getNoOfRooms() < 0) {
                        System.out.println("Invalid number, try again");
                    }
                    if (numOfRooms > chosenRoom.getNoOfRooms()) {
                        System.out.println("Not enough rooms available");

                    } else {
                        chosenRoom.setNoOfRooms(chosenRoom.getNoOfRooms() - numOfRooms);
                    }
                }
            }
            
            
            
            // Time to get details of person now    
            
            System.out.println("Please enter your Name\n");
            name = in.nextLine();
            System.out.println("Your reservation number is: \n");
            resNum += 1;
            
            
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResNum() {
        return resNum;
    }

    public void setResNum(int resNum) {
        this.resNum = resNum;
    }

    public boolean isResType() {
        return resType;
    }

    public void setResType(boolean resType) {
        this.resType = resType;
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

    public int getNumOfRooms() {
        return numOfRooms;
    }

    public void setNumOfRooms(int numOfRooms) {
        this.numOfRooms = numOfRooms;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getOccupancy() {
        return occupancy;
    }

    public void setOccupancy(int occupancy) {
        this.occupancy = occupancy;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Scanner getIn() {
        return in;
    }

    public void setIn(Scanner in) {
        this.in = in;
    }
}
