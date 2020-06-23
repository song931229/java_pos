package Buyer_GUI;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Index_GUI.Base_Frame;
import Pannel.Buts_Panel;
import Pannel.MYPanel;
import Pannel.SearchBar;

public class Buyer_List_Frame extends Base_Frame  {

	private String [] ColName = {"이름","전화","생년","포인트","Lv","가입일"};
	String [][] Data ;
	
	DefaultTableModel model = new DefaultTableModel(Data,ColName);
	
	JTable table = new JTable(model);
	MYPanel base= new MYPanel();
	
	MYPanel list= new MYPanel();
	
	String[] sbar_S= {"이름","전화","생년","Lv","가입일"};
	SearchBar sbar = new SearchBar(sbar_S,6,2);
	
	String[] bp_S= {"<","1","2","3",">"};
	Buts_Panel bp1= new Buts_Panel(5,6,2,bp_S,false);

	DefaultTableModel m = (DefaultTableModel)table.getModel();
	
	public Buyer_List_Frame(String title, int x, int y) {
		super("Buyer_List", x, y);
		// TODO Auto-generated constructor stub
	}

}
