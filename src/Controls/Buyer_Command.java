package Controls;

import java.sql.SQLException;

import Buyer_GUI.*;
import Seller_GUI.Seller_Info_Frame;
import Server_DATA.BuyerDTO;

public class Buyer_Command {
	private Command_Center cc;
	
	public void command(int butno) throws SQLException {
		cc=Command_Center.getInstance();
		switch(butno) {
		case 1:
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
		case 2:
			cc.buyer_list_frame=new Buyer_List_Frame();
			cc.buyer_frame.setVisible(false);
			break;
		case 3:
			cc.buyer_frame.setVisible(false);
			cc.buyer_frame=null;
			cc.index_frame.setVisible(true);
			break;
		case 4:
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
		case 1:
			switch(butno) {
			case 1:
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
			case 2:
				cc.buyer_sign_frame.setVisible(false);
				cc.buyer_sign_frame=null;
				cc.buyer_frame.setVisible(true);
				break;
			}
			break;
		case 2:
			switch(butno) {
			case 1:
				if (cc.buyer_list_frame.current_page>1) {
					cc.buyer_list_frame.current_page-=1;
					cc.buyer_list_frame.shows();
				}
				break;
			case 2:
				cc.buyer_list_frame.current_page=Integer.parseInt(cc.buyer_list_frame.bp1.buts[1].getText());
				cc.buyer_list_frame.shows();
				break;
			case 3:
				cc.buyer_list_frame.current_page=Integer.parseInt(cc.buyer_list_frame.bp1.buts[2].getText());
				cc.buyer_list_frame.shows();
				break;
			case 4:
				cc.buyer_list_frame.current_page=Integer.parseInt(cc.buyer_list_frame.bp1.buts[3].getText());
				cc.buyer_list_frame.shows();
				break;
			case 5:
				if (cc.buyer_list_frame.current_page<cc.buyer_list_frame.endpage) {
					cc.buyer_list_frame.current_page+=1;
					cc.buyer_list_frame.shows();
				}
				break;
			case 6:
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
			case 7:
				cc.buyer_list_frame.current_page=1;
				cc.buyer_list_frame.sbar.searchcom.setSelectedIndex(0);
				cc.buyer_list_frame.sbar.searchvalue.setText("");
				cc.buyer_list_frame.search=null;
				cc.buyer_list_frame.searchvalue=null;
				cc.buyer_list_frame.shows();
				break;
			case 8:
				cc.buyer_list_frame.setVisible(false);
				cc.buyer_list_frame=null;
				cc.buyer_frame.setVisible(true);
				break;
			}
			break;
		case 4:
			switch(butno) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				cc.buyer_info_frame.setVisible(false);
				cc.buyer_info_frame=null;
				break;
			}
		}
	}
}
