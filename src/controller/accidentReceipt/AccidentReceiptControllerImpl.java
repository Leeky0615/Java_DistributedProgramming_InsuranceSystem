package controller.accidentReceipt;

import java.util.ArrayList;

import model.dto.AccidentReceipt;
import model.service.accidentReceipt.AccidentReceiptListImpl;

public class AccidentReceiptControllerImpl implements AccidentReceiptController {
	private AccidentReceiptListImpl accidentReceiptList;

	public AccidentReceiptControllerImpl() {
		
	}

	public void connectCtoS(AccidentReceiptListImpl accidentReceiptList) {
		this.accidentReceiptList = accidentReceiptList;
	}

	public ArrayList<AccidentReceipt> getAccidentReceiptList() {
		return this.accidentReceiptList.getAccidentReceiptList();
	}
}
