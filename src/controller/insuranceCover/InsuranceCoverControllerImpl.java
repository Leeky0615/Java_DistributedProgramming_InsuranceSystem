package controller.insuranceCover;

import java.util.Vector;

import model.service.insuranceCover.InsuranceCoverImpl;

public class InsuranceCoverControllerImpl implements InsuranceCoverController {
	private InsuranceCoverImpl insuranceCover;
	
	public InsuranceCoverControllerImpl() {
	}
	
	public void connectCtoS(InsuranceCoverImpl insuranceCover) {
		this.insuranceCover = insuranceCover;
	}

	public void writeAccientReceipt(Vector<String> accidentReceiptContents) {
		this.insuranceCover.writeAccientReceipt(accidentReceiptContents);
	}
}
