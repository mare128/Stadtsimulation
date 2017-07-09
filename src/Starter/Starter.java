package Starter;

import java.awt.Color;

import Simulation.SimulationCalculator;
import Zeichenfenster.MouseAndKeyListener;
import Zeichenfenster.MyCanvas;
import Zeichenfenster.OpeningScreen;

public class Starter {
	
	private SimulationCalculator sc;
	
	public static void main(String[] args) {
		OpeningScreen os = new OpeningScreen(Color.white);
		MyCanvas c = new MyCanvas(os.getPanel(), 0, 0, 0, 0, null);
		new MouseAndKeyListener(os);
		SimulationCalculator sc = new SimulationCalculator();
		sc.startSimulation();
	}

}
