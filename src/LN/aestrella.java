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
    
    //Ubica el menor, el mayor y el numero del medio de las zonas 1, 3 y 5
    public Order calculateOrder(ArrayList<Zona> listZona){
        Order order = new Order();

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
    
    public int heuristic(Order order){
        if(order.getHigher() == order.getMedium() || (order.getHigher() - order.getMedium()) < order.getMinor()){
            return order.getMinor() + ((order.getHigher() + order.getMedium() - order.getMinor())/2);
        }
        else{
            return order.getHigher() - order.getMedium() + ((order.getHigher() + order.getMedium() - order.getMinor())/2);
        }
    }
    
    public void printSon(ArrayList<Zona> listZonaTemp){
        System.out.print("Hijo: " + listZonaTemp.get(1).getPosition() + " " + listZonaTemp.get(3).getPosition() + " " + listZonaTemp.get(5).getPosition());
        Order or = calculateOrder(listZonaTemp);
        System.out.println(" Heuristic: " + heuristic(or));
    }
    
    public void printMovementList(ArrayList<BestMovement> listMovement){
        System.out.println("Movimientos a realizar:");
        for(int i = 0; i < listMovement.size(); i++){
            System.out.println("Paso " + (i+1) + ": " + "Zona:" + listMovement.get(i).getZona() + " " + "Direccion:" + listMovement.get(i).getDirection());
        } 
    }
    
    public Route bestMovement(Order order, ArrayList<Zona> listZona, ArrayList<BestMovement> listMovement){
        Route route = new Route();
        BestMovement bm = new BestMovement();
        ArrayList<Zona> listZonaTemp = (ArrayList<Zona>)listZona.clone();
        Order or = calculateOrder(listZona);
        int actualHeuristic = heuristic(or);
        System.out.println("Posicion Actual: " + listZona.get(1).getPosition() + " " + listZona.get(3).getPosition() + " " + listZona.get(5).getPosition());
        
        for(int i = 1; i <= 5; i++){

            //Mover a la izquierda
            if(i == 1){
                listZonaTemp.get(1).setPosition(listZonaTemp.get(1).getPosition() - 1);
                listZonaTemp.get(5).setPosition(listZonaTemp.get(5).getPosition() - 1);
                Order orTemp = calculateOrder(listZonaTemp);
                if(heuristic(orTemp) < actualHeuristic){
                    bm.setZona(1);
                    bm.setDirection(-1);
                    actualHeuristic = heuristic(orTemp);
                    route.setListBestMovement(listMovement);
                    route.setListZona(listZonaTemp);
                    route.setOrd(orTemp);
                }
                else{
                    System.out.println("Aqui deberia de despicharze");
                }
            }
            //listZonaTemp.get(i).setPosition(listZonaTemp.get(i).getPosition() - 1);
        }
        System.out.println("Aqui va el or");
        System.out.println("Higher:" + or.getHigher() + "Medium:" + or.getMedium() + "Minor" + or.getMinor());
        
        printSon(listZonaTemp);
        
        listMovement.add(bm);
        
        printMovementList(listMovement);
        
        return route;
    } 
}
