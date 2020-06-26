package Buyer_GUI;

import javax.swing.JLabel;
import javax.swing.JTextField;

import Index_GUI.Base_Frame;
import Index_GUI.MYButton;
import Pannel.MYPanel;
import Pannel.NumberField;
import Server_DATA.BuyerDTO;

public class Buyer_Update_Frame extends Base_Frame {
	//프레임 번호 6-5
	
	public BuyerDTO buyerDTO;
	MYPanel jp_base= new MYPanel();
	MYPanel jp_up= new MYPanel();
	MYPanel jp_down= new MYPanel();
	
	JLabel lb_name = new JLabel("이름",JLabel.CENTER);
	JLabel lb_tel = new JLabel("전화",JLabel.CENTER);
	JLabel lb_birth = new JLabel("생년",JLabel.CENTER);
	JLabel lb_point= new JLabel("Point",JLabel.CENTER);
	JLabel lb_lv = new JLabel("등급",JLabel.CENTER);
	
	public JTextField jtf_name= new JTextField();
	public NumberField jtf_tel= new NumberField();
	public NumberField jtf_birth= new NumberField();
	public NumberField jtf_point= new NumberField();
	public NumberField jtf_lv= new NumberField();

	MYButton bt_ok=new MYButton("수정",6,5,1);
	MYButton bt_cc=new MYButton("취소",6,5,2);
	
	public Buyer_Update_Frame(BuyerDTO buyerDTO) {
		super("고객 정보 수정", 300, 350);
		// TODO Auto-generated constructor stub
		this.buyerDTO=buyerDTO;
		
		jp_up.setGridLayout(5, 2, 10, 10);
		jp_up.add(lb_name);
		jtf_name.setText(buyerDTO.getName());
		jtf_name.setEditable(false);
		jp_up.add(jtf_name);
		
		jp_up.add(lb_tel);
		jtf_tel.setText(buyerDTO.getTel());
		jp_up.add(jtf_tel);
		
		jp_up.add(lb_birth);
		jtf_birth.setText(buyerDTO.getBirth());
		jtf_birth.setEditable(false);
		jp_up.add(jtf_birth);
		
		jp_up.add(lb_point);
		jtf_point.setText(Integer.toString(buyerDTO.getPoint()));
		jtf_point.setEditable(false);
		jp_up.add(jtf_point);
		
		jp_up.add(lb_lv);
		jtf_lv.setText(Integer.toString(buyerDTO.getLv()));
		jp_up.add(jtf_lv);
		

		jp_down.setGridLayout(1,2,10,10);
		jp_down.add(bt_ok);
		jp_down.add(bt_cc);
		
		jp_base.setLayout(null);
		jp_base.add(jp_up);
		jp_base.add(jp_down);
		jp_up.setBounds(10, 10, 240, 240);
		jp_down.setBounds(70, 260, 150, 30);
		
		this.setMainPanel(jp_base);
		this.setVisible(true);
	}
}
