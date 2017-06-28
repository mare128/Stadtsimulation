package Starter;

import Zeichenfenster.MyFrame;

import java.awt.Color;

import Zeichenfenster.Mausereignisse;
import Zeichenfenster.Rechteck;

public class Starter {

	public static void main(String[] args) {
		MyFrame j = new MyFrame();
		new Mausereignisse(j);
		new Rechteck(j, 600, 34, 200, 300, Color.green);
	}

}
