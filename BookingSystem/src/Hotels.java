/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Windows10
 */
import java.util.ArrayList;
public class Hotels {
    private ArrayList<String[]> rooms;
    private String type;
    public void getHotelDetails(ArrayList<String[]> list){
        this.rooms = (ArrayList<String[]>)list.clone();
    }
    
}
