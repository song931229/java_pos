package Seller_GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Index_GUI.Base_Frame;
import Pannel.Buts_Panel;
import Pannel.MYPanel;
import Pannel.SearchBar;

public class Seller_List_Frame extends Base_Frame {
	private String [] ColName = {"이름","전화","생년","ID","cash_C","cash_N","Lv","가입일"};
	String [][] Data ;
	
	DefaultTableModel model = new DefaultTableModel(Data,ColName);
	
	JTable table = new JTable(model);
	MYPanel base= new MYPanel();
	
	MYPanel list= new MYPanel();
	
	String[] sbar_S= {"이름","전화","생년","ID","Lv","가입일"};
	SearchBar sbar = new SearchBar(sbar_S);
	
	String[] bp_S= {"<","1","2","3",">"};
	Buts_Panel bp1= new Buts_Panel(1,5,bp_S,false);

	DefaultTableModel m = (DefaultTableModel)table.getModel();
	
	public Seller_List_Frame() {
		super("직원 목록", 800, 500);
		// TODO Auto-generated constructor stub
		list.setBackground(Color.WHITE);
		list.setBorderLayout();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.getTableHeader().setFont(new Font("맑은고딕", Font.BOLD, 15));
		list.add(new JScrollPane(table));

		base.setLayout(null);
		
		base.add(sbar);
		base.add(list);
		base.add(bp1);
		list.setBounds(25, 40, 750, 380);
		bp1.setBounds(275,430, 250,30);
		sbar.setBounds(150, 10, 500, 30);
		
		this.setMainPanel(base);;
		this.setVisible(true);
	}

}
