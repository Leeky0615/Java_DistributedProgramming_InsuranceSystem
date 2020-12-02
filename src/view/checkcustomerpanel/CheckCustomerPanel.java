package view.checkcustomerpanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import constants.ViewConstants.EMainFrame;
import constants.ViewConstants.ETableStatus;
import constants.ViewConstants.EViewFrame;
import main.Menu;
import model.service.checkCustomerInfo.CheckCustomerInfoImpl;
import model.service.customer.CustomerListImpl;
import view.defaultClass.DefaultPanel;

public class CheckCustomerPanel extends DefaultPanel {
	private static final long serialVersionUID = 1L;
	
	private CustomerListImpl customerList;
	private CheckCustomerInfoImpl checkCustomerInfo;
	private JTextField customerName_t,customerId_t1,customerId_t2;
	private CustomerTable customerTable;
	private ActionHandler actionHandler;
	private MouseHandler mousehandler;

	private JButton searchButton,detailCheckBtn, addCustomerBtn,refreshBtn;

	public CheckCustomerPanel(Menu menu) {
		super(menu);
		this.customerList = (CustomerListImpl)this.menu.getCustomerList();
		this.checkCustomerInfo = (CheckCustomerInfoImpl) this.menu.getCheckCustomerInfo();
		this.actionHandler = new ActionHandler();
		this.mousehandler = new MouseHandler();
		this.createPanel();
	}
	
	public void createPanel() {
		this.removeAll();
		this.setLayout(null);
		JPanel searchPanel = new JPanel();
		searchPanel.setBounds(12, 10, 576, 107);
		searchPanel.setLayout(null);
		searchPanel.setBorder(new TitledBorder(new LineBorder(Color.lightGray,1),"고객 검색하기"));
		
		// 고객 이름
		JLabel customerName_l = new JLabel("이름");
		customerName_l.setHorizontalAlignment(SwingConstants.CENTER);
		customerName_l.setFont(EViewFrame.eFont.getFont());
		customerName_l.setBounds(12, 27, 159, 30);
		searchPanel.add(customerName_l);
		
		customerName_t = new JTextField();
		customerName_t.setHorizontalAlignment(SwingConstants.LEFT);
		customerName_t.setBounds(183, 27, 222, 30);
		searchPanel.add(customerName_t);
		customerName_t.setColumns(10);
		
		// 고객 주민등록번호
		JLabel customerId_l = new JLabel("주민등록번호");
		customerId_l.setHorizontalAlignment(SwingConstants.CENTER);
		customerId_l.setFont(EViewFrame.eFont.getFont());
		customerId_l.setBounds(12, 66, 159, 30);
		searchPanel.add(customerId_l);
		
		customerId_t1 = new JTextField();
		customerId_t1.setHorizontalAlignment(SwingConstants.LEFT);
		customerId_t1.setColumns(10);
		customerId_t1.setBounds(183, 67, 99, 30);
		searchPanel.add(customerId_t1);
		JLabel hyphen_l = new JLabel("-");
		hyphen_l.setHorizontalAlignment(SwingConstants.CENTER);
		hyphen_l.setFont(EViewFrame.eFont.getFont());
		hyphen_l.setBounds(286, 67, 17, 30);
		searchPanel.add(hyphen_l);		
		customerId_t2 = new JTextField();
		customerId_t2.setHorizontalAlignment(SwingConstants.LEFT);
		customerId_t2.setColumns(10);
		customerId_t2.setBounds(306, 67, 99, 30);
		searchPanel.add(customerId_t2);
		
		// 검색 버튼
		searchButton = new JButton("검색");
		searchButton.setFont(EViewFrame.eFont.getFont());
		searchButton.setBounds(447, 25, 98, 71);
		searchButton.addActionListener(this.actionHandler);
		searchPanel.add(searchButton);
		this.add(searchPanel);
		
		// 고객 리스트 테이블
		this.customerTable = new CustomerTable(this.customerList, ETableStatus.checkCustomer);
		this.customerTable.addMouseListener(this.mousehandler);
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(12, 127, 576, 185);
		scroll.setBorder(new TitledBorder(new LineBorder(Color.lightGray,1),"고객 리스트"));
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		scroll.setViewportView(this.customerTable);
		scroll.setPreferredSize(new Dimension(EMainFrame.eWidth.getValue(),50));
		this.add(scroll);
		
		// 버튼 패널
		JPanel panel = new JPanel();
		panel.setBounds(12, 322, 576, 168);
		panel.setBorder(new TitledBorder(new LineBorder(Color.lightGray,1)));
		this.detailCheckBtn = new JButton("고객 정보 확인하기");
		this.detailCheckBtn.setFont(EViewFrame.eFont.getFont());
		this.detailCheckBtn.setBounds(12, 62, 552, 42);
		this.detailCheckBtn.addActionListener(actionHandler);
		this.addCustomerBtn = new JButton("고객 정보 추가하기");
		this.addCustomerBtn.setFont(EViewFrame.eFont.getFont());
		this.addCustomerBtn.setBounds(12, 10, 552, 42);
		this.addCustomerBtn.addActionListener(actionHandler);
		this.refreshBtn = new JButton("새로 고침");
		this.refreshBtn.setFont(EViewFrame.eFont.getFont());
		this.refreshBtn.setBounds(12, 114, 552, 42);
		this.refreshBtn.addActionListener(actionHandler);
		panel.setLayout(null);
		panel.add(this.detailCheckBtn);
		panel.add(this.addCustomerBtn);
		panel.add(this.refreshBtn);
		this.add(panel);
		
		updateUI();
	}
	
	public void buttonClick(Object source) {
		// 고객 상세조회 버튼 클릭시
		if (source.equals(this.detailCheckBtn)) {
			// 선택된 Row가 없는 경우
			if (this.customerTable.getRow() == null) {
				JOptionPane.showMessageDialog(null, "고객을 선택해주세요.", "고객 선택", JOptionPane.WARNING_MESSAGE);
				return;
			// 현재 패널을 초기화 하고 고객정보 패널을 생성
			}else {
				this.removeAll();
				CustomerInfoPanel customerInfoPanel = new CustomerInfoPanel(this, this.customerList);
				// 고객을 조회할때 파라미터로 Row를 주는 경우
				if(customerInfoPanel.setSelectedRow(this.customerTable.getRow(), null, null) != null) {
					customerInfoPanel.createDefaultPanel();
					customerInfoPanel.createButton();
					this.setLayout(new GridLayout(1,1));
					this.add(customerInfoPanel);
				}else {this.createPanel();}
			}
		// 고객 추가하기 버튼클릭시
		}else if(source.equals(this.addCustomerBtn)) {
			AddCustomerFrame addCustomerFrame = new AddCustomerFrame(this.checkCustomerInfo);
			addCustomerFrame.setVisible(true);
			if (!(addCustomerFrame.isFocusable())) {this.createPanel();}
		// 검색 버튼 클릭시 
		}else if(source.equals(this.searchButton)){
			String customerName = this.customerName_t.getText();
			String customerId = this.customerId_t1.getText()+"-"+this.customerId_t2.getText();
			this.removeAll();
			// 고객을 조회할때 파라미터로 고객이름과 주민등록번호를 주는 경우
			CustomerInfoPanel customerInfoPanel = new CustomerInfoPanel(this, this.customerList);
			if (customerInfoPanel.setSelectedRow(null,customerName,customerId) != null) {
				customerInfoPanel.createDefaultPanel();
				customerInfoPanel.createButton();
				this.setLayout(new GridLayout(1,1));
				this.add(customerInfoPanel);
			}else {
				JOptionPane.showMessageDialog(null, "등록되지 않은 고객입니다. 다시 확인해 주세요.", "등록되지 않은 고객", JOptionPane.WARNING_MESSAGE);
				this.createPanel();
			}
		// 새로고침 버튼 클릭시	
		}else if (source.equals(this.refreshBtn)) {this.createPanel();}
		this.updateUI();
	}
	private class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			buttonClick(e.getSource());
		}
	}
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