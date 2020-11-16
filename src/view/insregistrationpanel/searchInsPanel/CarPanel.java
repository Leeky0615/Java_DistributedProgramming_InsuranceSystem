package view.insregistrationpanel.searchInsPanel;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import constants.ControlConstants.ECarType;
import constants.ControlConstants.EPaymentMethod;
import constants.ViewConstants.EViewFrame;
import constants.ViewConstants.EcarInsurance;

public class CarPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField num_t,age_t,paymentDate_t;
	private JComboBox<String> type_t, history_t,paymentMethod_t;
	
	public CarPanel() {
		this.setLayout(null);
		this.setBorder(new TitledBorder(new LineBorder(Color.lightGray,1),"자동차보험 가입"));
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 20, 96, 176);
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));
		
		JLabel type_l = new JLabel(EcarInsurance.type.getText());
		type_l.setFont(EViewFrame.eFont.getFont());
		type_l.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(type_l);
		
		JLabel num_l = new JLabel(EcarInsurance.num.getText());
		num_l.setFont(EViewFrame.eFont.getFont());
		num_l.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(num_l);
		
		JLabel age_l = new JLabel(EcarInsurance.age.getText());
		age_l.setFont(EViewFrame.eFont.getFont());
		age_l.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(age_l);
		
		JLabel history_l = new JLabel(EcarInsurance.history.getText());
		history_l.setFont(EViewFrame.eFont.getFont());
		history_l.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(history_l);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(109, 20, 137, 176);
		panel_1.setLayout(null);
		
		type_t = new JComboBox<String>();
		for(ECarType type : ECarType.values()) {type_t.addItem(type.getText());}
		type_t.setFont(EViewFrame.eFont.getFont());
		type_t.setBounds(12, 15, 116, 30);
		type_t.setSelectedIndex(0);
		panel_1.add(type_t);
		
		num_t = new JTextField();
		num_t.setBounds(12, 54, 116, 30);
		num_t.setFont(EViewFrame.eFont.getFont());
		num_t.setColumns(10);
		panel_1.add(num_t);
		
		age_t = new JTextField();
		age_t.setBounds(12, 94, 116, 31);
		age_t.setFont(EViewFrame.eFont.getFont());
		age_t.setColumns(10);
		panel_1.add(age_t);
		
		history_t = new JComboBox<String>();
		history_t.setBounds(12, 134, 116, 30);
		history_t.setFont(EViewFrame.eFont.getFont());
		history_t.addItem("있음");
		history_t.addItem("없음");
		history_t.setSelectedIndex(0);
		panel_1.add(history_t);
		
		this.add(panel);
		this.add(panel_1);
		
		JLabel paymentMethod_l = new JLabel("납입방식");
		paymentMethod_l.setBounds(265, 39, 56, 20);
		paymentMethod_l.setFont(EViewFrame.eFont.getFont());
		paymentMethod_l.setHorizontalAlignment(SwingConstants.LEFT);
		add(paymentMethod_l);
		
		paymentMethod_t = new JComboBox<String>();
		paymentMethod_t.setBounds(333, 34, 116, 30);
		for(EPaymentMethod method : EPaymentMethod.values()) {paymentMethod_t.addItem(method.getText());}
		paymentMethod_t.setFont(EViewFrame.eFont.getFont());
		paymentMethod_t.setSelectedIndex(0);
		add(paymentMethod_t);
		
		paymentDate_t = new JTextField();
		paymentDate_t.setBounds(333, 74, 116, 31);
		paymentDate_t.setFont(EViewFrame.eFont.getFont());
		paymentDate_t.setColumns(10);
		add(paymentDate_t);
		
		JLabel paymentDate_l = new JLabel("매월 납입일");
		paymentDate_l.setBounds(247, 79, 74, 20);
		paymentDate_l.setFont(EViewFrame.eFont.getFont());
		paymentDate_l.setHorizontalAlignment(SwingConstants.LEFT);
		add(paymentDate_l);
	}

	public int getNum_t() {return Integer.parseInt(num_t.getText());}
	public int getAge_t() {return Integer.parseInt(age_t.getText());}
	public ECarType getType_t() {
		for(ECarType type : ECarType.values()) {
			if (type.getText().equals(type_t.getSelectedItem().toString())) {
				return type;
			}
		}
		return null;
	}
	public boolean getHistory_t() {
		if (history_t.getSelectedItem().toString().equals("있음")) {
			return true;
		}
		return false;
	}
	public EPaymentMethod getPaymentMethod_t() {
		for(EPaymentMethod method : EPaymentMethod.values()) {
			if (method.getText().equals(paymentMethod_t.getSelectedItem().toString())) {
				return method;
			}
		}
		return null;
	}
	public int getPaymentDate_t() {return Integer.parseInt(paymentDate_t.getText());}
}