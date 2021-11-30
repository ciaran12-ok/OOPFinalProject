
/**
 * A class representing a type of reservation that sets the discounts
 *
 * @author Orla
 * @version 13/11/2021
 */
public class ReservationType {

    private String type;
    private double discount;
    private boolean refundable;

    /**
     * Constructor that accepts a string reservation type, checks to make sure
     * it is a valid reservation type, and sets the discount based off the type
     *
     * @param type
     */
    public ReservationType(String type) {
        if (type.equals("S") || type.equals("s")) {
            this.type = "S";
            discount = 0;
            refundable = true;

        } else if (type.equals("AP") || type.equals("ap")) {
            this.type = "AP";
            discount = 0.05;
            refundable = false;
        } else {
            System.out.println("Please enter a valid reservation type.");
        }

    }

    /**
     * Returns the reservation type
     *
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * Set the reservation type
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the discount
     *
     * @return discount
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * Method that checks whether a reservation is refundable
     *
     * @return true/false
     */
    public boolean isRefundable() {
        return refundable;
    }

    /**
     * Returns a String representation of a reservation type
     *
     * @return
     */
    @Override
    public String toString() {
        return "ReservationType: " + type;
    }
}

/**
 * Class to test that the ReservationType class is working as expected
 *
 * @author Orla
 * @version 28/11/2021
 */
class TestReservationType {

    public static void main(String[] args) {
        /*
        Test 1: testing the Standard type
         */
        ReservationType s = new ReservationType("s");
        String actualOutput1 = s.toString();

        String expectedOutput1 = "ReservationType: S";
        if (expectedOutput1.equals(actualOutput1) && s.getDiscount() == 0) {
            if (s.isRefundable()) {
                System.out.println("Test 1 Passed");
            }
        } else {
            System.out.println("Test 1 Failed");
        }
        
        
        /*
        Test 2: testing the Standard type
         */
        ReservationType ap = new ReservationType("AP");
        String actualOutput2 = ap.toString();

        String expectedOutput2 = "ReservationType: AP";
        if (expectedOutput2.equals(actualOutput2) && ap.getDiscount() == 0.05) {
            if (ap.isRefundable() == false) {
                System.out.println("Test 2 Passed");
            }
        } else {
            System.out.println("Test 2 Failed");
        }

    }
}
