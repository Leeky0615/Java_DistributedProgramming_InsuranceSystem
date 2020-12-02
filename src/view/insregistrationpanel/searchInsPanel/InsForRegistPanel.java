package view.insregistrationpanel.searchInsPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import constants.ControllerConstants.EController;
import constants.ViewConstants.EInsuranceHead;
import constants.ViewConstants.EViewFrame;
import controller.FrontController;
import controller.insuranceRegistration.InsuranceRegistrationControllerImpl;
import model.dto.Insurance;

public class InsForRegistPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private SearchInsurancePanel searchInsurancePanel;
	private FrontController frontController;
	private InsuranceRegistrationControllerImpl insuranceRegistrationController;
	
	private Vector<Object> selectedRow;
	private Insurance insurance;
	private ActionHandler actionHandler;
	
	private JTextField customerName_t,customerId_t1,customerId_t2;
	private JPanel basicInfoPanel, detailInfoPanel, btnPanel;
	private JButton registrationBtn,backBtn;
	
	public InsForRegistPanel(SearchInsurancePanel searchInsurancePanel, FrontController frontController, Vector<Object> selectedRow) {
		this.frontController = frontController;
		this.insuranceRegistrationController = (InsuranceRegistrationControllerImpl) frontController.mappingController(EController.InsuranceRegistrationController.getControllerName());
		this.selectedRow = selectedRow;
		this.searchInsurancePanel = searchInsurancePanel;
		
		this.actionHandler = new ActionHandler();
		this.setLayout(null);
		
		this.setInsurance((int)this.selectedRow.get(EInsuranceHead.id.ordinal()));
		
		this.createDetailPanel();
		this.createBasicPanel();
		this.createBtnPanel();
	}
	public void createDetailPanel() {
		this.detailInfoPanel = new JPanel();
		this.detailInfoPanel.setLayout(null);
		this.detailInfoPanel.setBounds(12, 10, 576, 121);
		this.detailInfoPanel.setBorder(new TitledBorder(new LineBorder(Color.lightGray,1),"고객 정보 입력"));
		
		// 고객 이름
		JLabel customerName_l = new JLabel("이름");
		customerName_l.setHorizontalAlignment(SwingConstants.CENTER);
		customerName_l.setFont(EViewFrame.eFont.getFont());
		customerName_l.setBounds(13, 30, 159, 30);
		this.detailInfoPanel.add(customerName_l);
		
		customerName_t = new JTextField();
		customerName_t.setHorizontalAlignment(SwingConstants.LEFT);
		customerName_t.setBounds(184, 30, 222, 30);
		this.detailInfoPanel.add(customerName_t);
		customerName_t.setColumns(10);
		
		// 고객 주민등록번호
		JLabel customerId_l = new JLabel("주민등록번호");
		customerId_l.setHorizontalAlignment(SwingConstants.CENTER);
		customerId_l.setFont(EViewFrame.eFont.getFont());
		customerId_l.setBounds(13, 69, 159, 30);
		this.detailInfoPanel.add(customerId_l);
		
		customerId_t1 = new JTextField();
		customerId_t1.setHorizontalAlignment(SwingConstants.LEFT);
		customerId_t1.setColumns(10);
		customerId_t1.setBounds(184, 70, 99, 30);
		this.detailInfoPanel.add(customerId_t1);
		JLabel hyphen_l = new JLabel("-");
		hyphen_l.setHorizontalAlignment(SwingConstants.CENTER);
		hyphen_l.setFont(EViewFrame.eFont.getFont());
		hyphen_l.setBounds(287, 70, 17, 30);
		this.detailInfoPanel.add(hyphen_l);		
		customerId_t2 = new JTextField();
		customerId_t2.setHorizontalAlignment(SwingConstants.LEFT);
		customerId_t2.setColumns(10);
		customerId_t2.setBounds(307, 70, 99, 30);
		this.detailInfoPanel.add(customerId_t2);
		
		// 검색 버튼
		registrationBtn = new JButton("상품 가입");
		registrationBtn.setFont(EViewFrame.eFont.getFont());
		registrationBtn.setBounds(440, 30, 107, 69);
		registrationBtn.addActionListener(this.actionHandler);
		this.detailInfoPanel.add(registrationBtn);
		this.add(this.detailInfoPanel);
	}
	public void createBasicPanel() {
		this.basicInfoPanel = new JPanel();
		this.basicInfoPanel.setLayout(null);
		this.basicInfoPanel.setBounds(12, 153, 576, 270);
		this.basicInfoPanel.setBorder(new TitledBorder(new LineBorder(Color.lightGray,1),"보험 기본정보"));
		
		JLabel description_l = new JLabel();
		description_l.setForeground(Color.BLUE);
		description_l.setFont(new Font("굴림", Font.ITALIC, 15));
		description_l.setBorder(new TitledBorder(new LineBorder(Color.lightGray,1)));
		description_l.setBounds(12, 105, 552, 141);
		description_l.setText(this.insurance.getInsuranceDescription());
		basicInfoPanel.add(description_l);

		JLabel num_l = new JLabel(EInsuranceHead.id.getText()+" : ");
		num_l.setHorizontalAlignment(SwingConstants.RIGHT);
		num_l.setFont(new Font("굴림", Font.PLAIN, 14));
		num_l.setBounds(12, 35, 57, 20);
		basicInfoPanel.add(num_l);
		JLabel num_l_1 = new JLabel(Integer.toString(this.insurance.getInsuranceId()));
		num_l_1.setFont(new Font("굴림", Font.PLAIN, 14));
		num_l_1.setBounds(81, 35, 100, 20);
		basicInfoPanel.add(num_l_1);
		
		JLabel name_l = new JLabel(EInsuranceHead.name.getText()+" : ");
		name_l.setHorizontalAlignment(SwingConstants.RIGHT);
		name_l.setFont(new Font("굴림", Font.PLAIN, 14));
		name_l.setBounds(193, 35, 57, 20);
		basicInfoPanel.add(name_l);
		JLabel name_l_1 = new JLabel(this.insurance.getInsuranceName());
		name_l_1.setFont(new Font("굴림", Font.PLAIN, 14));
		name_l_1.setBounds(262, 35, 100, 20);
		basicInfoPanel.add(name_l_1);
		
		JLabel gaurantee = new JLabel(EInsuranceHead.guarantee.getText()+" : ");
		gaurantee.setHorizontalAlignment(SwingConstants.RIGHT);
		gaurantee.setFont(new Font("굴림", Font.PLAIN, 14));
		gaurantee.setBounds(12, 75, 57, 20);
		basicInfoPanel.add(gaurantee);
		JLabel gaurantee_1 = new JLabel(this.insurance.getContractCondition().getGuarantee()+"원");
		gaurantee_1.setFont(new Font("굴림", Font.PLAIN, 14));
		gaurantee_1.setBounds(81, 75, 100, 20);
		basicInfoPanel.add(gaurantee_1);
		
		JLabel payment = new JLabel(EInsuranceHead.payment.getText()+" : ");
		payment.setHorizontalAlignment(SwingConstants.RIGHT);
		payment.setFont(new Font("굴림", Font.PLAIN, 14));
		payment.setBounds(193, 75, 57, 20);
		basicInfoPanel.add(payment);
		JLabel payment_1 = new JLabel(this.insurance.getContractCondition().getPayment()+"원");
		payment_1.setFont(new Font("굴림", Font.PLAIN, 14));
		payment_1.setBounds(262, 75, 100, 20);
		basicInfoPanel.add(payment_1);
		
		JLabel period_l = new JLabel(EInsuranceHead.period.getText()+" : ");
		period_l.setHorizontalAlignment(SwingConstants.RIGHT);
		period_l.setFont(new Font("굴림", Font.PLAIN, 14));
		period_l.setBounds(404, 35, 57, 20);
		basicInfoPanel.add(period_l);
		JLabel period_l_1 = new JLabel(this.insurance.getContractCondition().getPeriod()+"년");
		period_l_1.setFont(new Font("굴림", Font.PLAIN, 14));
		period_l_1.setBounds(465, 35, 99, 20);
		basicInfoPanel.add(period_l_1);
		
		JLabel type_l = new JLabel(EInsuranceHead.type.getText()+" : ");
		type_l.setHorizontalAlignment(SwingConstants.RIGHT);
		type_l.setFont(new Font("굴림", Font.PLAIN, 14));
		type_l.setBounds(381, 75, 80, 20);
		basicInfoPanel.add(type_l);
		JLabel type_l_1 = new JLabel(this.selectedRow.get(5).toString());
		type_l_1.setFont(new Font("굴림", Font.PLAIN, 14));
		type_l_1.setBounds(465, 75, 99, 20);
		basicInfoPanel.add(type_l_1);
		this.add(this.basicInfoPanel);
	}
	
	public void setInsurance(int insuranceId) {this.insurance = this.insuranceRegistrationController.searchInsurance(insuranceId);}
	
	public void createBtnPanel() {
		btnPanel = new JPanel();
		btnPanel.setBounds(12, 433, 576, 37);
		btnPanel.setBorder(new TitledBorder(new LineBorder(Color.lightGray,1)));
		
		backBtn = new JButton("돌아가기");
		backBtn.setBounds(12, 1, 552, 35);
		backBtn.setFont(EViewFrame.eFont.getFont());
		backBtn.addActionListener(actionHandler);
		btnPanel.setLayout(null);
		btnPanel.add(backBtn);
		this.add(btnPanel);
	}
	public void buttonClick(Object source) {
		if (source.equals(this.registrationBtn)) {
			String customerName = this.customerName_t.getText();
			String customerId = this.customerId_t1.getText()+"-"+this.customerId_t2.getText();
			if (this.insuranceRegistrationController.writeCustomerInfomation(customerName, customerId)) {
				RegistrationFrame registrationFrame = new RegistrationFrame(this.frontcontroller, this.insurance);
				registrationFrame.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null, "회원 정보가 일치하지 않습니다. 다시 확인해주세요", "회원 정보 확인", JOptionPane.WARNING_MESSAGE);
				return;
			}
		}else if(source.equals(this.backBtn)){
			this.removeAll();
			this.searchInsurancePanel.createSelectPanel();
			this.searchInsurancePanel.createTable();
		}
	}
	private class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			buttonClick(e.getSource());
		}
	}
}

