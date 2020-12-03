package model.service.insuranceDesign;

import java.util.ArrayList;


public interface InsuranceDesignList {
	public ArrayList<InsuranceDesign> getInsuranceDesignList();
	public boolean add(InsuranceDesign insuranceDesign);
	public boolean deleteById(int insuranceDesginId);
	public boolean deleteByName(String insuranceName);
	public InsuranceDesign searchById(int insuranceDesignId);
	public InsuranceDesign searchByInsuranceName(String insuranceName);
	public ArrayList<InsuranceDesign> searchByWriterName(String writer);
}