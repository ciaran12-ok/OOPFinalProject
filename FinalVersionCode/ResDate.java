
import java.time.LocalDate;


/**
 *
 * @author Nabel Sodipe
 * @date 26/11/2021
 */
public class ResDate {

    private int year;
    private int month;
    private int day;

    /**
     * Constructor that creates a date from a string entered
     *
     * @param s
     */
    public ResDate(String s) {
        String[] input = s.split("/");

        day = Integer.parseInt(input[0]);
        month = Integer.parseInt(input[1]);
        year = Integer.parseInt(input[2]);
    }
    public ResDate(){
        
    }

    /**
     * Constructor that creates a date from ints entered
     *
     * @param s
     */
    public ResDate(int day, int month, int year) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * Method to get the day of a week from a ResDate
     * @return dayIndex Monday=1,Tuesday=2,...,Sunday=7
     */
    public int getDayOfWeek(){
        
        LocalDate date = LocalDate.of(year,month,day);
       int dayIndex = date.getDayOfWeek().getValue();
      
       return dayIndex;
        
    }
    /**
     * Method to check whether two date are equal
     *
     * @param o
     * @return true/false
     */
    public boolean equals(Object o) {
        if (o == null || !(o instanceof ResDate)) {
            return false;
        }
        ResDate app = (ResDate) o;
        return (app.year == this.year && app.month == this.month && app.day == this.day);

    }

    /**
     * Returns the year of a date
     *
     * @return year
     */
    public int getYear() {
        return year;
    }

    /**
     * Returns the month of a date
     *
     * @return month
     */
    public int getMonth() {
        return month;
    }

    /**
     * Returns the day of a date
     *
     * @return day
     */
    public int getDay() {
        return day;
    }
    /**
     * Method that converts a ResDate to a LocalDate,
     * allows us to use some of the localDate methods
     * @return date
     */
    public LocalDate convertToLocal(){
        LocalDate date = LocalDate.of(this.year,this.month,this.day);
        return date;
        
    }
    

    /**
     * Returns a string representation of a string
     *
     * @return
     */
    public String toString() {
        return day + "/" + month + "/" + year;
    }
}

