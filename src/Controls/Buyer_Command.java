package Controls;

import java.sql.SQLException;

import Buyer_GUI.*;
import Seller_GUI.Seller_Info_Frame;
import Seller_GUI.Seller_Update_Frame;
import Server_DATA.BuyerDTO;
import Server_DATA.SellerDTO;

public class Buyer_Command {
	private Command_Center cc;
	
	public void command(int butno) throws SQLException {
		cc=Command_Center.getInstance();;
		switch(butno) {
		case 1://6-0-1
			String tel=cc.diup("중복확인", "전화번호를 입력해 주세요.");
			if (tel==null) {
				break;
			}
			if (cc.buyerDAO.isNew(tel)==true) {
				cc.popup("중복", "이미 등록된 전화번호 입니다.");
				break;
			}
			cc.buyer_sign_frame=new Buyer_Sign_Frame(tel);
			cc.buyer_frame.setVisible(false);
			break;
		case 2://6-0-2
			cc.buyer_list_frame=new Buyer_List_Frame();
			cc.buyer_frame.setVisible(false);
			break;
		case 3://6-0-3
			cc.buyer_frame.setVisible(false);
			cc.buyer_frame=null;
			cc.index_frame.setVisible(true);
			break;
		case 4://6-0-4
			if(cc.buyer_info_frame==null) {
				cc.buyer_info_frame=new Buyer_Info_Frame(cc.buyer_list_frame.clicked_tel);
			}else {
				cc.popup(cc.buyer_info_frame,"경고","이미 정보창이 열려있습니다.");
			}
			break;
		}
	}
	
	public void subcommand(int subframe, int butno) throws SQLException {
		cc=Command_Center.getInstance();
		switch(subframe) {
		case 1://등록
			switch(butno) {
			case 1://6-1-1
				String get_name=cc.buyer_sign_frame.jtf_name.getText();
				String get_tel=cc.buyer_sign_frame.jtf_tel.getText();
				String get_birth=cc.buyer_sign_frame.jtf_birth.getText();
				char[] get_pw1_chars=cc.buyer_sign_frame.jtf_pw1.getPassword();
				char[] get_pw2_chars=cc.buyer_sign_frame.jtf_pw2.getPassword();
				
				String get_pw1="";
				for (int i=0; i<get_pw1_chars.length; i++) {
					get_pw1+=get_pw1_chars[i];
				}
				String get_pw2="";
				for (int i=0; i<get_pw2_chars.length; i++) {
					get_pw2+=get_pw2_chars[i];
				}
				
				int user_lv=cc.user.getLv();
				if (!get_pw1.equals(get_pw2)) {
					cc.popup("비밀번호", "비밀번호가 일치하지 않습니다.");
					break;
				}
				
				BuyerDTO BuyerDTO= new BuyerDTO(get_name,get_tel,get_birth,get_pw1);
				int result = cc.buyerDAO.signBuyer(BuyerDTO);
				if (result==1) {
					cc.popup("성공", get_name+"님 을 등록하였습니다.");
				}
				cc.buyer_sign_frame.setVisible(false);
				cc.buyer_sign_frame=null;
				cc.buyer_frame.setVisible(true);
				break;
			case 2://6-1-2
				cc.buyer_sign_frame.setVisible(false);
				cc.buyer_sign_frame=null;
				cc.buyer_frame.setVisible(true);
				break;
			}
			break;
		case 2://목록
			switch(butno) {
			case 1://6-2-1
				if (cc.buyer_list_frame.current_page>1) {
					cc.buyer_list_frame.current_page-=1;
					cc.buyer_list_frame.shows();
				}
				break;
			case 2://6-2-2
				cc.buyer_list_frame.current_page=Integer.parseInt(cc.buyer_list_frame.bp1.buts[1].getText());
				cc.buyer_list_frame.shows();
				break;
			case 3://6-2-3
				cc.buyer_list_frame.current_page=Integer.parseInt(cc.buyer_list_frame.bp1.buts[2].getText());
				cc.buyer_list_frame.shows();
				break;
			case 4://6-2-4
				cc.buyer_list_frame.current_page=Integer.parseInt(cc.buyer_list_frame.bp1.buts[3].getText());
				cc.buyer_list_frame.shows();
				break;
			case 5://6-2-5
				if (cc.buyer_list_frame.current_page<cc.buyer_list_frame.endpage) {
					cc.buyer_list_frame.current_page+=1;
					cc.buyer_list_frame.shows();
				}
				break;
			case 6://6-2-6
				if(cc.buyer_list_frame.sbar.searchvalue.getText().equals("")) {
					cc.popup("유효성", "검색값을 입력해 주세요.");
					break;
				}
				String[] search= {"name","tel","birth","lv","joindate"};
				int index=cc.buyer_list_frame.sbar.searchcom.getSelectedIndex();
				cc.buyer_list_frame.search=search[index];
				cc.buyer_list_frame.current_page=1;
				cc.buyer_list_frame.searchvalue=cc.buyer_list_frame.sbar.searchvalue.getText();
				cc.buyer_list_frame.shows();
				break;
			case 7://6-2-7
				cc.buyer_list_frame.current_page=1;
				cc.buyer_list_frame.sbar.searchcom.setSelectedIndex(0);
				cc.buyer_list_frame.sbar.searchvalue.setText("");
				cc.buyer_list_frame.search=null;
				cc.buyer_list_frame.searchvalue=null;
				cc.buyer_list_frame.shows();
				break;
			case 8://6-2-8
				cc.buyer_list_frame.setVisible(false);
				cc.buyer_list_frame=null;
				cc.buyer_frame.setVisible(true);
				break;
			}
			break;
		case 4://인포
			switch(butno) {
			case 1://6-4-1
				cc.buyer_info_frame.setVisible(false);
				cc.buyer_update_frame= new Buyer_Update_Frame(cc.buyer_info_frame.buyerDTO);
				cc.buyer_info_frame=null;
				break;
			case 2://6-4-2
				String getpw=cc.diup("삭제", "관리자의 비밀번호를 입력해주세요.");
				int result= cc.sellerDAO.isCollect(cc.user.getId(), getpw);
				if (result==1) {
					int sub_result=cc.buyerDAO.delete_Buyer(cc.buyer_info_frame.buyerDTO.getBno());
					if (sub_result==1) {
						cc.popup("삭제", cc.user.getId()+"를 삭제하였습니다.");
						cc.buyer_info_frame.setVisible(false);
						cc.buyer_info_frame=null;
						cc.buyer_list_frame.shows();
					}else {
						cc.popup("실패", "문제발생 관리자에게 문의하세요.");
					}
				}else {
					cc.popup(cc.buyer_info_frame, "실패", "입력된 비밀번호가 틀렸습니다.");
				}
				break;
			case 3://6-4-3
				cc.buyer_info_frame.setVisible(false);
				cc.buyer_info_frame=null;
				break;
			}
			break;
		case 5://수정
			switch(butno) {
			case 1://6-5-1
				if (cc.buyer_update_frame.jtf_tel.getText().equals("")) {
					cc.popup("유효성 검사", "전화번호를 입력해 주세요.");
					break;
				}
				if (cc.buyer_update_frame.jtf_lv.getText().equals("")) {
					cc.popup("유효성 검사", "Lv를 입력해 주세요.");
					break;
				}
				BuyerDTO updateDTO=cc.buyer_update_frame.buyerDTO;
				updateDTO.setTel(cc.buyer_update_frame.jtf_tel.getText());
				updateDTO.setLv(
						Integer.parseInt(cc.buyer_update_frame.jtf_lv.getText()));
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
					int sub_result=cc.buyerDAO.update_Buyer(updateDTO);
					if (sub_result==1) {
						cc.popup("성공", "수정에 성공하였습니다.!");
						cc.buyer_update_frame.setVisible(false);
						cc.buyer_update_frame=null;
						cc.buyer_list_frame.shows();
					}else {
						cc.popup("실패", "문제발생 관리자에게 문의하세요.");
					}
				}else {
					cc.popup(cc.buyer_update_frame, "실패", "입력된 비밀번호가 틀렸습니다.");
					cc.buyer_update_frame.setVisible(false);
					cc.buyer_update_frame=null;
					cc.buyer_info_frame=new Buyer_Info_Frame(cc.buyer_list_frame.clicked_tel);
				}
				break;
			case 2://6-5-2
				cc.buyer_update_frame.setVisible(false);
				cc.buyer_update_frame=null;
				break;
			}
			break;
		}
		
	}
}
