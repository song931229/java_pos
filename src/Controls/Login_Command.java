package Controls;

import java.sql.SQLException;

import Server_DATA.SellerDAO;

public class Login_Command {
	Command_Center cc;
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
					cc.find_id_frame.setVisible(false);
					cc.find_id_frame=null;
					cc.login_frame.setVisible(true);
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
		}
	}
}
