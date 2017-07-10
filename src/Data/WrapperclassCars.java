package Data;

public class WrapperclassCars {
private int[] direction;
private int[] xpos;
private int[] ypos;
private int[] destination;


public WrapperclassCars(int length, int[] dirArray, int destArray[], int[] xArray, int[] yArray) {
	direction = new int[length];
	xpos = new int[length];
	ypos = new int[length];
	destination = new int[length];
	destination = destArray;
	direction = dirArray;
	xpos = xArray;
	ypos = yArray;
}

public int[] getDirection() {
	return direction;
}
public int[] getXPosition() {
	return xpos;
}
public int[] getYPosition() {
	return ypos;
}
public int[] getDestination(){
	return destination;
}
	
}
