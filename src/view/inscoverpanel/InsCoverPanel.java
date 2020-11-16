package view.inscoverpanel;

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
import control.accidentReciept.AccidentReceiptListImpl;
import control.insuranceCover.InsuranceCoverImpl;
import main.Menu;
import view.defaultClass.DefaultPanel;

public class InsCoverPanel extends DefaultPanel{
	private static final long serialVersionUID = 1L;
	
	private AccidentReceiptListImpl accidentReceiptList;
	private InsuranceCoverImpl insuranceCover;
	
	private AccidentReceiptTable accidentReceiptTable;
	private JButton detailCheckBtn, writeAccidentReceiptBtn,refreshBtn;
	private ActionHandler actionHandler;
	private MouseHandler mousehandler;
	public InsCoverPanel(Menu menu) {
		super(menu);
		this.accidentReceiptList = (AccidentReceiptListImpl)this.menu.getAccidentReceiptList();
		this.insuranceCover = (InsuranceCoverImpl)this.menu.getInsuranceCover();
		this.actionHandler = new ActionHandler();
		this.mousehandler = new MouseHandler();
		
		this.createPanel();
	}
	
	public void createPanel() {
		this.removeAll();
		this.setLayout(null);
		this.accidentReceiptTable = new AccidentReceiptTable(this.accidentReceiptList);
		this.accidentReceiptTable.addMouseListener(this.mousehandler);
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(12, 10, 576, 302);
		scroll.setBorder(new TitledBorder(new LineBorder(Color.lightGray,1),"��������� ����Ʈ"));
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		scroll.setViewportView(this.accidentReceiptTable);
		scroll.setPreferredSize(new Dimension(EMainFrame.eWidth.getValue(),50));
		this.add(scroll);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 322, 576, 168);
		panel.setBorder(new TitledBorder(new LineBorder(Color.lightGray,1)));
		this.detailCheckBtn = new JButton("��������� �� Ȯ���ϱ�");
		this.detailCheckBtn.setFont(EViewFrame.eFont.getFont());
		this.detailCheckBtn.setBounds(12, 62, 552, 42);
		this.detailCheckBtn.addActionListener(actionHandler);
		this.writeAccidentReceiptBtn = new JButton("��������� �ۼ��ϱ�");
		this.writeAccidentReceiptBtn.setFont(EViewFrame.eFont.getFont());
		this.writeAccidentReceiptBtn.setBounds(12, 10, 552, 42);
		this.writeAccidentReceiptBtn.addActionListener(actionHandler);
		panel.add(this.writeAccidentReceiptBtn);
		this.refreshBtn = new JButton("���� ��ħ");
		this.refreshBtn.setFont(EViewFrame.eFont.getFont());
		this.refreshBtn.setBounds(12, 114, 552, 42);
		this.refreshBtn.addActionListener(actionHandler);
		panel.setLayout(null);
		panel.add(this.detailCheckBtn);
		panel.add(this.refreshBtn);
		this.add(panel);
		
		scroll.updateUI();
		panel.updateUI();
	}
	
	public void buttonClick(Object source) {
		if (source.equals(this.detailCheckBtn)) {
			if (this.accidentReceiptTable.getRow() == null) {
				JOptionPane.showMessageDialog(null, "����������� ������ �ּ���.", "��� ������ ����", JOptionPane.WARNING_MESSAGE);
				return;
			}else {
				this.removeAll();
				AccidentReceiptPanel accidentReceiptPanel = new AccidentReceiptPanel(this, this.insuranceCover,this.accidentReceiptList,this.accidentReceiptTable.getRow());
				this.setLayout(new GridLayout(1,1));
				this.add(accidentReceiptPanel);
			}
		}else if(source.equals(this.writeAccidentReceiptBtn)) {
			WriteAccidentReceiptFrame accidentReceiptFrame = new WriteAccidentReceiptFrame(this.insuranceCover);
			accidentReceiptFrame.setVisible(true);
			if (!(accidentReceiptFrame.isFocusable())) {this.createPanel();}
		}else {this.createPanel();}
		this.updateUI();
	}
	
	
	private class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			buttonClick(e.getSource());
		}
	}
	
	// ���̺��� ����Ŭ������ �� ���� ����ȸ�ϱ� ��ư�� ���� �������ȸ�ϱ��г��� ������.
	public void selectRow() {
		if (this.accidentReceiptTable.getRow() == null) {
			JOptionPane.showMessageDialog(null, "����������� ������ �ּ���.", "��� ������ ����", JOptionPane.WARNING_MESSAGE);
			return;
		}else{this.detailCheckBtn.doClick();}
	}
	private class MouseHandler extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() == 2) {selectRow();}
		}
	}

	
}