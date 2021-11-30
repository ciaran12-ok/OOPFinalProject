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
