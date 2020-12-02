package view.acceptinspanel;

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

import constants.ControllerConstants.EController;
import constants.ViewConstants.EInsuranceDesign;
import constants.ViewConstants.EViewFrame;
import controller.FrontController;
import controller.acceptInsuranceDesign.AcceptInsDesignControllerImpl;
import controller.insuranceDesign.InsuranceDesignControllerImpl;
import model.dto.InsuranceDesign;
import model.service.insuranceDesign.InsuranceDesignListImpl;

public class InsuranceDesignPanel extends JPanel{
private static final long serialVersionUID = 1L;
	
	private Vector<Object> objects;
	private InsuranceDesignControllerImpl insuranceDesignController;
	private AcceptInsDesignControllerImpl acceptInsDesignController;
	private InsuranceDesign insuranceDesign;
	private AcceptInsPanel acceptInsPanel;
	private AcceptedInsPanel acceptedInsPanel;
	
	private JPanel information;
	private ActionHandler actionHandler;
	private JButton approve,disApprove,back;

	private JPanel btnPanel;

	private Vector<JLabel> labels;
	// 보험승인하기(AcceptInsPanel) 패널에서 보험 상세조회를 클릭시 생성되는 Constructor
	public InsuranceDesignPanel(AcceptInsPanel acceptInsPanel, FrontController frontController, Vector<Object> vector) {
		setPreferredSize(new Dimension(601, 521));
		setLayout(null);
		
		this.acceptInsPanel = acceptInsPanel;	
		this.insuranceDesignController = (InsuranceDesignControllerImpl) frontController.mappingController(EController.InsuranceDesignController.getControllerName());
		this.acceptInsDesignController = (AcceptInsDesignControllerImpl) frontController.mappingController(EController.AcceptInsDesignController.getControllerName());	
		this.objects = vector;
		this.createDefaultPanel();
		this.actionHandler = new ActionHandler();
		
		btnPanel = new JPanel();
		btnPanel.setLayout(null);
		btnPanel.setBounds(12, 384, 576, 116);
		btnPanel.setBorder(new TitledBorder(new LineBorder(Color.lightGray,1)));
		approve = new JButton("보험설계서 승인");
		approve.setFont(EViewFrame.eFont.getFont());
		approve.setBounds(9, 15, 253, 38);
		approve.addActionListener(actionHandler);
		
		disApprove = new JButton("보험설계서 미승인");
		disApprove.setFont(EViewFrame.eFont.getFont());
		disApprove.setBounds(292, 15, 253, 38);
		disApprove.addActionListener(actionHandler);
		
		back = new JButton("돌아가기");
		back.setFont(EViewFrame.eFont.getFont());
		back.setBounds(9, 63, 536, 38);
		back.addActionListener(actionHandler);
		
		btnPanel.add(approve);
		btnPanel.add(disApprove);
		btnPanel.add(back);
		this.add(btnPanel);
	}
	
	// 승인된 보험 조회하기(AcceptedInsPanel) 패널에서 보험 상세조회를 클릭시 생성되는 Constructor
	public InsuranceDesignPanel(AcceptedInsPanel acceptedInsPanel,FrontController frontController, Vector<Object> vector) {
		setPreferredSize(new Dimension(601, 521));
		setLayout(null);
		
		this.acceptedInsPanel = acceptedInsPanel;	
		this.insuranceDesignController = (InsuranceDesignControllerImpl) frontController.mappingController(EController.InsuranceDesignController.getControllerName());
		this.objects = vector;
		this.createDefaultPanel();
		
		this.actionHandler = new ActionHandler();
		btnPanel = new JPanel();
		btnPanel.setLayout(null);
		btnPanel.setBounds(12, 384, 576, 116);
		btnPanel.setBorder(new TitledBorder(new LineBorder(Color.lightGray,1)));
		
		back = new JButton("돌아가기");
		back.setFont(EViewFrame.eFont.getFont());
		back.setBounds(9, 10, 552, 42);
		back.addActionListener(actionHandler);
		
		btnPanel.add(back);
		this.add(btnPanel);
	}
	public Vector<String> getInsuranceInfo(){
		return this.insuranceDesignController.setInsuranceInfo((Integer)this.objects.get(0));
	}
	// 기본 패널내용을 생성하는 메서드
	public void createDefaultPanel() {
		this.labels= new Vector<JLabel>(); 
		information = new JPanel();
		information.setLocation(12, 10);
		information.setSize(576, 364);
		information.setBorder(new TitledBorder(new LineBorder(Color.lightGray,1),"보험 상세정보"));
		information.setLayout(new FlowLayout(FlowLayout.LEADING,10,5));
		
		Vector<String> infos  = getInsuranceInfo();
		for (EInsuranceDesign insuranceDesign : EInsuranceDesign.values()) {
			JLabel label = new JLabel();
			if (insuranceDesign.name().equals("description")) {
				label.setPreferredSize(new Dimension(400,100));
				label.setText(infos.get(insuranceDesign.ordinal()));
			}else {
				label.setPreferredSize(new Dimension(270,45));
				label.setText(insuranceDesign.getText()+" : "+infos.get(insuranceDesign.ordinal()));
			}
			label.setFont(EViewFrame.eFont.getFont());
			information.add(label);
			labels.add(label);
		}
		this.add(information);
	}
	
	// 버튼 클릭시 실행되는 메서드
	public void buttonClick(Object source) {
		if (source.equals(this.approve)) {
			// 보험 승인 버튼 클릭시
			this.acceptInsDesignController.approve(this.insuranceDesign.getInsuranceDesignId());
			JOptionPane.showMessageDialog(this, "해당 보험설계서가 승인되었습니다.");
		}else if (source.equals(this.disApprove)) {
			// 보험 미승인버튼 클릭시
			this.acceptInsDesignController.disapprove(this.insuranceDesign.getInsuranceDesignId());
			JOptionPane.showMessageDialog(this, "해당 보험설계서가 미승인되었습니다.");
		}else if(source.equals(this.back)){
			// 뒤로가기 버튼 클릭시
			this.information.setVisible(false);
			this.btnPanel.setVisible(false);
			this.removeAll();
			// 보험 승인하기 패널(AcceptInsPanel)으로 부터 생성된 패널에서  뒤로가기 버튼을 눌럿을 경우
			if (this.acceptInsPanel != null) {this.acceptInsPanel.createPanel();}
			// 승인된 보험 상세조회하기 패널(AcceptedInsPanel)으로 부터 생성된 패널에서 뒤로가기 버튼을 눌럿을 경우
			if(acceptedInsPanel != null){this.acceptedInsPanel.createDefaultPanel();}
		}
		repaint();
		revalidate();
	}
	private class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			buttonClick(e.getSource());
		}
	}
}