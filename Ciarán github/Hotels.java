/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ciaranokeeffe
 */
public class Hotels {
    
    private String name;
    private int star;
    private Room starArray[];
    private Room roomForCon;
    
    
    public Hotels(int starNo, Room pStarArray[]){  
        
        this.star= starNo;
        pStarArray = starArray;
   
        }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public Room[] getStarArray() {
        return starArray;
    }

    public void setStarArray(Room[] starArray) {
        this.starArray = starArray;
    }
    
    
    
   
}
