package Zeichenfenster;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class KreisPanel extends JPanel{
	
	private JPanel panel;
	
	public KreisPanel(JPanel p){
		panel = new KreisPanel(p);
		p.setBounds(0, 0, 100, 100);
		p.setVisible(true);
		p.setLayout(null);
		p.add(panel);
	}
    public void paintComponent(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, 100, 100);
    }
}