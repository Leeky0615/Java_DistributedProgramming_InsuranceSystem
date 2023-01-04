package view.insregistrationpanel.searchInsPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import constants.ControlConstants.EInsuranceType;
import constants.ControllerConstants.EController;
import controller.insuranceRegistration.InsuranceRegistrationControllerImpl;
import main.FrontController;
import model.entity.Insurance;

public class RegistrationFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	private InsuranceRegistrationControllerImpl insuranceRegistrationController;
	private Insurance requestInsurance;

	private JButton okBtn,cancelBtn;
	private ActionHandler actionHandler;
	private CancerPanel cancerPanel;
	private CarPanel carPanel;
	private FirePanel firePanel;
	public RegistrationFrame(FrontController frontController, Insurance insurance) {
		this.insuranceRegistrationController = (InsuranceRegistrationControllerImpl) frontController.mappingController(EController.InsuranceRegistrationController.getControllerName());
		this.requestInsurance = insurance;

		this.setSize(500, 280);
		this.setTitle("고객추가");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.add(this.createPanel(),BorderLayout.CENTER);
		this.createBtnPanel();
	}

	private JPanel createPanel() {
		if (requestInsurance.getInsuranceType() == EInsuranceType.CANCER) {
			this.cancerPanel = new CancerPanel();
			return this.cancerPanel;
		}else if(requestInsurance.getInsuranceType() == EInsuranceType.CAR) {
			this.carPanel = new CarPanel();
			return this.carPanel;
		}else if(requestInsurance.getInsuranceType() == EInsuranceType.FIRE) {
			this.firePanel = new FirePanel();
			return this.firePanel;
		}
		return null;
	}

	private void createBtnPanel() {
		JPanel panel = new JPanel();
		this.actionHandler = new ActionHandler();
		this.okBtn = new JButton("가입 신청");
		this.okBtn.addActionListener(this.actionHandler);
		this.cancelBtn = new JButton("취소");
		this.cancelBtn.addActionListener(this.actionHandler);
		panel.add(okBtn);
		panel.add(cancelBtn);
		this.add(panel, BorderLayout.SOUTH);
	}
	public void buttonClick(Object source) {
		if (source.equals(this.okBtn)) {
			Vector<Object> infos = new Vector<Object>();
			EInsuranceType type = requestInsurance.getInsuranceType();
			if (type == EInsuranceType.CANCER) {
				infos.add(this.cancerPanel.getPaymentMethod_t());
				infos.add(this.cancerPanel.getPaymentDate_t());
			}else if(type == EInsuranceType.CAR) {
				infos.add(this.carPanel.getPaymentMethod_t());
				infos.add(this.carPanel.getPaymentDate_t());
				infos.add(this.carPanel.getNum_t());
				infos.add(this.carPanel.getAge_t());
				infos.add(this.carPanel.getType_t());
				infos.add(this.carPanel.getHistory_t());
			}else if(type == EInsuranceType.FIRE) {
				infos.add(this.firePanel.getPaymentMethod_t());
				infos.add(this.firePanel.getPaymentDate_t());
				infos.add(this.firePanel.getArea_t());
				infos.add(this.firePanel.getAge_t());
				infos.add(this.firePanel.getType_t());
				infos.add(this.firePanel.getPrice_t());
			}
			this.insuranceRegistrationController.writeInsuranceInformation(this.requestInsurance, type,infos);
			this.insuranceRegistrationController.request();
			JOptionPane.showMessageDialog(this, "가입 요청이 완료되었습니다.");
			this.dispose();
		}else {
			this.dispose();
		}
	}
	private class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			buttonClick(e.getSource());
		}
	}
}

