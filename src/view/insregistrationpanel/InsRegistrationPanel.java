package view.insregistrationpanel;

import java.awt.BorderLayout;

import javax.swing.JTabbedPane;

import constants.ViewConstants.ELogin;
import controller.FrontController;
import view.defaultClass.DefaultPanel;
import view.insregistrationpanel.acceptRegistPanel.AcceptRegistrationPanel;
import view.insregistrationpanel.requestPanel.RequestPanel;
import view.insregistrationpanel.searchInsPanel.SearchInsurancePanel;
import view.mainFrame.MainFrame;

public class InsRegistrationPanel extends DefaultPanel {
	private static final long serialVersionUID = 1L;
	
	private JTabbedPane jTabbedPane;
	private RequestPanel requestpanel;
	private SearchInsurancePanel searchInsurancePanel;
	private AcceptRegistrationPanel acceptRegistrationPanel;
	
	public InsRegistrationPanel(FrontController frontController) {
		super(frontController);
		this.setLayout(new BorderLayout());
		
		this.createPanel();
	}

	public void createPanel() {
		this.jTabbedPane = new JTabbedPane();
		if (MainFrame.user == ELogin.underwriter) {
			this.acceptRegistrationPanel = new AcceptRegistrationPanel(this.frontController);
			this.jTabbedPane.add("가입 승인",this.acceptRegistrationPanel);
		}else {
			this.requestpanel = new RequestPanel(this.frontController);
			this.jTabbedPane.add("면담 요청",this.requestpanel);
			this.searchInsurancePanel = new SearchInsurancePanel(this.frontController,"Registration");
			this.jTabbedPane.add("보험 가입",this.searchInsurancePanel);
		}
		
		this.add(jTabbedPane, BorderLayout.CENTER);		
	}
}
