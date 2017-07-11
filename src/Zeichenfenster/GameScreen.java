package Zeichenfenster;

import java.awt.Color;

public class GameScreen extends MyFrame{
	
	public GameScreen(Color color){
		super(color);
		MyMenu m = new MyMenu(p);
	}
	
	public void paint(){
		paintAll(getGraphics());
	}
	
	public void paint2(int x, int y, int width, int height, Color color){
		MyCanvas c = new MyCanvas(p, x, y, width, height, color);
	}
	
	public void paint3(int x, int y, int width, int height, Color color, int i){
		MyCanvas[] c = new MyCanvas[i];
		for(int j = 0; j < i; j++){
			c[j] = new MyCanvas(p, x, y, width, height, color);
		}
	}
}
