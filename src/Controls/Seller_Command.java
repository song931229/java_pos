package Controls;

import java.sql.SQLException;

import Seller_GUI.*;
import Server_DATA.SellerDTO;

public class Seller_Command {
	private Command_Center cc;
	
	public void command(int butno) throws SQLException {
		cc=Command_Center.getInstance();
		switch(butno) {
		case 1:
			String tel=cc.diup("중복확인", "전화번호를 입력해 주세요.");
			if (tel==null) {
				break;
			}
			if (cc.sellerDAO.isNew(tel)==true) {
				cc.popup("중복", "이미 등록된 전화번호 입니다.");
				break;
			}
			cc.seller_sign_frame=new Seller_Sign_Frame(tel);
			cc.seller_frame.setVisible(false);
			break;
		case 2:
			cc.seller_list_frame=new Seller_List_Frame();
			cc.seller_frame.setVisible(false);
			break;
		case 3:
			cc.seller_frame.setVisible(false);
			cc.seller_frame=null;
			cc.index_frame.setVisible(true);
			break;
		case 4:
			if(cc.seller_info_frame==null) {
				cc.seller_info_frame=new Seller_Info_Frame(cc.seller_list_frame.clicked_id);
			}else {
				cc.popup(cc.seller_info_frame,"경고","이미 정보창이 열려있습니다.");
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
				String get_name=cc.seller_sign_frame.jtf_name.getText();
				String get_tel=cc.seller_sign_frame.jtf_tel.getText();
				String get_birth=cc.seller_sign_frame.jtf_birth.getText();
				String get_id=cc.seller_sign_frame.jtf_id.getText();
				char[] get_pw1_chars=cc.seller_sign_frame.jtf_pw1.getPassword();
				char[] get_pw2_chars=cc.seller_sign_frame.jtf_pw2.getPassword();
				int get_lv=Integer.parseInt(cc.seller_sign_frame.jtf_lv.getText());
				
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
				if (8<=get_lv) {
					cc.popup("경고", "최고 권한은 6레벨입니다.");
					break;
				}else if (user_lv<=get_lv) {
					cc.popup("경고", "권한("+cc.user.getLv()+")이상의 레벨을 부열할수 없습니다.");
					break;
				}
				SellerDTO sellerDTO= new SellerDTO(get_name,get_tel,get_birth,get_id,get_pw1,get_lv);
				int result = cc.sellerDAO.signSeller(sellerDTO);
				if (result==1) {
					cc.popup("성공", get_name+"님 을 등록하였습니다.");
				}
				cc.seller_sign_frame.setVisible(false);
				cc.seller_sign_frame=null;
				cc.seller_frame.setVisible(true);
				break;
			case 2:
				cc.seller_sign_frame.setVisible(false);
				cc.seller_sign_frame=null;
				cc.seller_frame.setVisible(true);
				break;
			}
			break;
		case 2:
			switch(butno) {
			case 1:
				if (cc.seller_list_frame.current_page>1) {
					cc.seller_list_frame.current_page-=1;
					cc.seller_list_frame.shows();
				}
				break;
			case 2:
				cc.seller_list_frame.current_page=Integer.parseInt(cc.seller_list_frame.bp1.buts[1].getText());
				cc.seller_list_frame.shows();
				break;
			case 3:
				cc.seller_list_frame.current_page=Integer.parseInt(cc.seller_list_frame.bp1.buts[2].getText());
				cc.seller_list_frame.shows();
				break;
			case 4:
				cc.seller_list_frame.current_page=Integer.parseInt(cc.seller_list_frame.bp1.buts[3].getText());
				cc.seller_list_frame.shows();
				break;
			case 5:
				if (cc.seller_list_frame.current_page<cc.seller_list_frame.endpage) {
					cc.seller_list_frame.current_page+=1;
					cc.seller_list_frame.shows();
				}
				break;
			case 6:
				if(cc.seller_list_frame.sbar.searchvalue.getText().equals("")) {
					cc.popup("유효성", "검색값을 입력해 주세요.");
					break;
				}
				String[] search= {"name","tel","birth","id","lv","joindate"};
				int index=cc.seller_list_frame.sbar.searchcom.getSelectedIndex();
				cc.seller_list_frame.search=search[index];
				cc.seller_list_frame.current_page=1;
				cc.seller_list_frame.searchvalue=cc.seller_list_frame.sbar.searchvalue.getText();
				System.out.println("624발동");
				cc.seller_list_frame.shows();
				break;
			case 7:
				cc.seller_list_frame.current_page=1;
				cc.seller_list_frame.sbar.searchcom.setSelectedIndex(0);
				cc.seller_list_frame.sbar.searchvalue.setText("");
				cc.seller_list_frame.search=null;
				cc.seller_list_frame.searchvalue=null;
				cc.seller_list_frame.shows();
				break;
			case 8:
				cc.seller_list_frame.setVisible(false);
				cc.seller_list_frame=null;
				cc.seller_frame.setVisible(true);
				break;
			}
			break;
		case 4:
			switch(butno) {
			case 1:
				cc.seller_info_frame.setVisible(false);
				cc.seller_update_frame= new Seller_Update_Frame(cc.seller_info_frame.sellerDTO);
				cc.seller_info_frame=null;
				break;
			case 2:
				String getpw=cc.diup("삭제", "관리자의 비밀번호를 입력해주세요.");
				int result= cc.sellerDAO.isCollect(cc.user.getId(), getpw);
				if (result==1) {
					int sub_result=cc.sellerDAO.delete_Seller(cc.seller_info_frame.sellerDTO.getId());
					if (sub_result==1) {
						cc.popup("삭제", cc.user.getId()+"를 삭제하였습니다.");
						cc.seller_info_frame.setVisible(false);
						cc.seller_info_frame=null;
						cc.seller_list_frame.shows();
					}else {
						cc.popup("실패", "문제발생 관리자에게 문의하세요.");
					}
				}else {
					cc.popup(cc.seller_info_frame, "실패", "입력된 비밀번호가 틀렸습니다.");
				}
				break;
			case 3:
				cc.seller_info_frame.setVisible(false);
				cc.seller_info_frame=null;
				break;
			}
			break;
		case 5:
			switch(butno){
			case 1:
				if (cc.seller_update_frame.jtf_tel.getText().equals("")) {
					cc.popup("유효성 검사", "전화번호를 입력해 주세요.");
					break;
				}
				if (cc.seller_update_frame.jtf_ncash.getText().equals("")) {
					cc.popup("유효성 검사", "N_Cash를 입력해 주세요.");
					break;
				}
				if (cc.seller_update_frame.jtf_lv.getText().equals("")) {
					cc.popup("유효성 검사", "Lv를 입력해 주세요.");
					break;
				}
				SellerDTO updateDTO=cc.seller_update_frame.sellerDTO;
				updateDTO.setTel(cc.seller_update_frame.jtf_tel.getText());
				updateDTO.setN_cash(
						Integer.parseInt(cc.seller_update_frame.jtf_ncash.getText()));
				updateDTO.setLv(
						Integer.parseInt(cc.seller_update_frame.jtf_lv.getText()));
				if(updateDTO.getLv()>=cc.user.getLv()) {
					cc.popup("경고", "현재 권한(Lv)보다 높거나 같은 권한(Lv)을 부여 할 수 없습니다.");
				}
				String getpw=cc.diup("수정", "관리자의 비밀번호를 입력해주세요.");
				if (getpw==null) {
					break;
				}
				if(getpw.equals("")) {
					cc.popup("경고", "값을 입력해주세요.");
				}
				int result= cc.sellerDAO.isCollect(cc.user.getId(), getpw);
				if (result==1) {
					int sub_result=cc.sellerDAO.update_Seller(updateDTO);
					if (sub_result==1) {
						cc.popup("성공", "수정에 성공하였습니다.!");
						cc.seller_update_frame.setVisible(false);
						cc.seller_update_frame=null;
						cc.seller_list_frame.shows();
					}else {
						cc.popup("실패", "문제발생 관리자에게 문의하세요.");
					}
				}else {
					cc.popup(cc.seller_update_frame, "실패", "입력된 비밀번호가 틀렸습니다.");
					cc.seller_update_frame.setVisible(false);
					cc.seller_update_frame=null;
					cc.seller_info_frame=new Seller_Info_Frame(cc.seller_list_frame.clicked_id);
				}
				break;
			case 2:
				cc.seller_update_frame.setVisible(false);
				cc.seller_update_frame=null;
			}
			break;
		}
	}
}
