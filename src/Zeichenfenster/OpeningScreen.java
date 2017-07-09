package Zeichenfenster;

import java.awt.Color;

import com.sun.imageio.stream.StreamCloser.CloseAction;

public class OpeningScreen extends MyFrame{

	private MyButton b1;
	private MyButton b2;
	private MyButton b3;
	
	public OpeningScreen(Color color){
		super(color);
		b1 = new MyButton(p, 810, 480, 300, 50, "Spiel starten");
		b2 = new MyButton(p, 810, 550, 300, 50, "Beenden");
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}
}
