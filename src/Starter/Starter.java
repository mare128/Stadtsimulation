package Starter;

import Simulation.SimulationCalculator;

public class Starter {
	
	private SimulationCalculator sc;
	
	public static void main(String[] args) {
		OpeningScreen os = new OpeningScreen(Color.white);
		MyCanvas c = new MyCanvas(os.getPanel());
		new MouseAndKeyListener(os);
		SimulationCalculator sc = new SimulationCalculator();
		sc.startSimulation();
	}

}
