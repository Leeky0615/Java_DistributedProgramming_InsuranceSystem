package main;

import view.mainFrame.MainFrame;

public class Main {

	public static void main(String[] args) {
		MainServices mainServices = new MainServices();
		mainServices.initialize();
		FrontController frontController = new FrontController();
		frontController.associate(mainServices);
		frontController.connectCtoS();
		
		MainFrame mainFrame = new MainFrame(frontController);
		mainFrame.setVisible(true);
	}
}