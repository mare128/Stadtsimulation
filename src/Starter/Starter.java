package Starter;

import Zeichenfenster.GameScreen;
import Zeichenfenster.OpeningScreen;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;

import Zeichenfenster.MouseAndKeyListener;
import Zeichenfenster.MyButton;
import Zeichenfenster.MyCanvas;

public class Starter {
	
	public static void main(String[] args) {
		OpeningScreen os = new OpeningScreen(Color.white);
		MyCanvas c = new MyCanvas(os.getPanel());
		c.paint(null);
		new MouseAndKeyListener(os);
	}

}
