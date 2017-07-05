package Starter;

import Zeichenfenster.MyFrame;
import java.awt.Color;
import Zeichenfenster.MouseAndKeyListener;
import Zeichenfenster.Rechteck;
import Zeichenfenster.MyButton;

public class Starter {

	
	public static void main(String[] args) {
		MyFrame j = new MyFrame(Color.white);		
		MyButton button1 = new MyButton(j.getPanel(), 0, 30, 70, 20, "test");
		new Rechteck(j.getPanel(), 600, 34, 200, 300, Color.green);
		new MouseAndKeyListener(j);
		button1.buttonPressed();
	}

}
