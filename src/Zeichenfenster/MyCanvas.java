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
	
	public MyCanvas(JPanel p,int x, int y, int width, int height, Color color){
		this.color = color;
		this.height = height;
		this.width = width;
		this.x = x;
		this.y = y;
		c = new Canvas();
		c.setBounds(x, y, width, height);
		c.setBackground(color);
		p.add(c);
	}
	
	public void paint(Graphics g){
		g.setColor(Color.black);
		g.fillRect(x, y, width, height);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public void moveX(int x){
		this.x = x;
	}
	
	public void moveY(int y){
		this.y = y;
	}
	
	public void logOut(){
		c.setVisible(false);;
	}
	
	public void logIn(){
		c.setVisible(true);
	}
}
