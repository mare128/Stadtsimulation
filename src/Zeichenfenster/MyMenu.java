package Zeichenfenster;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;

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
		menuItem = new JMenuItem("Wohnhaus");
		menuItem.setActionCommand("Wohnhaus");
		menu.add(menuItem);
		menuItem = new JMenuItem("Gewerbe");
		menuItem.setActionCommand("Gewerbe");
		menu.add(menuItem);
		menuItem = new JMenuItem("Industrie");
		menuItem.setActionCommand("Industrie");
		menu.add(menuItem);
		menuItem = new JMenuItem("Park");
		menuItem.setActionCommand("Park");
		menu.add(menuItem);
		menuItem = new JMenuItem("Parkplatz");
		menuItem.setActionCommand("Parkplatz");
		menu.add(menuItem);
		menuItem = new JMenuItem("Krankenhaus");
		menuItem.setActionCommand("Krankenhaus");
		menu.add(menuItem);
		menuItem = new JMenuItem("Polizeiwache");
		menuItem.setActionCommand("Polizeiwache");
		menu.add(menuItem);
		menuItem = new JMenuItem("Feuerwache");
		menuItem.setActionCommand("Feuerwache");
		menu.add(menuItem);
		menuItem = new JMenuItem("Schule");
		menuItem.setActionCommand("Schule");
		menu.add(menuItem);
		menu = new JMenu("Events");
		menuBar.add(menu);
		menuItem = new JMenuItem("Stau");
		menuItem.setActionCommand("Stau");
		menu.add(menuItem);
		menuItem = new JMenuItem("Hausbrand");
		menuItem.setActionCommand("Hausbrand");
		menu.add(menuItem);
		menuItem = new JMenuItem("Unfall");
		menuItem.setActionCommand("Unfall");
		menu.add(menuItem);
		p.add(menuBar);
	}
}
