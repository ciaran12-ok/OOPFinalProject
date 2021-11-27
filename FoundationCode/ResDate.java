/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Nabel Sodipe
 * @date 26/11/2021
 */
    public class ResDate
{  
   private int year;
   private int month;
   private int day;

   public ResDate(String s){
    String[] input = s.split("/");
    
    day   = Integer.parseInt(input[0]);
    
    month = Integer.parseInt(input[1]);
    
    year  = Integer.parseInt(input[2]);
    }
   
    public boolean equals(Object o){
        if(o == null|| ! (o instanceof ResDate))
        return false;
        ResDate app = (ResDate) o;
        return(app.year == year && app.month == month && app.day == day);
        
    }
   
    public String toString(){
        return day + "/" + month + "/" + year;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
   
}

