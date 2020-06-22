package Seller_GUI;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Index_GUI.Base_Frame;
import Index_GUI.MYButton;
import Pannel.MYPanel;
import Pannel.NumberField;

public class Seller_Sign_Frame extends Base_Frame {
	
	MYPanel jp_base= new MYPanel();
	MYPanel jp_up= new MYPanel();
	MYPanel jp_down= new MYPanel();
	
	JLabel lb_name = new JLabel("이름",JLabel.CENTER);
	JLabel lb_tel = new JLabel("전화",JLabel.CENTER);
	JLabel lb_birth = new JLabel("생년",JLabel.CENTER);
	JLabel lb_id = new JLabel("ID",JLabel.CENTER);
	JLabel lb_pw1 = new JLabel("PW",JLabel.CENTER);
	JLabel lb_pw2 = new JLabel("PW 확인",JLabel.CENTER);
	JLabel lb_lv = new JLabel("Level",JLabel.CENTER);
	
	public JTextField jtf_name= new JTextField();
	public NumberField jtf_tel= new NumberField();
	public NumberField jtf_birth= new NumberField();
	public JTextField jtf_id= new JTextField();
	public JPasswordField jtf_pw1= new JPasswordField();
	public JPasswordField jtf_pw2= new JPasswordField();
	public NumberField jtf_lv= new NumberField();

	MYButton bt_ok=new MYButton("등록",5,1,1);
	MYButton bt_cc=new MYButton("취소",5,1,2);
	
	public Seller_Sign_Frame() {
		super("직원 등록", 300, 430);
		// TODO Auto-generated constructor stub
		
		
		jp_up.setGridLayout(7, 2, 10, 10);
		jp_up.add(lb_name);
		jp_up.add(jtf_name);
		
		jp_up.add(lb_tel);
		jp_up.add(jtf_tel);
		
		jp_up.add(lb_birth);
		jp_up.add(jtf_birth);
		
		jp_up.add(lb_id);
		jp_up.add(jtf_id);
		
		jp_up.add(lb_pw1);
		jtf_pw1.setEchoChar('*');
		jp_up.add(jtf_pw1);
		
		jp_up.add(lb_pw2);
		jtf_pw2.setEchoChar('*');
		jp_up.add(jtf_pw2);
		
		jp_up.add(lb_lv);
		jp_up.add(jtf_lv);
		

		jp_down.setGridLayout(1,2,10,10);
		jp_down.add(bt_ok);
		jp_down.add(bt_cc);
		
		jp_base.setLayout(null);
		jp_base.add(jp_up);
		jp_base.add(jp_down);
		jp_up.setBounds(10, 10, 240, 330);
		jp_down.setBounds(70, 350, 150, 30);
		
		this.setMainPanel(jp_base);
		this.setVisible(true);
	}
	
}
