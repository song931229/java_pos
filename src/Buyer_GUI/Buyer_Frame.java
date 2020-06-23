package Buyer_GUI;

import javax.swing.JPanel;

import Index_GUI.Base_Frame;
import Pannel.*;

public class Buyer_Frame extends Base_Frame {
	private Buts_Panel bp;
	public Buyer_Frame() {
		super("고객 관리", 200, 300);
		// TODO Auto-generated constructor stub

		String[] contents= {"고객 등록","고객 목록","종료"};
		bp=new Buts_Panel(false,3,6,0,contents,true);
		this.setMainPanel(bp);
		this.ButtonOn();
		this.setVisible(true);
	}
	
	public void ButtonOn() {
		for (int i=0; i<bp.buts.length; i++) {
			bp.buts[i].setEnabled(true);
		}
	}

}
