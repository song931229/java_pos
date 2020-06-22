package Controls;

import java.sql.SQLException;

import Index_GUI.*;
import Login_GUI.*;
import Server_DATA.SellerDAO;

public class Login_Command {
	private Command_Center cc;
	
	public void command(int butno) throws SQLException {
		cc=Command_Center.getInstance();
		switch(butno) {
		case 0:
			String typed_id=cc.login_frame.jtf_id.getText();
			char[] typed_pw_char=cc.login_frame.jtf_pw.getPassword();
			String typed_pw="";
			for (int i =0; i<typed_pw_char.length; i++) {
				typed_pw+=typed_pw_char[i];
			}
			if (typed_id.equals("")) {
				cc.popup("유효성 검사", "아이디를 입력해 주세요.");
				break;
			}
			if (typed_pw.equals("")) {
				cc.popup("유효성 검사", "비밀번호를 입력해 주세요.");
				break;
			}
			cc.login_frame.jtf_pw.setText("");
			int returnd=cc.sellerDAO.isCollect(typed_id, typed_pw);
			if (returnd==1) {
				cc.popup("성공", "로그인 성공");
				cc.user = cc.sellerDAO.getSeller(typed_id);
				cc.login_frame.setVisible(false);
				cc.login_frame=null;
				cc.index_frame=new Index_Frame(cc.user);
			}else if(returnd==0) {
				cc.popup("실패", "비밀번호 확인");
			}else if(returnd==-1) {
				cc.popup("실패", "로그인ID 확인");
			}
			break;
		case 1:
			cc.login_frame.setVisible(false);
			cc.find_id_frame = new Find_Id_Frame();
			break;
		case 2:
			cc.login_frame.setVisible(false);
			cc.find_pw_frame = new Find_Pw_Frame();
			break;
		case 3:
			cc.login_frame.setVisible(false);
			cc.login_frame=null;
			cc.index_frame.setVisible(true);
			break;
		}
	}
	
	public void subcommand(int subframe,int butno) throws SQLException {
		cc=Command_Center.getInstance();
		// TODO Auto-generated method stub
		switch(subframe) {
		case 1:
			switch(butno) {
			case 1:
				System.out.println("ID찾기");
				String typed_name =cc.find_id_frame.jtf_name.getText();
				String typed_tel =cc.find_id_frame.jtf_tel.getText();
				String typed_birth =cc.find_id_frame.jtf_birth.getText();
				cc.find_id_frame.jtf_name.setText("");
				cc.find_id_frame.jtf_tel.setText("");
				cc.find_id_frame.jtf_birth.setText("");
				if (typed_name.equals("")) {
					cc.popup("유효성 검사", "이름를 입력해 주세요.");
					break;
				}
				if (typed_tel.equals("")) {
					cc.popup("유효성 검사", "전화번호를 입력해 주세요.");
					break;
				}
				if (typed_birth.equals("")) {
					cc.popup("유효성 검사", "생년월일을 입력해 주세요.");
					break;
				}
				String returnd=cc.sellerDAO.Find_Id(typed_name, typed_tel, typed_birth);
				if (returnd==null) {
					cc.popup("실패", "정보와 일치하는 값을 찾을 수 없습니다.");
				}else {
					cc.popup("성공", "찾으시는 아이디는 \n"+returnd+"\n 입니다.");
					cc.find_id_frame.setVisible(false);
					cc.find_id_frame=null;
					cc.login_frame.setVisible(true);
				}
				break;
			case 2:
				System.out.println("취소");
				cc.find_id_frame.setVisible(false);
				cc.login_frame.setVisible(true);
				cc.find_id_frame=null;
				break;
			}
			break;
		case 2:
			switch(butno) {
			case 1:
				System.out.println("PW찾기");
				String typed_name =cc.find_pw_frame.jtf_name.getText();
				String typed_tel =cc.find_pw_frame.jtf_tel.getText();
				String typed_birth =cc.find_pw_frame.jtf_birth.getText();
				String typed_id =cc.find_pw_frame.jtf_id.getText();
				cc.find_pw_frame.jtf_name.setText("");
				cc.find_pw_frame.jtf_tel.setText("");
				cc.find_pw_frame.jtf_birth.setText("");
				cc.find_pw_frame.jtf_id.setText("");
				if (typed_name.equals("")) {
					cc.popup("유효성 검사", "이름를 입력해 주세요.");
					break;
				}
				if (typed_tel.equals("")) {
					cc.popup("유효성 검사", "전화번호를 입력해 주세요.");
					break;
				}
				if (typed_birth.equals("")) {
					cc.popup("유효성 검사", "생년월일을 입력해 주세요.");
					break;
				}
				if (typed_id.equals("")) {
					cc.popup("유효성 검사", "아이디를 입력해 주세요.");
					break;
				}
				boolean returnd=cc.sellerDAO.Find_Pw(typed_name, typed_tel, typed_birth, typed_id);
				if (returnd==false) {
					cc.popup("실패", "정보와 일치하는 값을 찾을 수 없습니다.");
				}else {
					//cc.비밀번호재설정.
					cc.find_pw_frame.setVisible(false);
					cc.find_pw_frame=null;
					cc.change_pw_frame=new Change_Pw_Frame(typed_id);
				}
				break;
			case 2:
				System.out.println("취소");
				cc.find_pw_frame.setVisible(false);
				cc.find_pw_frame=null;
				cc.login_frame.setVisible(true);
				break;
			}
			break;
		case 3:
			switch(butno) {
			case 1:
				char[] change_pw1_chars=cc.change_pw_frame.jtf_pw1.getPassword();
				char[] change_pw2_chars=cc.change_pw_frame.jtf_pw2.getPassword();
				String change_pw1="";
				String change_pw2="";
				for (int i=0; i<change_pw1_chars.length; i++) {
					change_pw1+=change_pw1_chars[i];
				}
				for (int i=0; i<change_pw2_chars.length; i++) {
					change_pw2+=change_pw1_chars[i];
				}
				if (change_pw1.equals("")) {
					cc.popup("유효성 검사", "변경할 비밀 번호를 입력해 주세요.");
					break;
				}else if(change_pw2.equals("")){
					cc.popup("유효성 검사", "비밀 번호 확인을 입력해 주세요.");
					break;
				}else if(!change_pw1.equals(change_pw2)) {
					cc.popup("유효성 검사", "비밀번호가 일치하지 않습니다.");
					break;
				}
				int result=cc.sellerDAO.changePW(change_pw1, cc.change_pw_frame.getTarget_Id());
				if (result==1) {
					cc.popup("성공", "비밀번호가 성공적으로 변경 되었습니다.");
					cc.change_pw_frame.setVisible(false);
					cc.change_pw_frame=null;
					cc.login_frame.setVisible(true);
				}
				break;
			case 2:
				cc.change_pw_frame.setVisible(false);
				cc.change_pw_frame=null;
				cc.login_frame.setVisible(true);
			}
			break;
		}
	}
}
