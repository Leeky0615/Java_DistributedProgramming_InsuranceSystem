package model.service.accidentReceipt;

import java.util.ArrayList;

import model.dao.accidentReceipt.AccidentReceiptDao;
import model.dao.accidentReceipt.AccidentReceiptDaoImpl;


public class AccidentReceiptListImpl implements AccidentReceiptList {
	private AccidentReceiptDao accidentReceiptDao;
	private ArrayList<AccidentReceipt> accidentReceiptList;
	
	public AccidentReceiptListImpl(){
		this.accidentReceiptDao = new AccidentReceiptDaoImpl();
		this.accidentReceiptList = accidentReceiptDao.select();
	}

	public ArrayList<AccidentReceipt> getAccidentReceiptList() {return accidentReceiptList;}
	public void setAccidentReceiptList(ArrayList<AccidentReceipt> accidentReceiptList) {this.accidentReceiptList = accidentReceiptList;}

	public boolean add(AccidentReceipt accidentReceipt){
		this.accidentReceiptList.add(accidentReceipt);
		return false;
	}

	public boolean deleteById(int accidentReceiptId){
		this.accidentReceiptList.remove(accidentReceiptId);
		return false;
	}

	@SuppressWarnings("unlikely-arg-type")
	public boolean deleteByName(String accidentReceiptName){
		this.accidentReceiptList.remove(accidentReceiptName);
		return false;
	}

	public AccidentReceipt searchById(int accidentReceiptId){
		for(AccidentReceipt accidentReceipt : this.accidentReceiptList) {
			if (accidentReceipt.getAccidentReceiptId() == accidentReceiptId) {return accidentReceipt;}
		}
		return null;
	}

	public AccidentReceipt searchByName(String accidentReceiptName){
		for(AccidentReceipt accidentReceipt : this.accidentReceiptList) {
			if (accidentReceipt.getAccidentReceiptName().equals(accidentReceiptName)) {return accidentReceipt;}
		}
		return null;
	}

}