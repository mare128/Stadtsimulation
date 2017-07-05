
public class Parser {
	// Zugriffsrechte?!?
	protected Houses houses;
	protected Language language;
	protected Cars cars;
	protected Settings settings;
private int lengthCars;
private int widthCars;
private int lengthHouses;
	
	public Parser(){
lengthCars = 1000;
widthCars = 3;
lengthHouses= 2000;
		cars = new Cars(lengthCars, widthCars);
		language= new Language(100, "german");
		settings = new Settings(10);
		houses = new Houses(lengthHouses);

		
		
	}
	
	

	
	

}
