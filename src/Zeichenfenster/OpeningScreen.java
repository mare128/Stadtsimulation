package Zeichenfenster;

import java.awt.Color;

public class OpeningScreen extends MyFrame{

	private MyButton b1;
	private MyButton b2;
	private MyButton b3;
	
	public OpeningScreen(Color color){
		super(color);
		b1 = new MyButton(p, 810, 455, 300, 50, "Spiel starten");
		b2 = new MyButton(p, 810, 515, 300, 50, "Optionen");
		b3 = new MyButton(p, 810, 575, 300, 50, "Beenden");
	}
}
