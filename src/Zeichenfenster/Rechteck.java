package Zeichenfenster;

import java.awt.Color;
import javax.swing.JPanel;

public class Rechteck {

	private RechtecksPanel rp;
	
	public Rechteck(JPanel p, int x, int y, int width, int height, Color color){
		rp = new RechtecksPanel(x, y, width, height, color);
		p.add(rp);
		p.setVisible(true);
	}
}
