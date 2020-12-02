package model.service.salesPerson;

import java.util.ArrayList;

import model.dao.salesPerson.SalesPersonDao;
import model.dao.salesPerson.SalesPersonDaoImpl;
import model.dto.SalesPerson;

public class SalesPersonListImpl implements SalesPersonList {
	private ArrayList<SalesPerson> salesPersonlist;
	private SalesPersonDao salesPersonDao;

	public SalesPersonListImpl() {
		this.salesPersonDao = new SalesPersonDaoImpl();
	}

	public ArrayList<SalesPerson> getSalesPersonlist() {
		return this.salesPersonlist = salesPersonDao.select();
	}
}
