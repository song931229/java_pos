package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Pannel.Buts_Panel;

public class Index_Frame extends Base_Frame {
	private int level=0;
	private boolean logining=false;
	private String[] cons= {"로그인","로그아웃","상품판매","상품주문","직원관리","고객관리","상품관리","종료"};
	private Buts_Panel bp;
	private String user;
	public Index_Frame() {
		super("index", 250, 600);
		// TODO Auto-generated constructor stub
		
		bp=new Buts_Panel(8,1,250,600,cons);
		
		this.setMainPanel(bp);
		this.ButtonOn();
		this.setVisible(true);
	}
//	public Index_Frame(int level,boolean logining) {
//		super("index", 250, 600);
//		// TODO Auto-generated constructor stub
//		this.setLevel(level);
//		this.setLogining(logining);
//		bp=new Buts_Pannel(8,1,250,600,cons);
//		this.setContentPane(bp);
//		this.ButtonOn();
//		this.setVisible(true);
//	}
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public boolean isLogining() {
		return logining;
	}
	public void setLogining(boolean logining) {
		this.logining = logining;
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
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
		if (level==0 || logining==false) {
			bp.buts[0][0].setEnabled(true);
		}
		
		if (logining==true && level>0) {
			bp.buts[1][0].setEnabled(true);
			bp.buts[3][0].setEnabled(true);
			bp.buts[4][0].setEnabled(true);
			bp.buts[6][0].setEnabled(true);
			if (level>2) {
				bp.buts[2][0].setEnabled(true);
			}
			if (level>3) {
				bp.buts[5][0].setEnabled(true);
			}
			if (level>4) {
				bp.buts[5][0].setEnabled(true);
			}
		}
		
		
		bp.buts[7][0].setEnabled(true);
	}
	
}
