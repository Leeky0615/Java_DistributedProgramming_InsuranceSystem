package model.dao.insurance;

import java.util.ArrayList;

import model.dto.Insurance;

public interface InsuranceDao {
	public void insert(Insurance insurance);

	public ArrayList<Insurance> select() ;
}
