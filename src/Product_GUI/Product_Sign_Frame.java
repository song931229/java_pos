package Product_GUI;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Index_GUI.Base_Frame;
import Index_GUI.MYButton;
import Pannel.MYPanel;
import Pannel.NumberField;

public class Product_Sign_Frame extends Base_Frame {
	// 프레임번호 7-1
	MYPanel jp_base= new MYPanel();
	MYPanel jp_up= new MYPanel();
	MYPanel jp_down= new MYPanel();
	
	JLabel lb_name = new JLabel("이름",JLabel.CENTER);
	JLabel lb_company = new JLabel("제조사",JLabel.CENTER);
	JLabel lb_orderprice = new JLabel("주문가",JLabel.CENTER);
	JLabel lb_sellprice = new JLabel("판매가",JLabel.CENTER);
	JLabel lb_barcode = new JLabel("바코드",JLabel.CENTER);
	
	public JTextField jtf_name= new JTextField();
	public JTextField jtf_company= new JTextField();
	public NumberField jtf_orderprice= new NumberField();
	public NumberField jtf_sellprice= new NumberField();
	public NumberField jtf_barcode= new NumberField();

	MYButton bt_ok=new MYButton("등록",7,1,1);
	MYButton bt_cc=new MYButton("취소",7,1,2);
	
	public Product_Sign_Frame(String barcode) {
		super("상품 등록", 300, 310);
		// TODO Auto-generated constructor stub
		jp_up.setGridLayout(5, 2, 10, 10);
		
		jp_up.add(lb_name);
		jp_up.add(jtf_name);
		
		jp_up.add(lb_company);
		jp_up.add(jtf_company);
		
		jp_up.add(lb_orderprice);
		jp_up.add(jtf_orderprice);
		
		jp_up.add(lb_sellprice);
		jp_up.add(jtf_sellprice);
		
		jp_up.add(lb_barcode);
		jtf_barcode.setText(barcode);
		jtf_barcode.setEditable(false);
		jp_up.add(jtf_barcode);
		

		jp_down.setGridLayout(1,2,10,10);
		jp_down.add(bt_ok);
		jp_down.add(bt_cc);
		
		jp_base.setLayout(null);
		jp_base.add(jp_up);
		jp_base.add(jp_down);
		jp_up.setBounds(10, 10, 240, 210);
		jp_down.setBounds(70, 230, 150, 30);
		
		this.setMainPanel(jp_base);
		this.setVisible(true);
	}

}
