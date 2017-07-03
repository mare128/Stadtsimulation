package Zeichenfenster;

import java.awt.Color;

import javax.swing.JFrame;

public class MyFrame extends JFrame{

	public MyFrame(Color color){
		setTitle("Stadtsimulation");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1920, 1080);
		setLocation(0, 0);
		setVisible(true);
		setBackground(color);
	}	
}
