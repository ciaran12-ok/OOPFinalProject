/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ciaranokeeffe
 */


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.util.Scanner;

public class PersonalInfo {
    
    private String name;
    private int occupancy;
    private Scanner info;
    public Date inDate;
    public Date outDate;

    public PersonalInfo() {
    }

    public PersonalInfo(String name, int occupancy, Date inDate, Date outDate) {
        this.name = name;
        this.occupancy = occupancy;
        this.inDate = inDate;
        this.outDate = outDate;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }
    
    
    
    
    // Ok need name, occupancy, check in date, check out, 

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOccupancy() {
        return occupancy;
    }

    public void setOccupancy(int occupancy) {
        this.occupancy = occupancy;
    }
    
    public void getPersonalInfo() throws ParseException{
    
        System.out.println("Please enter your full name/n");
        setName(info.nextLine());
        System.out.println("Welcome "+ getName()+ " Please enter the amount of"
                + "people you would like to stay in one room\n"
                + "If you are looking for multiple\n rooms, this system works by "
                + "booking one room at a time.");
        setOccupancy(info.nextInt());
        
        
        
        
    
    }
    
    public void setInandOut() throws ParseException{
    
    System.out.println("Please enter the date of your desired date in dd-mm-yyyy");
        String date = info.nextLine();
        Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(date);
        if (date1.before(LocalDate.now()))
    }

   
}

