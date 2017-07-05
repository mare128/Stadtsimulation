package Simulation;

import Zeichenfenster.MyFrame;
import Zeichenfenster.Rechteck;

public class Car {

	private int xPosition;
	private int yPosition;
	private int ID;
	private int acceleration;
	private int destination;
	private int direction;
	private int width;
	private int height;
	private MyFrame MyFrame;
	
	public Car(int x, int y, int ID, int destination, int direction){
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
		Rechteck car = new Rechteck(MyFrame ,x, y, width, height, color);
	}
	
	public void drive(){
		
	}
	
	
}
