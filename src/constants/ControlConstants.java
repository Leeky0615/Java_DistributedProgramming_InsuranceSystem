package constants;

import model.entity.CancerInsurance;
import model.entity.CarInsurance;
import model.entity.FireInsurance;
import model.entity.Insurance;

public class ControlConstants {
	public ControlConstants() {}

	// Accident Receipt & ContractCondition
	public interface EInsurance{
		public String getText();
	}
	public enum EInsuranceType{
		CAR("자동차 보험", new CarInsurance()),
		FIRE("화재 보험", new FireInsurance()),
		CANCER("암 보험",new CancerInsurance());
		private String text;
		private Insurance insurance;
		private EInsuranceType(String text,Insurance insurance) {
			this.text = text;
			this.insurance = insurance;
			}
		public String getText() {return this.text;}
		public Insurance getInsurance() {return this.insurance;}
	}
	public enum EPaymentMethod{
		CASH("현금 지급"),  CARD("카드 지급"),  ACCOUNT("계좌 이체");
		private String text;
		private EPaymentMethod(String text) {this.text = text;}
		public String getText() {return this.text;}
	}

	// Customer
	public enum EJob{
		SOLDIER("군인"),  POLICE("경찰"),  FIREMAN("소방관"),
		DRIVER("운전기사"),NO_JOB("무직");
		private String text;
		private EJob(String text) {this.text = text;}
		public String getText() {return this.text;}
	}
	public enum EIllHistory{
		NOTHING("없음"),  CANCER("암"),  BLOODPRESURE("혈압"),
		GLYCOSURIA("당뇨"),ACCIDENT("사고");
		private String text;
		private EIllHistory(String text) {this.text = text;}
		public String getText() {return this.text;}
	}
	public enum ECarType{
		SMALL("소형차"),  MID("중형차"),  LARGE("대형차"),
		MOTOR("오토바이");
		private String text;
		private ECarType(String text) {this.text = text;}
		public String getText() {return this.text;}
	}
	public enum EBuildingType{
		Apartment("아파트"),  House("주택"),  Factory("공장"),
		Warehouse("창고"), Buiding("빌딩");
		private String text;
		private EBuildingType(String text) {this.text = text;}
		public String getText() {return this.text;}
	}

}
