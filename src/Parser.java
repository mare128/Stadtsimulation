
public class Parser {
	private Map map;
	private Language language;
	private Saves saves;
	private Settings settings;
private int lengthCars;
private int widthCars;
private int lengthHouses;
	
	public Parser(){
lengthCars = 1000;
widthCars = 3;
lengthHouses= 2000;
		map = new Map(lengthCars, widthCars, lengthHouses);
		language= new Language(100);
		saves = new Saves(lengthCars, widthCars, lengthHouses);
		settings = new Settings(100);

		
		
	}
	
	// Rückgabetyp void oder Array-String? 
	// language: german or english
	public void loadLanguage(String name){
		if (name.equals("german")){
		language.createGerman();
		language.getArrayLanguage();}
		else if (name.equals("english")){
			language.createEnglish();
			language.getArrayLanguage();
		}
	}
	
	// small, medium or large map
	// Verwendung der Map?
	public void loadHousesMap(String name){
		if (name.equals("small")){
			map.createSmallHousesMap();
			map.getMapHousesArray();}
		else if (name.equals("medium")){
			map.createMediumHousesMap();
			map.getMapHousesArray();}
		else if (name.equals("large")){
			map.createLargeHousesMap();
			map.getMapHousesArray();}

	};
	public void loadSettings(String name){
		if (name.equals("settings1")){
			settings.createSettings1();
			settings.getArraySettings();}
	};
	
	public void writeCars(int p1, int p2, String content){
	map.writeCars(p1, p2, content);
	}
	public void writeHouses(int position, String content){
		map.writeHouses(position, content);
		}
	
	public void saveCars(int number){
		saves.saveCars(number, map.getMapCarsArray());
	}
public void saveHouses(int number){
		saves.saveHouses(number, map.getMapHousesArray());
	}

	
	// Rückgabewert void oder String[][]?
	public String[][] loadSavedCars(int number){
		  
		String[][] array = new String[lengthCars][widthCars];
		array= saves.loadCars(number);
		map.setCarsMap(array);
		return array;

	}
public String[] loadSavedHouses(int number){
		  
		String[] array = new String[lengthHouses];
		array= saves.loadHouses(number);
		map.setHousesMap(array);
		return array;

	}

}
