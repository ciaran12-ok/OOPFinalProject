/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nabel Sodipe 
 * 
 */

import java.util.ArrayList;
import java.time.LocalDate;



public class Reservation {
    private String name;
    private int number;
    private LocalDate CheckIn;
    private LocalDate CheckOut;
    private String hotel;
    private String room; 
    private double type;
    
    //constructor 
    public Reservation(String name,int number, LocalDate CheckIn, LocalDate Checkout,
            String Hotel,String room, double type){
        this.name = name;
        this.number = number;
        this.CheckIn = CheckIn;
        this.CheckOut = CheckOut;
        this.hotel = Hotel;
        this.room = room;
        this.type = type;
    }
    
   //get and set methods for all above

    // all information from book room has to be put in csv file...
  public void Reservation(){
       // reservation = new ArrayList<>();
       
    }
     
   // getCost() which gets the total cost of the whole Reservation 
    public void getCost(){
        // Type of Room 
        // Type of Reservation Type
        
    }
   
    
   // bookRoom() book which room is wanted
    public void bookRoom(){
        
    }
   
    //cancel() when someone wantes to cancel method 
    public boolean Cancel(){
        /*
        if(getDayoftheWeek < ReservationDate - 2){
            refund = true 
        }
        else
        return false
      
        */
    }
    
       
   }
   
    //public void add(Reservation a){
       // reservation.add(a);
    //}
    
    

