package figura;
import LN.JPanelImagenGiratoria;
import EN.*;
import LN.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.JFrame;
 
public class Figura{
    
    
 
    public static void main(String[] args) {
        final JFrame jf = new JFrame("Prueba Imagen Giratoria");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(500, 525);
 
        final JPanelImagenGiratoria ig = new JPanelImagenGiratoria();
        
        ig.setPath("images/Glyph_20-Anillo1.png");
        ig.setPath2("images/Glyph_20-Anillo2.png");
        ig.setPath3("images/Glyph_20-Anillo3.png");
        ig.setPath4("images/Glyph_20-Anillo4.png");
        ig.setPath5("images/Glyph_20-Anillo5.png");
        ig.setPath6("images/Glyph_20-Anillo6.png");
        ig.setX(0);
        ig.setY(0);
        
        final JButton jb = new JButton();
        jb.setMnemonic(KeyEvent.VK_D);
        jb.setActionCommand("rotateLeft");
        jb.addActionListener((ActionEvent e) -> {
            ig.setGrados(30);
        });

        
        
        jf.setLayout(new BorderLayout());
        jf.add(ig, BorderLayout.CENTER);
        jf.add(jb, BorderLayout.SOUTH);
 
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        aestrella ae = new aestrella();
        Zona z0 = new Zona();
        Zona z1 = new Zona();
        Zona z2 = new Zona();
        Zona z3 = new Zona();
        Zona z4 = new Zona();
        Zona z5 = new Zona();
        z1.setPosition(4);
        z2.setPosition(1);
        z3.setPosition(2);
        z4.setPosition(1);
        z5.setPosition(6);
        Zona z0temp = new Zona();
        Zona z1temp = new Zona();
        Zona z2temp = new Zona();
        Zona z3temp = new Zona();
        Zona z4temp = new Zona();
        Zona z5temp = new Zona();
        z1temp.setPosition(4);
        z2temp.setPosition(1);
        z3temp.setPosition(2);
        z4temp.setPosition(1);
        z5temp.setPosition(6);
        ArrayList<Zona> listZona = new ArrayList<>();
        listZona.add(z0);
        listZona.add(z1);
        listZona.add(z2);
        listZona.add(z3);
        listZona.add(z4);
        listZona.add(z5);
        ArrayList<Zona> listZonaTemp = new ArrayList<>();
        listZonaTemp.add(z0temp);
        listZonaTemp.add(z1temp);
        listZonaTemp.add(z2temp);
        listZonaTemp.add(z3temp);
        listZonaTemp.add(z4temp);
        listZonaTemp.add(z5temp);
        
        Order or = ae.calculateOrder(listZona);
        
        /*Prueba de calculateOrder()
        System.out.println("Minor: " + or.getMinor());
        System.out.println("Medium: " + or.getMedium());
        System.out.println("Higher: " + or.getHigher());*/
        
        /*Prueba del heuristico
        System.out.println("Heuristic: " + ae.heuristic(or));*/
        
        ArrayList<BestMovement> listMovement = new ArrayList<>();
        System.out.println("PASOS NECESARIOS: " + ae.heuristic(or, listZona));

        for(int i=0; i <= ae.heuristic(or, listZona) + 1; i++){
            listMovement = ae.bestMovement(or, listZona, listZonaTemp, listMovement).getListBestMovement();
            //listZona = ae.bestMovement(or, listZona, listMovement).getListZona();
            //or = ae.bestMovement(or, listZona, listMovement).getOrd();
        }
        
        ae.printMovementList(listMovement);
        //Este mae!!
    }
}