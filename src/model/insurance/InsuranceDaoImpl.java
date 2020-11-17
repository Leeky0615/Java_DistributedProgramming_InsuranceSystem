package model.insurance;

import java.util.ArrayList;
import java.util.List;

import control.insurance.Insurance;
import model.Dao;

public class InsuranceDaoImpl extends Dao implements InsuranceDao{
	public InsuranceDaoImpl() {super();}
	
	/*  super클래스(Dao클래스)에서 선언한 session(인스턴스변수)의 
	 *  함수 selectList()를 사용 -> 테이블에 있는 모든 값을 list에 담음
	 *  selectList()에 있는 파라미터는 mapper.xml파일에서 
	 *  미리 정해둔 Select태그를 이용 -> mapper이름+사용할 태그이름
	 */
	public ArrayList<Insurance> select() {
		List<Insurance> list = session.selectList("Insurance.Select");
		return (ArrayList<Insurance>)list;
	}
	
	/*
	 *  super클래스(Dao클래스)의 insert()함수 호출
	 *  -> 파라미터로 객체의 이름과 객체를 보냄.
	 */
	public void insert(Insurance insurance) {super.insert(insurance.getClass().getSimpleName(), insurance);}
}
