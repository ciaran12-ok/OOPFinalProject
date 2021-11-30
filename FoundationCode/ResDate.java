
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
        return (app.year == year && app.month == month && app.day == day);

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
        LocalDate date = LocalDate.of(year,month,day);
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

/**
 * Class to test that the ResDate class is working as expected
 *
 * @author Orla
 * @version 28/22/2021
 */
class TestResDate {

    public static void main(String[] args) {
        /*
        Test 1
        Testing by comparing Strings
         */
        ResDate today = new ResDate("28/11/2021");
        String actualOutput = today.toString();

        String expectedOutput = today.getDay() + "/" + today.getMonth()
                + "/" + today.getYear();

        if (expectedOutput.equals(actualOutput)) {
            System.out.println("Test 1 Passed");
        } else {
            System.out.println("Test 1 Failed");
        }
        /*
        Test 2
        Testing by using the ResDate equals() method
         */
        ResDate date = new ResDate("28/11/2021");
        if (today.equals(date)) {
            System.out.println("Test 2 Passed");
        } else {
            System.out.println("Test 2 Failed");
        }
         /*
        Test 3
        Testingthe getDayOfWeek() 
         */
        ResDate date2 = new ResDate("29/11/2021");
        if (date2.getDayOfWeek()  == 1) {
            System.out.println("Test 3 Passed");
        } else {
            System.out.println("Test 3 Failed");
        }

    }
}
