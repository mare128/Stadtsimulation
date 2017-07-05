package Simulation;

public class Customize {

	private String[] buildings;
	private SimulationCalculator SimulationCalculator;

	public Customize(SimulationCalculator sc){
		this.SimulationCalculator = sc;
		buildings = new String[1200];
		buildings = SimulationCalculator.getMap();
		
	}
	
	public void changeFunction(int ID, String function){
		buildings[ID]= function;
	}
}
