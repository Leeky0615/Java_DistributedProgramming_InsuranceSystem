package view.insdevelopmentpanel;

import java.awt.BorderLayout;

import javax.swing.JTabbedPane;

import controller.FrontController;
import view.defaultClass.DefaultPanel;
import view.insregistrationpanel.searchInsPanel.SearchInsurancePanel;

public class InsDevelopmentPanel extends DefaultPanel{
	private static final long serialVersionUID = 1L;

	private JTabbedPane jTabbedPane;
	private WriteInsurancePanel writeInsurancePanel;
	private SearchInsurancePanel searchInsurancePanel;

	public InsDevelopmentPanel(FrontController frontController) {
		super(frontController);
		createPanel();
	}
	public void createPanel() {
		this.setLayout(new BorderLayout());
		this.jTabbedPane = new JTabbedPane();

		this.writeInsurancePanel = new WriteInsurancePanel(this.frontController);
		this.jTabbedPane.add("보험설계서 작성하기",this.writeInsurancePanel);
		this.searchInsurancePanel = new SearchInsurancePanel(this.frontController,"Development");
		this.jTabbedPane.add("보험 상세조회",this.searchInsurancePanel);
		this.add(jTabbedPane, BorderLayout.CENTER);		
		updateUI();
	}

}