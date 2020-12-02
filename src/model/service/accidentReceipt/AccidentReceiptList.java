package model.service.accidentReceipt;

import java.util.ArrayList;

import model.dto.AccidentReceipt;

public interface AccidentReceiptList {
	public ArrayList<AccidentReceipt> getAccidentReceiptList();
	public boolean add(AccidentReceipt accidentReceipt);
	public boolean deleteById(int accidentReceiptId);
	public boolean deleteByName(String accidentReceiptName);
	public AccidentReceipt searchById(int accidentReceiptId);
	public AccidentReceipt searchByName(String accidentReceiptName);
}