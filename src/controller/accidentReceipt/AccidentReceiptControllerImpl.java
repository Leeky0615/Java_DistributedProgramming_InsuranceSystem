package controller.accidentReceipt;

import model.service.accidentReceipt.AccidentReceiptListImpl;

public class AccidentReceiptControllerImpl implements AccidentReceiptController {
	private AccidentReceiptListImpl accidentReceiptList;

	public AccidentReceiptControllerImpl() {
		
	}

	public void connectCtoS(AccidentReceiptListImpl accidentReceiptList) {
		this.accidentReceiptList = accidentReceiptList;
	}
}
