package Simulation;

public class Customize {

	private SimulationCalculator SimulationCalculator;
	private String[] map;
	private boolean placeable;

	public Customize(SimulationCalculator sc){
		this.SimulationCalculator = sc;
		map = sc.getMap();
	}
	
	public void changeFunction(int ID, String function){
		switch (function){
		case "1" : case "2" : case "3" : case "4" : case "5" : case "6" : case "7" : case "8" : test(ID,function); break;
		case "9" : placeable = true; break;
		}
		if(placeable = true)
		SimulationCalculator.changeFunction(ID,function);
	}
	
	public boolean test(int ID, String function){
		if((map[ID - 1].equals("street") || map[ID + 1].equals("street") || map[ID - 48].equals("street") || map[ID + 48].equals("street")) || (map[ID - 1].equals(function) || map[ID + 1].equals(function) || map[ID - 48].equals(function) || map[ID + 48].equals(function))){
			placeable = true;
		}
		else{
			placeable = false;
		}
		return placeable;
	}
}