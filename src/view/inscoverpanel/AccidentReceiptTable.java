package view.inscoverpanel;

import java.util.Vector;

import control.accidentReceipt.AccidentReceipt;
import control.accidentReceipt.AccidentReceiptListImpl;
import view.defaultClass.Default_AccidnetReceiptTable;

public class AccidentReceiptTable extends Default_AccidnetReceiptTable {
	private static final long serialVersionUID = 1L;
	
	private AccidentReceiptListImpl accidentReceiptList;
	
	public AccidentReceiptTable(AccidentReceiptListImpl accidentReceiptList) {
		super();
		this.accidentReceiptList = accidentReceiptList;
		this.refresh();
	}

	public void refresh() {
		this.rowData.clear();
		for (AccidentReceipt accidentReceipt : this.accidentReceiptList.getAccidentReceiptList()) {
			Vector<Object> accidentReceipts = new Vector<Object>();
			accidentReceipts.add(accidentReceipt.getAccidentReceiptId());
			accidentReceipts.add(accidentReceipt.getAccidentReceiptName());
			accidentReceipts.add(accidentReceipt.getCustomerName());
			accidentReceipts.add(accidentReceipt.getInsuranceType());
			accidentReceipts.add(accidentReceipt.getAccidentDate());
			if (accidentReceipt.isPaymentStatus()) {accidentReceipts.add("지급완료");}
			else {accidentReceipts.add("미지급");}
			this.rowData.add(accidentReceipts);
		}
		this.updateUI();
	}
}
