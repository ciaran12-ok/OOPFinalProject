/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ciaranokeeffe
 */
import java.util.Scanner;

public class Reservation {

    private Scanner in;
    private String hotelType;
    private Room roomChosen;
    private Hotel hotelT;
    private Room tempRoom;
    private PersonalInfo person;
    public PersonalInfo p2;

    public String getHotelType() {
        return hotelType;
    }

    public void setHotelType(String hotelType) {
        this.hotelType = hotelType;
    }

    public Room getRoomChosen() {
        return roomChosen;
    }

    public void setRoomChosen(Room roomChosen) {
        this.roomChosen = roomChosen;
    }

    public Reservation(String hotelType, Room roomChosen) {
        this.hotelType = hotelType;
        this.roomChosen = roomChosen;
    }

    public void setReservation() {

        System.out.println("What star hotel would you like to stay in?\n"
                + "1) 5-STAR  2) 4-STAR 3) 3-STAR");
        int star = in.nextInt() - 1;
        setHotelType(hotelT.hotelType[star]);

        // 5 star tree
        if (getHotelType().equals(hotelT.hotelType[0])) {

            System.out.println("Which room would you like to book?"
                    + "1) Deluxe Double 2) Deluxe Twin 3) Deluxe Single 4) Deluxe Family");
            int command2 = in.nextInt() - 1;
            tempRoom = tempRoom.fiveStarRooms[command2];
            if (person.getOccupancy() > tempRoom.getMax() || person.getOccupancy() < tempRoom.getMin()) {
                System.out.println("Invalid number of people for chosen room"
                        + "\nPlease see the room sheet in the help file");

                // Maybe a method to check this is ok. 
                System.out.println("Please re enter your occupancy for the room");
                person.setOccupancy(in.nextInt());

            } else {

                setRoomChosen(tempRoom);
                // maybe add to an array??
                Reservation r1 = new Reservation(getHotelType(), getRoomChosen());
            }

        }//end of 5 star

        // 4 star tree
        if (getHotelType().equals(hotelT.hotelType[1])) {

            System.out.println("Which room would you like to book?"
                    + "1) Executive Double 2) Executive Twin 3) Executive Single");
            int command2 = in.nextInt() - 1;
            tempRoom = tempRoom.fourStarRooms[command2];
            if (person.getOccupancy() > tempRoom.getMax() || person.getOccupancy() < tempRoom.getMin()) {
                System.out.println("Invalid number of people for chosen room"
                        + "\nPlease see the room sheet in the help file");

                // Maybe a method to check this is ok. 
                System.out.println("Please re enter your occupancy for the room");
                person.setOccupancy(in.nextInt());

            } else {

                setRoomChosen(tempRoom);
                // maybe add to an array??
                Reservation r1 = new Reservation(getHotelType(), getRoomChosen());
            }

        }// end of 4 star  

        //3 star tree
        if (getHotelType().equals(hotelT.hotelType[2])) {

            System.out.println("Which room would you like to book?"
                    + "1)classic Double 2) Classic Twin");
            int command2 = in.nextInt() - 1;
            tempRoom = tempRoom.threeStarRooms[command2];
            if (person.getOccupancy() > tempRoom.getMax() || person.getOccupancy() < tempRoom.getMin()) {
                System.out.println("Invalid number of people for chosen room"
                        + "\nPlease see the room sheet in the help file");

                // Maybe a method to check this is ok. 
                System.out.println("Please re enter your occupancy for the room");
                person.setOccupancy(in.nextInt());

            } else {

                setRoomChosen(tempRoom);
                // maybe add to an array??
                Reservation r1 = new Reservation(getHotelType(), getRoomChosen());
            }

        }//end of 3 star

    }
}
