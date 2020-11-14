package constants;


import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ViewConstants {
	public static final long serialVersionUID = 1L;
	
	public ViewConstants() {}
	public enum ETableStatus{insuranceRegistration, checkCustomer}
	public enum ELogin{customer, salesman, underwriter, developer,assessment}
	public enum EViewFrame{
		eFont(new Font("한컴 고딕", Font.PLAIN, 15), null),
		eImg(null, new ImageIcon("img/insurance.png")),
		eLoginImg(null, new ImageIcon("img/login.png")),
		eLoginBtnImg(null, new ImageIcon("img/loginBtn.png"));
		private Font font;
		private ImageIcon ImageIcon;
		private EViewFrame(Font font,ImageIcon ImageIcon) {
			this.font = font;
			this.ImageIcon = ImageIcon;
		}
		public Font getFont() {return this.font;}
		public ImageIcon getImageIcon() {return this.ImageIcon;}
	}
	public enum EMainFrame {
		eWidth(580),
		eHeight(800);
		
		private int value;		
		private EMainFrame(int value) {this.value = value;}	
		public int getValue() {return this.value;}
	}
	public enum EPanels{
		acceptInsPanel("AcceptInsPanel"),
		insDevelopmentPanel("InsDevelopmentPanel"),
		insRegistrationPanel("InsRegistrationPanel"),
		checkCustomerPanel("CheckCustomerPanel"),
		insCoverPanel("InsCoverPanel");
		
		private String panel;
		private EPanels(String panel) {this.panel = panel;}
		public String getPanel() {return this.panel;}
	}
	public enum EButton {
		acceptInsBtn(new JButton("보험 승인"),"AcceptInsPanel"),
		insDevelopmentBtn(new JButton("보험 개발"),"InsDevelopmentPanel"),
		insRegistrationBtn(new JButton("보험 가입"),"InsRegistrationPanel"),
		checkCustomerBtn(new JButton("고객 확인"),"CheckCustomerPanel"),
		insCoverBtn(new JButton("보험 처리"),"InsCoverPanel");
		
		private JButton btn;
		private String panelName;
		private EButton(JButton btn,String panelName) {
			this.btn = btn;
			this.panelName = panelName;
		}		
		public JButton getButton() {return this.btn;}
		public String getPanelName() {return this.panelName;}
	}
	
	public enum EAccidentReceiptHead{
		receiptId("사고접수서 번호"),  receiptName("사고접수서 이름"),  customerName("고객 이름"),
		type("보험 종류"), date("사고 날짜"), paymentStatus("지급 여부");
		private String text;
		private EAccidentReceiptHead(String text) {this.text = text;}
		public String getText() {return this.text;}
	}
	
	public enum EAccidentReceipt{
		AccidentReceiptId("사고접수서 번호"), AccidentReceiptName("사고접수서 이름"),  CustomerName("고객 이름"),
		CustomerId("고객 주민등록번호"), InsuranceType("보험 종류"), PaymentMethod("보상 방식"), 
		AccidentDate("사고 날짜"), HospitalName("병원명"), DeathStatus("사망 여부"),
		AccidentPlace("사고 장소"), DiagnosisName("질병명"), DamageScale("피해 규모"),
		AccidentCircumstances("사고 상황"), Money("지급액");
		private String text;
		private EAccidentReceipt(String text) {this.text = text;}
		public String getText() {return this.text;}
	}
	
	public enum EInsuranceDesignHead{
		insuranceDesignId("설계번호"),writer("작성자"),
		insuranceName("보험이름"),insuranceType("보험 종류"),
		madedate("작성 날짜"),  approveStatus("승인 여부");
		private String text;
		private EInsuranceDesignHead(String text) {this.text = text;}
		public String getText() {return this.text;}
	}
	
	public enum EInsuranceDesign{
		insuranceDesignId("설계번호"), writer("작성자"),
		insuranceName("보험이름"),madedate("작성 날짜"),
	    guarantee("보장액"), payment("지급액"),
	    period("보험 기간"),insuranceType("보험 종류"),
	    description("보험 설명");
		private String text;
		private EInsuranceDesign(String text) {this.text = text;}
		public String getText() {return this.text;}
	}
	public enum EBasicInsurance{
		id("설계 번호"), name("보험 이름"), guarantee("보장액"), payment("납입액"),
		period("보험 기간"),type("보험 종류"), description("보험 설명");
		private String text;
		private EBasicInsurance(String text) {this.text = text;}
		public String getText() {return this.text;}
	}
	public enum ECustomerHead{
		name("이름"), customerId("주민등록번호"),  gender("성별"),
		age("나이"), phoneNum("전화번호");
		private String text;
		private ECustomerHead(String text) {this.text = text;}
		public String getText() {return this.text;}
	}
	
	public enum ECustomer{
		name("이름"), customerId("주민등록번호"),  gender("성별"),
		age("나이"), phoneNum("전화번호"), job("직업"),
		illHistory("병력"), propety("재산");
		private String text;
		private ECustomer(String text) {this.text = text;}
		public String getText() {return this.text;}
	}
	
	public enum ESalesPersonHead{
		name("이름"),  office("사무실 주소"), phoneNum("전화번호");
		private String text;
		private ESalesPersonHead(String text) {this.text = text;}
		public String getText() {return this.text;}
	}
	
	public enum EInsuranceHead{
		id("번호"), name("이름"),  guarantee("보장액"), payment("납입액"),
		period("기간"), type("보험 종류");
		private String text;
		private EInsuranceHead(String text) {this.text = text;}
		public String getText() {return this.text;}
	}
	public enum EInsuranceRequest{
		id("상품 번호"), name("상품 이름"), paymentType("납입 방식"),
		date("납입일");
		private String text;
		private EInsuranceRequest(String text) {this.text = text;}
		public String getText() {return this.text;}
	}
	public enum EcarInsurance{
		type("종류"), num("차량 번호"),  history("사고 이력"), age("연식");
		private String text;
		private EcarInsurance(String text) {this.text = text;}
		public String getText() {return this.text;}
	}
	public enum EFireInsurance{
		type("건물 종류"), area("건물 면적"), price("건물 가치"), age("건축 날짜");
		private String text;
		private EFireInsurance(String text) {this.text = text;}
		public String getText() {return this.text;}
	}
	public enum EApprovalStatus{
		RequestInsDesign("승인 요청"), ApprovalIns("승인 허가"), DisApprovalIns("승인 거부");
		private String text;
		private EApprovalStatus(String text) {this.text = text;}
		public String getText() {return this.text;}
	}
	
	
}
