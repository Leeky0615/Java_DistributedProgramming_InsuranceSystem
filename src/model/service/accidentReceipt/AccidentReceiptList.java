package model.service.accidentReceipt;

import model.dto.AccidentReceipt;

public interface AccidentReceiptList {
	public boolean add(AccidentReceipt accidentReceipt);
	public boolean deleteById(int accidentReceiptId);
	public boolean deleteByName(String accidentReceiptName);
	public AccidentReceipt searchById(int accidentReceiptId);
	public AccidentReceipt searchByName(String accidentReceiptName);
}