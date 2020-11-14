package view.defaultClass;

import java.awt.Dimension;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import constants.ViewConstants.EMainFrame;
import constants.ViewConstants.ESalesPersonHead;

public class Default_SalesPersonTable extends JTable{
	private static final long serialVersionUID = 1L;
	protected Vector<Vector<Object>> rowData;
	
	public Default_SalesPersonTable() {
		this.rowData = new Vector<Vector<Object>>();
		
		this.setPreferredSize(new Dimension(EMainFrame.eWidth.getValue(), EMainFrame.eHeight.getValue() / 9 * 3));
		this.setModel(setDefaultTableModel(rowData));
		this.initTable();
	}
	
	
	// 보험설계서 테이블을 만들때 사용되는 메소드
	public void initTable() {
		DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
		cellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		this.getColumnModel().getColumn(0).setPreferredWidth(30);
		this.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
		this.getColumnModel().getColumn(1).setPreferredWidth(100);
		this.getColumnModel().getColumn(1).setCellRenderer(cellRenderer);
		this.getColumnModel().getColumn(2).setPreferredWidth(50);
		this.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
		
		this.getTableHeader().setReorderingAllowed(false); 
		this.getTableHeader().setResizingAllowed(false);
		this.getTableHeader().setDefaultRenderer(cellRenderer);
		
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setFillsViewportHeight(true);
	}
	public Vector<Object> setHead(){
		Vector<Object> head = new Vector<Object>();
		for (ESalesPersonHead eSalesPersonHead : ESalesPersonHead.values()) {head.add(eSalesPersonHead.getText());}
		return head;
	}
	public DefaultTableModel setDefaultTableModel(Vector<Vector<Object>> rowData) {
		DefaultTableModel dtm = new DefaultTableModel(rowData, setHead()){
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int rowindex, int mColIndex) {return false;}
		};
		return dtm;
	}
	
	public Vector<Object> getRow() {
		try {return this.rowData.get(this.getSelectedRow());}
		catch (Exception e) {return null;}
	}
}
