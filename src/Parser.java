
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
lengthBuildings= 1056;
		cars = new Cars(lengthCars, widthCars);
		language= new Language(100, "german");
		settings = new Settings(10);
		buildings = new Buildings(lengthBuildings);

		
		
	}
	public String[] loadLanguage(int number){
		String[] array = language.loadSavedArray(number);
		return array;
	}
	
	public int getVisits(){
		int number=settings.getVisits();
		return number;
	}
	
	public String[] loadMap(String size){
		String[] array=buildings.loadMap(size);
		return array;
		
	}
	

	
	

}
