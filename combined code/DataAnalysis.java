
import java.time.LocalDate;

/**
 * Class to analyze reservations booked
 *
 * @author Orla
 */
public class DataAnalysis {

    /**
     * Returns an array with the number of five star hotels booked at element 2,
     * the number of four star hotels booked at element 1,the number of three
     * star hotels booked at element 0
     *
     * @param reservationInfo
     * @return
     */
    public int[] countHotelsStars(String[][] reservationInfo) {
        int[] starsBooked = new int[3];
        int countThreeStars = 0;
        int countFourStars = 0;
        int countFiveStars = 0;
        for (int i = 1; i < reservationInfo[0].length; i++) {
            int star = Integer.parseInt(reservationInfo[i][0]);
            if (star == 3) {
                countThreeStars++;
            } else if (star == 4) {
                countFourStars++;
            } else if (star == 5) {
                countFiveStars++;
            }
        }
        starsBooked[0] = countThreeStars;
        starsBooked[1] = countFourStars;
        starsBooked[2] = countFiveStars;

        return starsBooked;
    }

    /**
     * Returns an array with the number of AP reservations booked at element 0,
     * and the number of S reservations booked at element 1
     *
     * @param reservationInfo
     * @return
     */
    public int[] countReservationType(String[][] reservationInfo) {
        int countAP = 0;
        int countS = 0;
        for (int i = 1; i < reservationInfo[3].length; i++) {
            String type = reservationInfo[i][3];
            if (type.equals("AP")) {
                countAP++;
            } else if (type.equals("S")) {
                countS++;
            }
        }
        int[] reservationTypeCount = {countAP, countS};
        return reservationTypeCount;
    }

    public double grossIncome(String[][] reservationInfo) {
        double income = 0;
        for (int i = 1; i < reservationInfo[8].length; i++) {
            income += Double.parseDouble(reservationInfo[i][8]);
        }
        return income;
    }

    public double averageReservationCost(String[][] reservationInfo) {
        double income = 0;
        for (int i = 1; i < reservationInfo[8].length; i++) {
            income += Double.parseDouble(reservationInfo[i][8]);
        }
        double avIncome = income / reservationInfo[8].length - 1;
        return avIncome;
    }

    public double averageRoomOccupancy(String[][] reservationInfo) {
        double occupancy = 0;
        for (int i = 1; i < reservationInfo[7].length; i++) {
            occupancy += Double.parseDouble(reservationInfo[i][7]);
        }
        double avOccupancy = occupancy / reservationInfo[7].length - 1;
        return avOccupancy;
    }

    public double averageStayLength(String[][] reservationInfo) {
        double stayLength = 0;

        for (int i = 1; i < reservationInfo[4].length; i++) {
            ResDate dIn = new ResDate(reservationInfo[i][4]);
            LocalDate dateIn = dIn.convertToLocal();
            int in = dateIn.getDayOfYear();

            ResDate dOut = new ResDate(reservationInfo[i][5]);
            LocalDate dateOut = dOut.convertToLocal();
            int out = dateOut.getDayOfYear();
            stayLength += out -in;
        }
        return stayLength/ reservationInfo[4].length;

    }
}
