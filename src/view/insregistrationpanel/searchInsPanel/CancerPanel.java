package view.insregistrationpanel.searchInsPanel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import constants.ControlConstants.EPaymentMethod;
import constants.ViewConstants.EViewFrame;

public class CancerPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JComboBox<String> paymentMethod_t;
	private JTextField paymentDate_t;
	public CancerPanel() {
		this.setLayout(null);
		this.setBorder(new TitledBorder(new LineBorder(Color.lightGray,1),"암보험 가입"));

		JLabel paymentMethod_l = new JLabel("납입방식");
		paymentMethod_l.setBounds(12, 43, 56, 20);
		paymentMethod_l.setFont(EViewFrame.eFont.getFont());
		paymentMethod_l.setHorizontalAlignment(SwingConstants.LEFT);
		add(paymentMethod_l);
		
		paymentMethod_t = new JComboBox<String>();
		paymentMethod_t.setBounds(80, 38, 116, 30);
		for(EPaymentMethod method : EPaymentMethod.values()) {paymentMethod_t.addItem(method.getText());}
		paymentMethod_t.setFont(EViewFrame.eFont.getFont());
		paymentMethod_t.setSelectedIndex(0);
		add(paymentMethod_t);
		
		paymentDate_t = new JTextField();
		paymentDate_t.setBounds(306, 36, 116, 31);
		paymentDate_t.setFont(EViewFrame.eFont.getFont());
		paymentDate_t.setColumns(10);
		add(paymentDate_t);
		
		JLabel paymentDate_l = new JLabel("매월 납입일");
		paymentDate_l.setBounds(220, 41, 74, 20);
		paymentDate_l.setFont(EViewFrame.eFont.getFont());
		paymentDate_l.setHorizontalAlignment(SwingConstants.LEFT);
		add(paymentDate_l);
		
		JLabel lblNewLabel = new JLabel("선택하신 암보험에 가입 요청을 하시겠습니까?");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblNewLabel.setBounds(12, 87, 426, 76);
		add(lblNewLabel);
		
		
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
