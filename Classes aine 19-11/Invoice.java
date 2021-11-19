/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aine
 * 
 */
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;
//class extends reservations class?
public class Invoice extends Reservation {
    private int numberOfRooms;
    private int price;
    private Scanner input;
   // ArrayList<String> writeInvoice = new ArrayList<>();
    
    // something to do with if they have an account/billing?
    
    public Invoice(String reservationNumber,String reservationName,
    ReservationType rType, Date checkIn, Date checkOut, Room room,
    int numberOfRooms,int price){
        super(reservationNumber, reservationName, rType, checkIn,
                checkOut, room);
        this.numberOfRooms = numberOfRooms;
        this.price = price;
}
    
    public int getPrice(int numberOfRooms, int roomPrice){
       // need some method to get room price from csv file
       // get room prices in array or soemthing depending on number
       // of rooms??
       price = numberOfRooms*roomPrice;
       return price;
    }
    
    public void Billing(){
        input = new Scanner(System.in);
        System.out.println("Do you have an existing Account?"
                + "1) Yes 2) No");
        int a = input.nextInt();
        
        switch (a) {
            case 1:
                System.out.println("Amount: " + price + " has been"
                        + " added to your account.");
                break;
            case 2:
                System.out.println("The total price for your "
                        + "stay will be: " + price);
                break;
            default:
                System.out.println("This is invalid. Please try again.");
                // add some kind of loop to make trying again possible
                // maybe in different class?
                break;
        }
    }
    
    @Override
    public String toString(){
        String ss = super.toString();
        return ss + numberOfRooms + price;
    }
    
}
