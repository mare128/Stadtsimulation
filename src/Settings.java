import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Settings extends File {
private String[] settings;
private int lengthSettings;

	
	public Settings(int length){
		 settings = new String[length];
	}
	
@Override
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
}
public String[] loadSettings(int number)
{
	String filename = "settings"+number+".txt";
    BufferedReader reader;
    
   
String[] values= new String[(lengthSettings+1)];
    try {
        reader = new BufferedReader(new FileReader(filename));
        String zeile = reader.readLine();
        
        	 values = zeile.split(";");
             
                                  for (int position = 0; position < (lengthSettings); position++) {
                                  
                                	  settings[position]= values[position];
                                	
                                  
                                  }             
                reader.close();
        return settings;             
    }
    catch (IOException e) {
        e.printStackTrace();
    }
	return settings;
}
public void saveSettings(int number)
{ String filename ="settings"+number+".txt";
    try {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
                    for (int p1 = 0; p1 < lengthSettings; p1++) {
                    	if(p1!=lengthSettings){
                               writer.write(settings[p1] + ";");}
				else{writer.write(settings[p1]);}
                               
                    			
    }
                    writer.close();}
    catch (IOException e) {
        e.printStackTrace();
    }
}
}
