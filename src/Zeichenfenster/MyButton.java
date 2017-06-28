package Zeichenfenster;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import Zeichenfenster.MyFrame;

public class MyButton implements ActionListener{
	
	private JButton button;

	public MyButton(MyFrame f, int x, int y, int width, int height, String buttonName){
		button = new JButton(buttonName);
		button.setSize(width, height);
        button.setLocation(x, y);
        button.setVisible(true);
        button.addActionListener(this);
        f.getContentPane().add(button);
        
	}
	
	public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            System.out.println("Ihr Spiel beginnt!");
        }
    }
}
