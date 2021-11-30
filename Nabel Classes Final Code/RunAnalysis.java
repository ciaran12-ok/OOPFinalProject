/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nab'O
 */
import java.io.FileNotFoundException;

/**
 * A class that runs an analysis of the reservation.csv file and prints out all
 * the information gathered
 *
 * @author Orla
 */
public class RunAnalysis {

    public static void main(String[] args) {
        try {

            /*
            Data Analysis looking at all hotels at the same time
             */
            DataAnalysis data = new DataAnalysis();
            ReadFile file = new ReadFile();
            String[][] reservationInfo = file.Reservations();
            int[] hotelStars = data.countHotelsStars(reservationInfo);

            System.out.println("Data Analysis for the l4 chain of Hotels: \n");
            System.out.println("Number of five star hotels booked: " + hotelStars[2]);
            System.out.println("Number of four star hotels booked: " + hotelStars[1]);
            System.out.println("Number of three star hotles booked: " + hotelStars[0]);

            int[] countRType = data.countReservationType(reservationInfo);
            System.out.println("Number of AP reservations: " + countRType[0]);
            System.out.println("Number of S reservations: " + countRType[1]);

            double averageOccupancy = data.averageRoomOccupancy(reservationInfo);
            System.out.printf("Average room occupancy: %.2f\n", averageOccupancy);

            double avStay = data.averageStayLength(reservationInfo);
            System.out.printf("Average stay length: %.1f days\n", avStay);

            double grossIncome = data.grossIncome(reservationInfo);
            System.out.printf("Gross Income: $%.2f\n", grossIncome);

            double avResCost = data.averageReservationCost(reservationInfo);
            System.out.printf("Average cost of a reservation: $%.2f\n", avResCost);

            /*
            Data Analysis looking at the 5 hotel
             */
            System.out.println("");
            System.out.println("Data Analysis for the 5-Star Hotel: \n");
            int[] count5RType = data.count5ReservationType(reservationInfo);
            System.out.println("Number of 5-Star AP reservations: " + count5RType[0]);
            System.out.println("Number of 5-Star S reservations: " + count5RType[1]);

            double average5Occupancy = data.average5RoomOccupancy(reservationInfo);
            System.out.printf("Average 5-Star room occupancy: %.2f\n", average5Occupancy);

            double av5Stay = data.average5StayLength(reservationInfo);
            System.out.printf("Average 5-Star stay length: %.1f days\n", av5Stay);

            String most5PopRoom = data.most5PopularRoom(reservationInfo);
            System.out.println("Most popular 5-Star Room: " + most5PopRoom);

            String busiestDayOfWeeek = data.busiestDayOfWeek(reservationInfo);
            System.out.println("Most popular day of the week for all hotels: " + busiestDayOfWeeek);

            double gross5Income = data.gross5Income(reservationInfo);
            System.out.printf("Gross Income for the 5-Star Hotel: $%.2f\n", gross5Income);

            double av5ResCost = data.average5ReservationCost(reservationInfo);
            System.out.printf("Average cost of a reservation in a 5-Star Hotel: $%.2f\n", av5ResCost);

            /*
            Data Analysis looking at the 4 star hotel
             */
            System.out.println("");
            System.out.println("Data Analysis for the 4-Star Hotel: \n");
            int[] count4RType = data.count4ReservationType(reservationInfo);
            System.out.println("Number of 4-Star AP reservations: " + count4RType[0]);
            System.out.println("Number of 4-Star S reservations: " + count4RType[1]);

            double average4Occupancy = data.average4RoomOccupancy(reservationInfo);
            System.out.printf("Average 4-Star room occupancy: %.2f\n", average4Occupancy);

            double av4Stay = data.average4StayLength(reservationInfo);
            System.out.printf("Average 4-Star stay length: %.1f days\n", av4Stay);

            String most4PopRoom = data.most4PopularRoom(reservationInfo);
            System.out.println("Most popular 4-Star Room: " + most4PopRoom);

            double gross4Income = data.gross4Income(reservationInfo);
            System.out.printf("Gross Income for the 4-Star Hotel: $%.2f\n", gross4Income);

            double av4ResCost = data.average4ReservationCost(reservationInfo);
            System.out.printf("Average cost of a reservation in a 4-Star Hotel: $%.2f\n", av4ResCost);

            /*
            Data Analysis looking at the 3 star hotel
             */
            System.out.println("");
            System.out.println("Data Analysis for the 3-Star Hotel: \n");
            int[] count3RType = data.count3ReservationType(reservationInfo);
            System.out.println("Number of 3-Star AP reservations: " + count3RType[0]);
            System.out.println("Number of 3-Star S reservations: " + count3RType[1]);

            double average3Occupancy = data.average3RoomOccupancy(reservationInfo);
            System.out.printf("Average 3-Star room occupancy: %.2f\n", average3Occupancy);

            double av3Stay = data.average3StayLength(reservationInfo);
            System.out.printf("Average 3-Star stay length: %.1f days\n", av3Stay);

            String most3PopRoom = data.most3PopularRoom(reservationInfo);
            System.out.println("Most popular 3-Star Room: " + most3PopRoom);

            double gross3Income = data.gross3Income(reservationInfo);
            System.out.printf("Gross Income for the 3-Star Hotel: $%.2f\n", gross3Income);

            double av3ResCost = data.average3ReservationCost(reservationInfo);
            System.out.printf("Average cost of a reservation in a 3-Star Hotel: $%.2f\n", av3ResCost);

        } catch (FileNotFoundException ex) {
            System.err.println("File not found, please try again.");
        }
    }

}
