package Login_GUI;

import javax.swing.*;

import Index_GUI.Base_Frame;
import Index_GUI.MYButton;
import Pannel.MYPanel;
import Pannel.NumberField;

public class Find_Id_Frame extends Base_Frame {

	MYPanel jp_base= new MYPanel();
	MYPanel jp_up= new MYPanel();
	MYPanel jp_down= new MYPanel();
	
	JLabel lb_name = new JLabel("이름",JLabel.CENTER);
	JLabel lb_tel = new JLabel("전화",JLabel.CENTER);
	JLabel lb_birth = new JLabel("생년",JLabel.CENTER);
	
	public JTextField jtf_name= new JTextField();
	public NumberField jtf_tel= new NumberField();
	public NumberField jtf_birth= new NumberField();

	MYButton bt_f=new MYButton("찾기",1,1,1);
	MYButton bt_c=new MYButton("취소",1,1,2);
	
	public Find_Id_Frame() {
		super("Find Id", 300, 250);
		// TODO Auto-generated constructor stub
	
		jp_up.setGridLayout(3, 2, 10, 10);
		jp_up.add(lb_name);
		jp_up.add(jtf_name);
		jp_up.add(lb_tel);
		jp_up.add(jtf_tel);
		jp_up.add(lb_birth);
		jp_up.add(jtf_birth);
		

		jp_down.setGridLayout(1,2,10,10);
		jp_down.add(bt_f);
		jp_down.add(bt_c);
		
		jp_base.setLayout(null);
		jp_base.add(jp_up);
		jp_base.add(jp_down);
		jp_up.setBounds(30, 10, 240, 150);
		jp_down.setBounds(45, 170, 200, 30);
		
		this.setMainPanel(jp_base);
		this.setVisible(true);
	}

}
