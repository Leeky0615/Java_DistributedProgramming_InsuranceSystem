package view.checkcustomerpanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import constants.ViewConstants.EViewFrame;
import model.dto.Customer;
import model.service.customer.CustomerListImpl;

public class CustomerInfoPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Vector<Object> objects;
	private CheckCustomerPanel checkCustomerPanel;
	private CustomerListImpl customerList;
	private Customer customer;
	
	private JPanel information;
	private ActionHandler actionHandler;
	private JButton back;

	private JPanel btnPanel;
	public CustomerInfoPanel(CheckCustomerPanel checkCustomerPanel, CustomerListImpl customerList) {
		setPreferredSize(new Dimension(600, 500));
		setLayout(null);
		
		this.customerList = customerList;
		this.checkCustomerPanel = checkCustomerPanel;
	}
	
	public Customer setSelectedRow(Vector<Object> vector, String customerName, String customerId) {
		this.objects = vector;
		for(Customer customer : this.customerList.getCustomerList()) {
			// 파라미터로 Row가 온경우
			if (this.objects != null) {
				if (customer.getCustomerSID().equals(this.objects.get(1))) {this.customer = customer;}
			// 파라미터로 Name,Id 가 온경우
			}else {
				if (customer.getCustomerSID().equals(customerId) && customer.getName().equals(customerName)) {
					this.customer = customer;
				}
			}		
		}
		return this.customer;
	}
	
	public void createDefaultPanel() {
		information = new JPanel();
		information.setLocation(12, 10);
		information.setSize(576, 383);
		information.setBorder(new TitledBorder(new LineBorder(Color.lightGray,1),"고객 상세정보"));
		information.setLayout(null);
		JLabel jLabel = new JLabel();
		jLabel.setBounds(5, 19, 275, 45);
		jLabel.setFont(EViewFrame.eFont.getFont());
		jLabel.setText("이름 : "+this.customer.getName());
		information.add(jLabel);
		JLabel jLabel1 = new JLabel();
		jLabel1.setBounds(5, 54, 275, 45);
		jLabel1.setFont(EViewFrame.eFont.getFont());
		jLabel1.setText("주민등록번호 : "+this.customer.getCustomerSID());
		information.add(jLabel1);
		JLabel jLabel2 = new JLabel();
		jLabel2.setBounds(5, 88, 275, 45);
		jLabel2.setFont(EViewFrame.eFont.getFont());
		jLabel2.setText("성별 : "+this.customer.isGender());
		information.add(jLabel2);
		JLabel jLabel3_1 = new JLabel();
		jLabel3_1.setText("나이 : "+this.customer.getAge());
		jLabel3_1.setFont(EViewFrame.eFont.getFont());
		jLabel3_1.setBounds(5, 123, 275, 45);
		information.add(jLabel3_1);
		JLabel jLabel3 = new JLabel();
		jLabel3.setBounds(5, 199, 275, 45);
		jLabel3.setFont(EViewFrame.eFont.getFont());
		jLabel3.setText("전화번호 : "+this.customer.getPhoneNum());
		information.add(jLabel3);
		JLabel jLabel4 = new JLabel();
		jLabel4.setBounds(5, 160, 275, 45);
		jLabel4.setFont(EViewFrame.eFont.getFont());
		jLabel4.setText("직업 : "+this.customer.getJob());
		information.add(jLabel4);
		JLabel jLabel5 = new JLabel();
		jLabel5.setBounds(5, 237, 275, 45);
		jLabel5.setFont(EViewFrame.eFont.getFont());
		jLabel5.setText("병력 : "+this.customer.getillHistory());
		information.add(jLabel5);
		JLabel jLabel7 = new JLabel();
		jLabel7.setBounds(5, 281, 275, 45);
		jLabel7.setFont(EViewFrame.eFont.getFont());
		jLabel7.setText("재산 : "+this.customer.getProperty());
		information.add(jLabel7);
		this.add(information);
	}
	
	public void createButton() {
		this.actionHandler = new ActionHandler();
		btnPanel = new JPanel();
		btnPanel.setLayout(null);
		btnPanel.setBounds(12, 414, 576, 76);
		btnPanel.setBorder(new TitledBorder(new LineBorder(Color.lightGray,1)));
		back = new JButton("돌아가기");
		back.setFont(EViewFrame.eFont.getFont());
		back.setBounds(12, 19, 552, 42);
		back.addActionListener(actionHandler);
		btnPanel.add(back);
		this.add(btnPanel);
	}
	
	public void buttonClick(Object source) {
		if (source.equals(this.back)) {
			this.removeAll();
			this.checkCustomerPanel.createPanel();
			this.information.setVisible(false);
			this.btnPanel.setVisible(false);
		}
	}
	protected class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			buttonClick(e.getSource());
		}
	}
	
}
