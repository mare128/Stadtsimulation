package Simulation;

public class Help {

	private SimulationCalculator sc;
	private Customize customize;
	private String[] map;
	
	public Help(SimulationCalculator sc, Customize customize){
		this.sc =sc;
		this.customize = customize;
	}
	
	public void startTutorial(){
		//Hier sollte mir nach einer kurzen Einweisung eine Mapgröße zurückgegeben werden. Das Tutorial entfällt, da man auf Grund fehlendem MVC-Modells weder fortfahren kann, noch
		//eine Mapgröße und die gewünschte Belegung der Häuser zurückgeben kann.
		map = sc.getMap();
		//hier sollte der Benutzer jetzt die Belegung für jedes Gebäude festlegen können(z.B. Wohnhaus oder Polizeiwache).
		
	}
	
	public void endTutorial(){
		//durch Benutzereingabe sollte hier das Tutorial beendet werden können.
	}
	
	public void showHelp(){
		//durch Benutzereingabe sollte hier ein Hilfefenster aufgerufen werden können.
	}
	
	public void closeHelp(){
		//durch Benutzereingabe sollte hier das Hilfefenster beendet werden können.
	}
}
