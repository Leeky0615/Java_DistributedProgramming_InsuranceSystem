package view.insdevelopmentpanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import constants.ControlConstants.EInsuranceType;
import constants.ViewConstants.EInsuranceDesign;
import constants.ViewConstants.EViewFrame;
import model.service.insuranceDevelopment.InsuranceDevelopmentImpl;

public class WriteInsurancePanel extends JPanel  {
	private static final long serialVersionUID = 1L;
	private InsuranceDevelopmentImpl insuranceDevelopment;
	
	private JTextArea description_t;
	private Vector<JLabel> labels;
	private Vector<JTextField> fields;
	private JComboBox<String> insType_t;

	private ActionListener actionHandler;
	private JButton newInsBtn;

	public WriteInsurancePanel(InsuranceDevelopmentImpl insuranceDevelopment) {
		this.insuranceDevelopment = insuranceDevelopment;
		
		this.setBorder(new TitledBorder(new LineBorder(Color.lightGray,1),"보험 설계하기"));
		
		this.labels = new Vector<JLabel>();
		this.fields = new Vector<JTextField>();
		this.actionHandler = new ActionHandler();
		
		createPanel();
		createBtnPanel();
	}
	
	public void createPanel() {
		this.setLayout(new FlowLayout(FlowLayout.LEADING, 15, 20));
		for (EInsuranceDesign basicInsurance : EInsuranceDesign.values()) {
			JLabel label = new JLabel(basicInsurance.getText());
			label.setPreferredSize(new Dimension(70,30));
			label.setFont(EViewFrame.eFont.getFont());
			this.add(label);
			this.labels.add(label);
			if (basicInsurance.name().equals("insuranceType")) {
				this.insType_t = new JComboBox<String>();
				this.insType_t.setFont(EViewFrame.eFont.getFont());
				for(EInsuranceType insuranceType : EInsuranceType.values()) {insType_t.addItem(insuranceType.getText());}
				this.insType_t.setSelectedIndex(0);
				this.insType_t.setPreferredSize(new Dimension(180,30));
				this.add(insType_t);
			}else if (basicInsurance.name().equals("description")) {
				JScrollPane scrollPane = new JScrollPane();
				description_t = new JTextArea();
				description_t.setLineWrap(true);
				description_t.setCaretPosition(description_t.getDocument().getLength());
				description_t.setFont(EViewFrame.eFont.getFont());
				scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
				scrollPane.setViewportView(this.description_t);
				scrollPane.setPreferredSize(new Dimension(455,100));
				this.add(scrollPane);
			}else {
				JTextField textfield = new JTextField(13);
				textfield.setFont(EViewFrame.eFont.getFont());
				this.fields.add(textfield);
				this.add(textfield);
			}
		}
	}
	
	public void createBtnPanel() {
		this.newInsBtn = new JButton("신규보험상품 등록 신청하기");
		this.newInsBtn.setFont(EViewFrame.eFont.getFont());
		this.newInsBtn.addActionListener(actionHandler);
		this.newInsBtn.setPreferredSize(new Dimension(555, 50));
		this.add(this.newInsBtn);
	}
	
	public Vector<String> getInfos(){
		Vector<String> infos = new Vector<String>();
		for (JTextField info : this.fields) {infos.add(info.getText());}
		infos.add(this.insType_t.getSelectedItem().toString());
		infos.add(this.description_t.getText());
		return infos;
	}
	public void buttonClick(Object name) {
		if (name.equals(this.newInsBtn)){
			this.insuranceDevelopment.designInsurance(this.getInfos());
			JOptionPane.showMessageDialog(this, "승인 요청이 완료되었습니다.");
		}
	}

	private class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			buttonClick(e.getSource());
		}
	}
}
