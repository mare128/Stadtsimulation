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
		//Hier sollte mir nach einer kurzen Einweisung eine Mapgr��e zur�ckgegeben werden. Das Tutorial entf�llt, da man auf Grund fehlendem MVC-Modells weder fortfahren kann, noch
		//eine Mapgr��e und die gew�nschte Belegung der H�user zur�ckgeben kann. Ich werde hier einfach eine eigene Belegung erstellen(nur als Beispiel).
		map = sc.getMap();
		//hier sollte der Benutzer jetzt die Belegung f�r jedes Geb�ude festlegen k�nnen(z.B. Wohnhaus oder Polizeiwache). Ich werde das jetzt manuel machen.
		
	}
	
	public void endTutorial(){
		//durch Benutzereingabe sollte hier das Tutorial beendet werden k�nnen.
	}
	
	public void showHelp(){
		//durch Benutzereingabe sollte hier ein Hilfefenster aufgerufen werden k�nnen.
	}
	
	public void closeHelp(){
		//durch Benutzereingabe sollte hier das Hilfefenster beendet werden k�nnen.
	}
}
