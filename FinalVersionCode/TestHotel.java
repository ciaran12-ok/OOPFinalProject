/**
 * A test class to make sure the hotel class is working as expected NOTE: should
 * be moved into it's own java file at the end
 *
 * @author Orla
 * @version 27//11/2021
 */
class TestHotel {

    public static void main(String[] args) {
        /*
        Test 1
        Testing the get methods vs the constructor using a toString()
         */

        //Creating a hotel using the full constructor
        Hotel myHotel1 = new Hotel("MyHotel1", 1);

        int[] rates1 = {75, 75, 70, 80, 90, 90, 75};
        Room room1 = new Room("Double Room", 35, 1, 2, rates1);
        int[] rates2 = {50, 75, 70, 80, 80, 70, 75};
        Room room2 = new Room("Single Room", 55, 1, 1, rates2);

        Room[] roomsAvailable1 = {room1, room2};
        myHotel1.setRoomsAvailable(roomsAvailable1);
        String actualOutput = myHotel1.toString();

        //Creating a string of expected output
        String expectedOutput = "";
        String roomsArray = "";
        try {
            for (int i = 0; i < myHotel1.getRoomsAvailable().length - 1; i++) {
                roomsArray += myHotel1.getRoomsAvailable()[i] + ",";
            }
            roomsArray += myHotel1.getRoomsAvailable()[myHotel1.getRoomsAvailable().length - 1];
        } catch (NullPointerException ex) {
            System.err.print("Rooms available array is empty");
        }

        expectedOutput = "Hotel:" + " Name:" + myHotel1.getName() + " Star:"
                + myHotel1.getStar() + " RoomsAvailable:" + roomsArray;

        //Comparing the two strings to see if they're the same
        //Run the main method to find out whether the test passed
        if (expectedOutput.equals(actualOutput)) {
            System.out.println("True: Test 1 Passed");
        } else {
            System.out.println("Test 1 Failed");
        }

        /*
        Test 2
         Testing the set methods vs the constructor using a toString()
         */
        //Using the hotel created above with the constructor: myHotel1
        //Creating a room using the set methods
        Hotel myHotel2 = new Hotel();
        myHotel2.setName("MyHotel1");
        myHotel2.setStar(1);

        int[] rates3 = {75, 75, 70, 80, 90, 90, 75};
        Room room3 = new Room("Double Room", 35, 1, 2, rates1);
        int[] rates4 = {50, 75, 70, 80, 80, 70, 75};
        Room room4 = new Room("Single Room", 55, 1, 1, rates2);

        Room[] roomsAvailable2 = {room3, room4};
        myHotel2.setRoomsAvailable(roomsAvailable2);

        //Comparing the two strings to see if they're the same
        //Run the main method to find out whether the test passed
        if (myHotel1.toString().equals(myHotel2.toString())) {
            System.out.println("True: Test 2 Passed");
        } else {
            System.out.println("Test 2 Failed");
        }

        /*
        Test 3
         Testing to see whether the getRoomOptions method is working as expected
         */
        String[] myHotel1OptionsActual = myHotel1.getRoomOptions();

        String[] myHotel1OptionsExpected = new String[myHotel1.getRoomsAvailable().length];

        for (int i = 0; i < myHotel1.getRoomsAvailable().length; i++) {
            myHotel1OptionsExpected[i] = i + ") " + myHotel1.getRoomsAvailable()[i].toString();
        }

        //Checks whether every element in both arrays is equal
        boolean passed = false;
        if (myHotel1OptionsActual.length == myHotel1OptionsExpected.length) {
            for (int i = 0; i < myHotel1OptionsActual.length; i++) {
                if (myHotel1OptionsActual[i].equals(myHotel1OptionsExpected[i])) {
                    passed = true;
                } else {
                    passed = false;
                }
            }
        }

        //Run the main method to find out whether the test passed
        if (passed = true) {
            System.out.println("True: Test 3 Passed");
        } else {
            System.out.println("Test 3 Failed");
        }

    }
}
