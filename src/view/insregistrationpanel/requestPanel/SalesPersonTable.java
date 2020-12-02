package view.insregistrationpanel.requestPanel;

import java.util.Vector;

import model.dto.SalesPerson;
import model.service.salesPerson.SalesPersonListImpl;
import view.defaultClass.Default_SalesPersonTable;

public class SalesPersonTable extends Default_SalesPersonTable{
	private static final long serialVersionUID = 1L;
	
	#private SalesPersonListImpl salesPersonList;
	
	public SalesPersonTable(#SalesPersonListImpl salesPersonList) {
		super();
		this.salesPersonList = salesPersonList;
		this.refresh();
	}

	public void refresh() {
		this.rowData.clear();
		for (SalesPerson salesPerson : this.salesPersonList.getSalesPersonlist()) {
			Vector<Object> salesPersonList = new Vector<Object>();
			salesPersonList.add(salesPerson.getName());
			salesPersonList.add(salesPerson.getPhoneNum());
			salesPersonList.add(salesPerson.getOffice());
			this.rowData.add(salesPersonList);
		}
		this.updateUI();
	}
}
