package Starter;

import Simulation.SimulationCalculator;

public class Starter {
	
	private SimulationCalculator sc;
	
	public static void main(String[] args) {
		SimulationCalculator sc = new SimulationCalculator();
		sc.startSimulation();
	}

}
