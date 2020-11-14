package control.insuranceCover;

import java.util.Vector;

import control.accidentRecipt.AccidentReceiptListImpl;

public interface InsuranceCover {
	public void acceptAccident(int accidentReceiptNum);
	public void writeAccientReceipt(Vector<String> accidentReceiptContents);
	public void associate(AccidentReceiptListImpl accidentReceiptList);
}