package Seller_GUI;

import javax.swing.JPanel;

import Controls.Command_Center;
import Index_GUI.Base_Frame;
import Pannel.*;

public class Seller_Frame extends Base_Frame {
	private Command_Center cc=Command_Center.getInstance();
	private Buts_Panel bp;
	private String[] contents= {"직원 등록","직원 목록","종료"};
	
	public Seller_Frame() {
		super("직원 관리", 200, 300);
		// TODO Auto-generated constructor stub

		bp=new Buts_Panel(3,1,5,contents,false);
		this.setMainPanel(bp);
		this.ButtonOn();
		
	}
	
	public void ButtonOn() {
		if(cc.getUser().getLv()>2) {
			bp.buts[0][0].setEnabled(true);
		}
		if(cc.getUser().getLv()>3) {
			bp.buts[1][0].setEnabled(true);
		}
		bp.buts[2][0].setEnabled(true);
	}

}
