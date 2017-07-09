package Zeichenfenster;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class MyButton implements ActionListener{
	
	private JButton button;
	private String buttonName;
	private boolean gameScreen;
	private int gameScreens;
	private boolean optionsScreen;

	public MyButton(JPanel p, int x, int y, int width, int height, String buttonName){
		this.buttonName = buttonName;
		gameScreens = 0;
		gameScreen = false;
		optionsScreen = false;
		button = new JButton(buttonName);
		button.setSize(width, height);
        button.setLocation(x, y);
        button.setVisible(true);
        button.addActionListener(this);
        button.setBackground(Color.white);
        button.setForeground(Color.blue);
        p.add(button);
	}
	
	public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Spiel starten") && gameScreens == 0){
        	gameScreen = true;
        	gameScreens = 1;
    			GameScreen gs = new GameScreen(Color.white);
        }else if(e.getActionCommand().equals("Spiel starten")){
			System.out.println("Only one Gamescreen is allowed!");
		}
        else if(e.getActionCommand().equals("Optionen") && optionsScreen == false){
        	optionsScreen = true;
        	OptionsScreen opt = new OptionsScreen(Color.white);
        }else if(e.getActionCommand().equals("Optionen")){
        	System.out.println("Only one Optionsscreen is allowed!");
        }
        else if(e.getActionCommand().equals("Beenden")){
            ImageIcon icon = new ImageIcon("bild.jpg");
            int antwort = JOptionPane.showConfirmDialog(null, "Wirklich schlieﬂen?", "Meldung", JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.INFORMATION_MESSAGE, icon);

            if (antwort == JOptionPane.OK_OPTION) {
                System.exit(0);
            } else if (antwort == JOptionPane.NO_OPTION) {
            } else if (antwort == JOptionPane.CANCEL_OPTION) {
            } else if (antwort == JOptionPane.CLOSED_OPTION) {
                System.out.println("Fenster geschlossen!");
            } 
        }
	}
	
	public boolean gameScreen(){
		return gameScreen;
	}
}
