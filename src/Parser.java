
public class Parser {
	// Zugriffsrechte?!?
	protected Buildings buildings;
	protected Language language;
	protected Cars cars;
	protected Settings settings;
private int lengthCars;
private int lengthBuildings;
	
	public Parser(){
lengthCars = 1000;

lengthBuildings= 1056;
		cars = new Cars(lengthCars);
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
	
	public void writeBuildings(int position, String content) {
		buildings.write(position, content);
	}
	
	public void saveBuildings(int number) {
		
		buildings.saveArray(number);
	}
	

	public String[] loadBuildings(int number) {
		return buildings.loadSavedArray(number);
	}
	
	public void writeCars(int position, String direction, int xPosition, int yPosition) {
	 cars.writeCars(position, direction, xPosition, yPosition);
	}
	public void saveCars(int number) {
		
		cars.saveArray(number);
	}
	
	public WraperclassCars loadCars(int number) {
		return cars.loadSavedArray(number);
		
	}

}
