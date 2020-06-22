package Seller_GUI;

import javax.swing.JPanel;

import Index_GUI.Base_Frame;
import Pannel.*;

public class Seller_Frame extends Base_Frame {
	private Buts_Panel bp;
	private String[] contents= {"직원 등록","직원 목록","종료"};
	
	public Seller_Frame() {
		super("직원 관리", 200, 300);
		// TODO Auto-generated constructor stub

		bp=new Buts_Panel(3,1,5,contents,true);
		this.setMainPanel(bp);
		this.ButtonOn();
	}
	
	public void ButtonOn() {
		for (int i=0; i<bp.buts.length; i++) {
			bp.buts[i][0].setEnabled(true);
		}
	}

}
