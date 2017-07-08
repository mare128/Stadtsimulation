package Zeichenfenster;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class MyCanvas{
	
	private int x;
	private int y;
	private int width;
	private int height;
	private Color color;
	private Canvas c;
	
	public MyCanvas(JPanel p){
		c = new Canvas();
		c.setBounds(0, 0, 100, 100);
		p.add(c);
	}
	
	public void paint(Graphics g){
		g.setColor(Color.black);
		g.fillRect(0, 0, 100, 100);
	}
	public void test(){
		
	}
}
