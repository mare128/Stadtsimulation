import java.io.*;


public class Saves extends File {
	private String[][] savesArray;
	private int lengthArray;

	public Saves(int length){
		String [][] savesArray = new String[length][10];
		lengthArray = length;
	}

	public String getFromFile(int p1, int p2){
		return savesArray[p1][p2];
	};
	public void write(int p1, int p2, String content){
		savesArray[p1][p2]= content;
	};

	public String[][] getArraySaves(){
	return savesArray;
	};
	
	public void save(String name, String[][] map)
    { String filename = name+ ".txt";
    savesArray = map;
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
                        for (int p1 = 0; p1 < lengthArray; p1++) {
                        	for (int p2 = 0; p2< 10; p2++)
                                   writer.write(savesArray[p1][p2] + ";");
                        			writer.close();
        }}
        catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	// Datei name, mehrfach speichern
	public String[][] load(String name)
    {
		String filename = name+ ".txt";
        BufferedReader reader;
        int valuesArray;
        valuesArray = 0;
        try {
            reader = new BufferedReader(new FileReader(filename));
            String zeile = reader.readLine();
            while (zeile != null) {
            	 String[] values = zeile.split(";");
                 
                                      for (int p1 = 0; p1 < (lengthArray); p1++) {
                                      for(int p2 = 0; p2 < 10; p2++){
                                    	  savesArray[p1][p2]= values[valuesArray];
                                    	  valuesArray++;
                                      }
                                      }             
                    
                         }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
		return savesArray;
}
}
