package Seller_GUI;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Index_GUI.Base_Frame;
import Index_GUI.MYButton;
import Pannel.MYPanel;
import Pannel.NumberField;
import Server_DATA.SellerDTO;

public class Seller_Update_Frame extends Base_Frame{
	// 프레임번호 5-5
	
	public SellerDTO sellerDTO;
	MYPanel jp_base= new MYPanel();
	MYPanel jp_up= new MYPanel();
	MYPanel jp_down= new MYPanel();
	
	JLabel lb_name = new JLabel("이름",JLabel.CENTER);
	JLabel lb_tel = new JLabel("전화",JLabel.CENTER);
	JLabel lb_birth = new JLabel("생년",JLabel.CENTER);
	JLabel lb_id = new JLabel("ID",JLabel.CENTER);
	JLabel lb_ccash = new JLabel("c_cash",JLabel.CENTER);
	JLabel lb_ncash = new JLabel("n_cash",JLabel.CENTER);
	JLabel lb_lv = new JLabel("Level",JLabel.CENTER);
	
	public JTextField jtf_name= new JTextField();
	public NumberField jtf_tel= new NumberField();
	public NumberField jtf_birth= new NumberField();
	public NumberField jtf_ccash= new NumberField();
	public NumberField jtf_ncash= new NumberField();
	public JTextField jtf_id= new JTextField();
	public NumberField jtf_lv= new NumberField();

	MYButton bt_ok=new MYButton("수정",5,5,1);
	MYButton bt_cc=new MYButton("취소",5,5,2);
	
	public Seller_Update_Frame(SellerDTO sellerDTO) {
		super("직원 수정", 300, 430);
		// TODO Auto-generated constructor stub
		this.sellerDTO=sellerDTO;
		
		jp_up.setGridLayout(7, 2, 10, 10);
		jp_up.add(lb_name);
		jtf_name.setText(sellerDTO.getName());
		jtf_name.setEditable(false);
		jp_up.add(jtf_name);
		
		jp_up.add(lb_tel);
		jtf_tel.setText(sellerDTO.getTel());
		jp_up.add(jtf_tel);
		
		jp_up.add(lb_birth);
		jtf_birth.setText(sellerDTO.getBirth());
		jtf_birth.setEditable(false);
		jp_up.add(jtf_birth);
		
		jp_up.add(lb_id);
		jtf_id.setText(sellerDTO.getId());
		jtf_id.setEditable(false);
		jp_up.add(jtf_id);
		
		jp_up.add(lb_ccash);
		jtf_ccash.setText(Integer.toString(sellerDTO.getC_cash()));
		jtf_ccash.setEditable(false);
		jp_up.add(jtf_ccash);
		
		jp_up.add(lb_ncash);
		jtf_ncash.setText(Integer.toString(sellerDTO.getN_cash()));
		jp_up.add(jtf_ncash);
		
		jp_up.add(lb_lv);
		jtf_lv.setText(Integer.toString(sellerDTO.getLv()));
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
