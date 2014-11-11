/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LN;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
 
public class JPanelImagenGiratoria extends javax.swing.JPanel {
 
    private int grados = 0;
    private int grados2 = 0;
    private int grados3 = 0;
    private int grados4 = 0;
    private int grados5 = 0;
    private String path;
    private String path2;
    private String path3;
    private String path4;
    private String path5;
    private String path6;
    private int y;
    private int x;
 
    public int getGrados() {
        return grados;
    }
 
    public void setGrados(int grados) {
        this.grados += grados;
        grados5 += grados;
        repaint();
    }

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the grados2
     */
    public int getGrados2() {
        return grados2;
    }

    /**
     * @param grados2 the grados2 to set
     */
    public void setGrados2(int grados2) {
        this.grados2 += grados2;
        repaint();
    }

    /**
     * @return the path2
     */
    public String getPath2() {
        return path2;
    }

    /**
     * @param path2 the path2 to set
     */
    public void setPath2(String path2) {
        this.path2 = path2;
    }

    /**
     * @return the grados3
     */
    public int getGrados3() {
        return grados3;
    }

    /**
     * @param grados3 the grados3 to set
     */
    public void setGrados3(int grados3) {
        //this.grados3 = grados3;
        this.grados3 += grados3;
        this.grados += grados3;
        repaint();
    }

    /**
     * @return the grados4
     */
    public int getGrados4() {
        return grados4;
    }

    /**
     * @param grados4 the grados4 to set
     */
    public void setGrados4(int grados4) {
        this.grados4 += grados4;
        repaint();
    }

    /**
     * @return the path3
     */
    public String getPath3() {
        return path3;
    }

    /**
     * @param path3 the path3 to set
     */
    public void setPath3(String path3) {
        this.path3 = path3;
    }

    /**
     * @return the path4
     */
    public String getPath4() {
        return path4;
    }

    /**
     * @param path4 the path4 to set
     */
    public void setPath4(String path4) {
        this.path4 = path4;
    }

    /**
     * @return the path5
     */
    public String getPath5() {
        return path5;
    }

    /**
     * @param path5 the path5 to set
     */
    public void setPath5(String path5) {
        this.path5 = path5;
        repaint();
    }

    /**
     * @return the path6
     */
    public String getPath6() {
        return path6;
    }

    /**
     * @param path6 the path6 to set
     */
    public void setPath6(String path6) {
        this.path6 = path6;
    }

    /**
     * @return the grados5
     */
    public int getGrados5() {
        return grados5;
    }

    /**
     * @param grados5 the grados5 to set
     */
    public void setGrados5(int grados5) {
        //this.grados5 = grados5;
        this.grados5 += grados5;
        this.grados3 += grados5;
        repaint();
    }
    
    public void moveZone(int _zone,int _direction){
        int degrees = _direction * 30;
        switch(_zone){
            case 1: 
                setGrados(degrees);
                break;
            case 2: 
                setGrados2(degrees);
                break;
            case 3: 
                setGrados3(degrees);
                break;
            case 4: 
                setGrados4(degrees);
                break;
            case 5: 
                setGrados5(degrees);
                break;
            default:
                break;
        }
                
    }
    
    @Override
    public void paint(Graphics g) {
        
        try {
            //Erase previous paint
            super.paint(g);
            
            //Convert radians to degrees
            double r = Math.toRadians(getGrados());
            double r2 = Math.toRadians(getGrados2());
            double r3 = Math.toRadians(getGrados3());
            double r4 = Math.toRadians(getGrados4());
            double r5 = Math.toRadians(getGrados5());
            
            //Load images into buffer
            BufferedImage img = ImageIO.read(new File(getPath()));
            BufferedImage img2 = ImageIO.read(new File(getPath2()));
            BufferedImage img3 = ImageIO.read(new File(getPath3()));
            BufferedImage img4 = ImageIO.read(new File(getPath4()));
            BufferedImage img5 = ImageIO.read(new File(getPath5()));
            BufferedImage img6 = ImageIO.read(new File(getPath6()));
            
            //Rotate and draw Objects
            AffineTransform at = new AffineTransform();
            at.rotate(r, img.getWidth()/2, img.getHeight()/2);
            ((Graphics2D) g).setTransform(at);
            g.drawImage(img, getX(), getY(), this);
            
            AffineTransform at2 = new AffineTransform();
            at2.rotate(r2, (img2.getWidth())/2, (img2.getHeight())/2);            
            ((Graphics2D) g).setTransform(at2);
            g.drawImage(img2, getX(), getY(), this);
            
            AffineTransform at3 = new AffineTransform();
            at3.rotate(r3, (img3.getWidth())/2, (img3.getHeight())/2);
            ((Graphics2D) g).setTransform(at3);
            g.drawImage(img3, getX(), getY(), this);
            
            AffineTransform at4 = new AffineTransform();
            at4.rotate(r4, (img4.getWidth())/2, (img4.getHeight())/2);
            ((Graphics2D) g).setTransform(at4);
            g.drawImage(img4, getX(), getY(), this);
            
            AffineTransform at5 = new AffineTransform();
            at5.rotate(r5, (img5.getWidth())/2, (img5.getHeight())/2);
            ((Graphics2D) g).setTransform(at5);
            g.drawImage(img5, getX(), getY(), this);
            
            AffineTransform at6 = new AffineTransform();
            at6.rotate(Math.toRadians(0), (img6.getWidth())/2, (img6.getHeight())/2);
            ((Graphics2D) g).setTransform(at6);
            g.drawImage(img6, getX(), getY(), this);
            
        } catch (IOException ex) {
            Logger.getLogger(JPanelImagenGiratoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}