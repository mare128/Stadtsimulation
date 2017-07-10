package Data;

public class Wrapperclass {
	private int xposition;
	private int yposition;
	private int direction;
	private int destination;
	
	public Wrapperclass(int dir, int dest, int xpos, int ypos){
		xposition = xpos;
		yposition = ypos;
		direction = dir;
		destination = dest;
	}

	public int getXposition() {
		return xposition;
	}

	public int getYposition() {
		return yposition;
	}

	public int getDirection() {
		return direction;
	}
	
	public int getDestination(){
		return destination;
	}

}