package Data;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public abstract class File {

protected String name;
protected String[] array;

protected int lengthArray;


 public File(int length) {
	array = new String[length];
	lengthArray = length;
	
}

public String getFromFile(int position){
	return array[position];
}


public void write(int position, String content){
	array[position]= content;
}

public String[] getArray() {
	return array;
}
public void saveArray(int number)
{ String filename =name+number+".txt";
    try {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
                    for (int position = 0; position < lengthArray; position++) {
                    	if(position!=lengthArray){
                    	
                               writer.write(array[position] + ";");}
                               
                          else{writer.write(array[position]);}
                    	
                    			
    }
                    writer.close();}
    catch (IOException e) {
        e.printStackTrace();
    }
}
public String[] loadSavedArray(int number)
{
	String filename = name+number+".txt";
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
