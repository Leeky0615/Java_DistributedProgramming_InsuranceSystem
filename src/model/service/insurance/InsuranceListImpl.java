package model.service.insurance;

import java.util.ArrayList;

import model.dao.insurance.InsuranceDao;
import model.dao.insurance.InsuranceDaoImpl;

public class InsuranceListImpl implements InsuranceList {
	private InsuranceDao insuranceDao;
	private ArrayList<Insurance> insuranceList;

	public InsuranceListImpl(){
		this.insuranceDao = new InsuranceDaoImpl();
	}

	public ArrayList<Insurance> getInsuranceList() {return this.insuranceList = this.insuranceDao.select();}
	
	public boolean add(Insurance insurance){
		this.insuranceList.add(insurance);
		return true;
	}
	public boolean delete(Insurance insurance){
		this.insuranceList.remove(insurance);
		return false;
	}
	public boolean deleteById(int insuranceId){
		this.insuranceList.remove(insuranceId);
		return false;
	}

	public Insurance searchByName(String insuranceName){
		for(Insurance insurance : this.insuranceList) {
			if (insurance.getInsuranceName() == insuranceName) {return insurance;}
		}
		return null;
	}
	public Insurance searchById(int insuranceId){
		for(Insurance insurance : this.insuranceList) {
			if (insurance.getInsuranceId() == insuranceId) {return insurance;}
		}
		return null;
	}

}