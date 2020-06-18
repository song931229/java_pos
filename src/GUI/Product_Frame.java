package GUI;

import javax.swing.JPanel;
import Pannel.*;

public class Product_Frame extends Base_Frame {
	private Buts_Panel bp;
	public Product_Frame() {
		super("상품 관리", 200, 500);
		// TODO Auto-generated constructor stub

		String[] contents= {"상품 등록","상품 목록","상품 찾기","종료"};
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
