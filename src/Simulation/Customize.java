package Simulation;

public class Customize {

	private SimulationCalculator SimulationCalculator;

	public Customize(SimulationCalculator sc){
		this.SimulationCalculator = sc;
	}
	
	public void changeFunction(int ID, String function){
		switch (function){
		case "1" : case "2" : case "3" : case "4" : case "5" : case "6" : case "7" : case "8" : test(ID,function); break;
		case "9" : break;
		}
		sc.changeFunction(ID,Function);
	}
	
	public void test(int ID, String function){
		
	}
	
}
