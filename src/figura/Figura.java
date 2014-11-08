package figura;
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
        /*final JFrame jf = new JFrame("Prueba Imagen Giratoria");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(500, 525);
 
        final JPanelImagenGiratoria ig = new JPanelImagenGiratoria();
        
        ig.setPath("images/image.jpg");
        ig.setPath2("images/nasa.jpg");
        ig.setPath3("images/pringles.gif");
        ig.setPath4("images/baseball.png");
        ig.setPath5("images/android.png");
        ig.setPath6("images/tennisBall.jpg");
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
        jf.setVisible(true);*/
        aestrella ae = new aestrella();
        zona z0 = new zona();
        zona z1 = new zona();
        zona z2 = new zona();
        zona z3 = new zona();
        zona z4 = new zona();
        zona z5 = new zona();
        z1.setPosition(4);
        z2.setPosition(-2);
        z3.setPosition(2);
        z4.setPosition(-1);
        z5.setPosition(6);
        ArrayList<zona> listZona = new ArrayList<>();
        listZona.add(z0);
        listZona.add(z1);
        listZona.add(z2);
        listZona.add(z3);
        listZona.add(z4);
        listZona.add(z5);
        
        order or = ae.calculateOrder(listZona);
        
        System.out.println("Minor: " + or.getMinor());
        System.out.println("Medium: " + or.getMedium());
        System.out.println("Higher: " + or.getHigher());
        
        System.out.println("Heuristic: " + ae.heuristic(or));
        
        ae.bestMovement(or, listZona);
        //Este mae!!
    }
    
    
}