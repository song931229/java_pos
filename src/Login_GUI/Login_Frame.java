package Login_GUI;

import java.awt.*;
import javax.swing.*;

import Index_GUI.Base_Frame;
import Index_GUI.MYButton;
import Pannel.*;

public class Login_Frame extends Base_Frame {

	MYPanel jp_base= new MYPanel();
	MYPanel jp_up= new MYPanel();
	MYPanel jp_up_l= new MYPanel();
	MYPanel jp_up_r= new MYPanel();
	MYPanel jp_up_c= new MYPanel();
	MYPanel jp_down= new MYPanel();
	
	JLabel lb_id = new JLabel("ID : ",JLabel.RIGHT);
	JLabel lb_pw = new JLabel("PW : ",JLabel.RIGHT);
	
	public JTextField jtf_id= new JTextField();
	public JPasswordField jtf_pw= new JPasswordField();
	
	MYButton login = new MYButton("로그인",1,0,0);
	MYButton F_id = new MYButton("ID찾기",1,0,1);
	MYButton F_pw = new MYButton("PW찾기",1,0,2);
	MYButton cancel = new MYButton("취소",1,0,3);
	
	public Login_Frame() {
		super("Login", 300, 200);
		// TODO Auto-generated constructor stub
		
		jp_up_l.setGridLayout(2,1,10,10);
		jp_up_l.add(lb_id);
		jp_up_l.add(lb_pw);
		
		jp_up_c.setGridLayout(2,1,10,10);
		jp_up_c.add(jtf_id);
		jtf_pw.setEchoChar('*');
		jp_up_c.add(jtf_pw);
		
		jp_up_r.setGridLayout(1,1);
		jp_up_r.add(login);
		
		jp_up.setBorderLayout(10, 0);
		jp_up.add(jp_up_l,BorderLayout.WEST);
		jp_up.add(jp_up_r,BorderLayout.EAST);
		jp_up.add(jp_up_c,BorderLayout.CENTER);
		
		jp_down.setGridLayout(1, 3);
		jp_down.add(F_id);
		jp_down.add(F_pw);
		jp_down.add(cancel);	
		
		jp_base.setLayout(null);
		
		jp_base.add(jp_up);
		jp_base.add(jp_down);
		jp_up.setBounds(20,10,250,100);
		jp_down.setBounds(20,120,250,30);
		
		setMainPanel(jp_base);
		setVisible(true);
	}
	

}
