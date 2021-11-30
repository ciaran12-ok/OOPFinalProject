
import java.time.LocalDate;

/**
 * Class to analyze reservations booked
 *
 * @author Orla
 * @version 30//11/2021
 */
public class DataAnalysis {

    /**
     * Returns an array with the number of five star hotels booked at element 2,
     * the number of four star hotels booked at element 1,the number of three
     * star hotels booked at element 0
     *
     * @param reservationInfo
     * @return int[]
     */
    public int[] countHotelsStars(String[][] reservationInfo) {
        int[] starsBooked = new int[3];
        int countThreeStars = 0;
        int countFourStars = 0;
        int countFiveStars = 0;
        for (int i = 1; i < reservationInfo.length; i++) {
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
     *
     * Returns an array with the number of AP reservations booked at element 0,
     * and the number of S reservations booked at element 1 for all hotels
     *
     * @param reservationInfo
     * @return int[]
     */
    public int[] countReservationType(String[][] reservationInfo) {
        int countAP = 0;
        int countS = 0;
        for (int i = 1; i < reservationInfo.length; i++) {
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

    /**
     * Returns the gross income for all the hotels
     *
     * @param reservationInfo
     * @return income
     */
    public double grossIncome(String[][] reservationInfo) {
        double income = 0;
        for (int i = 1; i < reservationInfo.length; i++) {
            income += Double.parseDouble(reservationInfo[i][8]);
        }
        return income;
    }

    /**
     * Returns the average cost of reserving a room for all hotels
     *
     * @param reservationInfo
     * @return avCost
     */
    public double averageReservationCost(String[][] reservationInfo) {
        double income = 0;
        for (int i = 1; i < reservationInfo.length; i++) {
            income += Double.parseDouble(reservationInfo[i][8]);
        }
        double avIncome = income / (reservationInfo.length - 1);
        return avIncome;
    }

    /**
     * Returns the average room occupancy for all the rooms in all the hotels
     *
     * @param reservationInfo
     * @return avOccupancy
     */
    public double averageRoomOccupancy(String[][] reservationInfo) {
        double occupancy = 0;
        for (int i = 1; i < reservationInfo.length; i++) {
            occupancy += Double.parseDouble(reservationInfo[i][7]);
        }
        double avOccupancy = occupancy / (reservationInfo.length - 1);
        return avOccupancy;
    }

    /**
     * Finds the average length of a stay for all hotels
     *
     * @param reservationInfo
     * @return avStayLength
     */
    public double averageStayLength(String[][] reservationInfo) {
        double stayLength = 0;

        for (int i = 1; i < reservationInfo.length; i++) {
            ResDate dIn = new ResDate(reservationInfo[i][4]);
            LocalDate dateIn = dIn.convertToLocal();
            int in = dateIn.getDayOfYear();

            ResDate dOut = new ResDate(reservationInfo[i][5]);
            LocalDate dateOut = dOut.convertToLocal();
            int out = dateOut.getDayOfYear();
            stayLength += out - in;
        }
        return stayLength / (reservationInfo.length - 1);

    }

    /**
     * Returns the busiest day of the week for all hotels
     *
     * @param reservationInfo
     * @return String
     */
    public String busiestDayOfWeek(String[][] reservationInfo) {
        int countMon = 0;
        int countTue = 0;
        int countWed = 0;
        int countThurs = 0;
        int countFri = 0;
        int countSat = 0;
        int countSun = 0;

        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturay", "Sunday"};
        int[] countDays = {countMon, countTue, countWed, countThurs, countFri, countSat, countSun};
        for (int i = 1; i < reservationInfo.length; i++) {
            ResDate cIn = new ResDate(reservationInfo[i][4]);
            ResDate cOut = new ResDate(reservationInfo[i][5]);
            LocalDate checkIn = cIn.convertToLocal();
            LocalDate checkOut = cOut.convertToLocal();
            int in = checkIn.getDayOfYear();
            int out = checkOut.getDayOfYear();
            int difference = out - in;
            int day = checkIn.getDayOfWeek().getValue();

            for (int j = 0; j < difference; j++) {
                int index = day + j;
                if (index >= 7) {
                    index = 0;
                }

                countDays[index]++;
            }
        }
//Find the most popluar day of the array 
//return a string of that day

        int indexMostPopular = 0;
        int max = countDays[0];
        if (countDays[1] > max) {
            indexMostPopular = 1;
            max = countDays[1];
        }
        if (countDays[2] > max) {
            indexMostPopular = 2;
            max = countDays[2];
        }
        if (countDays[3] > max) {
            indexMostPopular = 3;
            max = countDays[3];
        }
        if (countDays[4] > max) {
            indexMostPopular = 4;
            max = countDays[4];
        }
        if (countDays[5] > max) {
            indexMostPopular = 5;
            max = countDays[5];
        }
        if (countDays[6] > max) {
            indexMostPopular = 6;
            max = countDays[6];
        }

        return days[indexMostPopular];

    }

    /**
     *
     * Returns an array with the number of AP reservations booked at element 0,
     * and the number of S reservations booked at element 1, for the 5 star
     * hotel
     *
     * @param reservationInfo
     * @return int[]
     */
    public int[] count5ReservationType(String[][] reservationInfo) {
        int countAP = 0;
        int countS = 0;
        for (int i = 1; i < reservationInfo.length; i++) {
            String type = reservationInfo[i][3];
            if (Integer.parseInt(reservationInfo[i][0]) == 5) {
                if (type.equals("AP")) {
                    countAP++;
                } else if (type.equals("S")) {
                    countS++;
                }
            }
        }
        int[] reservationTypeCount = {countAP, countS};
        return reservationTypeCount;
    }

    /**
     * Returns the gross income for the 5 star hotel
     *
     * @param reservationInfo
     * @return income
     */
    public double gross5Income(String[][] reservationInfo) {
        double income = 0;
        for (int i = 1; i < reservationInfo.length; i++) {
            if (Integer.parseInt(reservationInfo[i][0]) == 5) {
                income += Double.parseDouble(reservationInfo[i][8]);
            }
        }
        return income;
    }

    /**
     * Returns the average cost of booking a room in a 5 star hotel
     *
     * @param reservationInfo
     * @return avCost
     */
    public double average5ReservationCost(String[][] reservationInfo) {
        double income = 0;
        int count5Star = 0;
        for (int i = 1; i < reservationInfo.length; i++) {
            if (Integer.parseInt(reservationInfo[i][0]) == 5) {
                count5Star++;
                income += Double.parseDouble(reservationInfo[i][8]);
            }
        }
        double avIncome = income / count5Star;
        return avIncome;
    }

    /**
     * Returns the average room occupancy booked for a 5 star hotel
     *
     * @param reservationInfo
     * @return avOccupancy
     */
    public double average5RoomOccupancy(String[][] reservationInfo) {
        double occupancy = 0;
        int count5Star = 0;
        for (int i = 1; i < reservationInfo.length; i++) {
            if (Integer.parseInt(reservationInfo[i][0]) == 5) {
                count5Star++;
                occupancy += Double.parseDouble(reservationInfo[i][7]);
            }
        }
        double avOccupancy = occupancy / count5Star;
        return avOccupancy;
    }

    /**
     * Returns the average length of a stay in a 5 star hotel
     *
     * @param reservationInfo
     * @return avStayLength
     */
    public double average5StayLength(String[][] reservationInfo) {
        double stayLength = 0;
        int count5Star = 0;
        for (int i = 1; i < reservationInfo.length; i++) {
            if (Integer.parseInt(reservationInfo[i][0]) == 5) {
                count5Star++;
                ResDate dIn = new ResDate(reservationInfo[i][4]);
                LocalDate dateIn = dIn.convertToLocal();
                int in = dateIn.getDayOfYear();

                ResDate dOut = new ResDate(reservationInfo[i][5]);
                LocalDate dateOut = dOut.convertToLocal();
                int out = dateOut.getDayOfYear();
                stayLength += out - in;
            }
        }
        return stayLength / count5Star;

    }

    /**
     * Returns the most popular room booked in a 5 star hotel
     *
     * @param reservationInfo
     * @return String room
     */
    public String most5PopularRoom(String[][] reservationInfo) {
        int dDoubleCount = 0;
        int dTwinCount = 0;
        int dSingleCount = 0;
        int dFamilyCount = 0;

        for (int i = 1; i < reservationInfo.length; i++) {
            if (Integer.parseInt(reservationInfo[i][0]) == 5) {
                if ((reservationInfo[i][6]).equals("Deluxe Double")) {
                    dDoubleCount++;
                } else if ((reservationInfo[i][6]).equals("Deluxe Single")) {
                    dSingleCount++;
                } else if ((reservationInfo[i][6]).equals("Deluxe Twin")) {
                    dTwinCount++;
                } else if ((reservationInfo[i][6]).equals("Deluxe Family")) {
                    dFamilyCount++;
                }
            }
        }
        int[] roomCounts = {dDoubleCount, dTwinCount, dSingleCount, dFamilyCount};

        int indexMostPopular = 0;
        int max = roomCounts[0];
        if (roomCounts[1] > max) {
            indexMostPopular = 1;
            max = roomCounts[1];
        }
        if (roomCounts[2] > max) {
            indexMostPopular = 2;
            max = roomCounts[2];
        }
        if (roomCounts[3] > max) {
            indexMostPopular = 3;
            max = roomCounts[3];
        }

        if (indexMostPopular == 0) {
            return "Deluxe Double";
        } else if (indexMostPopular == 1) {
            return "Deluxe Twin";
        } else if (indexMostPopular == 2) {
            return "Deluxe Single";
        } else if (indexMostPopular == 3) {
            return "Deluxe Family";
        } else {
            return null;
        }

    }

    /**
     *
     * Returns an array with the number of AP reservations booked at element 0,
     * and the number of S reservations booked at element 1, for the 4 star
     * hotel
     *
     * @param reservationInfo
     * @return int[]
     */
    public int[] count4ReservationType(String[][] reservationInfo) {
        int countAP = 0;
        int countS = 0;
        for (int i = 1; i < reservationInfo.length; i++) {
            String type = reservationInfo[i][3];
            if (Integer.parseInt(reservationInfo[i][0]) == 4) {
                if (type.equals("AP")) {
                    countAP++;
                } else if (type.equals("S")) {
                    countS++;
                }
            }
        }
        int[] reservationTypeCount = {countAP, countS};
        return reservationTypeCount;
    }

    /**
     * Returns the gross income for the 4 star hotel
     *
     * @param reservationInfo
     * @return income
     */
    public double gross4Income(String[][] reservationInfo) {
        double income = 0;
        for (int i = 1; i < reservationInfo.length; i++) {
            if (Integer.parseInt(reservationInfo[i][0]) == 4) {
                income += Double.parseDouble(reservationInfo[i][8]);
            }
        }
        return income;
    }

    /**
     * Returns the average cost of booking a room in a 4 star hotel
     *
     * @param reservationInfo
     * @return avCost
     */
    public double average4ReservationCost(String[][] reservationInfo) {
        double income = 0;
        int count4Star = 0;
        for (int i = 1; i < reservationInfo.length; i++) {
            if (Integer.parseInt(reservationInfo[i][0]) == 4) {
                count4Star++;
                income += Double.parseDouble(reservationInfo[i][8]);
            }
        }
        double avIncome = income / count4Star;
        return avIncome;
    }

    /**
     * Returns the average room occupancy booked for a 4 star hotel
     *
     * @param reservationInfo
     * @return avOccupancy
     */
    public double average4RoomOccupancy(String[][] reservationInfo) {
        double occupancy = 0;
        int count4Star = 0;
        for (int i = 1; i < reservationInfo.length; i++) {
            if (Integer.parseInt(reservationInfo[i][0]) == 4) {
                count4Star++;
                occupancy += Double.parseDouble(reservationInfo[i][7]);
            }
        }
        double avOccupancy = occupancy / count4Star;
        return avOccupancy;
    }

    /**
     * Returns the average length of a stay in a 4 star hotel
     *
     * @param reservationInfo
     * @return avStayLength
     */
    public double average4StayLength(String[][] reservationInfo) {
        double stayLength = 0;
        int count4Star = 0;
        for (int i = 1; i < reservationInfo.length; i++) {
            if (Integer.parseInt(reservationInfo[i][0]) == 4) {
                count4Star++;
                ResDate dIn = new ResDate(reservationInfo[i][4]);
                LocalDate dateIn = dIn.convertToLocal();
                int in = dateIn.getDayOfYear();

                ResDate dOut = new ResDate(reservationInfo[i][5]);
                LocalDate dateOut = dOut.convertToLocal();
                int out = dateOut.getDayOfYear();
                stayLength += out - in;
            }
        }
        return stayLength / count4Star;

    }

    /**
     * Returns the most popular room booked in a 4 star hotel
     *
     * @param reservationInfo
     * @return String room
     */
    public String most4PopularRoom(String[][] reservationInfo) {
        int eDoubleCount = 0;
        int eTwinCount = 0;
        int eSingleCount = 0;

        for (int i = 1; i < reservationInfo.length; i++) {
            if (Integer.parseInt(reservationInfo[i][0]) == 4) {
                if ((reservationInfo[i][6]).equals("Executive Double")) {
                    eDoubleCount++;
                } else if ((reservationInfo[i][6]).equals("Executive Single")) {
                    eSingleCount++;
                } else if ((reservationInfo[i][6]).equals("Executive Twin")) {
                    eTwinCount++;
                }
            }
        }
        int[] roomCounts = {eDoubleCount, eTwinCount, eSingleCount};

        int indexMostPopular = 0;
        int max = roomCounts[0];
        if (roomCounts[1] > max) {
            indexMostPopular = 1;
            max = roomCounts[1];
        }
        if (roomCounts[2] > max) {
            indexMostPopular = 2;
            max = roomCounts[2];
        }

        if (indexMostPopular == 0) {
            return "Executive Double";
        } else if (indexMostPopular == 1) {
            return "Executive Twin";
        } else if (indexMostPopular == 2) {
            return "Executive Single";
        } else {
            return null;
        }

    }

    /**
     *
     * Returns an array with the number of AP reservations booked at element 0,
     * and the number of S reservations booked at element 1, for the 3 star
     * hotel
     *
     * @param reservationInfo
     * @return int[]
     */
    public int[] count3ReservationType(String[][] reservationInfo) {
        int countAP = 0;
        int countS = 0;
        for (int i = 1; i < reservationInfo.length; i++) {
            String type = reservationInfo[i][3];
            if (Integer.parseInt(reservationInfo[i][0]) == 3) {
                if (type.equals("AP")) {
                    countAP++;
                } else if (type.equals("S")) {
                    countS++;
                }
            }
        }
        int[] reservationTypeCount = {countAP, countS};
        return reservationTypeCount;
    }

    /**
     * Returns the gross income for the 3 star hotel
     *
     * @param reservationInfo
     * @return income
     */
    public double gross3Income(String[][] reservationInfo) {
        double income = 0;
        for (int i = 1; i < reservationInfo.length; i++) {
            if (Integer.parseInt(reservationInfo[i][0]) == 3) {
                income += Double.parseDouble(reservationInfo[i][8]);
            }
        }
        return income;
    }

    /**
     * Returns the average cost of booking a room in a 3 star hotel
     *
     * @param reservationInfo
     * @return avCost
     */
    public double average3ReservationCost(String[][] reservationInfo) {
        double income = 0;
        int count3Star = 0;
        for (int i = 1; i < reservationInfo.length; i++) {
            if (Integer.parseInt(reservationInfo[i][0]) == 3) {
                count3Star++;
                income += Double.parseDouble(reservationInfo[i][8]);
            }
        }
        double avIncome = income / count3Star;
        return avIncome;
    }

    /**
     * Returns the average room occupancy booked for a 3 star hotel
     *
     * @param reservationInfo
     * @return avOccupancy
     */
    public double average3RoomOccupancy(String[][] reservationInfo) {
        double occupancy = 0;
        int count3Star = 0;
        for (int i = 1; i < reservationInfo.length; i++) {
            if (Integer.parseInt(reservationInfo[i][0]) == 3) {
                count3Star++;
                occupancy += Double.parseDouble(reservationInfo[i][7]);
            }
        }
        double avOccupancy = occupancy / count3Star;
        return avOccupancy;
    }

    /**
     * Returns the average length of a stay in a 3 star hotel
     *
     * @param reservationInfo
     * @return avStayLength
     */
    public double average3StayLength(String[][] reservationInfo) {
        double stayLength = 0;
        int count3Star = 0;
        for (int i = 1; i < reservationInfo.length; i++) {
            if (Integer.parseInt(reservationInfo[i][0]) == 3) {
                count3Star++;
                ResDate dIn = new ResDate(reservationInfo[i][4]);
                LocalDate dateIn = dIn.convertToLocal();
                int in = dateIn.getDayOfYear();

                ResDate dOut = new ResDate(reservationInfo[i][5]);
                LocalDate dateOut = dOut.convertToLocal();
                int out = dateOut.getDayOfYear();
                stayLength += out - in;
            }
        }
        return stayLength / count3Star;

    }

    /**
     * Returns the most popular room booked in a 3 star hotel
     *
     * @param reservationInfo
     * @return String room
     */
    public String most3PopularRoom(String[][] reservationInfo) {
        int cDoubleCount = 0;
        int cTwinCount = 0;
        int cSingleCount = 0;

        for (int i = 1; i < reservationInfo.length; i++) {
            if (Integer.parseInt(reservationInfo[i][0]) == 5) {
                if ((reservationInfo[i][6]).equals("Classic Double")) {
                    cDoubleCount++;
                } else if ((reservationInfo[i][6]).equals("Classic Single")) {
                    cSingleCount++;
                } else if ((reservationInfo[i][6]).equals("Classic Twin")) {
                    cTwinCount++;
                }
            }
        }
        int[] roomCounts = {cDoubleCount, cTwinCount, cSingleCount};

        int indexMostPopular = 0;
        int max = roomCounts[0];
        if (roomCounts[1] > max) {
            indexMostPopular = 1;
            max = roomCounts[1];
        }
        if (roomCounts[2] > max) {
            indexMostPopular = 2;
            max = roomCounts[2];
        }

        if (indexMostPopular == 0) {
            return "Classic Double";
        } else if (indexMostPopular == 1) {
            return "Classic Twin";
        } else if (indexMostPopular == 2) {
            return "Classic Single";
        } else {
            return null;
        }

    }

}
