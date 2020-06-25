package Product_GUI;

import javax.swing.JTable;

import Controls.Command_Center;
import Index_GUI.Base_Frame;
import Pannel.*;


public class Product_List_Frame extends Base_Frame {
	// 프레임번호 7-2
	private Command_Center cc=Command_Center.getInstance();
	public String search;
	public String searchvalue;
	public int clicked_row=-1;
	public String clicked_id;
	public int current_page=1;
	private int pagesize=30;
	public int endpage;
	private int total_counts;
	private String [] ColName = {"상품명","제조사","주문가","판매가","수량","바코드"};
	private String [][] Data ;
	
	private JTable table = new JTable();
	private MYPanel base= new MYPanel();
	
	private MYPanel list= new MYPanel();
	
	private String[] sbar_S= {"상품명","제조사","수량","바코드"};
	public SearchBar sbar = new SearchBar(sbar_S,5,2);
	
	String[] bp_S= {"<","1","2","3",">"};
	public Buts_Panel bp1= new Buts_Panel(5,5,2,bp_S,false);
	public Product_List_Frame() {
		super("상품 목록", 800, 500);
		// TODO Auto-generated constructor stub
	}

}
