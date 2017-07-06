package Data;

public class Settings extends File {
private int visits;

	
	public Settings(int length){
		super(length);
		name = "settings";
		String numberOfVisits = array[0];
		if(numberOfVisits.equals("0")){
			visits = 0;
			array[0] = "1";
		}
		else{
			visits = 1;
		}
		saveArray(0);
		
	}
	public int getVisits(){
		return visits;
	}
	
                                                       

}

