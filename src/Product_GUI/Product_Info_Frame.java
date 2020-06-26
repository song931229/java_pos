package Product_GUI;

import java.sql.SQLException;

import javax.swing.JLabel;

import Controls.Command_Center;
import Index_GUI.Base_Frame;
import Index_GUI.MYButton;
import Pannel.MYPanel;
import Server_DATA.ProductDTO;

public class Product_Info_Frame extends Base_Frame {
	//프레임 번호 7-4
	private Command_Center cc=Command_Center.getInstance();
	public ProductDTO productDTO;
	MYPanel jp_base= new MYPanel();
	MYPanel jp_up= new MYPanel();
	MYPanel jp_down= new MYPanel();
	String[] items = {"상품명","제조사","주문가","판매가","수량","바코드"};
	JLabel[] lbs_l=new JLabel[items.length];
	JLabel[] lbs_r=new JLabel[items.length];


	MYButton bt_up=new MYButton("수정",7,4,1);
	MYButton bt_del=new MYButton("삭제",7,4,2);
	MYButton bt_cc=new MYButton("닫기",7,4,3);

	public Product_Info_Frame(String barcode) throws SQLException {
		super("상품 정보", 300, 410);
		productDTO=cc.productDAO.infoProduct(barcode);
		// TODO Auto-generated constructor stub
		String[] values={
				productDTO.getName(),
				productDTO.getCompany(),
				Integer.toString(productDTO.getOrderprice()),
				Integer.toString(productDTO.getSellprice()),
				Integer.toString(productDTO.getPqty()),
				productDTO.getBarcode()};
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
		jp_up.setBounds(10, 10, 280, 310);
		jp_down.setBounds(50, 330, 200, 30);
		
		this.setMainPanel(jp_base);
	}

}
