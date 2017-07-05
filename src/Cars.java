import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Cars {
	private String[][] array;
	
	private int lengthArray;
	private int widthArray;
	private String name;

// numeration starts with 0
	public Cars(int length, int width){
		array = new String[length][width];
		name = "cars";
	
lengthArray = length;
widthArray = width;
	}
	public void writeCars(int arrayPosition, String xposition, String yposition, String direction) {
		array[arrayPosition][0]= xposition;
		array[arrayPosition][1]= yposition;
		array[arrayPosition][2]= direction;

	}
	
	public Wraperclass getCars(int arrayPosition){
		String xpos= array[arrayPosition][0];
		String ypos= array[arrayPosition][1];
		String dir= array[arrayPosition][2];


		Wraperclass wraperclass = new Wraperclass(xpos, ypos, dir);
		return wraperclass;
	}

	// position: 0--> x position, 1 --> y position, 2--> direction
	public String getFromFile(int arrayPosition, int position) {
		return array[arrayPosition][position];
		
	}
	
	// position: 0--> x position, 1 --> y position, 2--> direction
	public void write(int arrayPosition,int position,  String content) {
		array[arrayPosition][position]= content;
		
	}
	
	public String[][] getArray(){
		return array;
	}
	
	public void saveArray(int number)
    { String filename =name + number+ ".txt";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
                        for (int p1 = 0; p1 < lengthArray; p1++) {
                        	for (int p2 = 0; p2< widthArray; p2++)
					if(p2!= widthArray&& p1!=lengthArray){
                                   writer.write(array[p1][p2] + ";");}
					else{writer.write(array[p1][p2]);}
                        			
        }writer.close();}
        catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public String[][] loadSavedArray(int number)
    {
		String filename = name+ number+".txt";
        BufferedReader reader;
        int valuesArray;
        valuesArray = 0;
	String[] values= new String[(lengthArray*widthArray+1)];
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            
            	 values = line.split(";");
            	 while(line != null) {
                 
                                      for (int p1 = 0; p1 < (lengthArray); p1++) {
                                      for(int p2 = 0; p2 < widthArray; p2++){
                                    	  array[p1][p2]= values[valuesArray];
                                    	  valuesArray++;
                                      }
                                      }}             
                    reader.close();
            return array;             
        }
        catch (IOException e) {
            e.printStackTrace();
        }
		return array;
}
}
