package Seller_GUI;

import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controls.Command_Center;
import Index_GUI.Base_Frame;
import Index_GUI.MYButton;
import Pannel.MYPanel;
import Pannel.NumberField;
import Server_DATA.SellerDTO;

public class Seller_Info_Frame extends Base_Frame {
	// 프레임번호 5-4
	private Command_Center cc=Command_Center.getInstance();
	public SellerDTO sellerdto;
	MYPanel jp_base= new MYPanel();
	MYPanel jp_up= new MYPanel();
	MYPanel jp_down= new MYPanel();
	String[] items = {"이름","전화","생년","ID","c_cash","n_cash","Lv","가입일"};
	JLabel[] lbs_l=new JLabel[items.length];
	JLabel[] lbs_r=new JLabel[items.length];


	MYButton bt_up=new MYButton("수정",5,4,1);
	MYButton bt_del=new MYButton("삭제",5,4,2);
	MYButton bt_cc=new MYButton("닫기",5,4,3);
	
	public Seller_Info_Frame(String id) throws SQLException {
		super("Seller Info", 300, 450);
		sellerdto=cc.sellerDAO.infoSeller(id);
		// TODO Auto-generated constructor stub
		String[] values={
				sellerdto.getName(),
				sellerdto.getTel(),
				sellerdto.getBirth(),
				sellerdto.getId(),
				Integer.toString(sellerdto.getC_cash()),
				Integer.toString(sellerdto.getN_cash()),
				Integer.toString(sellerdto.getLv()),
				sellerdto.getJoindate()};
		jp_up.setGridLayout(8, 2, 10, 10);
		
		for (int i=0;i<items.length;i++) {
			lbs_l[i]=new JLabel(items[i],JLabel.CENTER);
			jp_up.add(lbs_l[i]);
			lbs_r[i]=new JLabel(values[i],JLabel.CENTER);
			jp_up.add(lbs_r[i]);
		}
	
		jp_down.setGridLayout(1,3,10,10);
		jp_down.add(bt_up);
		jp_down.add(bt_del);
		jp_down.add(bt_cc);
		
		jp_base.setLayout(null);
		jp_base.add(jp_up);
		jp_base.add(jp_down);
		jp_up.setBounds(25, 10, 250, 350);
		jp_down.setBounds(50, 370, 200, 30);
		
		this.setMainPanel(jp_base);
		this.setVisible(true);
	}
	
}
