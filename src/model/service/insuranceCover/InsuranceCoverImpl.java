package model.service.insuranceCover;

import java.util.Vector;

import constants.ControlConstants.EInsuranceType;
import constants.ControlConstants.EPaymentMethod;
import constants.ViewConstants.EAccidentReceipt;
import model.dao.accidentReceipt.AccidentReceiptDao;
import model.dao.accidentReceipt.AccidentReceiptDaoImpl;
import model.entity.AccidentReceipt;
import model.service.accidentReceipt.AccidentReceiptListImpl;

public class InsuranceCoverImpl implements InsuranceCover {
	private AccidentReceiptListImpl accidentReceiptList;
	private AccidentReceiptDao accidentReceiptDao;
	public InsuranceCoverImpl(){
		this.accidentReceiptDao = new AccidentReceiptDaoImpl();
	}
	public void associate(AccidentReceiptListImpl accidentReceiptList) {this.accidentReceiptList = accidentReceiptList;}

	public void acceptAccident(int accidentReceiptId){
		AccidentReceipt accidentReceipt = this.accidentReceiptList.searchById(accidentReceiptId);
		accidentReceipt.setPaymentStatus(true);
		this.accidentReceiptDao.update(accidentReceipt);
	}

	public void writeAccientReceipt(Vector<String> accidentReceiptContents){
		AccidentReceipt accidentReceipt = new AccidentReceipt();
		for(EAccidentReceipt eAccidentReceipt : EAccidentReceipt.values()) {
			String value = accidentReceiptContents.get(eAccidentReceipt.ordinal());
			switch (eAccidentReceipt.getText()) {
			case "사고접수서 번호": accidentReceipt.setAccidentReceiptId(Integer.parseInt(value));break;
			case "사고접수서 이름": accidentReceipt.setAccidentReceiptName(value);break;
			case "고객 이름": accidentReceipt.setCustomerName(value);break;
			case "고객 주민등록번호":accidentReceipt.setCustomerId(value);break;
			case "보험 종류":
				switch (value) {
				case "자동차 보험":accidentReceipt.setInsuranceType(EInsuranceType.CAR);break;
				case "암 보험":accidentReceipt.setInsuranceType(EInsuranceType.CANCER);break;
				case "화재 보험":accidentReceipt.setInsuranceType(EInsuranceType.FIRE);break;
				default:break;
				}
				break;
			case "보상 방식":
				switch (value) {
				case "현금 지급":accidentReceipt.setPaymentMethod(EPaymentMethod.CASH);	break;
				case "카드 지급":accidentReceipt.setPaymentMethod(EPaymentMethod.CARD);	break;
				case "계좌 이체":accidentReceipt.setPaymentMethod(EPaymentMethod.ACCOUNT);break;
				default:break;
				}
				break;
			case "사고 날짜": accidentReceipt.setAccidentDate(value);break;
			case "병원명": accidentReceipt.setHospitalName(value);break;
			case "사망 여부":
				if (value.equals("아니오")) {accidentReceipt.setDeathStatus(false);}
				else {accidentReceipt.setDeathStatus(true);}
				break;
			case "사고 장소": accidentReceipt.setAccidentPlace(value);break;
			case "질병명": accidentReceipt.setDiagnosisName(value);break;
			case "피해 규모": accidentReceipt.setDamageScale(value);break;
			case "사고 상황": accidentReceipt.setAccidentCircumstances(value);break;
			case "지급액": accidentReceipt.setMoney(Integer.parseInt(value));break;
			default: break;
			}
		}
		this.accidentReceiptDao.insert(accidentReceipt);
		this.accidentReceiptList.add(accidentReceipt);
	}
}
