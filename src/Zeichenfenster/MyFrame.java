package Zeichenfenster;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame extends JFrame{
	
	protected JPanel p;

	public MyFrame(Color color){
		setTitle("Stadtsimulation");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		setLayout(null);
		setVisible(true);
		setExtendedState(MAXIMIZED_BOTH);
		p = new JPanel();
		p.setSize(1920, 1080);
		p.setLocation(0, 0);
		p.setBackground(color);
		p.setLayout(null);
		add(p);
	}	
	
	public JPanel getPanel(){
		return p;
	}
}
