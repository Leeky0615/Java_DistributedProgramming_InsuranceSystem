package model.service.insuranceDevelopment;

import java.util.ArrayList;

import model.dao.insuranceDesign.InsuranceDesignDao;
import model.dao.insuranceDesign.InsuranceDesignDaoImpl;
import model.dto.InsuranceDesign;

public class InsuranceDesignListImpl implements InsuranceDesignList {
	private InsuranceDesignDao insuranceDesignDao;
	private ArrayList<InsuranceDesign> insuranceDesignList;

	public InsuranceDesignListImpl(){
		this.insuranceDesignDao = new InsuranceDesignDaoImpl();
		this.insuranceDesignList = this.insuranceDesignDao.select();
	}
	public ArrayList<InsuranceDesign> getInsuranceDesignList() {return insuranceDesignList;}
	public void setInsuranceDesignList(ArrayList<InsuranceDesign> insuranceDesignList) {this.insuranceDesignList = insuranceDesignList;}
	
	public boolean add(InsuranceDesign insuranceDesign){
		this.insuranceDesignList.add(insuranceDesign);
		return false;
	}

	public boolean deleteById(int insuranceDesignId){
		this.insuranceDesignList.remove(insuranceDesignId);
		return false;
	}

	@SuppressWarnings("unlikely-arg-type")
	public boolean deleteByName(String insuranceName){
		this.insuranceDesignList.remove(insuranceName);
		return false;
	}

	public InsuranceDesign searchById(int insuranceDesignId){
		for(InsuranceDesign insuranceDesign : this.insuranceDesignList) {
			if (insuranceDesign.getInsuranceDesignId() == insuranceDesignId) {return insuranceDesign;}
		}
		return null;
	}


	public InsuranceDesign searchByInsuranceName(String insuranceName){
		for(InsuranceDesign insuranceDesign : this.insuranceDesignList) {
			if (insuranceDesign.getInsurance().getInsuranceName().equals(insuranceName)) {return insuranceDesign;}
		}
		return null;
	}
	
	public ArrayList<InsuranceDesign> searchByWriterName(String writer){
		ArrayList<InsuranceDesign> insDesignList = new ArrayList<InsuranceDesign>();
		for(InsuranceDesign insuranceDesign : this.insuranceDesignList) {
			if (insuranceDesign.getWriter().equals(writer)) {insDesignList.add(insuranceDesign);}
		}
		return insDesignList;
	}

}