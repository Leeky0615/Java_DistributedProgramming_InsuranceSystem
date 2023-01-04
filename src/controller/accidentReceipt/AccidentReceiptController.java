package controller.accidentReceipt;

import java.util.ArrayList;

import model.entity.AccidentReceipt;
import model.service.accidentReceipt.AccidentReceiptListImpl;

public interface AccidentReceiptController {
	public void connectCtoS(AccidentReceiptListImpl accidentReceiptList);
	public ArrayList<AccidentReceipt> getAccidentReceiptList();
}
