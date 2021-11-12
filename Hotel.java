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

    public String[] fiveStar = {"Ballyfin House", "Plaza Hotel", "The Quay Hotel"};
    public String[] fourStar = {"Ashdown Hotel", "Amber Springs Hotel", "Riverside Hotel"};
    public String[] threestar = {"Woodenbridge Hotel", "Doonmore Hotel", "Murphy's Hotel"}; 

    @Override
    public String toString() {
        return "Hotel{" + "name=" + name + ", star=" + star + ", fiveStar=" + fiveStar + ", fourStar=" + fourStar + ", threestar=" + threestar + '}';
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
