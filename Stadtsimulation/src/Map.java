
public class Map extends File {
private String[][] mapArray;


// numeration starts with 0
	public Map(int length){
		String [][] mapArray = new String[length][10];
		
	}
	
	public void createSmallMap(){
		//write() content map
	}
	
	public void createMediumMap(){
		//write() content map
	}

	public void createLargeMap(){
		//write() content map
	}


public String getFromFile(int p1, int p2){
	return mapArray[p1][p2];
}

public void write(int p1, int p2, String content){
	mapArray[p1][p2] = content;
}
public void setMap(String[][] map){
	mapArray= map;
}

public String[][] getArrayMap(){
	return mapArray;
}
}
