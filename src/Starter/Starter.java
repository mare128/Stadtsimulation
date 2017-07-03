package Starter;

import Zeichenfenster.MyFrame;
import java.awt.Color;
import Zeichenfenster.MouseAndKeyListener;
import Zeichenfenster.Rechteck;
import Zeichenfenster.MyButton;

public class Starter {

	
	public static void main(String[] args) {
		MyFrame j = new MyFrame(Color.gray);
		MyButton button1 = new MyButton(j, 100, 30, 70, 20, "test");
		new Rechteck(j, 600, 34, 200, 300, Color.green);
		new MouseAndKeyListener(j);
		button1.buttonPressed();
	}

}
