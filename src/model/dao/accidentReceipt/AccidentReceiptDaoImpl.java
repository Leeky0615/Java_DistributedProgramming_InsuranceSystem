package model.dao.accidentReceipt;

import java.util.ArrayList;
import java.util.List;

import model.dao.Dao;
import model.dto.AccidentReceipt;

public class AccidentReceiptDaoImpl extends Dao implements AccidentReceiptDao{
	public AccidentReceiptDaoImpl() {super();}
	
	public ArrayList<AccidentReceipt> select() {
		/*
		 *  super클래스(Dao클래스)에서 선언한 session(인스턴스변수)의 
		 *  함수 selectList()를 사용 -> 테이블에 있는 모든 값을 list에 담음
		 *  selectList()에 있는 파라미터는 mapper.xml파일에서 
		 *  미리 정해둔 Select태그를 이용 -> mapper이름+사용할 태그이름
		 */
		List<AccidentReceipt> list = this.session.selectList("AccidentReceipt.Select");
		return (ArrayList<AccidentReceipt>)list;
	}
	public void insert(AccidentReceipt accidentReceipt) {super.insert(accidentReceipt.getClass().getSimpleName(), accidentReceipt);}
	public void update(AccidentReceipt accidentReceipt) {super.update(accidentReceipt.getClass().getSimpleName(), accidentReceipt);}
}
