
import java.io.FileNotFoundException;

/**
 *
 * @author Orla
 */
public class RunAnalysis {

    public static void main(String[] args) {
        try {
            DataAnalysis data = new DataAnalysis();
            ReadFile file = new ReadFile();
            String[][] reservationInfo = file.ExampleReservations();
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

        } catch (FileNotFoundException ex) {
            System.err.println("File not found, please try again.");
        }
    }

}
