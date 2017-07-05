import java.io.*;


public class Saves extends File {
	private String[][] savesCarsArray;
private String[] savesHousesArray;

	private int lengthCarsArray;
private int widthCarsArray;
private int lengthHousesArray;

	public Saves(int lengthCars, int widthCars, int lengthHouses){
		savesCarsArray = new String[lengthCars][widthCars];
		lengthCarsArray = lengthCars;
widthCarsArray = widthCars;
lengthHousesArray=lengthHouses;
	}

	public String getCarsFromFile(int p1, int p2){
		return savesCarsArray[p1][p2];
	};
public String getHousesFromFile(int position){
		return savesHousesArray[position];
	};
	public void writeCars(int p1, int p2, String content){
		savesCarsArray[p1][p2]= content;
	};
public void writeHouses(int position, String content){
		savesHousesArray[position]= content;
	};

	public String[][] getSavesCarsArray(){
	return savesCarsArray;
	};
public String[] getSavesHousesArray(){
	return savesHousesArray;
	};
	
	public void saveCars(int number, String[][] mapCars)
    { String filename = "cars"+number+ ".txt";
    savesCarsArray = mapCars;
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
                        for (int p1 = 0; p1 < lengthCarsArray; p1++) {
                        	for (int p2 = 0; p2< widthCarsArray; p2++)
					if(p2!= widthCarsArray&& p1!=lengthCarsArray){
                                   writer.write(savesCarsArray[p1][p2] + ";");}
					else{writer.write(savesCarsArray[p1][p2]);}
                        			
        }writer.close();}
        catch (IOException e) {
            e.printStackTrace();
        }
    }
public void saveHouses(int number, String[] mapHouses)
    { String filename ="houses"+number+".txt";
    savesHousesArray = mapHouses;
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
                        for (int p1 = 0; p1 < lengthHousesArray; p1++) {
                        	if(p1!=lengthHousesArray){
                                   writer.write(savesHousesArray[p1] + ";");}
					else{writer.write(savesHousesArray[p1]);}
                                   
                        			
        }
                        writer.close();}
        catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	
	// Datei name, mehrfach speichern
	public String[][] loadCars(int number)
    {
		String filename = "cars"+number+".txt";
        BufferedReader reader;
        int valuesArray;
        valuesArray = 0;
	String[] values= new String[(lengthCarsArray*widthCarsArray+1)];
        try {
            reader = new BufferedReader(new FileReader(filename));
            String zeile = reader.readLine();
            
            	 values = zeile.split(";");
                 
                                      for (int p1 = 0; p1 < (lengthCarsArray); p1++) {
                                      for(int p2 = 0; p2 < widthCarsArray; p2++){
                                    	  savesCarsArray[p1][p2]= values[valuesArray];
                                    	  valuesArray++;
                                      }
                                      }             
                    reader.close();
            return savesCarsArray;             
        }
        catch (IOException e) {
            e.printStackTrace();
        }
		return savesCarsArray;
}
public String[] loadHouses(int number)
    {
		String filename = "houses"+number+".txt";
        BufferedReader reader;
        
       
	String[] values= new String[(lengthHousesArray+1)];
        try {
            reader = new BufferedReader(new FileReader(filename));
            String zeile = reader.readLine();
            
            	 values = zeile.split(";");
                 
                                      for (int position = 0; position < (lengthHousesArray); position++) {
                                      
                                    	  savesHousesArray[position]= values[position];
                                    	
                                      
                                      }             
                    reader.close();
            return savesHousesArray;             
        }
        catch (IOException e) {
            e.printStackTrace();
        }
		return savesHousesArray;
}
}
