package main;

import view.mainFrame.MainFrame;

public class Main {

	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.associate();
		
		MainFrame mainFrame = new MainFrame(menu);
		mainFrame.setVisible(true);

//		한글 ...
	}
}