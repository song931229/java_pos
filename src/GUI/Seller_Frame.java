package GUI;

import javax.swing.JPanel;
import Pannel.*;

public class Seller_Frame extends Base_Frame {
	private Buts_Panel bp;
	public Seller_Frame() {
		super("직원 관리", 200, 500);
		// TODO Auto-generated constructor stub

		String[] contents= {"직원 등록","직원 목록","직원 찾기","종료"};
		bp=new Buts_Panel(4,1,contents);
		
		this.setMainPanel(bp);
		this.ButtonOn();
		this.setVisible(true);
	}
	
	public void ButtonOn() {
		for (int i=0; i<bp.buts.length; i++) {
			bp.buts[i][0].setEnabled(true);
		}
	}

}
