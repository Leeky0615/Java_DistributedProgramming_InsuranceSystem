package controller.salesPerson;

import model.service.salesPerson.SalesPersonListImpl;

public class SalesPersonControllerImpl implements SalesPersonController {
	private SalesPersonListImpl salesPersonList;
	public SalesPersonControllerImpl() {
		
	}

	public void connectCtoS(SalesPersonListImpl salesPersonList) {
		this.salesPersonList = salesPersonList;
	}
}
