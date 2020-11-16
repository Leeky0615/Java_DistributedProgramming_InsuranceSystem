package main;

import view.mainFrame.MainFrame;

public class Main {

	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.associate();
		
		MainFrame mainFrame = new MainFrame(menu);
		mainFrame.setVisible(true);
		
//		깃허브 연동확인 두번쨰 한글 확인
	}
}