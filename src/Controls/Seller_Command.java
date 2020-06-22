package Controls;

import java.sql.SQLException;

import Seller_GUI.*;

public class Seller_Command {
	private Command_Center cc;
	
	public void command(int butno) throws SQLException {
		cc=Command_Center.getInstance();
		switch(butno) {
		case 1:
			cc.seller_sign_frame=new Seller_Sign_Frame();
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
		}
	}
	
	public void subcommand(int subframe, int butno) throws SQLException {
		cc=Command_Center.getInstance();
		System.out.println(subframe);
		System.out.println(butno);
		switch(subframe) {
		case 1:
			switch(butno) {
			case 1:
				String get_name=cc.seller_sign_frame.jtf_name.getText();
				String get_tel=cc.seller_sign_frame.jtf_tel.getText();
				String get_birth=cc.seller_sign_frame.jtf_birth.getText();
				String get_id=cc.seller_sign_frame.jtf_id.getText();
				char[] get_pw1_chars=cc.seller_sign_frame.jtf_pw1.getPassword();
				char[] get_pw2_chars=cc.seller_sign_frame.jtf_pw1.getPassword();
				String get_pw1="";
				for (int i=0; i<get_pw1_chars.length; i++) {
					get_pw1+=get_pw1_chars[i];
				}
				String get_pw2="";
				for (int i=0; i<get_pw2_chars.length; i++) {
					get_pw2+=get_pw2_chars[i];
				}
				int get_lv=Integer.parseInt(cc.seller_sign_frame.jtf_lv.getText());
				if (!get_pw1.equals(get_pw2)) {
					cc.popup("비밀번호!", "비밀번호가 일치하지 않습니다.");
				}
				
				break;
			case 2:
				break;
			}
			break;
		case 2:
			break;
		}
	}
}
