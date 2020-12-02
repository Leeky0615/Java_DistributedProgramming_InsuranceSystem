package view.insdevelopmentpanel;

import java.awt.BorderLayout;

import javax.swing.JTabbedPane;

import main.Menu;
import model.service.insurance.InsuranceListImpl;
import model.service.insuranceDevelopment.InsuranceDevelopmentImpl;
import model.service.insuranceRegistration.InsuranceRegistrationImpl;
import view.defaultClass.DefaultPanel;
import view.insregistrationpanel.searchInsPanel.SearchInsurancePanel;

public class InsDevelopmentPanel extends DefaultPanel{
	private static final long serialVersionUID = 1L;
	#private InsuranceRegistrationImpl insuranceRegistration;
	#private InsuranceDevelopmentImpl insuranceDevelopment;
	#private InsuranceListImpl insuranceList;

	private JTabbedPane jTabbedPane;
	private WriteInsurancePanel writeInsurancePanel;
	private SearchInsurancePanel searchInsurancePanel;

	public InsDevelopmentPanel(Menu menu) {
		super(menu);
		this.insuranceRegistration = (InsuranceRegistrationImpl) this.menu.getInsuranceRegistration();		
		this.insuranceDevelopment = (InsuranceDevelopmentImpl) this.menu.getInsuranceDevelopment();
		this.insuranceList = (InsuranceListImpl) this.menu.getInsuranceList();
		createPanel();
	}
	public void createPanel() {
		this.setLayout(new BorderLayout());
		this.jTabbedPane = new JTabbedPane();

		this.writeInsurancePanel = new WriteInsurancePanel(this.insuranceDevelopment);
		this.jTabbedPane.add("보험설계서 작성하기",this.writeInsurancePanel);
		this.searchInsurancePanel = new SearchInsurancePanel(this.insuranceRegistration,this.insuranceList,"Development");
		this.jTabbedPane.add("보험 상세조회",this.searchInsurancePanel);
		this.add(jTabbedPane, BorderLayout.CENTER);		
		updateUI();
	}

}