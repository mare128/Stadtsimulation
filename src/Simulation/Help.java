package Simulation;

public class Help {

	private SimulationCalculator sc;
	
	public Help(SimulationCalculator sim){
		sc=sim;
	}
	
	public void startTutorial(){
		sc.enterMenu();
		//men� �ffnen also halt oben in dieser zeile so wie dus machen wolltest und dann brauchen wir halt dass die verschiedenen Men�funktionen da sind = enterMenu() Methode schreiben
		//dann brauch ich ein Textfeld in einem Zeichenfenster daneben und 2 Kn�pfe in die ich was schreiben kann
		//im men� brauch ich dann die R�ckgabe welche Mapgr��e gew�hlt wurde
	}
	
	public void endTutorial(){
		
	}
	
	public void showHelp(){
		
	}
	
	public void closeHelp(){
		
	}
}
