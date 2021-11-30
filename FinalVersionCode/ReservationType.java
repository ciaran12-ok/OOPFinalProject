
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
        return "" + type;
    }
}

