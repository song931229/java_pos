package Login_GUI;

import java.awt.*;
import javax.swing.*;

import Index_GUI.Base_Frame;
import Pannel.*;

public class Login_Frame extends Base_Frame {

	public Login_Frame() {
		super("Login", 300, 200);
		// TODO Auto-generated constructor stub
		MYPanel jp_base= new MYPanel();
		MYPanel jp_up= new MYPanel();
		MYPanel jp_up_l= new MYPanel();
		MYPanel jp_up_r= new MYPanel();
		MYPanel jp_up_c= new MYPanel();
		MYPanel jp_down= new MYPanel();
		
		JLabel lb_id = new JLabel("ID : ",JLabel.RIGHT);
		JLabel lb_pw = new JLabel("PW : ",JLabel.RIGHT);
		
		JTextField jtf_id= new JTextField();
		JTextField jtf_pw= new JTextField();
		
		JButton login = new JButton("로그인");
		JButton F_id = new JButton("ID찾기");
		JButton F_pw = new JButton("PW찾기");
		JButton cancel = new JButton("취소");
		
		jp_up_l.setGridLayout(2,1,10,10);
		jp_up_l.add(lb_id);
		jp_up_l.add(lb_pw);
		
		jp_up_c.setGridLayout(2,1,10,10);
		jp_up_c.add(jtf_id);
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
