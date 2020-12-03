package view.insregistrationpanel.requestPanel;

import java.util.Vector;

import constants.ControllerConstants.EController;
import controller.salesPerson.SalesPersonControllerImpl;
import main.FrontController;
import model.service.salesPerson.SalesPerson;
import view.defaultClass.Default_SalesPersonTable;

public class SalesPersonTable extends Default_SalesPersonTable{
	private static final long serialVersionUID = 1L;
	
	private SalesPersonControllerImpl salesPersonController;
	
	public SalesPersonTable(FrontController frontController) {
		super();
		this.salesPersonController = (SalesPersonControllerImpl) frontController.mappingController(EController.SalesPersonController.getControllerName());
		this.refresh();
	}

	public void refresh() {
		this.rowData.clear();
		for (SalesPerson salesPerson : this.salesPersonController.getSalesPersonlist()) {
			Vector<Object> salesPersonList = new Vector<Object>();
			salesPersonList.add(salesPerson.getName());
			salesPersonList.add(salesPerson.getPhoneNum());
			salesPersonList.add(salesPerson.getOffice());
			this.rowData.add(salesPersonList);
		}
		this.updateUI();
	}
}
