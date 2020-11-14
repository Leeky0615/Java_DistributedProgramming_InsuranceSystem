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
import control.insuranceDevelopment.InsuranceDesignListImpl;

public class AcceptedInsPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private InsuranceDesignListImpl insuranceDesignList;
	private AcceptInsPanel acceptInsPanel;

	private InsuranceDesignTable insuranceDesignTable;
	private JButton detailCheckBtn,backBtn;
	private ActionHandler actionHandler;
	private MouseHandler mousehandler;

	public AcceptedInsPanel(AcceptInsPanel acceptInsPanel, InsuranceDesignListImpl insuranceDesignList) {
		this.acceptInsPanel = acceptInsPanel;
		this.insuranceDesignList = insuranceDesignList;
		this.mousehandler = new MouseHandler();

		this.createDefaultPanel();
	}
	public void createDefaultPanel() {
		this.removeAll();
		this.setLayout(null);
		
		// 보험설계서 리스트 테이블
		this.insuranceDesignTable = new InsuranceDesignTable((InsuranceDesignListImpl) this.insuranceDesignList, true);
		this.insuranceDesignTable.addMouseListener(mousehandler);
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(12, 10, 576, 364);
		scroll.setBorder(new TitledBorder(new LineBorder(Color.lightGray,1),"승인된 보험설계서 리스트"));
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		scroll.setViewportView(this.insuranceDesignTable);
		scroll.setPreferredSize(new Dimension(EMainFrame.eWidth.getValue(),50));
		this.add(scroll);
		
		// 버튼이 담긴 패널 생성
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(12, 384, 576, 116);
		panel.setBorder(new TitledBorder(new LineBorder(Color.lightGray,1)));
		this.actionHandler = new ActionHandler();
		
		this.detailCheckBtn = new JButton("보험 상세 확인하기");
		this.detailCheckBtn.setFont(EViewFrame.eFont.getFont());
		this.detailCheckBtn.setBounds(12, 10, 552, 42);
		this.detailCheckBtn.addActionListener(this.actionHandler);
		
		this.backBtn = new JButton("뒤로가기");
		this.backBtn.setFont(EViewFrame.eFont.getFont());
		this.backBtn.setBounds(12, 62, 552, 42);
		this.backBtn.addActionListener(this.actionHandler);
		
		panel.add(this.detailCheckBtn);
		panel.add(this.backBtn);
		this.add(panel);
		updateUI();
	}
	
	// 버튼 클릭시 실행되는 메소드
	public void buttonClick(Object source) {
		if (source.equals(this.backBtn)) {
			// 뒤로가기 버튼클릭시 현재 패널을 초기화하고 이전 패널을 생성
			this.removeAll();
			this.acceptInsPanel.createPanel();
			this.insuranceDesignTable.setVisible(false);
			this.backBtn.setVisible(false);
		}else if(source.equals(this.detailCheckBtn)){
			// 상세조회 버튼클릭시 상세조회패널을 생성
			this.removeAll();
			InsuranceDesignPanel insuranceDesignPanel = new InsuranceDesignPanel(this,this.insuranceDesignList,this.insuranceDesignTable.getRow());
			this.setLayout(new GridLayout(1,1));
			this.add(insuranceDesignPanel);
		}
		updateUI();
		revalidate();
	}
	
	// 버튼클릭시 사용되는 Handler
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
