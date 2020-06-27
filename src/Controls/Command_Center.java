package Controls;
import java.awt.Frame;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Buyer_GUI.Buyer_Frame;
import Buyer_GUI.Buyer_Info_Frame;
import Buyer_GUI.Buyer_List_Frame;
import Buyer_GUI.Buyer_Sign_Frame;
import Buyer_GUI.Buyer_Update_Frame;
import Index_GUI.Index_Frame;
import Login_GUI.Change_Pw_Frame;
import Login_GUI.Find_Id_Frame;
import Login_GUI.Find_Pw_Frame;
import Login_GUI.Login_Frame;
import Ordering_GUI.Ordering_Add_Frame;
import Ordering_GUI.Ordering_Frame;
import Ordering_GUI.Ordering_List_Frame;
import Ordering_GUI.Ordering_Log_Frame;
import Product_GUI.Product_Frame;
import Product_GUI.Product_Info_Frame;
import Product_GUI.Product_List_Frame;
import Product_GUI.Product_Sign_Frame;
import Product_GUI.Product_Update_Frame;
import Seller_GUI.Seller_Frame;
import Seller_GUI.Seller_Info_Frame;
import Seller_GUI.Seller_List_Frame;
import Seller_GUI.Seller_Sign_Frame;
import Seller_GUI.Seller_Update_Frame;
import Server_DATA.BuyerDAO;
import Server_DATA.ProductDAO;
import Server_DATA.SellerDAO;
import Server_DATA.SellerDTO;

public class Command_Center {
	
	protected SellerDTO user=null;
	//0 초기 프레임
	protected Index_Frame index_frame;
	//1 로그인 프레임
	protected Login_Frame login_frame;
	protected Find_Id_Frame find_id_frame;
	protected Find_Pw_Frame find_pw_frame;
	protected Change_Pw_Frame change_pw_frame;
	//2 로그아웃 버튼
	//--
	
	//3 물품 구매 프레임
	
	
	//4 물품 판매 프레임
	protected Ordering_Frame ordering_frame;
	protected Ordering_List_Frame ordering_list_frame;
	protected Ordering_Add_Frame ordering_add_frame;
	protected Ordering_Log_Frame ordering_log_frame;
	
	//5 직원 관리 프레임
	protected Seller_Frame seller_frame;
	protected Seller_Sign_Frame seller_sign_frame;
	protected Seller_List_Frame seller_list_frame;
	protected Seller_Info_Frame seller_info_frame;
	protected Seller_Update_Frame seller_update_frame;
	//6 고객 관리
	protected Buyer_Frame buyer_frame;
	protected Buyer_Sign_Frame buyer_sign_frame;
	protected Buyer_List_Frame buyer_list_frame;
	protected Buyer_Info_Frame buyer_info_frame;
	protected Buyer_Update_Frame buyer_update_frame;
	//7 상품 관리
	protected Product_Frame product_frame;
	protected Product_Sign_Frame product_sign_frame;
	protected Product_List_Frame product_list_frame;
	protected Product_Info_Frame product_info_frame;
	protected Product_Update_Frame product_update_frame;
	//	8 종료
	
	public SellerDAO sellerDAO=new SellerDAO();
	public BuyerDAO buyerDAO=new BuyerDAO();
	public ProductDAO productDAO=new ProductDAO();
	
	protected Login_Command login_command=new Login_Command();
	
	protected Selling_Command selling_command=new Selling_Command();
	protected Ordering_Command ordering_command=new Ordering_Command();
	
	protected Seller_Command seller_command=new Seller_Command();
	protected Buyer_Command buyer_command=new Buyer_Command();
	protected Product_Command product_command=new Product_Command();

	
	private Command_Center(){}
	
	public static Command_Center getInstance() {
		return LazyHolder.Instance;
	}

	
	private static class LazyHolder {
		private static final Command_Center Instance = new Command_Center();
	}
	

	public SellerDAO getSellerDAO() {
		return sellerDAO;
	}
	
	public SellerDTO getUser() {
		return user;
	}

	public void start() {
		index_frame = new Index_Frame();
	}

	public void popup(String title, String con) {
		JOptionPane.showMessageDialog(null, con, title, JOptionPane.WARNING_MESSAGE);
	}
	
	public void popup(JFrame frame,String title, String con) {
		if (frame.getState()== Frame.ICONIFIED) {
			frame.setState(Frame.NORMAL);
		}
		frame.requestFocus();
		JOptionPane.showMessageDialog(frame, con, title, JOptionPane.WARNING_MESSAGE);
	}
	
	public String diup(String title, String con) {
		return JOptionPane.showInputDialog(null, con,title,JOptionPane.PLAIN_MESSAGE);
	}
	
	public void command(int frame, int subframe , int butno) throws SQLException {
		System.out.println(Integer.toString(frame)+"-"+Integer.toString(subframe)+"-"+Integer.toString(butno));
		switch(frame) {
		case 0:
			if(subframe==0) {
				command_to_index(butno);
			}else {
				System.out.println("0-?-?");
			}
			break;
		case 1:
			if(subframe==0) {
				login_command.command(butno);
			}else {
				login_command.subcommand(subframe, butno);
			}
			break;
		case 3:
			System.out.println("상품판매 커맨드");
			break;
		case 4:
			if(subframe==0) {
				ordering_command.command(butno);
			}else {
				ordering_command.subcommand(subframe, butno);
			}
			break;
		case 5:
			if(subframe==0) {
				seller_command.command(butno);
			}else {
				seller_command.subcommand(subframe, butno);
			}
			break;
		case 6:
			if(subframe==0) {
				buyer_command.command(butno);
			}else {
				buyer_command.subcommand(subframe, butno);
			}
			break;
		case 7:
			if(subframe==0) {
				product_command.command(butno);
			}else {
				product_command.subcommand(subframe, butno);
			}
			break;
		}
	}

	
	//0 인덱스 프레임으로 명령 전달.
	private void command_to_index(int butno) {
		switch(butno) {
		case 1:
			index_frame.setVisible(false);
			index_frame=null;
			login_frame=new Login_Frame();
			break;
		case 2:
			user=null;
			index_frame.setVisible(false);
			index_frame=null;
			index_frame=new Index_Frame();
			break;
		case 3:
			System.out.println("상품 판매 프레임");
			break;
		case 4:
			index_frame.setVisible(false);
			ordering_frame = new Ordering_Frame();
			break;
		case 5:
			index_frame.setVisible(false);
			seller_frame= new Seller_Frame();
			seller_frame.setVisible(true);
			break;
		case 6:
			index_frame.setVisible(false);
			buyer_frame= new Buyer_Frame();
			buyer_frame.setVisible(true);
			break;
		case 7:
			index_frame.setVisible(false);
			product_frame= new Product_Frame();
			product_frame.setVisible(true);
			break;
		case 8:
			index_frame.setVisible(false);
			index_frame=null;
			System.exit(0);
		}
	}
	
}
