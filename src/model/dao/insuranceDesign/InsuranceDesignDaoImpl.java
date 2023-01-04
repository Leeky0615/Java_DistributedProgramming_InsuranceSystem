package model.dao.insuranceDesign;

import java.util.ArrayList;
import java.util.List;

import constants.ViewConstants.EApprovalStatus;
import model.dao.Dao;
import model.entity.ContractCondition;
import model.entity.Insurance;
import model.entity.InsuranceDesign;

public class InsuranceDesignDaoImpl extends Dao implements InsuranceDesignDao{
	public InsuranceDesignDaoImpl() {super();}

	/*  super클래스(Dao클래스)에서 선언한 session(인스턴스변수)의
	 *  함수 selectList()를 사용 -> 테이블에 있는 모든 값을 list에 담음
	 *  selectList()에 있는 파라미터는 mapper.xml파일에서
	 *  미리 정해둔 Select태그를 이용 -> mapper이름+사용할 태그이름
	 */
	public ArrayList<InsuranceDesign> select() {
		List<InsuranceDesign> list = session.selectList("InsuranceDesign.Select");
		return (ArrayList<InsuranceDesign>)list;
	}

	/*
	 *  super클래스(Dao클래스)의 insert()함수 호출
	 *  -> 파라미터로 객체의 이름과 객체를 보냄.
	 */
	public void insert(InsuranceDesign insuranceDesign) {
		Insurance insurance = insuranceDesign.getInsurance();
		ContractCondition contractCondition = insurance.getContractCondition();

		super.insert(contractCondition.getClass().getSimpleName(), contractCondition);
		super.insert(insurance.getClass().getSimpleName(), insurance);
		super.insert(insuranceDesign.getClass().getSimpleName(), insuranceDesign);
	}

	public void delete(int insuranceDesignId) {
		super.update(Insurance.class.getSimpleName(), insuranceDesignId*10);
		super.update(ContractCondition.class.getSimpleName(), insuranceDesignId*10);
	}

	public void update(InsuranceDesign insuranceDesign) {
		super.update(insuranceDesign.getClass().getSimpleName(), insuranceDesign);
		if (insuranceDesign.getApprovalStatus() == EApprovalStatus.ApprovalIns) {
			Insurance insurance = insuranceDesign.getInsurance();
			ContractCondition contractCondition = insurance.getContractCondition();

			super.update(insurance.getClass().getSimpleName(), insurance);
			super.update(contractCondition.getClass().getSimpleName(), contractCondition);
		}
	}


}
