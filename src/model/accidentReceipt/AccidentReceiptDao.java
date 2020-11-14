package model.accidentReceipt;

import java.util.ArrayList;

import control.accidentRecipt.AccidentReceipt;

public interface AccidentReceiptDao {
	public ArrayList<AccidentReceipt> select() ;

	public void insert(AccidentReceipt accidentReceipt);

	public void update(boolean status, int accidentReceiptId);
}
