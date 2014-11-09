/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EN;

import java.util.ArrayList;

/**
 *
 * @author Cana
 */
public class Route {
    private ArrayList<BestMovement> listBestMovement;
    private Order ord;
    private ArrayList<Zona> listZona;

    /**
     * @return the listBestMovement
     */
    public ArrayList<BestMovement> getListBestMovement() {
        return listBestMovement;
    }

    /**
     * @param listBestMovement the listBestMovement to set
     */
    public void setListBestMovement(ArrayList<BestMovement> listBestMovement) {
        this.listBestMovement = listBestMovement;
    }

    /**
     * @return the ord
     */
    public Order getOrd() {
        return ord;
    }

    /**
     * @param ord the ord to set
     */
    public void setOrd(Order ord) {
        this.ord = ord;
    }

    /**
     * @return the listZona
     */
    public ArrayList<Zona> getListZona() {
        return listZona;
    }

    /**
     * @param listZona the listZona to set
     */
    public void setListZona(ArrayList<Zona> listZona) {
        this.listZona = listZona;
    }
    
}
