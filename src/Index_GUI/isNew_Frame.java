package Index_GUI;

import javax.swing.JLabel;

import Pannel.Buts_Panel;
import Pannel.NumberField;

public class isNew_Frame extends Base_Frame {
	
	JLabel lb_info = new JLabel("전화번호를 입력해 주세요.");
	NumberField nf_tel = new NumberField();
	String[] con = {"확인","취소"};
	Buts_Panel buts= new Buts_Panel(2, 0, 7, con, true);

	public isNew_Frame() {
		super("중복확인", 200, 100);
		// TODO Auto-generated constructor stub
	}

}
