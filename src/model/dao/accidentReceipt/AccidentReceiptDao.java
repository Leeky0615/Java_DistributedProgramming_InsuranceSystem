package model.dao.accidentReceipt;

import java.util.ArrayList;

import model.dto.AccidentReceipt;

public interface AccidentReceiptDao {
	public ArrayList<AccidentReceipt> select();
	public void insert(AccidentReceipt accidentReceipt);
	public void update(AccidentReceipt accidentReceipt);
//	asdasd
}
