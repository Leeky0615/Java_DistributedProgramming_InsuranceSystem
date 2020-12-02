package view.mainFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import constants.ControllerConstants.EController;
import constants.ViewConstants.EButton;
import constants.ViewConstants.ELogin;
import constants.ViewConstants.EPanels;
import constants.ViewConstants.EViewFrame;
import controller.FrontController;
import controller.login.LoginControllerImpl;
import view.defaultClass.DefaultPanel;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	public static ELogin user = null;
	private Vector<DefaultPanel> panels;
	private ButtonPanel buttonPanel;
	private LoginPanel loginPanel;
	private BackBtnPanel backBtnPanel;
	private DefaultPanel currentPanel;
	private ActionHandler actionHandler;
	private FrontController frontController;
	private LoginControllerImpl loginController;
	private JLabel imageLabel;
	
	public MainFrame(FrontController frontController) {
		super();
		this.setThema();
		this.setTitle("보험 시스템");
		this.setSize(new Dimension(611,580));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setBackground(new Color(94,175,164));
		this.setLayout(new BorderLayout());
		this.frontController = frontController;
		this.loginController = (LoginControllerImpl) frontController.mappingController(EController.LoginController.getControllerName());
		
		this.actionHandler = new ActionHandler();
		this.panels = new Vector<DefaultPanel>();
		
		this.createLoginPanel();
		this.createButtonPanel();
	}
	
	// 테마 설정 메소드
	public void setThema() {
		try {
		    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		    JFrame.setDefaultLookAndFeelDecorated(true);
		} catch (Exception e) {}
	}
	// 메인프레임에 기본 패널들을 만드는 메소드
	private void createLoginPanel() {
		this.loginPanel = new LoginPanel(this.actionHandler);
		this.add(this.loginPanel, BorderLayout.CENTER);
	}
	public void createButtonPanel() {
		this.buttonPanel = new ButtonPanel(this.actionHandler);
	}
	private void createDefaultPanels() {
		this.backBtnPanel = new BackBtnPanel(actionHandler);
		this.add(backBtnPanel, BorderLayout.SOUTH);
		
		this.imageLabel = new JLabel(setImage());
		this.add(this.imageLabel, BorderLayout.CENTER);
		
		// 프로그램에서 사용되는 패널들을 사용하기위해 패널벡터를 만들어 넣어놈.
		for(EPanels ePanel : EPanels.values()) {this.panels.add(this.createPanel(ePanel.getPanel()));}
	}
	
	// 메인프레임의 imagelabel에 이미지를 넣기위해 이미지파일을 등록하는 메소드
	public ImageIcon setImage() {
		ImageIcon icon = EViewFrame.eImg.getImageIcon();
		Image originImg = icon.getImage(); 
		Image changedImg= originImg.getScaledInstance(600, 530, Image.SCALE_SMOOTH );
		ImageIcon changedicon = new ImageIcon(changedImg);
		return changedicon;
	}
	
	// Reflection을 이용해 패널을 만들어주는 메소드
	@SuppressWarnings("rawtypes")
	public DefaultPanel createPanel(String name) {
		try{
			Class<?> clazz = Class.forName("view."+name.toLowerCase()+"."+name);
			Class arg = FrontController.class;
			Object newPanel = clazz.getConstructor(arg).newInstance(this.frontController);
			return (DefaultPanel) newPanel;
		}catch (Exception e) {e.printStackTrace();}
		return null;
	}
	
	@SuppressWarnings("deprecation")
	public ELogin logincheck() {
		// loginController의 logincheck함수를 실행.
		MainFrame.user = this.loginController.loginCheck(this.loginPanel.getLoginTextField().getText(), this.loginPanel.getPasswordField().getText());
		return MainFrame.user;
	}
	// 버튼이 클릭시 실행되는 메소드
	public void buttonClick(String name) {
		Vector<JButton> buttons = this.buttonPanel.getButtons();
		if(name.equals("login")){
			if(logincheck() == null){
				JOptionPane.showMessageDialog(null, "등록되지 않은 사용자입니다. 다시 확인해 주세요.", "등록되지 않은 사용자", JOptionPane.WARNING_MESSAGE);
				return;
			}else {
				if (logincheck() == ELogin.developer) {
					for(JButton button : buttons) {
						if (button.equals(buttons.get(EButton.insDevelopmentBtn.ordinal()))) {button.setVisible(true);}
						else {button.setVisible(false);}
					}
				}else if(logincheck() == ELogin.customer) {
					for(JButton button : buttons) {
						if (button.equals(buttons.get(EButton.insRegistrationBtn.ordinal()))) {button.setVisible(true);}
						else {button.setVisible(false);}
					}
				}else if(logincheck() == ELogin.salesman) {
					for(JButton button : buttons) {
						if (button.equals(buttons.get(EButton.checkCustomerBtn.ordinal()))) {button.setVisible(true);}
						else {button.setVisible(false);}
					}
				}else if(logincheck() == ELogin.underwriter) {
					for(JButton button : buttons) {
						if (button.equals(buttons.get(EButton.acceptInsBtn.ordinal())) || button.equals(buttons.get(EButton.insRegistrationBtn.ordinal()))) {
							button.setVisible(true);
						}else {button.setVisible(false);}
					}
				}else if(logincheck() == ELogin.assessment) {
					for(JButton button : buttons) {
						if (button.equals(buttons.get(EButton.insCoverBtn.ordinal()))) {button.setVisible(true);}
						else {button.setVisible(false);}
					}
				}
				this.createDefaultPanels();
				this.add(this.buttonPanel, BorderLayout.NORTH);
				this.backBtnPanel.setVisible(false);
				this.loginPanel.setVisible(false);
				this.repaint();
			}
		}
		else if (name.equals("backToMain")) {
			// 처음화면으로 가기 : 현재 프레임을 초기화하고 패널벡터에서 현재패널을 삭제함.
			this.remove(currentPanel);
			this.createDefaultPanels();
			this.createButtonPanel();
			this.add(this.buttonPanel, BorderLayout.NORTH);
			this.backBtnPanel.setVisible(false);
			this.buttonPanel.setVisible(true);
			this.panels.remove(this.currentPanel);
			this.repaint();
		} else if(name.equals("logout")){
			this.createLoginPanel();
			this.remove(buttonPanel);
			this.remove(backBtnPanel);
			this.remove(currentPanel);
			this.createButtonPanel();
			this.loginPanel.setVisible(true);
			this.backBtnPanel.setVisible(false);
			this.imageLabel.setVisible(false);
			this.panels.remove(this.currentPanel);
			this.repaint();
			this.revalidate();
		}else {
			// 버튼패널에 있는 버튼 클릭시
			this.backBtnPanel.setVisible(true);
			this.remove(this.imageLabel);
			this.remove(this.buttonPanel);
			// 패널의 크기가 4이면 선택된 패널버튼의 패널을 추가
			if (this.panels.size() == 4) {this.panels.add(createPanel(name));}
			/* 
			 * 위에서 만들어준 패널 벡터에서 값을 하나씩 비교해 
			 * 선택된 패널의 이름과 같을 시  메인프레임에 패널을 붙여주고 현재패널로 설정 
			*/
			for (DefaultPanel panel : this.panels) {
				if (panel.getClass().getName().equals("view." + name.toLowerCase() + "." + name)) {
					getContentPane().add(panel, BorderLayout.CENTER);
					this.currentPanel = panel;
				}
			}
		}
	}
	
	public class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			buttonClick(e.getActionCommand());
		}
	}
}

