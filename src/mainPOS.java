

import java.sql.SQLException;

import Buyer_GUI.*;
import Index_GUI.*;
import Pannel.*;
import Seller_GUI.*;
import Server_DATA.*;

public class mainPOS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("실행함");
		
		PosDAO pdao= new PosDAO();
		
		try {
			pdao.check_admin();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("시작");
		
		Index_Frame test=new Index_Frame();
		test.setVisible(true);
//		Login_Frame test=new Login_Frame();
//		Find_Id_Frame test=new Find_Id_Frame();
//		Seller_Frame test=new Seller_Frame();
//		Buyer_Frame test=new Buyer_Frame();
//		Product_Frame test=new Product_Frame();

//		Seller_Sign_Frame test= new Seller_Sign_Frame();
//		Seller_List_Frame test= new Seller_List_Frame();
//		Seller_Info_Frame test= new Seller_Info_Frame();
//		Buyer_Sign_Frame test = new Buyer_Sign_Frame();
		
		
	}
}
