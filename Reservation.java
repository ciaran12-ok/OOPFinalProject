import java.util.Scanner;
import java.util.Arrays;


public class Reservation {
    
    private Room room;
    private Hotel hotel;
    private Scanner in;
    
    
    public Reservation (){
    
        in = new Scanner(System.in);
    }
    
    public void run(){
    
        boolean more = true;
        
        while(more){
        
            System.out.println("Welcome to the reservation system.\n"
                    + "What type of Hotel would you like to stay in?\n"
                    + "A) 5-STAR  B) 4-STAR C) 3-STAR");
            String command1 = in.nextLine().toUpperCase();
            
            
            // 5-Star Hotel Choice tree
            if (command1.equals("A")){
                System.out.println("What Hotel would you like to stay in?"
                        + "1) Balyfin House 2) Plaza Hotel 3) Quay Hotel");
                int hotelChoice = in.nextInt();
        
                if (command1.equals("A")){
                    System.out.println("Which room would you like to book?"
                            + "A) Deluxe Double B) Deluxe Twin C) Deluxe Single D) Deluxe Family");
                    String command2 = in.nextLine().toUpperCase();
                    // Room A
                    if(command2.equals("A")){
                        System.out.println("Amount of rooms available is" + room.deluxeDouble[0] );
                        System.out.println("How many rooms would you like to book?");
                            
                        int numOfRooms = in.nextInt();
                            if (numOfRooms <0){
                                System.out.println("Invalid number, try again");
                            }
                            if (numOfRooms > room.deluxeDouble[0]){
                                System.out.println("Not enough rooms available");

                            }
                            else{
                               room.deluxeDouble[0] = room.deluxeDouble[0] -numOfRooms;
                            }
                    }
                    //Room B
                    if(command2.equals("B")){
                        System.out.println("Amount of rooms available is" + room.deluxeTwin[0] );
                        System.out.println("How many rooms would you like to book?");
                            
                        int numOfRooms = in.nextInt();
                            if (numOfRooms <0){
                                System.out.println("Invalid number, try again");
                            }
                            if (numOfRooms > room.deluxeTwin[0]){
                                System.out.println("Not enough rooms available");

                            }
                            else{
                               room.deluxeTwin[0] = room.deluxeTwin[0] -numOfRooms;
                            }
                    }
                    
                    //Room C
                    if(command2.equals("C")){
                        System.out.println("Amount of rooms available is" + room.deluxeSingle[0] );
                        System.out.println("How many rooms would you like to book?");
                            
                        int numOfRooms = in.nextInt();
                            if (numOfRooms <0){
                                System.out.println("Invalid number, try again");
                            }
                            if (numOfRooms > room.deluxeSingle[0]){
                                System.out.println("Not enough rooms available");

                            }
                            else{
                               room.deluxeSingle[0] = room.deluxeSingle[0] -numOfRooms;
                            }
                    }
                    // Room D
                    if(command2.equals("D")){
                        System.out.println("Amount of rooms available is" + room.deluxeFamily[0] );
                        System.out.println("How many rooms would you like to book?");
                            
                        int numOfRooms = in.nextInt();
                            if (numOfRooms <0){
                                System.out.println("Invalid number, try again");
                            }
                            if (numOfRooms > room.deluxeFamily[0]){
                                System.out.println("Not enough rooms available");

                            }
                            else{
                               room.deluxeFamily[0] = room.deluxeFamily[0] -numOfRooms;
                            }
                    }


                }
                else if (command1.equals("B")){

                }
                else if (command1.equals("C")){

                }


            }
        }
    
    }
    
    
}
