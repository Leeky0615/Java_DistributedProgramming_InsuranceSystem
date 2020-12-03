package model.dao.insuranceRegistration;

import java.util.ArrayList;
import java.util.List;

import constants.ControlConstants.EInsuranceType;
import model.dao.Dao;
import model.service.customer.Customer;
import model.service.insurance.CancerInsurance;
import model.service.insurance.CarInsurance;
import model.service.insurance.FireInsurance;
import model.service.insurance.Insurance;
import model.service.insuranceDesign.InsuranceDesign;

public class InsuranceRegistrationDaoImpl extends Dao implements InsuranceRegistrationDao{
	public InsuranceRegistrationDaoImpl() {super();}
	
	/*  super클래스(Dao클래스)에서 선언한 session(인스턴스변수)의 
	 *  함수 selectList()를 사용 -> 테이블에 있는 모든 값을 list에 담음
	 *  selectList()에 있는 파라미터는 mapper.xml파일에서 
	 *  미리 정해둔 Select태그를 이용 -> mapper이름+사용할 태그이름
	 */
	public ArrayList<InsuranceDesign> select() {
		List<InsuranceDesign> list = session.selectList("InsuranceDesign.Select");
		return (ArrayList<InsuranceDesign>)list;
	}
	
	/*  super클래스(Dao클래스)에서 선언한 session(인스턴스변수)의 
	 *  함수 selectOne()를 사용 -> 파라미터 값을 만족하는 하나의 row의 정보를 담은 객체를 가져옴
	 *  selectOne()에 있는 파라미터는 mapper.xml파일에서 
	 *  미리 정해둔 Select태그를 이용 -> mapper이름+사용할 태그이름
	 */
	public Insurance selectByCancerInsurance(int customerId) {
		Insurance insurance = new CancerInsurance();
		insurance = this.session.selectOne("Cancer.Select", customerId);
		return insurance;
	}
	public Insurance selectByCarInsurance(int customerId) {
		Insurance insurance = new CarInsurance();
		insurance = this.session.selectOne("Car.Select", customerId);
		return insurance;
	}
	public Insurance selectByFireInsurance(int customerId) {
		Insurance insurance = new FireInsurance();
		insurance = this.session.selectOne("Fire.Select", customerId);
		return insurance;
	}
	
	/*
	 *  super클래스(Dao클래스)의 insert()함수 호출
	 *  -> 파라미터로 객체의 이름과 객체를 보냄.
	 */
	public void insert(Insurance insurance) {super.insert(insurance.getClass().getSimpleName(), insurance);}
	
	public void update(Customer customer) {super.update(customer.getClass().getSimpleName(), customer);}
	
	public void delete(EInsuranceType eInsuranceType, int customerId) {
			if (eInsuranceType == EInsuranceType.CANCER) {
				super.update(CancerInsurance.class.getSimpleName(), customerId);
			}else if(eInsuranceType == EInsuranceType.CAR) {
				super.update(CarInsurance.class.getSimpleName(), customerId);
			}else if(eInsuranceType == EInsuranceType.FIRE) {
				super.update(FireInsurance.class.getSimpleName(), customerId);
			}
	}
}
	
