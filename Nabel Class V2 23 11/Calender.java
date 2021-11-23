

/**
 *
 * @author Nabel Sodipe 
 * @date 13/11/2021
 */
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;

public class Calender {
    private Date Date1;
    private Date Date2;
    private ArrayList<Reservation> reservations;
    
    
    //creating an arraylist for reservations 
    public void Calander(){
        reservations = new ArrayList<>();
    } 
    
    //adds a reservation from calander        
    public void addToCalender(Reservation res){
        reservations.add(res);
    }
    
    
    //removing a reservation 
    public void cancel(Reservation a){
        
        for(int i =0; i < reservations.size(); i++){
            if(reservations.get(i).equals(a)){
                reservations.remove(a);
                    
                return;
        }  
        }
        
    }
    
    // Checks if Dates within Range could be used for csv. file to check for busy Dates
    public boolean DateWithinRange(Date resDate){
        
        boolean result = false;
        
        if((resDate.equals(Date1) || resDate.equals(Date2))
                || (resDate.after(Date1) && resDate.before(Date1))){
                result = true;
        }
        return result;
    }
     //returns all the reservaitons in the ArrayList       
     public ArrayList<Reservation> getReservations(){
         return reservations;
     } 
     
     
}
 