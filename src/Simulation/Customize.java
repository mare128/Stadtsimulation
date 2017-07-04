package Simulation;

public class Customize {

	private int[][] buildings;
	private SimulationCalculator SimulationCalculator;

	public Customize(SimulationCalculator sc){
		this.SimulationCalculator = sc;
		buildings = new int[2000][1];
		SimulationCalculator.getMap();
		
	}
	
	public void changeFunction(int ID, int function){
		buildings[ID][0] = function;
	}
	public void reserveBuilding(int ID, int function){
		
		
	}
}
