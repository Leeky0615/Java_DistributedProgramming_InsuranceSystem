package controller.salesPerson;

import java.util.ArrayList;

import model.entity.SalesPerson;
import model.service.salesPerson.SalesPersonListImpl;

public class SalesPersonControllerImpl implements SalesPersonController {
	private SalesPersonListImpl salesPersonList;

	public SalesPersonControllerImpl() {}

	public void connectCtoS(SalesPersonListImpl salesPersonList) {this.salesPersonList = salesPersonList;}

	public ArrayList<SalesPerson> getSalesPersonlist() {return this.salesPersonList.getSalesPersonlist();}
}
