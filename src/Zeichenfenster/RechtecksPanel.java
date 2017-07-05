package Zeichenfenster;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class RechtecksPanel extends JPanel {
	
	private int width;
	private int height;
	private int x;
	private int y;
	private Color color;
	
	public RechtecksPanel(int x, int y, int width, int height, Color color){
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		this.color = color;
	}
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.fillRect(x, y, width, height);
        g2d.setColor(color);
    }
}
