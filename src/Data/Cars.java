package Data;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Cars {
	private int[] direction;
	private int[] destination;
	private int lengthArray;
	private String name;
	private int[] xpos;
	private int[] ypos;
	
	public Cars(int length){
		direction = new int[length];
		destination = new int[length];
		lengthArray = length;
		name = "cars";
		xpos = new int[length];
		ypos = new int[length];

	}
	public void writeCars(int arrayPosition,int dir,int dest, int xPosition, int yPosition) {
		direction[arrayPosition]= dir;
		xpos[arrayPosition]= xPosition;
		ypos[arrayPosition]=yPosition;
		destination[arrayPosition] = dest;

	}
	
	public Wrapperclass getCars(int arrayPosition){
		Wrapperclass wraperclass = new Wrapperclass(direction[arrayPosition],destination[arrayPosition],xpos[arrayPosition], ypos[arrayPosition]);
		return wraperclass;
	}

	// position: 0--> x position, 1 --> y position, 2--> direction
	
	
	public void saveArray(int number) {
     String filename =name + number+"direction"+ ".txt";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
                        for (int p1 = 0; p1 < lengthArray; p1++) {
                        	
					if( p1!=lengthArray){
                                   writer.write(direction[p1]+ ";");}
					else{writer.write(direction[p1]);}
                        			
        }writer.close();}
        
        catch (IOException e) {
            e.printStackTrace();
        }
        filename =name + number+"xpos"+ ".txt";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
                        for (int p1 = 0; p1 < lengthArray; p1++) {
                        	
					if( p1!=lengthArray){
                                   writer.write(xpos[p1]+ ";");}
					else{writer.write(xpos[p1]);}
                        			
        }writer.close();}
        
        catch (IOException e) {
            e.printStackTrace();
        }
        filename =name + number+"ypos"+ ".txt";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
                        for (int p1 = 0; p1 < lengthArray; p1++) {
                        	
					if( p1!=lengthArray){
                                   writer.write(ypos[p1]+ ";");}
					else{writer.write(ypos[p1]);}
                        			
        }writer.close();}
        
        catch (IOException e) {
            e.printStackTrace();
        }
        
    }
	
	public WrapperclassCars loadSavedArray(int number)
    {
		String filename = name+ number+direction+".txt";
        BufferedReader reader;
       
	String[] values= new String[(lengthArray+1)];
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            
            	 values = line.split(";");
            	 direction.toString();
            	
                 
                                      for (int p1 = 0; p1 < (lengthArray); p1++) {
                                    
                                    	  direction[p1] = Integer.parseInt(values[p1]);
                                      }
                                                 
                    reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
        filename = name+ number+"xpos"+".txt";
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            
            	 values = line.split(";");
            	
                 
                                      for (int p1 = 0; p1 < (lengthArray); p1++) {
                                    
                                    	  xpos[p1]=  Integer.parseInt(values[p1]);
                                      }
                                                 
                    reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
        filename = name+ number+"ypos"+".txt";
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            
            	 values = line.split(";");
            	
                 
                                      for (int p1 = 0; p1 < (lengthArray); p1++) {
                                    
                                    	  ypos[p1]=  Integer.parseInt(values[p1]);
                                      }
                                                 
                    reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        WrapperclassCars wrapperclass = new WrapperclassCars(lengthArray, direction,destination, xpos, ypos);
	return wrapperclass;
}
}
