
public class Language extends File {
	private String[] language;

	
	public Language(int length){
		 language = new String[length];
	}
	
@Override
public String getFromFile(int position){
	return language[position];
}

public void write(String content, int position){
	language[position] = content;
}

public void createGerman(){
	
	
}

public void createEnglish(){
	
}



public String[] getArrayLanguage(){
	return language;
}
}
