

/**
 *
 * @author Nabel Sodipe 
 * @date 13/11/2021
 */
import java.time.LocalDate;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;

public class Calender {
    private Date checkinDate;
    private Date checkoutDate;
    private ArrayList<Reservation> reservations;
    
    
    public void Calander(){
        reservations = new ArrayList<>();
    } 
    
    // getInstance() gets a calander using the specified time zone 
    // we set the the default Dates to a certain date e.g. 2021/11/17
    public final void SetReservationDates(int DaysFromNow, int Stay){
            Calendar ref = Calendar.getInstance();
        ref.set(ref.get(Calendar.YEAR), 
                    ref.get(Calendar.MONTH), 
                        ref.get(Calendar.DAY_OF_MONTH)
                                + DaysFromNow, 2021,11,17);
        
        checkinDate = ref.getTime();
        
        ref.add(Calendar.DAY_OF_MONTH, Stay);
        
        checkoutDate = ref.getTime();
    }
    
    public Date getCheckinDate(){
        return checkinDate;
    }
    
    public Date getCheckoutDate(){
        return checkoutDate;
    }
    
    public void setCheckinDate(Date checkinDate){
        this.checkinDate = checkinDate;
    }
    
    public void setCheckoutDate(Date checkoutDate){
        this.checkoutDate = checkoutDate;
    }
    
}