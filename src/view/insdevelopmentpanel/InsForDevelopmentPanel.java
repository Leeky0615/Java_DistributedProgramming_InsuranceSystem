package view.insdevelopmentpanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import constants.ControllerConstants.EController;
import constants.ViewConstants.EInsuranceHead;
import constants.ViewConstants.EViewFrame;
import controller.insuranceRegistration.InsuranceRegistrationControllerImpl;
import main.FrontController;
import model.entity.Insurance;
import view.insregistrationpanel.searchInsPanel.SearchInsurancePanel;

public class InsForDevelopmentPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private SearchInsurancePanel searchInsurancePanel;
	private InsuranceRegistrationControllerImpl insuranceRegistrationController;

	private Vector<Object> selectedRow;
	private Insurance insurance;
	private ActionHandler actionHandler;

	private JPanel basicInfoPanel, btnPanel;
	private JButton backBtn;

	public InsForDevelopmentPanel(SearchInsurancePanel searchInsurancePanel, FrontController frontController, Vector<Object> selectedRow) {
		this.insuranceRegistrationController = (InsuranceRegistrationControllerImpl) frontController.mappingController(EController.InsuranceRegistrationController.getControllerName());
		this.selectedRow = selectedRow;
		this.searchInsurancePanel = searchInsurancePanel;

		this.actionHandler = new ActionHandler();
		this.setLayout(null);

		this.setInsurance((int)this.selectedRow.get(EInsuranceHead.id.ordinal()));

		this.createBasicPanel();
		this.createBtnPanel();
	}
	public void createBasicPanel() {
		this.basicInfoPanel = new JPanel();
		this.basicInfoPanel.setLayout(null);
		this.basicInfoPanel.setBounds(12, 10, 576, 379);
		this.basicInfoPanel.setBorder(new TitledBorder(new LineBorder(Color.lightGray,1),"보험 기본정보"));

		JLabel description_l = new JLabel();
		description_l.setForeground(Color.BLUE);
		description_l.setFont(new Font("굴림", Font.ITALIC, 15));
		description_l.setBorder(new TitledBorder(new LineBorder(Color.lightGray,1)));
		description_l.setBounds(12, 188, 552, 170);
		description_l.setText(this.insurance.getInsuranceDescription());
		basicInfoPanel.add(description_l);

		JLabel num_l = new JLabel(EInsuranceHead.id.getText()+" : ");
		num_l.setHorizontalAlignment(SwingConstants.RIGHT);
		num_l.setFont(EViewFrame.eFont.getFont());
		num_l.setBounds(12, 50, 57, 20);
		basicInfoPanel.add(num_l);
		JLabel num_l_1 = new JLabel(Integer.toString(this.insurance.getInsuranceId()));
		num_l_1.setFont(EViewFrame.eFont.getFont());
		num_l_1.setBounds(81, 50, 100, 20);
		basicInfoPanel.add(num_l_1);

		JLabel name_l = new JLabel(EInsuranceHead.name.getText()+" : ");
		name_l.setHorizontalAlignment(SwingConstants.RIGHT);
		name_l.setFont(EViewFrame.eFont.getFont());
		name_l.setBounds(193, 50, 57, 20);
		basicInfoPanel.add(name_l);
		JLabel name_l_1 = new JLabel(this.insurance.getInsuranceName());
		name_l_1.setFont(EViewFrame.eFont.getFont());
		name_l_1.setBounds(262, 50, 100, 20);
		basicInfoPanel.add(name_l_1);

		JLabel gaurantee = new JLabel(EInsuranceHead.guarantee.getText()+" : ");
		gaurantee.setHorizontalAlignment(SwingConstants.RIGHT);
		gaurantee.setFont(EViewFrame.eFont.getFont());
		gaurantee.setBounds(12, 111, 57, 20);
		basicInfoPanel.add(gaurantee);
		JLabel gaurantee_1 = new JLabel(this.insurance.getContractCondition().getGuarantee()+"원");
		gaurantee_1.setFont(EViewFrame.eFont.getFont());
		gaurantee_1.setBounds(81, 111, 100, 20);
		basicInfoPanel.add(gaurantee_1);

		JLabel payment = new JLabel(EInsuranceHead.payment.getText()+" : ");
		payment.setHorizontalAlignment(SwingConstants.RIGHT);
		payment.setFont(EViewFrame.eFont.getFont());
		payment.setBounds(193, 111, 57, 20);
		basicInfoPanel.add(payment);
		JLabel payment_1 = new JLabel(this.insurance.getContractCondition().getPayment()+"원");
		payment_1.setFont(EViewFrame.eFont.getFont());
		payment_1.setBounds(262, 111, 100, 20);
		basicInfoPanel.add(payment_1);

		JLabel period_l = new JLabel(EInsuranceHead.period.getText()+" : ");
		period_l.setHorizontalAlignment(SwingConstants.RIGHT);
		period_l.setFont(EViewFrame.eFont.getFont());
		period_l.setBounds(404, 50, 57, 20);
		basicInfoPanel.add(period_l);
		JLabel period_l_1 = new JLabel(this.insurance.getContractCondition().getPeriod()+"년");
		period_l_1.setFont(EViewFrame.eFont.getFont());
		period_l_1.setBounds(465, 50, 99, 20);
		basicInfoPanel.add(period_l_1);

		JLabel type_l = new JLabel(EInsuranceHead.type.getText()+" : ");
		type_l.setHorizontalAlignment(SwingConstants.RIGHT);
		type_l.setFont(EViewFrame.eFont.getFont());
		type_l.setBounds(381, 111, 80, 20);
		basicInfoPanel.add(type_l);
		JLabel type_l_1 = new JLabel(this.selectedRow.get(5).toString());
		type_l_1.setFont(EViewFrame.eFont.getFont());
		type_l_1.setBounds(465, 111, 99, 20);
		basicInfoPanel.add(type_l_1);
		this.add(this.basicInfoPanel);

		JLabel lblNewLabel = new JLabel("보험 설명");
		lblNewLabel.setFont(EViewFrame.eFont.getFont());
		lblNewLabel.setBounds(12, 161, 100, 27);
		basicInfoPanel.add(lblNewLabel);
	}

	public void createBtnPanel() {
		btnPanel = new JPanel();
		btnPanel.setBounds(12, 409, 576, 63);
		btnPanel.setBorder(new TitledBorder(new LineBorder(Color.lightGray,1)));

		backBtn = new JButton("돌아가기");
		backBtn.setBounds(12, 10, 552, 43);
		backBtn.setFont(EViewFrame.eFont.getFont());
		backBtn.addActionListener(actionHandler);
		btnPanel.setLayout(null);
		btnPanel.add(backBtn);
		this.add(btnPanel);
	}

	public void setInsurance(int insuranceId) {
		this.insurance = this.insuranceRegistrationController.searchInsurance(insuranceId);
	}

	public void buttonClick() {
		this.removeAll();
		this.searchInsurancePanel.createSelectPanel();
		this.searchInsurancePanel.createTable();
	}
	private class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			buttonClick();
		}
	}
}
