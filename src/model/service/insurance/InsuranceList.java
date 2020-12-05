package model.service.insurance;

import java.util.ArrayList;

import model.dto.Insurance;

public interface InsuranceList {
	public ArrayList<Insurance> getInsuranceList();
	public boolean add(Insurance insurance);
	public boolean delete(Insurance insurance);
	public boolean deleteById(int insuranceId);
	public Insurance searchByName(String insuranceName);
	public Insurance searchById(int insuranceId);
}

