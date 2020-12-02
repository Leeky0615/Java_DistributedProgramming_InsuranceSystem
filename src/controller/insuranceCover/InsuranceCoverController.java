package controller.insuranceCover;

import java.util.Vector;

import model.service.insuranceCover.InsuranceCoverImpl;

public interface InsuranceCoverController {
	public void connectCtoS(InsuranceCoverImpl insuranceCover);
	public void writeAccientReceipt(Vector<String> accidentReceiptContents);
}
