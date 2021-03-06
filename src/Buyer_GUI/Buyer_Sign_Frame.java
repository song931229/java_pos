package Buyer_GUI;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Index_GUI.Base_Frame;
import Pannel.MYPanel;
import Pannel.NumberField;

public class Buyer_Sign_Frame extends Base_Frame {

	MYPanel jp_base= new MYPanel();
	MYPanel jp_up= new MYPanel();
	MYPanel jp_down= new MYPanel();
	
	JLabel lb_name = new JLabel("이름",JLabel.CENTER);
	JLabel lb_pnum = new JLabel("전화",JLabel.CENTER);
	JLabel lb_birth = new JLabel("생년",JLabel.CENTER);
	
	JTextField jtf_name= new JTextField();
	NumberField jtf_pnum= new NumberField();
	NumberField jtf_birth= new NumberField();

	JButton bt_ok=new JButton("등록");
	JButton bt_cc=new JButton("취소");
	
	public Buyer_Sign_Frame() {
		super("Buyer_Sign", 300, 200);
		// TODO Auto-generated constructor stub
		
		jp_up.setGridLayout(3, 2, 10, 10);
		jp_up.add(lb_name);
		jp_up.add(jtf_name);
		
		jp_up.add(lb_pnum);
		jp_up.add(jtf_pnum);
		
		jp_up.add(lb_birth);
		jp_up.add(jtf_birth);

		jp_down.setGridLayout(1,2,10,10);
		jp_down.add(bt_ok);
		jp_down.add(bt_cc);
		
		jp_base.setLayout(null);
		jp_base.add(jp_up);
		jp_base.add(jp_down);
		jp_up.setBounds(10, 10, 240, 100);
		jp_down.setBounds(70, 125, 150, 30);
		
		this.setMainPanel(jp_base);
		this.setVisible(true);
	}

}
