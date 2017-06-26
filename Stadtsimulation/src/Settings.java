
public class Settings extends File {
private String[] settings;

	
	public Settings(int length){
		 Settings = new String[length];
	}
	
public String getFromFile(int position){
	return settings[position];
};

public void createSettings1(){
	
}

public void write(int position, String content){
	settings[position] = content;
};

public String[] getArraySettings(){
	return settings;
};
}
