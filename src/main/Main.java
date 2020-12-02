package main;

import controller.FrontController;
import view.mainFrame.MainFrame;

public class Main {

	public static void main(String[] args) {
		FrontController menu = new FrontController();
		
		MainFrame mainFrame = new MainFrame(menu);
		mainFrame.setVisible(true);
	}
}