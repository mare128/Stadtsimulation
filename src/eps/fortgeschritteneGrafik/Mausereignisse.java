package eps.fortgeschritteneGrafik;

import java.awt.event.MouseEvent; 
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import eps.fortgeschritteneGrafik.interna.Zeichenfenster; 

import javax.swing.JFrame; 

public class Mausereignisse extends JFrame implements MouseListener { 

    public Mausereignisse() {
        Zeichenfenster.zeichenfensterGeben().addMouseListener(this);
        this.addMouseListener(this); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setTitle("Maus Ereignisse"); 
        this.setSize(600, 400); 
        this.setLocationRelativeTo(null); 
        this.setVisible(true); 
    } 

    @Override 
    public void mouseClicked(MouseEvent e) { 
        System.out.println("Mouse " + e.getClickCount() + " times clicked at " 
                + e.getPoint()); 
    } 

    @Override 
    public void mousePressed(MouseEvent e) { 
        System.out.println("Mouse " + e.getClickCount() + " times pressed at " 
                + e.getPoint()); 
    } 

    @Override 
    public void mouseReleased(MouseEvent e) { 
        System.out.println("Mouse " + e.getClickCount() + " times released at " 
                + e.getPoint()); 
    } 

    @Override 
    public void mouseEntered(MouseEvent e) { 
        System.out.println("Mouse entered at " + e.getPoint()); 
    } 

    @Override 
    public void mouseExited(MouseEvent e) { 
        System.out.println("Mouse exited at " + e.getPoint()); 
    } 

    public static void main(String[] args) { 
        new Mausereignisse(); 
    } 
}