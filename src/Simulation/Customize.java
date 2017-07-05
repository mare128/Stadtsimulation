package Simulation;

public class Customize {

	private int[] buildings;
	private SimulationCalculator SimulationCalculator;

	public Customize(SimulationCalculator sc){
		this.SimulationCalculator = sc;
		buildings = new int[1200];
		buildings = SimulationCalculator.getMap();
		
	}
	
	public void changeFunction(int ID, int function){
		buildings[ID]= function;
	}
}
