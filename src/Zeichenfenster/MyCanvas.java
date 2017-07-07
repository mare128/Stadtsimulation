package Zeichenfenster;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class MyCanvas {
	
	private int x;
	private int y;
	private int width;
	private int height;
	private Color color;
	private Canvas c;
	
	public MyCanvas(JPanel p, int x, int y, int width, int height, Color color){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		c = new Canvas();
		c.setBounds(50, 60, 70, 80);
		p.add(c);
	}
	
	public void paint(Graphics g){
		g.setColor(Color.black);
		g.fillRect(50, 60, 70, 80);
	}
}
