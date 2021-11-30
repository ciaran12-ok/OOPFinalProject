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
