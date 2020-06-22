package Login_GUI;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Index_GUI.Base_Frame;
import Index_GUI.MYButton;
import Pannel.MYPanel;
import Pannel.NumberField;

public class Change_Pw_Frame extends Base_Frame {
	private String target_Id;
	
	MYPanel jp_base= new MYPanel();
	MYPanel jp_up= new MYPanel();
	MYPanel jp_down= new MYPanel();
	
	JLabel lb_pw1 = new JLabel("비밀번호",JLabel.CENTER);
	JLabel lb_pw2 = new JLabel("비밀번호 확인",JLabel.CENTER);
	
	public JPasswordField jtf_pw1= new JPasswordField();
	public JPasswordField jtf_pw2= new JPasswordField();
	
	MYButton bt_f=new MYButton("변경",1,3,1);
	MYButton bt_c=new MYButton("취소",1,3,2);
	
	public Change_Pw_Frame(String id) {
		super("Change Pw", 300, 200);
		// TODO Auto-generated constructor stub
		this.target_Id=id;
		jp_up.setGridLayout(2, 2, 10, 10);
		jp_up.add(lb_pw1);
		jp_up.add(jtf_pw1);
		jp_up.add(lb_pw2);
		jp_up.add(jtf_pw2);
		

		jp_down.setGridLayout(1,2,10,10);
		jp_down.add(bt_f);
		jp_down.add(bt_c);
		
		jp_base.setLayout(null);
		jp_base.add(jp_up);
		jp_base.add(jp_down);
		jp_up.setBounds(30, 10, 240, 100);
		jp_down.setBounds(45, 130, 200, 30);
		
		this.setMainPanel(jp_base);
		this.setVisible(true);
	}

	public String getTarget_Id() {
		return target_Id;
	}
	
	
}
