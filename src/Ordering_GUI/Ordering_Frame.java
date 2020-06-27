package Ordering_GUI;

import Controls.Command_Center;
import Index_GUI.Base_Frame;
import Pannel.Buts_Panel;

public class Ordering_Frame extends Base_Frame {
	// 프레임번호 4-0
	private Command_Center cc=Command_Center.getInstance();
	private Buts_Panel bp;
	private String[] contents= {"주문 하기","주문 기록","종료"};
	
	public Ordering_Frame() {
		super("주문 관리", 200, 300);
		// TODO Auto-generated constructor stub
		
		bp=new Buts_Panel(false,3,4,0,contents,false);
		this.setMainPanel(bp);
		this.ButtonOn();
	}
	
	public void ButtonOn() {
		for (int i=0; i<bp.buts.length; i++) {
			bp.buts[i].setEnabled(true);
		}
	}
	
}
