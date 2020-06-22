package Index_GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controls.Command_Center;
import Pannel.Buts_Panel;
import Server_DATA.SellerDTO;

public class Index_Frame extends Base_Frame {
	private Command_Center cc=Command_Center.getInstance();
	//싱글톤 객체에 ㄱㄱ
	private String[] cons= {"로그인","로그아웃","상품판매","상품주문","직원관리","고객관리","상품관리","종료"};
	private Buts_Panel bp;
	
	public Index_Frame() {
		super("index", 250, 600);
		// TODO Auto-generated constructor stub
		
		bp=new Buts_Panel(8,1,0,cons,false);
		
		this.setMainPanel(bp);
		this.ButtonOn();
	}
	
	public Index_Frame(SellerDTO user) {
		super("index", 250, 600);
		// TODO Auto-generated constructor stub
		bp=new Buts_Panel(8,1,0,cons,false);
		this.setMainPanel(bp);
		this.ButtonOn();
	}
	
	
	// 상황에 맞는 버튼 활성화
	// 0 로그인	0
	// 1 로그아웃	1
	// 2 직원관리	3
	// 3 고객관리	1
	// 4 상품판매	1
	// 5 상품주문	4
	// 6 상품관리	1
	// 7 종료		0
	
	// 1레벨 이상 고객 등록 수정 삭제 가능
	// 3레벨 이상 직원 등록 가능
	// 4레벨 이상 물품 주문 가능
	// 5레벨 이상 모든 기능 사용 가능 (물품 정보 수정, 판매자 삭제)
	public void ButtonOn() {
		if (cc.getUser()==null||cc.getUser().getLv()==0) {
			bp.buts[0][0].setEnabled(true);
		}
		
		if (cc.getUser()!=null && cc.getUser().getLv()>0) {
			bp.buts[1][0].setEnabled(true);
			bp.buts[3][0].setEnabled(true);
			bp.buts[4][0].setEnabled(true);
			bp.buts[6][0].setEnabled(true);
			if (cc.getUser().getLv()>2) {
				bp.buts[2][0].setEnabled(true);
			}
			if (cc.getUser().getLv()>3) {
				bp.buts[5][0].setEnabled(true);
			}
			if (cc.getUser().getLv()>4) {
				bp.buts[5][0].setEnabled(true);
			}
		}

		bp.buts[7][0].setEnabled(true);
	}
	
}
