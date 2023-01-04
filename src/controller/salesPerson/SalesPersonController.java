package controller.salesPerson;

import java.util.ArrayList;

import model.entity.SalesPerson;
import model.service.salesPerson.SalesPersonListImpl;

public interface SalesPersonController {
	public void connectCtoS(SalesPersonListImpl salesPersonList);
	public ArrayList<SalesPerson> getSalesPersonlist();

}
