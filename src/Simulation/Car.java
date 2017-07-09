package Simulation;

import java.awt.Color;

import javax.swing.JPanel;

import Zeichenfenster.MyCanvas;
import Zeichenfenster.MyFrame;

public class Car {

	private int xPosition;
	private int yPosition;
	private int ID;
	private int destination;
	private int direction;
	private int width;
	private int height;
	private MyFrame MyFrame;
	
	public Car(JPanel p,int x, int y, int ID, int destination, int direction){
		if(direction == 0){
			width = 15;
			height = 6;
		} else{
			width = 6;
			height = 15;
		}
		xPosition = x;
		yPosition = y;
		this.ID = ID;
		this.destination = destination;
		this.direction = direction;
		MyCanvas car = new MyCanvas(MyFrame.getPanel() ,x, y, width, height, Color.white);
	}
	
	public void drive(){
		if(destination >= ID){
			if((destination % 48) >= (ID % 48)){
				
			}
		}
	}
	
	public void changeDestination(int destination){
		this.destination = destination;
	}

	public int getxPosition() {
		return xPosition;
	}

	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public int getyPosition() {
		return yPosition;
	}

	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	public int getDestination() {
		return destination;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	
}
