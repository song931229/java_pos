package Login_GUI;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Pannel.MYPanel;
import Pannel.NumberField;

public class Change_Pw_Frame {
	MYPanel jp_base= new MYPanel();
	MYPanel jp_up= new MYPanel();
	MYPanel jp_down= new MYPanel();
	
	JLabel lb_pw1 = new JLabel("비밀번호",JLabel.CENTER);
	JLabel lb_pw2 = new JLabel("비밀번호 확인",JLabel.CENTER);
	
	public JPasswordField jtf_pw1= new JPasswordField();
	public JPasswordField jtf_pw2= new JPasswordField();
}
