package model.salesPerson;

import java.sql.ResultSet;
import java.util.ArrayList;

import control.salesPerson.SalesPerson;
import model.Dao;

public class SalesPersonDaoImpl extends Dao implements SalesPersonDao{
	public SalesPersonDaoImpl() {super();}

	public ArrayList<SalesPerson> select() {
		ArrayList<SalesPerson> salesPersonList = new ArrayList<SalesPerson>();
		try {
			String query = "SELECT * FROM salesPerson;";
			ResultSet rs = this.select(query);
			while(rs.next()) {
				SalesPerson salesPerson = new SalesPerson();
				salesPerson.setName(rs.getString("name"));
				salesPerson.setOffice(rs.getString("office"));
				salesPerson.setPhonNum(rs.getString("phonenum"));
				salesPersonList.add(salesPerson);
			}
			rs.close();
		} catch (Exception e) {e.printStackTrace();}
		return salesPersonList;
	}
}
