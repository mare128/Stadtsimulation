package Starter;

import Zeichenfenster.MyFrame;
import java.awt.Color;
import java.awt.event.ActionEvent;

import Zeichenfenster.MouseAndKeyListener;
import Zeichenfenster.Rechteck;
import Zeichenfenster.MyButton;
import Zeichenfenster.MyCanvas;

public class Starter {
	
	public static void main(String[] args) {
		MyFrame launchScreen = new MyFrame(Color.white);
		MyButton button1 = new MyButton(launchScreen.getPanel(), 810, 455, 300, 50, "Spiel starten");
		MyButton button2 = new MyButton(launchScreen.getPanel(), 810, 515, 300, 50, "Optionen");
		MyButton button3 = new MyButton(launchScreen.getPanel(), 810, 575, 300, 50, "Beenden");
		MyCanvas c = new MyCanvas(launchScreen.getPanel(), 0, 340, 1920, 90, Color.black);
		new MouseAndKeyListener(launchScreen);
	}

}
