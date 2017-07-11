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
	private String[] map;
	private SimulationCalculator sc;
	private MyCanvas car;
	private boolean visible;
	private boolean driving;
	
	public Car(SimulationCalculator sc,JPanel p,int x, int y, int ID, int destination, int direction){
		if(direction == 0 || direction == 2 || direction == 4){
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
		car = new MyCanvas(MyFrame.getPanel() ,x, y, width, height, Color.white);		
		this.sc = sc;
		map = sc.getMap();
		visible = true;
		driving = false;
	}
	
	public void drive(){
		if(visible = true){
			int position = (( xPosition % 40 ) + ( 48 * ((yPosition - 90) % 40 )));
			boolean destinationReached = false;
			switch(direction){
			case 0 : if(destination == position + 48 || destination == position - 48); destinationReached = true; break;
			case 1 : if(destination == position + 1 || destination == position - 1); destinationReached = true; break;
			case 2 : if(destination == position + 48); destinationReached = true; break;
			case 3 : if(destination == position + 1); destinationReached = true; break;
			case 4 : if(destination == position - 48); destinationReached = true; break;
			case 5 : if(destination == position - 1); destinationReached = true; break;
			}
			if(destinationReached == false){
				driving = true;
				if(destination > position){
					if((destination % 48) > (position % 48)){
						if(map[position + 48].equals("street")){
							yPosition += 2;
							direction = 3;
							car.moveY(yPosition);
						} else if(map[position + 1].equals("street")){
							xPosition += 2;
							direction = 2;
							car.moveX(xPosition);
						} else if(map[position - 48].equals("street")){
							yPosition -= 2;
							direction = 5;
							car.moveY(yPosition);
						} else {
							xPosition -= 2;
							direction = 4;
							car.moveX(xPosition);
						}
					} else if(map[position + 48].equals("street")){
						yPosition += 2;
						direction = 3;
						car.moveY(yPosition);
					} else if(map[position + 1].equals("street")){
						xPosition -= 2;
						direction = 4;
						car.moveX(xPosition);
					} else if(map[position - 48].equals("street")){
						yPosition -= 2;
						direction = 5;
						car.moveY(yPosition);
					} else {
						xPosition += 2;
						direction = 2;
						car.moveX(xPosition);
					}
				}
				else{
					if((destination % 48) > (position % 48)){
						if(map[position + 48].equals("street")){
							yPosition -= 2;
							direction = 5;
							car.moveY(yPosition);
						} else if(map[position + 1].equals("street")){
							xPosition += 2;
							direction = 2;
							car.moveX(xPosition);
						} else if(map[position - 48].equals("street")){
							yPosition += 2;
							direction = 3;
							car.moveY(yPosition);
						} else {
							xPosition -= 2;
							direction = 4;
							car.moveX(xPosition);
						}
					} else if(map[position + 48].equals("street")){
						yPosition -= 2;
						direction = 5;
						car.moveY(yPosition);
					} else if(map[position + 1].equals("street")){
						xPosition -= 2;
						direction = 4;
						car.moveX(xPosition);
					} else if(map[position - 48].equals("street")){
						yPosition += 2;
						direction = 3;
						car.moveY(yPosition);
					} else {
						xPosition += 2;
						direction = 2;
						car.moveX(xPosition);
					}			
				}	
			}else{
				logOut();
			}
		}else{	
			logIn();
			drive();
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
	
	private void logOut(){
		car.logOut();
		visible = false;
	}
	
	private void logIn(){
		car.logIn();
		visible = true;
	}
	
	public boolean getDriving(){
		return driving;
	}
}
