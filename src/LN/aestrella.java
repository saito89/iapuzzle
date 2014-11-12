/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LN;
import EN.*;
import static java.lang.Math.abs;
import static java.lang.Math.min;
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
            if(listZona.get(i).getPosition() < order.getMinor()){
                order.setMedium(order.getMinor());
                order.setMinor(listZona.get(i).getPosition());
            }
            else{
                if(listZona.get(i).getPosition() > order.getHigher()){
                    order.setMedium(order.getHigher());
                    order.setHigher(listZona.get(i).getPosition());
                }
                else{
                    order.setMedium(listZona.get(i).getPosition());
                }
            }
        }
        return order;
    }
    
    public int diferencia(int a, int b, int c){
        if((a - b) > c){
            return (a-c)-b;
        }
        else{
            return 0;
        }
    }
    
    //Busca la ruta mas corta al orden original, ya sea a 0 o a 12 (la misma posicion fisicamente)
    public int equilibrio(int a){
        return min(a, abs(a-12));
    }
    
    public int heuristic(Order order, ArrayList<Zona> listZona){
        int menor = order.getMinor();
        int diferencia = diferencia(order.getHigher(), order.getMedium(), order.getMinor());
        int equilibrio = equilibrio((order.getHigher() + order.getMedium() - order.getMinor())/2);
        //System.out.println("Menor:" + menor + "Dif:" + diferencia + "Eql:" + equilibrio);
        return menor + diferencia + equilibrio + abs(listZona.get(2).getPosition()) + abs(listZona.get(4).getPosition());
    }
    
    public void printSon(ArrayList<Zona> listZonaTemp){
        System.out.print("Hijo: " + listZonaTemp.get(1).getPosition() + " "+ listZonaTemp.get(2).getPosition() + " " + listZonaTemp.get(3).getPosition() + " "+ listZonaTemp.get(4).getPosition() + " " + listZonaTemp.get(5).getPosition());
        Order or = calculateOrder(listZonaTemp);
        System.out.println(" Heuristic: " + heuristic(or, listZonaTemp));
    }
    
    public void printMovementList(ArrayList<BestMovement> listMovement){
        System.out.println("Movimientos a realizar:");
        for(int i = 0; i < listMovement.size(); i++){
            System.out.println("Paso " + (i+1) + ": " + "Zona:" + listMovement.get(i).getZona() + " " + "Direccion:" + listMovement.get(i).getDirection());
        } 
    }
    
    public void restoreListZonaTemp(ArrayList<Zona> listZonaTemp, ArrayList<Zona> listZona){
        listZonaTemp.get(1).setPosition(listZona.get(1).getPosition());
        listZonaTemp.get(2).setPosition(listZona.get(2).getPosition());
        listZonaTemp.get(3).setPosition(listZona.get(3).getPosition());
        listZonaTemp.get(4).setPosition(listZona.get(4).getPosition());
        listZonaTemp.get(5).setPosition(listZona.get(5).getPosition());
    }
    
    public void setNewCandidate(int zona, int dir, BestMovement bm, Order orTemp, ArrayList<Zona> listZona, ArrayList<Zona> listZonaTemp, Route route, ArrayList<BestMovement> listMovement){
        bm.setZona(zona);
        bm.setDirection(dir);
        route.setListBestMovement(listMovement);
        System.out.println("Candidato con Heuristic = " + heuristic(orTemp, listZonaTemp) + " =======> ELEGIDO!!");
    }
    
    public void setChosenSon(BestMovement bm, ArrayList<Zona> listZona, ArrayList<Zona> listZonaTemp){
        int zone = bm.getZona();
        int dir = bm.getDirection();
        
        if(zone == 1){
            listZona.get(1).setPosition(listZonaTemp.get(1).getPosition() + dir);
            listZona.get(5).setPosition(listZonaTemp.get(5).getPosition() + dir);
        }
        else if(zone == 2){
            listZona.get(2).setPosition(listZonaTemp.get(2).getPosition() + dir);
        }
        else if(zone == 3){
            listZona.get(3).setPosition(listZonaTemp.get(3).getPosition() + dir);
            listZona.get(1).setPosition(listZonaTemp.get(1).getPosition() + dir);
        }
        else if(zone == 4){
            listZona.get(4).setPosition(listZonaTemp.get(4).getPosition() + dir);
        }
         else if(zone == 5){
            listZona.get(5).setPosition(listZonaTemp.get(5).getPosition() + dir);
            listZona.get(3).setPosition(listZonaTemp.get(3).getPosition() + dir);
        }
    }
    
    public Route bestMovement(Order order, ArrayList<Zona> listZona, ArrayList<Zona> listZonaTemp, ArrayList<BestMovement> listMovement){
        Route route = new Route();
        BestMovement bm = new BestMovement();
        Order or = calculateOrder(listZona);
        int actualHeuristic = heuristic(or, listZona);
        System.out.println("\n<==== CALCULO DE HIJOS ====> \n");
        System.out.print("<= Posicion Actual: " + listZona.get(1).getPosition() + " " + listZona.get(2).getPosition() + " " + listZona.get(3).getPosition() + " "+ listZona.get(4).getPosition() + " " + listZona.get(5).getPosition());
        System.out.println(" - Heuristic:" + actualHeuristic + " =>\n");
        
        restoreListZonaTemp(listZonaTemp, listZona);
        //Mover ZONA 1 a la Izquierda
        System.out.println("=> Hijo Zona 1 Izquierda");
        listZonaTemp.get(1).setPosition(listZona.get(1).getPosition() - 1);
        listZonaTemp.get(5).setPosition(listZona.get(5).getPosition() - 1);
        Order orTemp = calculateOrder(listZonaTemp);
        printSon(listZonaTemp);
        if(heuristic(orTemp, listZonaTemp) < actualHeuristic){
            setNewCandidate(1, -1, bm, orTemp, listZona, listZonaTemp, route, listMovement);
            actualHeuristic = heuristic(orTemp, listZonaTemp);
        }
        restoreListZonaTemp(listZonaTemp, listZona);
        //Mover ZONA 1 a la Derecha
        System.out.println("=> Hijo Zona 1 Derecha");
        listZonaTemp.get(1).setPosition(listZona.get(1).getPosition() + 1);
        listZonaTemp.get(5).setPosition(listZona.get(5).getPosition() + 1);
        orTemp = calculateOrder(listZonaTemp);
        printSon(listZonaTemp);
        if(heuristic(orTemp, listZonaTemp) < actualHeuristic){
            setNewCandidate(1, 1, bm, orTemp, listZona, listZonaTemp, route, listMovement);
            actualHeuristic = heuristic(orTemp, listZonaTemp);
        }
        restoreListZonaTemp(listZonaTemp, listZona);
        
        //Mover ZONA 2 a la Izquierda
        System.out.println("=> Hijo Zona 2 Izquierda");
        listZonaTemp.get(2).setPosition(listZona.get(2).getPosition() - 1);
        orTemp = calculateOrder(listZonaTemp);
        printSon(listZonaTemp);
        if(heuristic(orTemp, listZonaTemp) < actualHeuristic){
            setNewCandidate(2, -1, bm, orTemp, listZona, listZonaTemp, route, listMovement);
            actualHeuristic = heuristic(orTemp, listZonaTemp);
        }
        restoreListZonaTemp(listZonaTemp, listZona);
        //Mover ZONA 2 a la Derecha
        System.out.println("=> Hijo Zona 2 Derecha");
        listZonaTemp.get(2).setPosition(listZona.get(2).getPosition() + 1);
        orTemp = calculateOrder(listZonaTemp);
        printSon(listZonaTemp);
        if(heuristic(orTemp, listZonaTemp) < actualHeuristic){
            setNewCandidate(2, 1, bm, orTemp, listZona, listZonaTemp, route, listMovement);
            actualHeuristic = heuristic(orTemp, listZonaTemp);
        }
        restoreListZonaTemp(listZonaTemp, listZona);
        
        //Mover ZONA 3 a la Izquierda
        System.out.println("=> Hijo Zona 3 Izquierda");
        listZonaTemp.get(3).setPosition(listZona.get(3).getPosition() - 1);
        listZonaTemp.get(1).setPosition(listZona.get(1).getPosition() - 1);
        orTemp = calculateOrder(listZonaTemp);
        printSon(listZonaTemp);
        if(heuristic(orTemp, listZonaTemp) < actualHeuristic){
            setNewCandidate(3, -1, bm, orTemp, listZona, listZonaTemp, route, listMovement);
            actualHeuristic = heuristic(orTemp, listZonaTemp);
        }
        restoreListZonaTemp(listZonaTemp, listZona);
        //Mover ZONA 3 a la Derecha
        restoreListZonaTemp(listZonaTemp, listZona);
        System.out.println("=> Hijo Zona 3 Derecha");
        listZonaTemp.get(3).setPosition(listZona.get(3).getPosition() + 1);
        listZonaTemp.get(1).setPosition(listZona.get(1).getPosition() + 1);
        orTemp = calculateOrder(listZonaTemp);
        printSon(listZonaTemp);
        if(heuristic(orTemp, listZonaTemp) < actualHeuristic){
            setNewCandidate(3, 1, bm, orTemp, listZona, listZonaTemp, route, listMovement);
            actualHeuristic = heuristic(orTemp, listZonaTemp);
        }
        restoreListZonaTemp(listZonaTemp, listZona);
        
        //Mover ZONA 4 a la Izquierda
        System.out.println("=> Hijo Zona 4 Izquierda");
        listZonaTemp.get(4).setPosition(listZona.get(4).getPosition() - 1);
        orTemp = calculateOrder(listZonaTemp);
        printSon(listZonaTemp);
        if(heuristic(orTemp, listZonaTemp) < actualHeuristic){
            setNewCandidate(4, -1, bm, orTemp, listZona, listZonaTemp, route, listMovement);
            actualHeuristic = heuristic(orTemp, listZonaTemp);
        }
        restoreListZonaTemp(listZonaTemp, listZona);
        //Mover ZONA 4 a la Derecha
        System.out.println("=> Hijo Zona 4 Derecha");
        listZonaTemp.get(4).setPosition(listZona.get(4).getPosition() + 1);
        orTemp = calculateOrder(listZonaTemp);
        printSon(listZonaTemp);
        if(heuristic(orTemp, listZonaTemp) < actualHeuristic){
            setNewCandidate(4, 1, bm, orTemp, listZona, listZonaTemp, route, listMovement);
            actualHeuristic = heuristic(orTemp, listZonaTemp);
        }
        restoreListZonaTemp(listZonaTemp, listZona);
        
        //Mover ZONA 5 a la Izquierda
        restoreListZonaTemp(listZonaTemp, listZona);
        System.out.println("=> Hijo Zona 5 Izquierda");
        listZonaTemp.get(5).setPosition(listZona.get(5).getPosition() - 1);
        listZonaTemp.get(3).setPosition(listZona.get(3).getPosition() - 1);
        orTemp = calculateOrder(listZonaTemp);
        printSon(listZonaTemp);
        if(heuristic(orTemp, listZonaTemp) < actualHeuristic){
            setNewCandidate(5, -1, bm, orTemp, listZona, listZonaTemp, route, listMovement);
            actualHeuristic = heuristic(orTemp, listZonaTemp);
        }
        restoreListZonaTemp(listZonaTemp, listZona);
        //Mover ZONA 5 a la Derecha
        restoreListZonaTemp(listZonaTemp, listZona);
        System.out.println("=> Hijo Zona 5 Derecha");
        listZonaTemp.get(5).setPosition(listZona.get(5).getPosition() + 1);
        listZonaTemp.get(3).setPosition(listZona.get(3).getPosition() + 1);
        orTemp = calculateOrder(listZonaTemp);
        printSon(listZonaTemp);
        if(heuristic(orTemp, listZonaTemp) < actualHeuristic){
            setNewCandidate(5, 1, bm, orTemp, listZona, listZonaTemp, route, listMovement);
            actualHeuristic = heuristic(orTemp, listZonaTemp);
        }
        restoreListZonaTemp(listZonaTemp, listZona);

        setChosenSon(bm, listZona, listZonaTemp);
        
        listMovement.add(bm);
        
        //System.out.println("Higher:" + or.getHigher() + "Medium:" + or.getMedium() + "Minor" + or.getMinor());
        return route;
    } 
}