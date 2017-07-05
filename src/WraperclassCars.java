
public class WraperclassCars {
private String[] direction;
private int xpos[];
private int ypos[];


public WraperclassCars(int length, String[] dirArray, int[] xArray, int[] yArray) {
	direction = new String[length];
	xpos = new int[length];
	ypos = new int[length];
	direction = dirArray;
	xpos = xArray;
	ypos = yArray;
}

public String[] getDirection() {
	return direction;
}
public int[] getXPosition() {
	return xpos;
}
public int[] getYPosition() {
	return ypos;
}
	
}
