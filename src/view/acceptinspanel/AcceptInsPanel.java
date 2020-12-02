package view.acceptinspanel;

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
import constants.ViewConstants.EViewFrame;
import main.Menu;
import model.service.acceptInsuranceDesign.AcceptInsDesignImpl;
import model.service.insuranceDevelopment.InsuranceDesignListImpl;
import view.defaultClass.DefaultPanel;

public class AcceptInsPanel extends DefaultPanel {
	private static final long serialVersionUID = 1L;
	private InsuranceDesignListImpl insuranceDesignList;
	private AcceptInsDesignImpl AcceptInsuranceDesign;
	
	private InsuranceDesignTable insuranceDesignTable;
	private JButton detailCheckBtn,acceptedInsBtn;
	
	private ActionHandler actionHandler;
	private MouseHandler mousehandler;


	public AcceptInsPanel(Menu menu) {
		super(menu);
		this.insuranceDesignList = (InsuranceDesignListImpl)this.menu.getInsuranceDesignList();
		this.AcceptInsuranceDesign= (AcceptInsDesignImpl)this.menu.getAcceptInsuranceDesign();
		this.mousehandler = new MouseHandler();

		this.createPanel();
	}
	
	public void createPanel() {
		this.removeAll();
		this.setLayout(null);
		// 테이블 생성
		this.insuranceDesignTable = new InsuranceDesignTable((InsuranceDesignListImpl) this.insuranceDesignList, false);
		this.insuranceDesignTable.addMouseListener(mousehandler);
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(12, 10, 576, 364);
		scroll.setBorder(new TitledBorder(new LineBorder(Color.lightGray,1),"보험 설계서 승인 대기 내역"));
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		scroll.setViewportView(this.insuranceDesignTable);
		scroll.setPreferredSize(new Dimension(EMainFrame.eWidth.getValue(),50));
		this.add(scroll);
		
		// 버튼 패널 생성
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(12, 384, 576, 116);
		panel.setBorder(new TitledBorder(new LineBorder(Color.lightGray,1)));
		this.actionHandler = new ActionHandler();
		// 보험상세확인하기 버튼
		this.detailCheckBtn = new JButton("보험 상세 확인하기");
		this.detailCheckBtn.setFont(EViewFrame.eFont.getFont());
		this.detailCheckBtn.setBounds(12, 10, 552, 42);
		this.detailCheckBtn.addActionListener(this.actionHandler);
		// 승인된 보험설계서 리스트 확인하기 버튼
		this.acceptedInsBtn = new JButton("승인된 보험설계서 리스트 확인하기");
		this.acceptedInsBtn.setFont(EViewFrame.eFont.getFont());
		this.acceptedInsBtn.setBounds(12, 62, 552, 42);
		this.acceptedInsBtn.addActionListener(this.actionHandler);
		panel.add(this.detailCheckBtn);
		panel.add(this.acceptedInsBtn);
		this.add(panel);
		
		scroll.updateUI();
		panel.updateUI();
	}
	
	// 버튼 ActionHandler
	public void buttonClick(Object source) {
		if (source.equals(this.detailCheckBtn)) {
			// 상세조회하기 버튼 클릭시
			if (this.insuranceDesignTable.getRow() == null) {
				// Row를 선택하지 않은 경우
				JOptionPane.showMessageDialog(null, "승인할 보험을 선택해주세요.", "설계한 보험 선택", JOptionPane.WARNING_MESSAGE);
				return;
			}else {
				// 보험설계서 패널을 보여줌
				this.removeAll();
				InsuranceDesignPanel insuranceDesignPanel = new InsuranceDesignPanel(this,this.AcceptInsuranceDesign,this.insuranceDesignList,this.insuranceDesignTable.getRow());
				this.setLayout(new GridLayout(1,1));
				this.add(insuranceDesignPanel);
			}
		}else if(source.equals(this.acceptedInsBtn)){
			// 승인된 보험설계서 내역을 클릭하는 경우, 승인된 보험설계서 패널을 보여줌
			this.removeAll();
			AcceptedInsPanel acceptedInsPanel = new AcceptedInsPanel(this,this.insuranceDesignList);
			this.setLayout(new GridLayout(1,1));
			this.add(acceptedInsPanel);
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
		if (this.insuranceDesignTable.getRow() == null) {
			JOptionPane.showMessageDialog(null, "보험설계서를 선택해 주세요.", "보험설계서 선택", JOptionPane.WARNING_MESSAGE);
			return;
		}else{this.detailCheckBtn.doClick();}
	}
	private class MouseHandler extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() == 2) {selectRow();}
		}
	}
}
