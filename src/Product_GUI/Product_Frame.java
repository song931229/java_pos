package Product_GUI;

import javax.swing.JPanel;

import Controls.Command_Center;
import Index_GUI.Base_Frame;
import Pannel.*;

public class Product_Frame extends Base_Frame {
	private Command_Center cc=Command_Center.getInstance();
	private Buts_Panel bp;
	private String[] contents= {"상품 등록","상품 목록","종료"};
	
	public Product_Frame() {
		super("상품 관리", 200, 300);
		// TODO Auto-generated constructor stub

		bp=new Buts_Panel(false,3,7,0,contents,true);
		
		this.setMainPanel(bp);
		this.ButtonOn();
		this.setVisible(true);
	}
	
	public void ButtonOn() {
		if(cc.getUser().getLv()>2) {
			bp.buts[0].setEnabled(true);
		}
		if(cc.getUser().getLv()>3) {
			bp.buts[1].setEnabled(true);
		}
		bp.buts[2].setEnabled(true);
	}

}
