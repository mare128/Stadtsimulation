package Zeichenfenster;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class Rechteck {

	private RechtecksPanel rp;
	
	public Rechteck(JPanel p, int x, int y, int width, int height, Color color){
		rp = new RechtecksPanel(x, y, width, height, color);
		p.add(rp);
		p.setVisible(true);
	}
}
