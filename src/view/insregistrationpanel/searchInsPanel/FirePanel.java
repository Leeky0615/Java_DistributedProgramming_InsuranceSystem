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

import constants.ControlConstants.EBuildingType;
import constants.ControlConstants.EPaymentMethod;
import constants.ViewConstants.EFireInsurance;
import constants.ViewConstants.EViewFrame;

public class FirePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField area_t;
	private JTextField age_t;
	private JComboBox<String> type_t;
	private JTextField price_t;
	private JComboBox<String> paymentMethod_t;
	private JTextField paymentDate_t;
	
	public FirePanel() {
		this.setLayout(null);
		this.setBorder(new TitledBorder(new LineBorder(Color.lightGray,1),"화재보험 가입"));
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 20, 85, 176);
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));
		
		JLabel type_l = new JLabel(EFireInsurance.type.getText());
		type_l.setFont(EViewFrame.eFont.getFont());
		type_l.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(type_l);
		
		JLabel area_l = new JLabel(EFireInsurance.area.getText());
		area_l.setFont(EViewFrame.eFont.getFont());
		area_l.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(area_l);
		
		JLabel age_l = new JLabel(EFireInsurance.age.getText());
		age_l.setFont(EViewFrame.eFont.getFont());
		age_l.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(age_l);
		
		JLabel price_l = new JLabel(EFireInsurance.price.getText());
		price_l.setFont(EViewFrame.eFont.getFont());
		price_l.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(price_l);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(109, 20, 137, 176);
		panel_1.setLayout(null);
		
		type_t = new JComboBox<String>();
		for(EBuildingType type : EBuildingType.values()) {type_t.addItem(type.getText());}
		type_t.setFont(EViewFrame.eFont.getFont());
		type_t.setBounds(12, 15, 116, 30);
		type_t.setSelectedIndex(0);
		panel_1.add(type_t);
		
		area_t = new JTextField();
		area_t.setBounds(12, 54, 116, 30);
		area_t.setFont(EViewFrame.eFont.getFont());
		area_t.setColumns(10);
		panel_1.add(area_t);
		
		age_t = new JTextField();
		age_t.setBounds(12, 94, 116, 31);
		age_t.setFont(EViewFrame.eFont.getFont());
		age_t.setColumns(10);
		panel_1.add(age_t);
		
		price_t = new JTextField();
		price_t.setBounds(12, 134, 116, 30);
		price_t.setFont(EViewFrame.eFont.getFont());
		panel_1.add(price_t);
		
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

	public int getArea_t() {return Integer.parseInt(area_t.getText());}
	public int getAge_t() {return Integer.parseInt(age_t.getText());}
	public EBuildingType getType_t() {
		for(EBuildingType type : EBuildingType.values()) {
			if (type.getText().equals(type_t.getSelectedItem().toString())) {
				return type;
			}
		}
		return null;
	}
	public int getPrice_t() {return Integer.parseInt(price_t.getText());}
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
