/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LN;
import EN.*;
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
    
    public int heuristic(order order){
        if(order.getHigher() == order.getMedium() || (order.getHigher() - order.getMedium()) < order.getMinor()){
            return order.getMinor() + ((order.getHigher() + order.getMedium() - order.getMinor())/2);
        }
        else{
            return order.getHigher() - order.getMedium() + ((order.getHigher() + order.getMedium() - order.getMinor())/2);
        }
    }
    
    public bestMovement bestMovement(order order, ArrayList<zona> listZona){
        bestMovement bm = new bestMovement();
        ArrayList<zona> listZonaTemp = (ArrayList<zona>)listZona.clone();
        System.out.println(listZonaTemp.size());
        System.out.println("Posicion Inicial: " + listZona.get(1).getPosition() + " " + listZona.get(3).getPosition() + " " + listZona.get(5).getPosition());
        
        for(int i = 1; i <= 5; i++){
            //Mover a la izquierda
            if(i == 1){
                listZonaTemp.get(1).setPosition(listZonaTemp.get(1).getPosition() - 1);
                listZonaTemp.get(5).setPosition(listZonaTemp.get(5).getPosition() - 1);   
            }
            //listZonaTemp.get(i).setPosition(listZonaTemp.get(i).getPosition() - 1);
        }
        ArrayList<bestMovement> listMovement = new ArrayList<>();
        bm.setZona(1);
        bm.setDirection(-1);
        listMovement.add(bm);
        System.out.println("Hijo: " + listZonaTemp.get(1).getPosition() + " " + listZonaTemp.get(3).getPosition() + " " + listZonaTemp.get(5).getPosition());
        order or = calculateOrder(listZonaTemp);
        System.out.println("Heuristic: " + heuristic(or));
        
        System.out.println("Movimiento a realizar: Zona:" + listMovement.get(0).getZona() + " " + "Direccion:" + listMovement.get(0).getDirection());
        
        return bm;
    } 
}
