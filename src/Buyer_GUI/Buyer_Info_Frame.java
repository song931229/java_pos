package Buyer_GUI;

import java.sql.SQLException;

import javax.swing.JLabel;

import Controls.Command_Center;
import Index_GUI.Base_Frame;
import Index_GUI.MYButton;
import Pannel.MYPanel;
import Server_DATA.BuyerDTO;


public class Buyer_Info_Frame extends Base_Frame {
	// 프레임번호 6-4
	private Command_Center cc=Command_Center.getInstance();
	public BuyerDTO buyerDTO;
	MYPanel jp_base= new MYPanel();
	MYPanel jp_up= new MYPanel();
	MYPanel jp_down= new MYPanel();
	String[] items = {"이름","전화","생년","point","Lv","가입일"};
	JLabel[] lbs_l=new JLabel[items.length];
	JLabel[] lbs_r=new JLabel[items.length];


	MYButton bt_up=new MYButton("수정",6,4,1);
	MYButton bt_del=new MYButton("삭제",6,4,2);
	MYButton bt_cc=new MYButton("닫기",6,4,3);

	public Buyer_Info_Frame(String tel) throws SQLException {
		super("고객 정보", 300,360);
		buyerDTO=cc.buyerDAO.infoBuyer(tel);
		// TODO Auto-generated constructor stub
		String[] values={
				buyerDTO.getName(),
				buyerDTO.getTel(),
				buyerDTO.getBirth(),
				Integer.toString(buyerDTO.getPoint()),
				Integer.toString(buyerDTO.getLv()),
				buyerDTO.getJoindate()};
		jp_up.setGridLayout(6, 2, 10, 10);
		
		for (int i=0;i<items.length;i++) {
			System.out.println(">>"+values[i]);
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
		jp_up.setBounds(10, 10, 280, 260);
		jp_down.setBounds(50, 280, 200, 30);
		
		this.setMainPanel(jp_base);

	}

}
