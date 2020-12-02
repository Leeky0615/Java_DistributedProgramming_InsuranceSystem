package view.defaultClass;

import javax.swing.JPanel;

import controller.FrontController;

// ���Ǵ� �гε��� SuperClass
public abstract class DefaultPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	protected FrontController frontController;
	public DefaultPanel(FrontController frontController) {this.frontController = frontController;}
	public Object setController(String claseeName) {return this.frontController.mappingController(claseeName);}
	public abstract void createPanel();
}
