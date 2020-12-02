package view.insregistrationpanel.acceptRegistPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import constants.ViewConstants.ECustomer;
import constants.ViewConstants.EFireInsurance;
import constants.ViewConstants.EInsuranceRequest;
import constants.ViewConstants.EViewFrame;
import constants.ViewConstants.EcarInsurance;
import model.dto.CancerInsurance;
import model.dto.CarInsurance;
import model.dto.Customer;
import model.dto.FireInsurance;
import model.dto.Insurance;
import model.service.customer.CustomerListImpl;
import model.service.insuranceRegistration.InsuranceRegistrationImpl;

public class RequestAcceptCustomerPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private AcceptRegistrationPanel acceptRegistrationPanel;
	#private InsuranceRegistrationImpl insuranceRegistration;
	#private CustomerListImpl customerList;
	private Customer customer;
	private ActionHandler actionHandler;
	
	private Insurance insurance;
	private JButton back,approve,disApprove;

	public RequestAcceptCustomerPanel(AcceptRegistrationPanel acceptRegistrationPanel, #InsuranceRegistrationImpl insuranceRegistration, #CustomerListImpl customerList) {
		setPreferredSize(new Dimension(600, 500));
		setLayout(new FlowLayout());
		
		this.acceptRegistrationPanel = acceptRegistrationPanel;
		this.insuranceRegistration = insuranceRegistration;
		this.customerList = customerList;
	}
	
	public void setSelectedRow(Vector<Object> vector) {
		for(Customer customer : this.customerList.getCustomerList()) {
			if (customer.getCustomerSID().equals(vector.get(1))) {this.customer = customer;}
		}
	}
	
	public Vector<Object> setCustomerInfos() {
		Vector<Object> infos = new Vector<Object>();
		infos.add(this.customer.getName());
		infos.add(this.customer.getCustomerSID());
		infos.add(this.customer.isGender());
		infos.add(this.customer.getAge());
		infos.add(this.customer.getPhoneNum());
		infos.add(this.customer.getJob().getText());
		infos.add(this.customer.getillHistory().getText());
		infos.add(this.customer.getProperty());
		return infos;
	}
	
	public Vector<Object> setInsuranceInfos() {
		insurance = this.insuranceRegistration.getReadyInsurance(this.customer.getId());
		Vector<Object> infos = new Vector<Object>();
		infos.add(insurance.getInsuranceId());
		infos.add(insurance.getInsuranceName());
		switch(insurance.getInsuranceType()) {
		case CANCER:
			infos.add(((CancerInsurance)insurance).getPaymentMethod().getText());
			infos.add(((CancerInsurance)insurance).getPaymentDate());
			break;
		case CAR:
			infos.add(((CarInsurance)insurance).getPaymentMethod().getText());
			infos.add(((CarInsurance)insurance).getPaymentDate());
			infos.add(((CarInsurance)insurance).getCarType().getText());
			infos.add(((CarInsurance)insurance).getCarNum());
			infos.add(((CarInsurance)insurance).getAge());
			break;
		case FIRE:
			infos.add(((FireInsurance)insurance).getPaymentMethod().getText());
			infos.add(((FireInsurance)insurance).getPaymentDate());
			infos.add(((FireInsurance)insurance).getBuildingType().getText());
			infos.add(((FireInsurance)insurance).getArea());
			infos.add(((FireInsurance)insurance).getUnitPrice());
			infos.add(((FireInsurance)insurance).getAge());
			break;
			default:break;
		}
		return infos;
	}
	
	public void createCustomerInfoPanel() {
		JPanel customerInfoPanel = new JPanel();
		customerInfoPanel.setPreferredSize(new Dimension(600, 180));
		customerInfoPanel.setBorder(new TitledBorder(new LineBorder(Color.lightGray,1),"고객 상세정보"));
		customerInfoPanel.setLayout(new FlowLayout());
		
		Vector<Object> infos = setCustomerInfos();
		for(ECustomer customer : ECustomer.values()) {
			JLabel label = new JLabel();
			label.setText(customer.getText()+" :  "+infos.get(customer.ordinal()));
			label.setPreferredSize(new Dimension(275, 35));
			label.setFont(EViewFrame.eFont.getFont());
			customerInfoPanel.add(label);
		}
		this.add(customerInfoPanel);
	}
	
	public void createInsuranceInfoPanel() {
		JPanel insuranceInfoPanel = new JPanel();
		insuranceInfoPanel.setPreferredSize(new Dimension(600, 180));
		insuranceInfoPanel.setLayout(new FlowLayout());
		insuranceInfoPanel.setBorder(new TitledBorder(new LineBorder(Color.lightGray,1),"보험 상세정보"));
		add(insuranceInfoPanel);
		
		Vector<Object> infos = setInsuranceInfos();
		for(EInsuranceRequest insuranceRequest : EInsuranceRequest.values()) {
			JLabel label = new JLabel();
			label.setText(insuranceRequest.getText()+" :  "+infos.get(insuranceRequest.ordinal()));
			label.setPreferredSize(new Dimension(275, 35));
			label.setFont(EViewFrame.eFont.getFont());
			insuranceInfoPanel.add(label);
		}
		switch(insurance.getInsuranceType()) {
		case CANCER:break;
		case CAR:
			for(EcarInsurance carInsurance : EcarInsurance.values()) {
				JLabel label = new JLabel();
				label.setText(carInsurance.getText()+" :  "+infos.get(carInsurance.ordinal()));
				label.setPreferredSize(new Dimension(275, 35));
				label.setFont(EViewFrame.eFont.getFont());
				insuranceInfoPanel.add(label);
			}
			break;
		case FIRE:
			for(EFireInsurance fireInsurance : EFireInsurance.values()) {
				JLabel label = new JLabel();
				label.setText(fireInsurance.getText()+" :  "+infos.get(fireInsurance.ordinal()+4));
				label.setPreferredSize(new Dimension(275, 35));
				label.setFont(EViewFrame.eFont.getFont());
				insuranceInfoPanel.add(label);
			}
			break;
		default:break;
		}
		this.add(insuranceInfoPanel);
	}
	
	public void createButton() {
		this.actionHandler = new ActionHandler();
		JPanel btnPanel = new JPanel();
		btnPanel.setBorder(new TitledBorder(new LineBorder(Color.lightGray,1)));
		btnPanel.setLayout(new FlowLayout());
		btnPanel.setPreferredSize(new Dimension(600, 100));
		
		approve = new JButton("상품 가입 승인");
		approve.setFont(EViewFrame.eFont.getFont());
		approve.setPreferredSize(new Dimension(270, 40));
		approve.addActionListener(actionHandler);
		btnPanel.add(approve);
		
		disApprove = new JButton("상품 가입 미승인");
		disApprove.setFont(EViewFrame.eFont.getFont());
		disApprove.setPreferredSize(new Dimension(270, 40));
		disApprove.addActionListener(actionHandler);
		btnPanel.add(disApprove);
		
		back = new JButton("돌아가기");
		back.setFont(EViewFrame.eFont.getFont());
		back.setPreferredSize(new Dimension(550, 40));
		back.addActionListener(actionHandler);
		btnPanel.add(back);
		this.add(btnPanel);
	}
	
	public void buttonClick(Object source) {
		if (source.equals(this.back)) {
			this.removeAll();
			this.acceptRegistrationPanel.createPanel();
			this.setVisible(false);
		}else if(source.equals(this.approve)) {
			this.insuranceRegistration.approve(this.customer);
			JOptionPane.showMessageDialog(this, "해당 상품에 가입되었습니다.");
		}else if(source.equals(this.disApprove)) {
			this.insuranceRegistration.disApprove(insurance.getInsuranceType(),this.customer);
			JOptionPane.showMessageDialog(this, "보험 가입이 승인되지 않았습니다.");
		}
	}
	protected class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			buttonClick(e.getSource());
		}
	}
}

