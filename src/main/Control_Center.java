package main;
import Buyer_GUI.*;
import Index_GUI.*;
import Login_GUI.*;
import Product_GUI.*;
import Seller_GUI.*;

public class Control_Center {
	
	private int level=0;
	private boolean logining=false;
	//0 초기 프레임
	private Index_Frame index_frame;
	//1 로그인 프레임
	private Login_Frame login_frame;
	private Find_Id_Frame find_id_frame;
	private Find_Pw_Frame find_pw_frame;
	//2 로그아웃 버튼
	//3 물품 구매 프레임
	//4 물품 판매 프레임
	
	//5 직원 관리 프레임
	private Seller_Frame seller_frame;
	private Seller_Sign_Frame seller_sign_frame;
	private Seller_List_Frame seller_list_frame;
	private Seller_Info_Frame seller_info_frame;
	//6 고객 관리
	private Buyer_Frame buyer_frame;
	private Buyer_Sign_Frame Buyer_sign_frame;
	//7 상품 관리
	private Product_Frame product_frame;
	//	8 종료
	
	
	
	private Control_Center(){}
	
	public static Control_Center getInstance() {
		return LazyHolder.Instance;
	}

	
	private static class LazyHolder {
		private static final Control_Center Instance = new Control_Center();
	}
	

	public void command(int frame, int butno) {
		System.out.println(Integer.toString(frame)+","+Integer.toString(butno));
		switch(frame) {
		case 0:
			switch(butno) {
			case 1:
				if(login_frame==null) {
					login_frame= new Login_Frame();
				}
				login_frame.setVisible(true);
				break;
			case 2:
				level=0;
				logining=false;
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
			break;
		case 1:
			
		}
	}
	
}
