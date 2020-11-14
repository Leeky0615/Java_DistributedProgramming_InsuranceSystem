package model.insurance;

import java.util.ArrayList;

import control.insurance.Insurance;

public interface InsuranceDao {
	public void insert(Insurance insurance);

	public ArrayList<Insurance> select() ;
}
