package Zeichenfenster;

import java.awt.Frame;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;
import javax.swing.Popup;

import com.sun.glass.events.KeyEvent;

public class MyMenu {
	JMenuBar menuBar;
	JMenu menu;
	JMenu menu2;
	JMenu menu3;
	JMenu menu4;
	JMenu submenu;
	JMenuItem menuItem;
	JRadioButtonMenuItem rbMenuItem;
	JCheckBoxMenuItem cbMenuItem;
	

	public MyMenu(JPanel p){
		//Create the menu bar.
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1920, 50);
		//Build the first menu
		menu = new JMenu("?");
		menu.setMnemonic(KeyEvent.VK_A);
		menuBar.add(menu);
		//a group of JMenuItems
		menuItem = new JMenuItem("Hilfe erhalten!", KeyEvent.VK_T);
		menuItem.setActionCommand("Hilfe erhalten");
		menuItem.setMnemonic(KeyEvent.VK_B);
		menu.add(menuItem);
		menu = new JMenu("Optionen");
		menuBar.add(menu);
		menuItem = new JMenuItem("Optionen");
		menuItem.setMnemonic(KeyEvent.VK_N);
		menuItem.setActionCommand("Optionen");
		menu.add(menuItem);
		menu.addSeparator();
		submenu = new JMenu("Speichern");
		submenu.setMnemonic(KeyEvent.VK_S);
		menuItem = new JMenuItem("Speicherstand");
		menuItem.setActionCommand("Speicherstand 1");
		submenu.add(menuItem);
		menuItem = new JMenuItem("Speicherstand 2");
		menuItem.setActionCommand("Speicherstand 2");
		submenu.add(menuItem);
		menuItem = new JMenuItem("Speicherstand 3");
		menuItem.setActionCommand("Speicherstand 3");
		submenu.add(menuItem);
		menuItem = new JMenuItem("Speicherstand 4");
		menuItem.setActionCommand("Speicherstand 4");
		submenu.add(menuItem);
		menuItem = new JMenuItem("Speicherstand 5");
		menuItem.setActionCommand("Speicherstand 5");
		submenu.add(menuItem);
		menu.add(submenu);
		menu = new JMenu("Stadt Anpassen");
		menuBar.add(menu);
		menuItem = new JMenuItem("Add Road");
		menuItem.setActionCommand("Add Road");
		menu.add(menuItem);
		submenu = new JMenu("Add Buildings");
		menuItem = new JMenuItem("Blue Building");
		menuItem.setActionCommand("Blue Building");
		submenu.add(menuItem);
		menuItem = new JMenuItem("Red Building");
		menuItem.setActionCommand("Red Building");
		submenu.add(menuItem);
		menuItem = new JMenuItem("Yellow Building");
		menuItem.setActionCommand("Yellow Building");
		submenu.add(menuItem);
		menuItem = new JMenuItem("Green Building");
		menuItem.setActionCommand("Green Building");
		submenu.add(menuItem);
		menu.add(submenu);
		menu = new JMenu("Events");
		menuBar.add(menu);
		menuItem = new JMenuItem("Traffic Jam");
		menuItem.setActionCommand("Traffic Jam");
		menu.add(menuItem);
		menuItem = new JMenuItem("Burning House");
		menuItem.setActionCommand("Burning House");
		menu.add(menuItem);
		menuItem = new JMenuItem("Crime Scene");
		menuItem.setActionCommand("Crime Scene");
		menu.add(menuItem);
		menuItem = new JMenuItem("Car Accident");
		menuItem.setActionCommand("Car Accident");
		menu.add(menuItem);
		p.add(menuBar);
	}
}
