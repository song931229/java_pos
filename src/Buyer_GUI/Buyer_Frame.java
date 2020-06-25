package Buyer_GUI;

import javax.swing.JPanel;

import Controls.Command_Center;
import Index_GUI.Base_Frame;
import Pannel.*;

public class Buyer_Frame extends Base_Frame {
	// 프레임번호 6-0
	private Command_Center cc=Command_Center.getInstance();
	private Buts_Panel bp;
	private String[] contents= {"고객 등록","고객 목록","종료"};
	
	public Buyer_Frame() {
		super("고객 관리", 200, 300);
		// TODO Auto-generated constructor stub

		bp=new Buts_Panel(false,3,6,0,contents,false);
		this.setMainPanel(bp);
		this.ButtonOn();
		
	}
	
	public void ButtonOn() {
		for (int i=0; i<bp.buts.length; i++) {
			bp.buts[i].setEnabled(true);
		}
	}

}
