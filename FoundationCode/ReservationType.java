
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
            this.type = type;
            discount = 0;
            refundable = true;
            if (type.equals("AP") || type.equals("ap")) {
                this.type = type;
                discount = 0.05;
                refundable = false;
            }
        } else {
            System.out.println("Please enter a valid reservation type.");
        }

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getDiscount() {
        return discount;
    }

    /**
     * Method that checks whether a reservation is refundable
     *
     * Move??
     *
     * @return
     */
    public boolean isRefundableFromType() {
        return refundable;
    }

}
