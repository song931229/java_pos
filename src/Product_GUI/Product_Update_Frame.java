package Product_GUI;

import javax.swing.JLabel;
import javax.swing.JTextField;

import Index_GUI.Base_Frame;
import Index_GUI.MYButton;
import Pannel.MYPanel;
import Pannel.NumberField;
import Server_DATA.ProductDTO;

public class Product_Update_Frame extends Base_Frame {
	//프레임 번호 7-5
	public ProductDTO productDTO;
	MYPanel jp_base= new MYPanel();
	MYPanel jp_up= new MYPanel();
	MYPanel jp_down= new MYPanel();
	
	JLabel lb_name = new JLabel("상품명",JLabel.CENTER);
	JLabel lb_company= new JLabel("제조사",JLabel.CENTER);
	JLabel lb_orderprice = new JLabel("주문가",JLabel.CENTER);
	JLabel lb_sellprice = new JLabel("판매가",JLabel.CENTER);
	JLabel lb_pqty= new JLabel("수량",JLabel.CENTER);
	JLabel lb_barcode = new JLabel("바코드",JLabel.CENTER);
	
	public JTextField jtf_name= new JTextField();
	public NumberField jtf_company= new NumberField();
	public NumberField jtf_orderprice= new NumberField();
	public NumberField jtf_sellprice= new NumberField();
	public NumberField jtf_pqty= new NumberField();
	public NumberField jtf_barcode= new NumberField();

	MYButton bt_ok=new MYButton("수정",7,5,1);
	MYButton bt_cc=new MYButton("취소",7,5,2);
	
	public Product_Update_Frame(ProductDTO productDTO) {
		super("상품 정보 수정",300,410);
		// TODO Auto-generated constructor stub
		this.productDTO=productDTO;
		
		jp_up.setGridLayout(6, 2, 10, 10);
		jp_up.add(lb_name);
		jtf_name.setText(productDTO.getName());
		jtf_name.setEditable(false);
		jp_up.add(jtf_name);
		
		jp_up.add(lb_company);
		jtf_company.setText(productDTO.getCompany());
		jtf_company.setEditable(false);
		jp_up.add(jtf_company);
		
		jp_up.add(lb_orderprice);
		jtf_orderprice.setText(Integer.toString(productDTO.getOrderprice()));
		jp_up.add(jtf_orderprice);
		
		jp_up.add(lb_sellprice);
		jtf_sellprice.setText(Integer.toString(productDTO.getSellprice()));
		jp_up.add(jtf_sellprice);
		
		jp_up.add(lb_pqty);
		jtf_pqty.setText(Integer.toString(productDTO.getPqty()));
		jp_up.add(jtf_pqty);
		
		jp_up.add(lb_barcode);
		jtf_barcode.setText(productDTO.getBarcode());
		jtf_barcode.setEditable(false);
		jp_up.add(jtf_barcode);

		jp_down.setGridLayout(1,2,10,10);
		jp_down.add(bt_ok);
		jp_down.add(bt_cc);
		
		jp_base.setLayout(null);
		jp_base.add(jp_up);
		jp_base.add(jp_down);
		jp_up.setBounds(10, 10, 240, 310);
		jp_down.setBounds(70, 330, 150, 30);
		
		this.setMainPanel(jp_base);
		this.setVisible(true);
		
	}

}
