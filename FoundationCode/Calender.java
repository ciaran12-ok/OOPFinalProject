/**
 *
 * @author Nabel Sodipe 
 * 
 */
import java.time.LocalDate;
import java.util.ArrayList;

public class Calender {
    private LocalDate Date1;
    private LocalDate Date2;
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
    public boolean DateWithinRange(LocalDate resDate){
        
        boolean result = false;
        
        if((resDate.isEqual(Date1) || resDate.isEqual(Date2))
                || (resDate.isBefore(Date2) && resDate.isAfter(Date1))){
                result = true;
        }
        return result;
    }
     //returns all the reservaitons in the ArrayList       
     public ArrayList<Reservation> getReservations(){
         return reservations;
     } 
     
     
}
