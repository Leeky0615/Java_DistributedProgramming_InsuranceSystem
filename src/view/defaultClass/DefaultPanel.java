package view.defaultClass;

import javax.swing.JPanel;

import main.Menu;

// 사용되는 패널들의 SuperClass
public abstract class DefaultPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	protected Menu menu;
	public DefaultPanel(Menu menu) {this.menu = menu;}
	public abstract void createPanel();
}
