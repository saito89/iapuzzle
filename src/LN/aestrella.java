/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LN;
import EN.*;
import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author Cana
 */
public class aestrella {
    //bestMovement movement = new bestMovement();
    
    public order calculateOrder(ArrayList<zona> listZona){
        order order = new order();

        order.setMinor(listZona.get(1).getPosition());
        order.setMedium(listZona.get(1).getPosition());
        order.setHigher(listZona.get(1).getPosition());

        for(int i = 3; i < listZona.size();i++){
            if(i == 4){
                continue;
            }
            if(listZona.get(i).getPosition() <= order.getMinor()){
                order.setMinor(listZona.get(i).getPosition());
            }
            else{
                if(listZona.get(i).getPosition() >= order.getMedium()){
                    order.setHigher(listZona.get(i).getPosition());
                }
                else{
                    order.setMedium(listZona.get(i).getPosition());
                }
            }
        }
        return order;
    }
    
    private int heuristic(int zona1, int zona2, int zona3, int zona4, int zona5){
        //int result = order.getMinor();
        return 0;
    }
}
