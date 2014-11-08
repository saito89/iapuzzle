package figura;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.*;
 
public class Figura{
    
    
 
    public static void main(String[] args) {
        final JFrame jf = new JFrame("Prueba Imagen Giratoria");
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
 
        /*final JSlider js = new JSlider(0, 360);
        js.addChangeListener(new javax.swing.event.ChangeListener() {
 
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                ig.setGrados(js.getValue());
            }
        });
        js.setValue(0);
        
        final JSlider js2 = new JSlider(0, 360);
        js2.addChangeListener(new javax.swing.event.ChangeListener() {
 
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                ig.setGrados2(js2.getValue());
            }
        });
        js2.setValue(0);
        */        
        
        final JButton jb = new JButton();
        jb.setMnemonic(KeyEvent.VK_D);
        jb.setActionCommand("rotateLeft");
        jb.addActionListener((ActionEvent e) -> {
            ig.setGrados(30);
        });

        
        
        jf.setLayout(new BorderLayout());
        //jf.add(js2, BorderLayout.NORTH);
        jf.add(ig, BorderLayout.CENTER);
        //jf.add(js, BorderLayout.SOUTH);
        jf.add(jb, BorderLayout.SOUTH);
 
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }
    
    
}