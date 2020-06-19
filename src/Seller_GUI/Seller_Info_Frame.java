package Seller_GUI;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Index_GUI.Base_Frame;
import Pannel.MYPanel;
import Pannel.NumberField;

public class Seller_Info_Frame extends Base_Frame {
	
	MYPanel jp_base= new MYPanel();
	MYPanel jp_up= new MYPanel();
	MYPanel jp_down= new MYPanel();
	String[] items = {"이름","전화","생년","ID","PW","Lv","가입일"};
	JLabel[] lbs_l=new JLabel[items.length];
	JLabel[] lbs_r=new JLabel[items.length];


	JButton bt_up=new JButton("수정");
	JButton bt_del=new JButton("삭제");
	JButton bt_cc=new JButton("닫기");
	
	public Seller_Info_Frame() {
		super("Seller Info", 300, 400);
		// TODO Auto-generated constructor stub
		
		jp_up.setGridLayout(7, 2, 10, 10);
		
		for (int i=0;i<items.length;i++) {
			lbs_l[i]=new JLabel(items[i],JLabel.CENTER);
			jp_up.add(lbs_l[i]);
			lbs_r[i]=new JLabel(items[i],JLabel.CENTER);
			jp_up.add(lbs_r[i]);
		}
	
		jp_down.setGridLayout(1,3,10,10);
		jp_down.add(bt_up);
		jp_down.add(bt_del);
		jp_down.add(bt_cc);
		
		jp_base.setLayout(null);
		jp_base.add(jp_up);
		jp_base.add(jp_down);
		jp_up.setBounds(25, 10, 250, 300);
		jp_down.setBounds(50, 320, 200, 30);
		
		this.setMainPanel(jp_base);
		this.setVisible(true);
	}
	
}
