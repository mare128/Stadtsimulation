package Zeichenfenster;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Simulation.SimulationCalculator;



public class MyButton implements ActionListener{
	
	private JButton button;
	private String buttonName;
	private GameScreen gs;
	private SimulationCalculator sc;
	
	public MyButton(JPanel p, int x, int y, int width, int height, String buttonName,SimulationCalculator sc){
		this.buttonName = buttonName;
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
        if(e.getActionCommand().equals("Spiel starten")){
    		gs = new GameScreen(Color.white);
    		sc.pushGameScreen(gs);
		}
        else if(e.getActionCommand().equals("Beenden")){
            ImageIcon icon = new ImageIcon("bild.jpg");
            int answer = JOptionPane.showConfirmDialog(null, "Wirklich schlieﬂen?", "Meldung", JOptionPane.YES_NO_OPTION,
            JOptionPane.INFORMATION_MESSAGE, icon);

            if (answer == JOptionPane.OK_OPTION) {
                System.exit(0);
            } else if (answer == JOptionPane.NO_OPTION) {
            } else if (answer == JOptionPane.CLOSED_OPTION) {
            } 
        }
	}
}
