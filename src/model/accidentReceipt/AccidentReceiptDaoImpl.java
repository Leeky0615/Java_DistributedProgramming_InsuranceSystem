package model.accidentReceipt;

import java.sql.ResultSet;
import java.util.ArrayList;

import constants.ControlConstants.EInsuranceType;
import constants.ControlConstants.EPaymentMethod;
import control.accidentReciept.AccidentReceipt;
import model.Dao;

public class AccidentReceiptDaoImpl extends Dao implements AccidentReceiptDao{
	public AccidentReceiptDaoImpl() {super();}
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

	public ArrayList<AccidentReceipt> select() {
		ArrayList<AccidentReceipt> accidentReceiptList = new ArrayList<AccidentReceipt>();
		try {
			String query = "SELECT * FROM accidentreceipt;";
			ResultSet rs = this.select(query);
			while(rs.next()) {
				AccidentReceipt accidentReceipt = new AccidentReceipt();
				accidentReceipt.setAccidentReceiptId(rs.getInt("accidentReceiptid"));
				accidentReceipt.setAccidentReceiptName(rs.getString("accidentreceiptname"));
				accidentReceipt.setCustomerName(rs.getString("customername"));
				accidentReceipt.setCustomerId(rs.getString("customerid"));
				switch (rs.getString("insurancetype")) {
				case "CAR":accidentReceipt.setInsuranceType(EInsuranceType.CAR);break; 
				case "CANCER":accidentReceipt.setInsuranceType(EInsuranceType.CANCER);break; 
				case "FIRE":accidentReceipt.setInsuranceType(EInsuranceType.FIRE);break; 
				default:break;
				}
				switch (rs.getString("paymentmethod")) {
				case "CASH":accidentReceipt.setPaymentMethod(EPaymentMethod.CASH);break; 
				case "CARD":accidentReceipt.setPaymentMethod(EPaymentMethod.CARD);break; 
				case "ACCOUNT":accidentReceipt.setPaymentMethod(EPaymentMethod.ACCOUNT);break; 
				default:break;
				}
				accidentReceipt.setAccidentDate(rs.getString("accidentdate"));
				accidentReceipt.setHospitalName(rs.getString("hospitalname"));
				accidentReceipt.setDeathStatus(rs.getBoolean("deathstatus"));
				accidentReceipt.setAccidentPlace(rs.getString("accidentplace"));
				accidentReceipt.setDiagnosisName(rs.getString("diagnosisname"));
				accidentReceipt.setDamageScale(rs.getString("damagescale"));
				accidentReceipt.setAccidentCircumstances(rs.getString("accidentcircumstances"));
				accidentReceipt.setMoney(rs.getInt("money"));
				accidentReceipt.setPaymentStatus(rs.getBoolean("paymentstatus"));
				accidentReceiptList.add(accidentReceipt);
			}
			rs.close();
		} catch (Exception e) {e.printStackTrace();}
		return accidentReceiptList;
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
