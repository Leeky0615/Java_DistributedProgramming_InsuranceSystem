package model.accidentReceipt;

import java.util.ArrayList;
import java.util.List;

import control.accidentReceipt.AccidentReceipt;
import model.Dao;

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
	
//-----------------------------------------------------------------------------------------------
	public void insert(AccidentReceipt accidentReceipt) {
		try {
			StringBuilder sb1 = new StringBuilder();
			sb1.append("INSERT INTO accidentreceipt (`accidentReceiptid`, `accidentreceiptname`, `customername`, "
					+ "`customerid`, `insurancetype`, `paymentmethod`, `accidentdate`, "
					+ "`hospitalname`, `deathstatus`, `accidentplace`, `diagnosisname`, "
					+ "`damagescale`, `accidentcircumstances`, `money`, `paymentstatus`) VALUES ('");
			sb1.append(accidentReceipt.getAccidentReceiptId()+"', '");
			sb1.append(accidentReceipt.getAccidentReceiptName()+"', '");
			sb1.append(accidentReceipt.getCustomerName()+"', '");
			sb1.append(accidentReceipt.getCustomerId()+"', '");
			sb1.append(accidentReceipt.getInsuranceType()+"', '");
			switch (accidentReceipt.getPaymentMethod()) {
				case ACCOUNT:sb1.append("ACCOUNT', '");break; 
				case CARD:sb1.append("CARD'', '");break; 
				case CASH:sb1.append("CASH', '");break; 
				default:break;
			}
			sb1.append(accidentReceipt.getAccidentDate()+"', '");
			sb1.append(accidentReceipt.getHospitalName()+"', '");
			if (accidentReceipt.isDeathStatus()) {sb1.append(1+"', '");}
			else {sb1.append(0+"', '");}
			sb1.append(accidentReceipt.getAccidentPlace()+"', '");
			sb1.append(accidentReceipt.getDiagnosisName()+"', '");
			sb1.append(accidentReceipt.getDamageScale()+"', '");
			sb1.append(accidentReceipt.getAccidentCircumstances()+"', '");
			sb1.append(accidentReceipt.getMoney()+"', '");
			sb1.append(0+"');");
			super.insert(sb1.toString());
		} catch (Exception e) {e.printStackTrace();}
	}

	public void update(boolean status, int accidentReceiptId) {
		try {
			System.out.println(status);
			StringBuilder sb1 = new StringBuilder();
			sb1.append("UPDATE accidentreceipt SET `paymentstatus` = '");
			if (status) {sb1.append(1+"' WHERE (`accidentReceiptid` = '");}
			else {sb1.append(0+"' WHERE (`accidentReceiptid` = '");}
			sb1.append(accidentReceiptId+"');");
			super.update(sb1.toString());
		} catch (Exception e) {e.getStackTrace();}
	}
	
}
