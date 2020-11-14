package control.salesPerson;

import java.util.ArrayList;

import model.salesPerson.SalesPersonDao;
import model.salesPerson.SalesPersonDaoImpl;

public class SalesPersonListImpl implements SalesPersonList{
	private ArrayList<SalesPerson> salesPersonlist;
	private SalesPersonDao salesPersonDao;
	
	public SalesPersonListImpl() {
		this.salesPersonDao = new SalesPersonDaoImpl();
		this.salesPersonlist = salesPersonDao.select();
	}
	public ArrayList<SalesPerson> getSalesPersonlist() {return salesPersonlist;}
	public void setSalesPersonlist(ArrayList<SalesPerson> salesPersonlist) {this.salesPersonlist = salesPersonlist;}
}
