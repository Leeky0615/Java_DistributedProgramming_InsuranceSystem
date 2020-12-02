package view.insregistrationpanel.acceptRegistPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import constants.ViewConstants.EMainFrame;
import constants.ViewConstants.ETableStatus;
import constants.ViewConstants.EViewFrame;
import model.service.customer.CustomerListImpl;
import model.service.insuranceRegistration.InsuranceRegistrationImpl;
import view.checkcustomerpanel.CustomerTable;

public class AcceptRegistrationPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private InsuranceRegistrationImpl insuranceRegistration;
	private CustomerListImpl customerList;

	private ActionHandler actionHandler;
	private MouseHandler mousehandler;
	
	private CustomerTable customerTable;
	private JButton detailCheckBtn;
	private JButton refresh;

	public AcceptRegistrationPanel(InsuranceRegistrationImpl insuranceRegistration, CustomerListImpl customerList) {
		this.insuranceRegistration = insuranceRegistration;
		this.customerList = customerList;
		this.mousehandler = new MouseHandler();

		this.createPanel();
	}
	
	public void createPanel() {
		this.removeAll();
		this.setLayout(null);
		// 테이블 생성
		this.customerTable = new CustomerTable(this.customerList, ETableStatus.insuranceRegistration);
		this.customerTable.addMouseListener(this.mousehandler);
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(12, 10, 576, 315);
		scroll.setBorder(new TitledBorder(new LineBorder(Color.lightGray,1),"고객 리스트"));
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		scroll.setViewportView(this.customerTable);
		scroll.setPreferredSize(new Dimension(EMainFrame.eWidth.getValue(),50));
		this.add(scroll);
		
		// 버튼 패널 생성
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(12, 335, 576, 113);
		panel.setBorder(new TitledBorder(new LineBorder(Color.lightGray,1)));
		this.actionHandler = new ActionHandler();
		// 보험상세확인하기 버튼
		this.detailCheckBtn = new JButton("상세 확인하기");
		this.detailCheckBtn.setFont(EViewFrame.eFont.getFont());
		this.detailCheckBtn.setBounds(12, 10, 552, 42);
		this.detailCheckBtn.addActionListener(this.actionHandler);
		panel.add(this.detailCheckBtn);
		this.refresh = new JButton("새로고침");
		this.refresh.setFont(EViewFrame.eFont.getFont());
		this.refresh.setBounds(12, 62, 552, 42);
		this.refresh.addActionListener(this.actionHandler);
		panel.add(this.refresh);
		
		this.add(panel);
		
		scroll.updateUI();
		panel.updateUI();
	}
	
	// 버튼 ActionHandler
	public void buttonClick(Object source) {
		if (source.equals(this.detailCheckBtn)) {
			// 상세조회하기 버튼 클릭시
			if (this.customerTable.getRow() == null) {
				// Row를 선택하지 않은 경우
				JOptionPane.showMessageDialog(null, "승인할 고객을 선택해주세요.", "고객 선택", JOptionPane.WARNING_MESSAGE);
				return;
			}else {
				this.removeAll();
				RequestAcceptCustomerPanel requestAcceptCustomerPanel = new RequestAcceptCustomerPanel(this, this.insuranceRegistration,this.customerList);
				requestAcceptCustomerPanel.setSelectedRow(this.customerTable.getRow());
				requestAcceptCustomerPanel.createCustomerInfoPanel();
				requestAcceptCustomerPanel.createInsuranceInfoPanel();
				requestAcceptCustomerPanel.createButton();
				////////////////////////고객 정보//////////////////////////
				this.setLayout(new GridLayout(1,1));
				this.add(requestAcceptCustomerPanel);
			}
		}else if (source.equals(this.refresh)) {
			this.removeAll();
			this.createPanel();
		}
		updateUI();
	}
	private class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			buttonClick(e.getSource());
		}
	}
	
	// 테이블을 더블클릭했을 시  버튼이 눌려 패널이 생성됨.
	public void selectRow() {
		if (this.customerTable.getRow() == null) {
			JOptionPane.showMessageDialog(null, "고객을 선택해 주세요.", "고객 선택", JOptionPane.WARNING_MESSAGE);
			return;
		}else{this.detailCheckBtn.doClick();}
	}
	private class MouseHandler extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() == 2) {selectRow();}
		}
	}
}

