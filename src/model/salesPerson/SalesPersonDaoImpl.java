package model.salesPerson;

import java.util.ArrayList;
import java.util.List;

import control.salesPerson.SalesPerson;
import model.Dao;

public class SalesPersonDaoImpl extends Dao implements SalesPersonDao{
	public SalesPersonDaoImpl() {super();}

	public ArrayList<SalesPerson> select() {
		List<SalesPerson> list = session.selectList("SalesPerson.Select");
		return (ArrayList<SalesPerson>)list;
	}
}
