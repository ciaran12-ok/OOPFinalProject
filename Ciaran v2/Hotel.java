/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ciaranokeeffe
 */
public class Hotel {
    
    
    public String name;
    public int star;

    public String hotelType[] = {"Five Star", "Four Star", "Three Star"};

    @Override
    public String toString() {
        return "Hotel{" + "name=" + name + ", star=" + star +"}";
    }
    
    
    public Hotel(String name, int star) {
        this.name = name;
        this.star = star;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }
    
    
}
