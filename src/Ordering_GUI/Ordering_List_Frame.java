package Ordering_GUI;

import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controls.Command_Center;
import Index_GUI.Base_Frame;
import Pannel.Buts_Panel;
import Pannel.MYPanel;
import Server_DATA.ProductDTO;

public class Ordering_List_Frame extends Base_Frame {
	//3-1
	private Command_Center cc=Command_Center.getInstance();
	public int clicked_row=-1;
	public String clicked_tel;
	public int current_page=1;
	private int pagesize=30;
	public int endpage=1;
	private int total_counts=0;
	public ArrayList<ProductDTO> order_products=new ArrayList<ProductDTO>();
	
	private String [] ColName = {"상품명","제조사","주문 수량","단가","계"};
	private String [][] Data ;
	
	private JTable table = new JTable();
	private MYPanel base= new MYPanel();
	
	private MYPanel list= new MYPanel();
	
	String[] bp_S0= {"추가","주문","초기화","종료"};
	public Buts_Panel bp0= new Buts_Panel(4,4,1,bp_S0,true,6);
	
	String[] bp_S= {"<","1","2","3",">"};
	public Buts_Panel bp1= new Buts_Panel(5,4,1,bp_S,false);
	
	public Ordering_List_Frame() throws SQLException {
		super("주문 목록", 800, 600);
		// TODO Auto-generated constructor stub
		list.setBackground(Color.WHITE);
		list.setBorderLayout();
		table.getTableHeader().setFont(new Font("맑은고딕", Font.BOLD, 15));
		list.add(new JScrollPane(table));
		
		base.setLayout(null);
		
		base.add(list);
		base.add(bp0);
		base.add(bp1);
		
		list.setBounds(25,70, 750, 450);
		bp0.setBounds(240,20, 320,30);
		bp1.setBounds(275,530, 250,30);
		this.reset();
		this.setMainPanel(base);;
		this.setVisible(true);
	}
	
	public void reset() throws SQLException {
		this.current_page=1;
		this.shows();
	}
	
	public void shows() throws SQLException {
		clicked_tel=null;
		clicked_row=-1;

		endpage=total_counts/pagesize;
		if (total_counts%pagesize!=0) {
			endpage+=1;
		}
		if (current_page>endpage) {
			current_page=1;
		}
		int start=current_page*pagesize-(pagesize-1);
		int end=current_page*pagesize;
		if (end>total_counts) {
			total_counts=end;
		}
		int buts_num=(current_page-1)/3;
		String [] buts_con= {Integer.toString(buts_num*3+1),Integer.toString(buts_num*3+2),
				Integer.toString(buts_num*3+3)};
		for(int i=1; i<4; i++) {
			bp1.buts[i].setText(buts_con[i-1]);
		}

		DefaultTableModel m=new DefaultTableModel(Data,ColName);
		table.setModel(m);
		this.ButtonOn();
	}
	
	private void ButtonOn() {
		for(int i=0; i<bp1.buts.length; i++) {
			bp1.buts[i].setEnabled(false);
		}
		
		int a=Integer.parseInt(bp1.buts[1].getText());
		int b=Integer.parseInt(bp1.buts[2].getText());
		int c=Integer.parseInt(bp1.buts[3].getText());
		//여기에 and조건을 추가하여 lv에따른 활성화가능.
		if (current_page>1) {
			bp1.buts[0].setEnabled(true);
		}
		if (current_page<endpage) {
			bp1.buts[4].setEnabled(true);
		}
		
		if (a!=1) {
			bp1.buts[1].setEnabled(true);
		}
		if(a<=endpage) {
			bp1.buts[1].setEnabled(true);
		}
		if(b<=endpage) {
			bp1.buts[2].setEnabled(true);
		}
		if(c<=endpage) {
			bp1.buts[3].setEnabled(true);
		}
		if(a==current_page) {
			bp1.buts[1].setEnabled(false);
		}
		if(b==current_page) {
			bp1.buts[2].setEnabled(false);
		}
		if(c==current_page) {
			bp1.buts[3].setEnabled(false);
		}
		
	}

}
