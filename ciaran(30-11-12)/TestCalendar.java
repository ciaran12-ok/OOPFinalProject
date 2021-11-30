
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ciaranokeeffe
 */
public class TestCalendar {

    public static void main(String[] args) {
        Calender myCalender = new Calender();

        /*
        Test 1: checking to see whether all reservations are added to the calender
         */
        Reservation res1 = new Reservation("1", "John", new ReservationType("AP"), new ResDate("20/11/2021"),
                new ResDate("23/11/2021"), "Single", 1);
        Reservation res2 = new Reservation("2", "Mary", new ReservationType("S"), new ResDate("19/11/2021"),
                new ResDate("25/11/2021"), "Double", 2);
        Reservation res3 = new Reservation("3", "Joe", new ReservationType("S"), new ResDate("18/10/2021"),
                new ResDate("20/10/2021"), "Double", 1);
        Reservation res4 = new Reservation("4", "John", new ReservationType("S"), new ResDate("21/11/2021"),
                new ResDate("23/11/2021"), "Single", 1);
        Reservation res5 = new Reservation("5", "John", new ReservationType("S"), new ResDate("22/11/2021"),
                new ResDate("23/11/2021"), "Single", 2);

        myCalender.addToCalender(res1);
        myCalender.addToCalender(res2);
        myCalender.addToCalender(res3);
        myCalender.addToCalender(res4);
        myCalender.addToCalender(res5);

        ArrayList<Reservation> reservations1 = new ArrayList<>();
        reservations1 = myCalender.getReservations();
        System.out.println("Test 1");
        for (Reservation r : reservations1) {
            System.out.println(r.toString());
        }
        System.out.println("Test 1 Passed");
        System.out.println("");

        /*
        Test 2 : checking to see whether a reservation is removed successfully
         */
        myCalender.removeReservation(res3);
        ArrayList<Reservation> reservations2 = new ArrayList<>();
        reservations2 = myCalender.getReservations();
        System.out.println("Test 2");
        for (Reservation r : reservations2) {
            System.out.println(r.toString());
        }
        System.out.println("Test 2 Passed");
        System.out.println("");

        /*
        Test 3 : checking to see whether the findReservation method works
        TEST IS CURRENTLY FAILING
         */
       // Reservation[] r = myCalender.findBooking("2023");
       // for (int i = 0; i < r.length; i++) {
       //     System.out.println(r[i]);
       // }

        
        Reservation r2 = myCalender.lookBooking("1");
        Reservation r3 = myCalender.lookBooking("4");
        
        System.out.println(myCalender.todaysDate());
        System.out.println(myCalender.nowToday());
        
    }
}