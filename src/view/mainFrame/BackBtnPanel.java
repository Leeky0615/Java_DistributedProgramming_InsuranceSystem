package view.mainFrame;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import constants.ViewConstants.EViewFrame;
import view.mainFrame.MainFrame.ActionHandler;

public class BackBtnPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private JButton backbtn, logoutbtn;

	public BackBtnPanel(ActionHandler actionHandler) {
		this.setLayout(new GridLayout(0,2));
		this.backbtn = new JButton("처음화면으로");
		this.backbtn.setFont(EViewFrame.eFont.getFont());
		this.backbtn.setHorizontalTextPosition(SwingConstants.CENTER);
		this.backbtn.addActionListener(actionHandler);
		this.backbtn.setActionCommand("backToMain");
		this.add(backbtn);
		
		this.logoutbtn = new JButton("로그아웃");
		this.logoutbtn.setFont(EViewFrame.eFont.getFont());
		this.logoutbtn.setHorizontalTextPosition(SwingConstants.CENTER);
		this.logoutbtn.addActionListener(actionHandler);
		this.logoutbtn.setActionCommand("logout");
		this.add(logoutbtn);
	}

}
