package view.mainFrame;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import constants.ViewConstants.EViewFrame;
import view.mainFrame.MainFrame.ActionHandler;

public class LoginPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel imageLabel;
	private JTextField loginTextField;
	private JPasswordField passwordField;
	private JButton bt;

	public JTextField getLoginTextField() {return loginTextField;}
	public void setLoginTextField(JTextField loginTextField) {this.loginTextField = loginTextField;}
	public JPasswordField getPasswordField() {return passwordField;}
	public void setPasswordField(JPasswordField passwordField) {this.passwordField = passwordField;}

	public LoginPanel(ActionHandler actionHandler) {
		this.setLayout(null);
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 600, 600);
		layeredPane.setLayout(null);
		

		this.imageLabel = new JLabel(setImage(EViewFrame.eLoginImg,600,550));
		imageLabel.setBounds(0, 0, 600, 550);
		
		loginTextField = new JTextField(15);
		loginTextField.setBounds(285, 192, 100, 30);
		layeredPane.add(loginTextField);
		 
		// 패스워드
		passwordField = new JPasswordField(15);
		passwordField.setBounds(285, 247, 100, 30);
		layeredPane.add(passwordField);
		 
		// 로그인버튼 추가
		bt = new JButton(setImage(EViewFrame.eLoginBtnImg,100,30));
		bt.setBounds(235, 310, 104, 30);
		layeredPane.add(bt);
		
		
		loginTextField.setOpaque(false);
		loginTextField.setFont(EViewFrame.eFont.getFont());
		//비밀번호 내용
		passwordField.setOpaque(false);
		passwordField.setFont(EViewFrame.eFont.getFont());
		// 버튼 투명처리
		bt.setContentAreaFilled(false);
		bt.addActionListener(actionHandler);
		bt.setActionCommand("login");
		layeredPane.add(imageLabel);
		add(layeredPane);
		
	}
	
	public JButton getBt() {return bt;}
	public void setBt(JButton bt) {this.bt = bt;}

	public ImageIcon setImage(EViewFrame frame,int x, int y) {
		ImageIcon icon = frame.getImageIcon();
		Image originImg = icon.getImage(); 
		Image changedImg= originImg.getScaledInstance(x, y, Image.SCALE_SMOOTH );
		ImageIcon changedicon = new ImageIcon(changedImg);
		return changedicon;
	}
	
	
}
