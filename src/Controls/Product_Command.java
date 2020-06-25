package Controls;

import java.sql.SQLException;

import Product_GUI.*;
import Server_DATA.ProductDTO;

public class Product_Command {
	private Command_Center cc;
	public void command(int butno) throws SQLException {
		cc=Command_Center.getInstance();
		switch(butno) {
		case 1:
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
		case 2:
			cc.product_list_frame=new Product_List_Frame();
			cc.product_frame.setVisible(false);
			break;
		case 3:
			cc.product_frame.setVisible(false);
			cc.product_frame=null;
			cc.index_frame.setVisible(true);
			break;
		case 4:
			break;
		}
	}
	
	public void subcommand(int subframe, int butno) throws SQLException {
		cc=Command_Center.getInstance();
		switch(subframe) {
		case 1:
			switch(butno) {
			case 1:
				String get_name=cc.product_sign_frame.jtf_name.getText();
				String get_tel=cc.product_sign_frame.jtf_tel.getText();
				String get_birth=cc.product_sign_frame.jtf_birth.getText();
				String get_id=cc.product_sign_frame.jtf_id.getText();
				char[] get_pw1_chars=cc.product_sign_frame.jtf_pw1.getPassword();
				char[] get_pw2_chars=cc.product_sign_frame.jtf_pw2.getPassword();
				int get_lv=Integer.parseInt(cc.product_sign_frame.jtf_lv.getText());
				
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
				ProductDTO productDTO= new ProductDTO(get_name,get_tel,get_birth,get_id,get_pw1,get_lv);
				int result = cc.productDAO.signproduct(productDTO);
				if (result==1) {
					cc.popup("성공", get_name+"님 을 등록하였습니다.");
				}
				cc.product_sign_frame.setVisible(false);
				cc.product_sign_frame=null;
				cc.product_frame.setVisible(true);
				break;
			case 2:
				cc.product_sign_frame.setVisible(false);
				cc.product_sign_frame=null;
				cc.product_frame.setVisible(true);
				break;
			}
			break;
		case 2:
			switch(butno) {
			case 1:
				if (cc.product_list_frame.current_page>1) {
					cc.product_list_frame.current_page-=1;
					cc.product_list_frame.shows();
				}
				break;
			case 2:
				cc.product_list_frame.current_page=Integer.parseInt(cc.product_list_frame.bp1.buts[1].getText());
				cc.product_list_frame.shows();
				break;
			case 3:
				cc.product_list_frame.current_page=Integer.parseInt(cc.product_list_frame.bp1.buts[2].getText());
				cc.product_list_frame.shows();
				break;
			case 4:
				cc.product_list_frame.current_page=Integer.parseInt(cc.product_list_frame.bp1.buts[3].getText());
				cc.product_list_frame.shows();
				break;
			case 5:
				if (cc.product_list_frame.current_page<cc.product_list_frame.endpage) {
					cc.product_list_frame.current_page+=1;
					cc.product_list_frame.shows();
				}
				break;
			case 6:
				cc.product_list_frame.current_page=1;
				String[] search= {"name","tel","birth","id","lv","joindate"};
				int index=cc.product_list_frame.sbar.searchcom.getSelectedIndex();
				cc.product_list_frame.search=search[index];
				cc.product_list_frame.searchvalue=cc.product_list_frame.sbar.searchvalue.getText();
				cc.product_list_frame.shows();
				break;
			case 7:
				cc.product_list_frame.current_page=1;
				cc.product_list_frame.sbar.searchcom.setSelectedIndex(0);
				cc.product_list_frame.sbar.searchvalue.setText("");
				cc.product_list_frame.search=null;
				cc.product_list_frame.searchvalue=null;
				cc.product_list_frame.shows();
				break;
			case 8:
				cc.product_list_frame.setVisible(false);
				cc.product_list_frame=null;
				cc.product_frame.setVisible(true);
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
				cc.product_info_frame.setVisible(false);
				cc.product_info_frame=null;
				break;
			}
		}
	}
}
