/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ciaranokeeffe
 */




public class Room {
    
    private String type;
    private int NoOfRooms;
    private int min;
    private int max;
    private int rate;
    
    
    public Room(String type, int NoOfRooms, int min, int max, int rate){
    
    }
    
    // Gonna try creat an array of type room??
    
    public Room(String type, int noOfRooms, int min, int max, int r1, int r2, int r3, int r4, int r5, int r6, int r7){
    
    }
    
    Room deluxeDouble = new Room ("Deluxe Double", 35,1,2,75,75,75,80,90,90,75);
    Room deluxeTwin = new Room ("Deluxe Twin",25,1,2,75,75,75,80,90,90,75 );
    Room deluxeSingle = new Room ("Deluxe Single",10,1,2,70,70,70,75,80,80,65);
    Room deluxeFamily = new Room("Deluxe Family", 10,1,3,80,80,80,80,100,100,80);
    Room executiveDouble = new Room("Executive Double", 40,1,2,70,70,70,70,80,85,85);
    Room executiveTwin = new Room("Executive Twin", 32,1,2,70,70,70,70,80,85,85);
    Room executiveSingle = new Room("Executive Single", 12,1,1,65,65,65,65,70,75,80);
    Room classicDouble = new Room("Classic Double",45,1,2,65,65,70,70,75,80,65);
    Room classicTwin = new Room("Classic Twin",45,1,2,65,65,70,70,80,85,65);
    
    public Room fiveStarRooms[] = {deluxeDouble, deluxeTwin, deluxeSingle, deluxeFamily};
    public Room fourStarRooms[] = {executiveDouble, executiveTwin, executiveSingle};
    public Room threeStarRooms[] = {classicDouble, classicTwin};
    
  
    
    
    /*
    public String fiveStarRooms1[] = {"Deluxe Double", "Deluxe Twin", "Deluxe Single", "Deluxe Family"};
    public String fourStarRooms1[] = {"Executive Double", "Executive Twin", "Executive Single"};
    public String threeStarRooms1[] = {"Classic Double", "Classic Single"}; 
    
    
    public int[] deluxeDouble1 = {35,1,2,75,75,75,80,90,90,75};
    int[] deluxeTwin1 = {25,1,2,75,75,75,80,90,90,75};
    int[] deluxeSingle1 = {10,1,2,70,70,70,75,80,80,65};
    int[] deluxeFamily1 = {10,1,3,80,80,80,80,100,100,80};
    int[] excutiveDouble = {40,1,2,70,70,70,70,80,85,85};
    int[] executiveTwi1n = {32,1,2,70,70,70,70,80,85,85};
    int[] executiveSingle1 = {12,1,1,65,65,65,65,70,75,80};
    int[] classicDouble1 = {45,1,2,65,65,70,70,75,80,65};
    int[] classicTwin1 = {45,1,2,65,65,70,70,80,85,65};

    */
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNoOfRooms() {
        return NoOfRooms;
    }

    public void setNoOfRooms(int NoOfRooms) {
        this.NoOfRooms = NoOfRooms;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
    
    
    
}

