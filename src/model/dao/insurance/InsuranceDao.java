package model.dao.insurance;

import java.util.ArrayList;

import model.service.insurance.Insurance;

public interface InsuranceDao {
	public void insert(Insurance insurance);

	public ArrayList<Insurance> select() ;
}
