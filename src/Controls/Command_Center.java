package Controls;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Buyer_GUI.*;
import Index_GUI.*;
import Login_GUI.*;
import Product_GUI.*;
import Seller_GUI.*;
import Server_DATA.*;

public class Command_Center {
	
	protected SellerDTO user=null;
	//0 초기 프레임
	protected Index_Frame index_frame;
	//1 로그인 프레임
	protected Login_Frame login_frame;
	protected Find_Id_Frame find_id_frame;
	protected Find_Pw_Frame find_pw_frame;
	//2 로그아웃 버튼
	
	//3 물품 구매 프레임
	//4 물품 판매 프레임
	
	//5 직원 관리 프레임
	protected Seller_Frame seller_frame;
	protected Seller_Sign_Frame seller_sign_frame;
	protected Seller_List_Frame seller_list_frame;
	protected Seller_Info_Frame seller_info_frame;
	//6 고객 관리
	protected Buyer_Frame buyer_frame;
	protected Buyer_Sign_Frame Buyer_sign_frame;
	//7 상품 관리
	protected Product_Frame product_frame;
	//	8 종료
	
	protected SellerDAO sellerDAO=new SellerDAO();
	
	protected Login_Command login_command=new Login_Command();
	
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

	public void setSellerDAO(SellerDAO sellerDAO) {
		this.sellerDAO = sellerDAO;
	}

	public void start() {
		index_frame = new Index_Frame();
	}

	public void command(int frame, int butno) throws SQLException {
		System.out.println(Integer.toString(frame)+","+Integer.toString(butno));
		switch(frame) {
		case 0:
			command_to_index(butno);
			break;
		case 1:
			command_to_login(butno);
			break;
		}
	}
	
	public void subcommand(int frame, int subframe, int butno) throws SQLException {
		// TODO Auto-generated method stub
		switch(frame) {
		case 1:
			login_command.subcommand(subframe, butno);
			break;
		}
	}
	
	public void popup(String title, String con) {
		JOptionPane.showMessageDialog(null, con, title, JOptionPane.WARNING_MESSAGE);
	}
	
	//0 인덱스 프레임으로 명령 전달.
	private void command_to_index(int butno) {
		switch(butno) {
		case 1:
			index_frame.setVisible(false);
			if(login_frame==null) {
				System.out.println("로그 null이라 생성");
				login_frame= new Login_Frame();
			}
			break;
		case 2:
			user=null;
			index_frame.setVisible(false);
			index_frame=null;
			index_frame= new Index_Frame();
			break;
		case 3:
			System.out.println("상품 판매 프레임");
			break;
		case 4:
			System.out.println("상품 주문 프레임");
			break;
		case 5:
			if(seller_frame==null) {
				seller_frame= new Seller_Frame();
			}
			seller_frame.setVisible(true);
			break;
		case 6:
			if(buyer_frame==null) {
				buyer_frame= new Buyer_Frame();
			}
			buyer_frame.setVisible(true);
			break;
		case 7:
			if(product_frame==null) {
				product_frame= new Product_Frame();
			}
			product_frame.setVisible(true);
			break;
		case 8:
			index_frame.setVisible(false);
			index_frame=null;
			System.exit(0);
		}
	}
	
	//1 로그인 프레임에 전달
	private void command_to_login(int butno) throws SQLException {
		switch(butno) {
		case 0:
			String typed_id=login_frame.jtf_id.getText();
			char[] typed_pw_char=login_frame.jtf_pw.getPassword();
			String typed_pw="";
			for (int i =0; i<typed_pw_char.length; i++) {
				typed_pw+=typed_pw_char[i];
			}
			if (typed_id.equals("")) {
				this.popup("유효성 검사", "아이디를 입력해 주세요.");
				break;
			}
			if (typed_pw.equals("")) {
				this.popup("유효성 검사", "비밀번호를 입력해 주세요.");
				break;
			}
			login_frame.jtf_pw.setText("");
			int returnd=sellerDAO.isCollect(typed_id, typed_pw);
			if (returnd==1) {
				this.popup("성공", "로그인 성공");
				user = sellerDAO.getSeller(typed_id);
				login_frame.setVisible(false);
				login_frame=null;
				index_frame=new Index_Frame(user);
			}else if(returnd==0) {
				this.popup("실패", "비밀번호 확인");
			}else if(returnd==-1) {
				this.popup("실패", "로그인ID 확인");
			}
			break;
		case 1:
			login_frame.setVisible(false);
			find_id_frame = new Find_Id_Frame();
			break;
		case 2:
			login_frame.setVisible(false);
			find_pw_frame = new Find_Pw_Frame();
			break;
		case 3:
			login_frame.setVisible(false);
			login_frame=null;
			index_frame.setVisible(true);
		}
	}


	
	
}
