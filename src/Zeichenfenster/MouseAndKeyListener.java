package Zeichenfenster;

import java.awt.event.MouseEvent; import java.awt.event.MouseListener;
import java.awt.event.KeyListener; 
import java.awt.event.KeyEvent;


public class MouseAndKeyListener implements MouseListener, KeyListener { 
	
    public MouseAndKeyListener(MyFrame j) {
        j.addMouseListener(this); 
        j.addKeyListener(this);
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
    
    public void keyTyped(KeyEvent e) {
        System.out.println("KeyTyped: ");
        if(e.getKeyChar() == KeyEvent.CHAR_UNDEFINED){
            System.out.println("Kein Unicode-Character gedr\u00FCckt!");
        }else{
            System.out.println(e.getKeyChar() + " gedr\u00FCckt!");
        }
        System.out.println("---");
    }
    public void keyPressed(KeyEvent e) {
        System.out.println("Taste: " + e.getKeyChar() + ", Code: " + e.getKeyCode());
        System.out.println("Tastenposition: " + e.getKeyLocation());
        System.out.println("---");
    }

    public void keyReleased(KeyEvent e) {
        System.out.println("KeyReleased: ");
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            System.out.println("Programmabbruch!");
            System.exit(0);
        }    
        System.out.println("Taste: " + e.getKeyChar() + ", Code: " + e.getKeyCode());
        System.out.println("---");
    }
    
}
