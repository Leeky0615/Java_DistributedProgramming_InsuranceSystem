package view.mainFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;

import constants.ViewConstants.EButton;
import constants.ViewConstants.EViewFrame;
import view.mainFrame.MainFrame.ActionHandler;

public class ButtonPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private Vector<JButton> buttons;
	
	// 메인 프레임에서 사용되는 버튼 패널
	public ButtonPanel(ActionHandler actionHandler) {
		this.setBackground(new Color(94,175,164));
		this.buttons = new Vector<JButton>();
		for (EButton eMenu : EButton.values()) {
			JButton btn = eMenu.getButton();
			btn.addActionListener(actionHandler);
			btn.setPreferredSize(new Dimension(100,40));
			btn.setFont(EViewFrame.eFont.getFont());
			btn.setActionCommand(eMenu.getPanelName());
			this.buttons.add(btn);
			this.add(btn);
		}
	}
	public Vector<JButton> getButtons() {return buttons;}
	public void setButtons(Vector<JButton> buttons) {this.buttons = buttons;}
}
