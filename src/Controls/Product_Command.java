package Controls;

import java.sql.SQLException;

import Buyer_GUI.Buyer_Info_Frame;
import Buyer_GUI.Buyer_Update_Frame;
import Product_GUI.*;
import Server_DATA.BuyerDTO;
import Server_DATA.ProductDTO;

public class Product_Command {
	private Command_Center cc;
	public void command(int butno) throws SQLException {
		cc=Command_Center.getInstance();
		switch(butno) {
		case 1://7-0-1
			String tel=cc.diup("중복확인", "바코드를 입력해 주세요.");
			if (tel==null) {
				break;
			}
			if (cc.productDAO.isNew(tel)==true) {
				cc.popup("중복", "이미 등록된 바코드 입니다.");
				break;
			}
			cc.product_sign_frame=new Product_Sign_Frame(tel);
			cc.product_frame.setVisible(false);
			break;
		case 2://7-0-2
			cc.product_list_frame=new Product_List_Frame();
			cc.product_frame.setVisible(false);
			break;
		case 3://7-0-3
			cc.product_frame.setVisible(false);
			cc.product_frame=null;
			cc.index_frame.setVisible(true);
			break;
		case 4://7-0-4
			if(cc.product_info_frame==null) {
				cc.product_info_frame=new Product_Info_Frame(cc.product_list_frame.clicked_barcode);
			}else {
				cc.popup(cc.product_info_frame,"경고","이미 정보창이 열려있습니다.");
			}
			break;
		}
	}
	
	public void subcommand(int subframe, int butno) throws SQLException {
		cc=Command_Center.getInstance();
		switch(subframe) {
		case 1://등록
			switch(butno) {
			case 1://7-1-1
				String get_name=cc.product_sign_frame.jtf_name.getText();
				String get_company=cc.product_sign_frame.jtf_company.getText();
				int get_orderprice=Integer.parseInt(cc.product_sign_frame.jtf_orderprice.getText());
				int get_sellprice=Integer.parseInt(cc.product_sign_frame.jtf_sellprice.getText());
				String get_barcode=cc.product_sign_frame.jtf_barcode.getText();

				ProductDTO productDTO= new ProductDTO(get_name, get_company, get_orderprice, get_sellprice, get_barcode);
				int result = cc.productDAO.signProduct(productDTO);
				if (result==1) {
					cc.popup("성공", get_name+"님 을 등록하였습니다.");
				}
				cc.product_sign_frame.setVisible(false);
				cc.product_sign_frame=null;
				cc.product_frame.setVisible(true);
				break;
			case 2://7-1-2
				cc.product_sign_frame.setVisible(false);
				cc.product_sign_frame=null;
				cc.product_frame.setVisible(true);
				break;
			}
			break;
		case 2://목록
			switch(butno) {
			case 1://7-2-1
				if (cc.product_list_frame.current_page>1) {
					cc.product_list_frame.current_page-=1;
					cc.product_list_frame.shows();
				}
				break;
			case 2://7-2-2
				cc.product_list_frame.current_page=Integer.parseInt(cc.product_list_frame.bp1.buts[1].getText());
				cc.product_list_frame.shows();
				break;
			case 3://7-2-3
				cc.product_list_frame.current_page=Integer.parseInt(cc.product_list_frame.bp1.buts[2].getText());
				cc.product_list_frame.shows();
				break;
			case 4://7-2-4
				cc.product_list_frame.current_page=Integer.parseInt(cc.product_list_frame.bp1.buts[3].getText());
				cc.product_list_frame.shows();
				break;
			case 5://7-2-5
				if (cc.product_list_frame.current_page<cc.product_list_frame.endpage) {
					cc.product_list_frame.current_page+=1;
					cc.product_list_frame.shows();
				}
				break;
			case 6://7-2-6
				cc.product_list_frame.current_page=1;
				String[] search= {"name","tel","birth","id","lv","joindate"};
				int index=cc.product_list_frame.sbar.searchcom.getSelectedIndex();
				cc.product_list_frame.search=search[index];
				cc.product_list_frame.searchvalue=cc.product_list_frame.sbar.searchvalue.getText();
				cc.product_list_frame.shows();
				break;
			case 7://7-2-7
				cc.product_list_frame.current_page=1;
				cc.product_list_frame.sbar.searchcom.setSelectedIndex(0);
				cc.product_list_frame.sbar.searchvalue.setText("");
				cc.product_list_frame.search=null;
				cc.product_list_frame.searchvalue=null;
				cc.product_list_frame.shows();
				break;
			case 8://7-2-8
				cc.product_list_frame.setVisible(false);
				cc.product_list_frame=null;
				cc.product_frame.setVisible(true);
				break;
			}
			break;
		case 4://인포
			switch(butno) {
			case 1://7-4-1 수정
				cc.product_info_frame.setVisible(false);
				cc.product_update_frame= new Product_Update_Frame(cc.product_info_frame.productDTO);
				cc.product_info_frame=null;
				break;
			case 2://7-4-2 삭제
				String getpw=cc.diup("삭제", "관리자의 비밀번호를 입력해주세요.");
				int result= cc.sellerDAO.isCollect(cc.user.getId(), getpw);
				if (result==1) {
					int sub_result=cc.productDAO.delete_Product(cc.product_info_frame.productDTO.getPno());
					if (sub_result==1) {
						cc.popup("삭제", cc.user.getId()+"를 삭제하였습니다.");
						cc.product_info_frame.setVisible(false);
						cc.product_info_frame=null;
						cc.product_list_frame.shows();
					}else {
						cc.popup("실패", "문제발생 관리자에게 문의하세요.");
					}
				}else {
					cc.popup(cc.product_info_frame, "실패", "입력된 비밀번호가 틀렸습니다.");
				}
				break;
			case 3://7-4-3 닫기
				cc.product_info_frame.setVisible(false);
				cc.product_info_frame=null;
				break;
			}
			break;
		case 5://수정
			switch(butno) {
			case 1://6-5-1
				if (cc.product_update_frame.jtf_orderprice.getText().equals("")) {
					cc.popup("유효성 검사", "주문가를 입력해 주세요.");
					break;
				}
				if (cc.product_update_frame.jtf_sellprice.equals("")) {
					cc.popup("유효성 검사", "판매가를 입력해 주세요.");
					break;
				}
				if (cc.product_update_frame.jtf_pqty.equals("")) {
					cc.popup("유효성 검사", "수량을 입력해 주세요.");
					break;
				}
				ProductDTO updateDTO=cc.product_update_frame.productDTO;
				updateDTO.setOrderprice(
						Integer.parseInt(cc.product_update_frame.jtf_orderprice.getText())
						);
				updateDTO.setSellprice(
						Integer.parseInt(cc.product_update_frame.jtf_sellprice.getText())
						);
				updateDTO.setPqty(
						Integer.parseInt(cc.product_update_frame.jtf_pqty.getText())
						);
				String getpw=cc.diup("수정", "관리자의 비밀번호를 입력해주세요.");
				if (getpw==null) {
					break;
				}
				if(getpw.equals("")) {
					cc.popup("경고", "값을 입력해주세요.");
					break;
				}
				int result= cc.sellerDAO.isCollect(cc.user.getId(), getpw);
				if (result==1) {
					int sub_result=cc.productDAO.update_product(updateDTO);
					if (sub_result==1) {
						cc.popup("성공", "수정에 성공하였습니다.!");
						cc.product_update_frame.setVisible(false);
						cc.product_update_frame=null;
						cc.product_list_frame.shows();
					}else {
						cc.popup("실패", "문제발생 관리자에게 문의하세요.");
					}
				}else {
					cc.popup(cc.product_update_frame, "실패", "입력된 비밀번호가 틀렸습니다.");
					cc.product_update_frame.setVisible(false);
					cc.product_update_frame=null;
					cc.product_info_frame=new Product_Info_Frame(cc.product_list_frame.clicked_barcode);
				}
				break;
			case 2://7-5-2
				cc.product_update_frame.setVisible(false);
				cc.product_update_frame=null;
				break;
			}
			break;
		}
	}
}
