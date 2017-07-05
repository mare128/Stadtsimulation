package Zeichenfenster;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

import Zeichenfenster.MyFrame;

public class MyButton implements ActionListener{
	
	private JButton button;
	private boolean buttonPressed;

	public MyButton(JPanel p, int x, int y, int width, int height, String buttonName){
		button = new JButton(buttonName);
		button.setSize(width, height);
        button.setLocation(x, y);
        button.setVisible(true);
        button.addActionListener(this);
        p.add(button);
	}
	
	public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            System.out.println("Ihr Spiel beginnt!");
        }
    }
	
	public void buttonPressed(){
		if(button.isSelected()){
			System.out.println("pressed");
		}
	}
}
