package Data;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Houses extends File {
	
	//small, medium, large or saved Map
	public Houses(int length) {
		super(length);
		name = "houses";
		
	}
	
	// size= small/medium/large
	public String[] loadMap(String size)
	{
		String filename = size+"Map"+".txt";
	    BufferedReader reader;
	    
	   
	String[] values= new String[(lengthArray)];
	    try {
	        reader = new BufferedReader(new FileReader(filename));
	        String line = reader.readLine();
	        
	        	 values = line.split(";");
	             
	                                  for (int position = 0; position < (lengthArray); position++) {
	                                  
	                                	  array[position]= values[position];
	                                	
	                                  
	                                  }             
	                reader.close();
	        return array;             
	    }
	    catch (IOException e) {
	        e.printStackTrace();
	    }
		return array;
	}


}
