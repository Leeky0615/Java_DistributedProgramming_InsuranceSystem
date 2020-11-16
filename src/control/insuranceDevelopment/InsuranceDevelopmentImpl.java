package control.insuranceDevelopment;

import java.util.Vector;

import constants.ControlConstants.EInsuranceType;
import constants.ViewConstants.EApprovalStatus;
import constants.ViewConstants.EInsuranceDesign;
import control.insurance.CancerInsurance;
import control.insurance.CarInsurance;
import control.insurance.FireInsurance;
import model.insuranceDesign.InsuranceDesignDaoImpl;

public class InsuranceDevelopmentImpl implements InsuranceDevelopment{
	private InsuranceDesignDaoImpl insuranceDesignDao;
	private InsuranceDesignList insuranceDesignList;

	public InsuranceDevelopmentImpl(){this.insuranceDesignDao = new InsuranceDesignDaoImpl();}
	
	public void associate(InsuranceDesignListImpl insuranceDesignList) {this.insuranceDesignList = insuranceDesignList;}

	public void designInsurance(Vector<String> infos){
		InsuranceDesign insuranceDesign = new InsuranceDesign();
		String insType = infos.get(EInsuranceDesign.insuranceType.ordinal());
		// ���� ������ ���� ����������
		if (insType.equals(EInsuranceType.CANCER.getText())) {insuranceDesign.setInsurance(new CancerInsurance());}
		else if(insType.equals(EInsuranceType.CAR.getText())) {insuranceDesign.setInsurance(new CarInsurance());}
		else {insuranceDesign.setInsurance(new FireInsurance());}
		// ���輳�輭�� ���� ������ ���������� ������
		insuranceDesign.setInsuranceDesignId(Integer.parseInt(infos.get(EInsuranceDesign.insuranceDesignId.ordinal())));
		insuranceDesign.setWriter(infos.get(EInsuranceDesign.writer.ordinal()));
		insuranceDesign.getInsurance().setInsuranceName(infos.get(EInsuranceDesign.insuranceName.ordinal()));
		insuranceDesign.setMadeDate(infos.get(EInsuranceDesign.madedate.ordinal()));
		insuranceDesign.getInsurance().getContractCondition().setGuarantee(Integer.parseInt(infos.get(EInsuranceDesign.guarantee.ordinal())));
		insuranceDesign.getInsurance().getContractCondition().setPayment(Integer.parseInt(infos.get(EInsuranceDesign.payment.ordinal())));
		insuranceDesign.getInsurance().getContractCondition().setPeriod(Integer.parseInt(infos.get(EInsuranceDesign.period.ordinal())));
		insuranceDesign.getInsurance().setInsuranceDescription(infos.get(EInsuranceDesign.description.ordinal()));
		insuranceDesign.getInsurance().setInsuranceId(insuranceDesign.getInsuranceDesignId()*10);
		insuranceDesign.getInsurance().getContractCondition().setContractConditionID(insuranceDesign.getInsuranceDesignId()*10);
		insuranceDesign.setApprovalStatus(this.requestApproval());
		// ���輳�輭 ����Ʈ�� ���輳�輭�� ����
		this.insuranceDesignList.add(insuranceDesign);
		this.insuranceDesignDao.insert(insuranceDesign);
	}
	
	public EApprovalStatus requestApproval(){return EApprovalStatus.RequestInsDesign;}
}