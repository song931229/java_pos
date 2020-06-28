package Ordering_GUI;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Controls.Command_Center;
import Index_GUI.Base_Frame;
import Index_GUI.MYButton;
import Pannel.MYPanel;
import Pannel.NumberField;
import Server_DATA.ProductDTO;

public class Ordering_Popup_Frame extends Base_Frame {
	
	private Command_Center cc=Command_Center.getInstance();
	
	public ProductDTO addingProduct;
	
	MYPanel jp_base= new MYPanel();
	MYPanel jp_up_l= new MYPanel();
	MYPanel jp_up_r= new MYPanel();
	MYPanel jp_mid= new MYPanel();
	MYPanel jp_down= new MYPanel();
	
	public int orderprice=0;
	
	// jp_up
	JLabel lb_name = new JLabel("상품명",JLabel.CENTER);
	JLabel lb_company= new JLabel("제조사",JLabel.CENTER);
	JLabel lb_orderprice = new JLabel("주문가",JLabel.CENTER);
	JLabel lb_sellprice = new JLabel("판매가",JLabel.CENTER);
	JLabel lb_pqty= new JLabel("현 재고",JLabel.CENTER);
	JLabel lb_barcode = new JLabel("바코드",JLabel.CENTER);
	
	public JTextField jtf_name= new JTextField();
	public JTextField jtf_company= new JTextField();
	public NumberField jtf_orderprice= new NumberField();
	public NumberField jtf_sellprice= new NumberField();
	public NumberField jtf_pqty= new NumberField();
	public NumberField jtf_barcode= new NumberField();

	
	//jp_mid
	JLabel lb_count= new JLabel("수량",JLabel.CENTER);
	public NumberField jtf_count=new NumberField();
	MYButton count_minus=new MYButton("-", 4, 5, 3);
	MYButton count_plus=new MYButton("+", 4, 5, 4);
	
	JLabel lb_totalprice= new JLabel("합계",JLabel.CENTER);
	public NumberField jtf_totalprice=new NumberField();
	
	
	
	//jp_down
	MYButton bt_ok=new MYButton("추가",4,5,1);
	MYButton bt_cc=new MYButton("취소",4,5,2);
	
	public Ordering_Popup_Frame(String barcode) throws SQLException {
		super("주문 수량",300,420);
		// TODO Auto-generated constructor stub
		this.addingProduct=cc.productDAO.infoProduct(barcode);
		this.orderprice=addingProduct.getOrderprice();
		
		jp_up_l.setGridLayout(8, 1, 10, 10);
		jp_up_r.setGridLayout(8, 1, 10, 10);
		jp_up_l.add(lb_name);
		jtf_name.setText(addingProduct.getName());
		jtf_name.setEditable(false);
		jp_up_r.add(jtf_name);
		
		jp_up_l.add(lb_company);
		jtf_company.setText(addingProduct.getCompany());
		jtf_company.setEditable(false);
		jp_up_r.add(jtf_company);
		
		jp_up_l.add(lb_orderprice);
		jtf_orderprice.setText(Integer.toString(addingProduct.getOrderprice()));
		jtf_orderprice.setEditable(false);
		jp_up_r.add(jtf_orderprice);
		
		jp_up_l.add(lb_sellprice);
		jtf_sellprice.setText(Integer.toString(addingProduct.getSellprice()));
		jtf_sellprice.setEditable(false);
		jp_up_r.add(jtf_sellprice);
		
		jp_up_l.add(lb_pqty);
		jtf_pqty.setText(Integer.toString(addingProduct.getPqty()));
		jtf_pqty.setEditable(false);
		jp_up_r.add(jtf_pqty);
		
		jp_up_l.add(lb_barcode);
		jtf_barcode.setText(addingProduct.getBarcode());
		jtf_barcode.setEditable(false);
		jp_up_r.add(jtf_barcode);
		
		
		jp_up_l.add(lb_count);
		jtf_count.setText("0");
		jtf_count.setEditable(false);
		
		jtf_count.addMouseListener(new MouseListener() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					String input=cc.diup("수량변경", "수량을입력해주세요.");
					if(input==null) {
						return;
					}
					if(input.equals("")) {
						cc.popup("경고", "값을 입력해 주세요.");
					}
	                if (input.matches("^[0-9]*$")) {
	                	if(Integer.parseInt(input)<=100) {
	                		jtf_count.setText(input);
	                		int totalprice = Integer.parseInt(input)*orderprice;
	                		jtf_totalprice.setText(Integer.toString(totalprice));
	                	}else {
	                		cc.popup("경고", "최대수량은 100입니다.");
	                	}
	                } else {
	                    cc.popup("경고", "숫자만 입력해 주세요.");
	                }
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
		});
		
		jtf_totalprice.setText("0");
		jp_mid.setGridLayout(1, 3,10,10);
		jp_mid.add(count_minus);
		jp_mid.add(jtf_count);
		jp_mid.add(count_plus);
		jp_up_r.add(jp_mid);
		
		jp_up_l.add(lb_totalprice);
		jtf_totalprice.setEditable(false);
		jp_up_r.add(jtf_totalprice);
		
		jp_down.setGridLayout(1,2,5,5);
		jp_down.add(bt_ok);
		jp_down.add(bt_cc);
		
		jp_base.setLayout(null);
		jp_base.add(jp_up_l);
		jp_base.add(jp_up_r);
		jp_base.add(jp_down);
		jp_up_l.setBounds(10, 10, 90, 320);
		jp_up_r.setBounds(100, 10, 160, 320);
		jp_down.setBounds(70, 340, 150, 30);
		
		this.setMainPanel(jp_base);
		this.setVisible(true);
		
	}
	
}
