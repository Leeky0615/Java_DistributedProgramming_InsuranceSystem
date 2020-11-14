package control.insurance;

import java.util.ArrayList;

public interface InsuranceList {
	public ArrayList<Insurance> getInsuranceList();
	public void setInsuranceList(ArrayList<Insurance> insuranceList);
	public boolean add(Insurance insurance);
	public boolean delete(Insurance insurance);
	public boolean deleteById(int insuranceId);
	public Insurance searchByName(String insuranceName);
	public Insurance searchById(int insuranceId);
}

