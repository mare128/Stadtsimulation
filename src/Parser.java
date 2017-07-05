
public class Parser {
	// Zugriffsrechte?!?
	protected Buildings buildings;
	protected Language language;
	protected Cars cars;
	protected Settings settings;
private int lengthCars;
private int widthCars;
private int lengthBuildings;
	
	public Parser(){
lengthCars = 1000;
widthCars = 3;
lengthBuildings= 2000;
		cars = new Cars(lengthCars, widthCars);
		language= new Language(100, "german");
		settings = new Settings(100);
		buildings = new Buildings(lengthBuildings);

		
		
	}
	
	

	
	

}
