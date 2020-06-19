package Buyer_GUI;

import javax.swing.JPanel;

import Index_GUI.Base_Frame;
import Pannel.*;

public class Buyer_Frame extends Base_Frame {
	private Buts_Panel bp;
	public Buyer_Frame() {
		super("고객 관리", 200, 500);
		// TODO Auto-generated constructor stub

		String[] contents= {"고객 등록","고객 목록","고객 찾기","종료"};
		bp=new Buts_Panel(4,1,contents,true);
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
