package Zeichenfenster;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class Rechteck {

	private MyFrame m;
	private RechtecksPanel p;
	
	public Rechteck(MyFrame m, int x, int y, int width, int height, Color color){
		this.m = m;
		p = new RechtecksPanel(x, y, width, height, color);
		m.add(p);
	}
}
