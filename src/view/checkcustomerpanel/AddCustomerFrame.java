package view.checkcustomerpanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import constants.ControlConstants.EIllHistory;
import constants.ControlConstants.EJob;
import constants.ViewConstants.ECustomer;
import constants.ViewConstants.EViewFrame;
import control.checkCustomerInfo.CheckCustomerInfoImpl;

public class AddCustomerFrame extends JFrame { //고객추가하기버튼누르는 경우
	private static final long serialVersionUID = 1L;
	private CheckCustomerInfoImpl checkCustomerInfo;

	private JButton saveBtn, cancelBtn;
	private ActionHandler actionHandler;
	
	private Vector<JTextField> fields,IdFields, phoneFields;
	private Vector<JComboBox<String>> combos;
	public AddCustomerFrame(CheckCustomerInfoImpl checkCustomerInfo) {
		this.checkCustomerInfo = checkCustomerInfo;
		this.actionHandler = new ActionHandler();
		
		this.setSize(380, 500);
		this.setTitle("고객추가");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(new FlowLayout());
		this.setVisible(true);

		this.fields = new Vector<JTextField>();
		this.IdFields = new Vector<JTextField>(); 
		this.phoneFields = new Vector<JTextField>();
		this.combos = new Vector<JComboBox<String>>();

		this.createInfoPanel();
		this.createBtnPanel();
	}
	private void createInfoPanel() {
		JPanel p = new JPanel();
		p.setPreferredSize(new Dimension(360, 350));
		p.setBorder(new TitledBorder(new LineBorder(Color.lightGray,1),"고객 추가하기"));
		p.setLayout(new FlowLayout(FlowLayout.LEADING,10,10));
		for(ECustomer customer : ECustomer.values()) {
			JLabel label = new JLabel(customer.getText());
			label.setFont(EViewFrame.eFont.getFont());
			label.setPreferredSize(new Dimension(100,30));
			p.add(label);
			if (customer == ECustomer.customerId) {
				JTextField field1 = new JTextField();
				field1.setFont(EViewFrame.eFont.getFont());
				field1.setPreferredSize(new Dimension(85,30));
				JTextField field2 = new JTextField();
				field2.setFont(EViewFrame.eFont.getFont());
				field2.setPreferredSize(new Dimension(85,30));
				JLabel lblNewLabel = new JLabel("-");
				lblNewLabel.setPreferredSize(new Dimension(10,30));
				lblNewLabel.setFont(EViewFrame.eFont.getFont());
				p.add(field1);
				p.add(lblNewLabel);
				p.add(field2);
				this.IdFields.add(field1);
				this.IdFields.add(field2);
			}else if(customer == ECustomer.phoneNum) {
				for (int i = 0; i < 2; i++) {
					JTextField field = new JTextField();
					field.setFont(EViewFrame.eFont.getFont());
					field.setPreferredSize(new Dimension(50,30));
					p.add(field);
					JLabel lblNewLabel = new JLabel("-");
					lblNewLabel.setPreferredSize(new Dimension(10,30));
					lblNewLabel.setFont(EViewFrame.eFont.getFont());
					p.add(lblNewLabel);
					this.phoneFields.add(field);
				}
				JTextField field = new JTextField();
				field.setFont(EViewFrame.eFont.getFont());
				field.setPreferredSize(new Dimension(50,30));
				p.add(field);
				this.phoneFields.add(field);
			}else if(customer == ECustomer.name || customer == ECustomer.propety || customer == ECustomer.age) {
				JTextField field = new JTextField();
				field.setFont(EViewFrame.eFont.getFont());
				field.setPreferredSize(new Dimension(150,30));
				p.add(field);
				this.fields.add(field);
			}else {
				JComboBox<String> comboBox = new JComboBox<String>();
				comboBox.setPreferredSize(new Dimension(150,30));
				if (customer == ECustomer.gender) {
					comboBox.addItem("남성");
					comboBox.addItem("여성");
				}else if(customer == ECustomer.job) {
					for(EJob job : EJob.values()) {comboBox.addItem(job.getText());}
				}else if(customer == ECustomer.illHistory) {
					for(EIllHistory illHistory : EIllHistory.values()) {comboBox.addItem(illHistory.getText());}
				}
				p.add(comboBox);
				this.combos.add(comboBox);
			}
		}
		this.add(p);
	}
	private void createBtnPanel() {
		JPanel btnPanel = new JPanel();
		btnPanel.setPreferredSize(new Dimension(355, 60));
		btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		btnPanel.setBorder(new TitledBorder(new LineBorder(Color.lightGray,1)));
		this.saveBtn = new JButton("저장");
		this.saveBtn.setPreferredSize(new Dimension(150,40));
		this.saveBtn.setFont(EViewFrame.eFont.getFont());
		this.cancelBtn = new JButton("취소");
		this.cancelBtn.setPreferredSize(new Dimension(150,40));
		this.cancelBtn.setFont(EViewFrame.eFont.getFont());
		this.saveBtn.addActionListener(this.actionHandler);
		this.cancelBtn.addActionListener(this.actionHandler);
		btnPanel.add(this.saveBtn);
		btnPanel.add(this.cancelBtn);
		this.add(btnPanel);
	}
	public void buttonclick(Object source) {
		// 저장하기 버튼 클릭시
		if (source.equals(this.saveBtn)) {
			Vector<String> customerContents = new Vector<String>();
			for (ECustomer customer : ECustomer.values()) {
				switch (customer) {
				case name: customerContents.add(fields.get(0).getText());break;
				case customerId: customerContents.add(this.IdFields.get(0).getText()+"-"
						+this.IdFields.get(1).getText());
					break;
				case gender:
					customerContents.add(combos.get(0).getSelectedItem().toString());
					break;
				case age: customerContents.add(fields.get(1).getText());break;
				case phoneNum: customerContents.add(this.phoneFields.get(0).getText()+"-"
						+this.phoneFields.get(1).getText()+"-"
						+this.phoneFields.get(2).getText());
					break;
				case job:
					customerContents.add(combos.get(1).getSelectedItem().toString());
					break;
				case illHistory:
					customerContents.add(combos.get(2).getSelectedItem().toString());
					break;
				case propety:
					customerContents.add(fields.get(2).getText());
					break;
				default:break;
				}
			}
			this.checkCustomerInfo.addNewCustomerInformation(customerContents);
			JOptionPane.showMessageDialog(this, "신규고객 추가가 완료되었습니다.");
			this.dispose();
		// 취소버튼 클릭시
		}else if(source.equals(this.cancelBtn)) {
			this.dispose();
		}
	}
	
	private class ActionHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			buttonclick(e.getSource());
		}
	}
}