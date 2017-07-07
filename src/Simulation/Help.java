package Simulation;

public class Help {

	private SimulationCalculator sc;
	
	public Help(SimulationCalculator sim){
		sc=sim;
	}
	
	public void startTutorial(){
		sc.enterMenu();
		//menü öffnen also halt oben in dieser zeile so wie dus machen wolltest und dann brauchen wir halt dass die verschiedenen Menüfunktionen da sind = enterMenu() Methode schreiben
		//dann brauch ich ein Textfeld in einem Zeichenfenster daneben und 2 Knöpfe in die ich was schreiben kann
		//im menü brauch ich dann die Rückgabe welche Mapgröße gewählt wurde
	}
	
	public void endTutorial(){
		
	}
	
	public void showHelp(){
		
	}
	
	public void closeHelp(){
		
	}
}
