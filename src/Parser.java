
public class Parser {
	private Map map;
	private Language language;
	private Saves saves;

	private Settings settings;
	
	public Parser(){
		map = new Map(1000);
		language= new Language(100);
		saves = new Saves(1000);
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
	public void loadMap(String name){
		if (name.equals("small")){
			map.createSmallMap();
			map.getArrayMap();}
		else if (name.equals("medium")){
			map.createMediumMap();
			map.getArrayMap();}
		else if (name.equals("large")){
			map.createLargeMap();
			map.getArrayMap();}

	};
	public void loadSettings(String name){
		if (name.equals("settings1")){
			settings.createSettings1();
			settings.getArraySettings();}
	};
	
	public void writeMap(int p1, int p2, String content){
	map.write(p1, p2, content);
	}
	
	//saves1, saves2, saves3, saves4, saves5
	public void saveMap(String name){
		
		
		saves.save(name, map.getArrayMap());
	}
	
	// Rückgabewert void oder String[][]?
	public void loadSavedMap(String name){
		  
		map.setMap(saves.load(name));
		


	};

}
