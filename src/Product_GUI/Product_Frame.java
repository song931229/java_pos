package Product_GUI;

import javax.swing.JPanel;

import Index_GUI.Base_Frame;
import Pannel.*;

public class Product_Frame extends Base_Frame {
	private Buts_Panel bp;
	private String[] contents= {"상품 등록","상품 목록","상품 찾기","종료"};
	
	public Product_Frame() {
		super("상품 관리", 200, 500);
		// TODO Auto-generated constructor stub

		bp=new Buts_Panel(false,4,7,0,contents,true);
		
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
