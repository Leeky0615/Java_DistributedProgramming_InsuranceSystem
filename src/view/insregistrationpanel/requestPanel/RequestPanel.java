package view.insregistrationpanel.requestPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import constants.ViewConstants.EMainFrame;
import model.service.salesPerson.SalesPersonListImpl;

public class RequestPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private ActionListener actionListener;
	#private SalesPersonListImpl salesPersonList;
	private SalesPersonTable salesPersonTable;
	private JButton yes;
	public RequestPanel(SalesPersonListImpl salesPersonList) {
		this.salesPersonList = salesPersonList;
		this.setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		JLabel jlabel = new JLabel("보험영업자에게 면담을 요청하시겠습니까?");
		panel.add(jlabel);
		this.actionListener = new ActionHandler();
		this.yes = new JButton("예");
		this.yes.addActionListener(actionListener);
		panel.add(yes);
		this.add(panel, BorderLayout.NORTH);
		
        this.salesPersonTable = new SalesPersonTable(this.salesPersonList);
		JScrollPane scroll = new JScrollPane();
   		scroll.setBounds(12, 127, 576, 185);
   		scroll.setBorder(new TitledBorder(new LineBorder(Color.lightGray,1),"주변 보험영업자  리스트"));
   		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
   		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
   		scroll.setViewportView(this.salesPersonTable);
   		scroll.setPreferredSize(new Dimension(EMainFrame.eWidth.getValue(),50));
   		this.add(scroll, BorderLayout.CENTER);
	}
	
	private void buttonclick(Object source) {
		if (source.equals(this.yes)) {
			JOptionPane.showMessageDialog(this, "면담 신청이 완료되었습니다.");
		}
	}
	private class ActionHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			buttonclick(e.getSource());
		}

	}

}
