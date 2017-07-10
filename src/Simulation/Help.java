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
		//eine Mapgröße und die gewünschte Belegung der Häuser zurückgeben kann. Ich werde hier einfach eine eigene Belegung erstellen(nur als Beispiel).
		map = sc.getMap();
		//hier sollte der Benutzer jetzt die Belegung für jedes Gebäude festlegen können(z.B. Wohnhaus oder Polizeiwache). Ich werde das jetzt manuel machen.
		
	}
	
	public void endTutorial(){
		
	}
	
	public void showHelp(){
		
	}
	
	public void closeHelp(){
		
	}
}
