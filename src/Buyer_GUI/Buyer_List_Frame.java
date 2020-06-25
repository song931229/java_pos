package Buyer_GUI;

import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controls.Command_Center;
import Index_GUI.Base_Frame;
import Pannel.Buts_Panel;
import Pannel.MYPanel;
import Pannel.SearchBar;
import Server_DATA.BuyerDTO;
import Server_DATA.SellerDTO;

public class Buyer_List_Frame extends Base_Frame  {
	// 프레임번호 6-2
	private Command_Center cc=Command_Center.getInstance();
	public String search;
	public String searchvalue;
	public int clicked_row=-1;
	public String clicked_tel;
	public int current_page=1;
	private int pagesize=30;
	public int endpage;
	private int total_counts;
	private String [] ColName = {"이름","전화","생년","포인트","Lv","가입일"};
	String [][] Data ;
	
	DefaultTableModel model = new DefaultTableModel(Data,ColName);
	
	JTable table = new JTable(model);
	MYPanel base= new MYPanel();
	
	MYPanel list= new MYPanel();
	
	String[] sbar_S= {"이름","전화","생년","Lv","가입일"};
	public SearchBar sbar = new SearchBar(sbar_S,6,2);
	
	String[] bp_S= {"<","1","2","3",">"};
	public Buts_Panel bp1= new Buts_Panel(5,6,2,bp_S,false);
	
	public Buyer_List_Frame() throws SQLException {
		super("고객 목록", 800, 500);
		// TODO Auto-generated constructor stub
		list.setBackground(Color.WHITE);
		list.setBorderLayout();
		table.getTableHeader().setFont(new Font("맑은고딕", Font.BOLD, 15));
		list.add(new JScrollPane(table));
		
		base.setLayout(null);
		
		base.add(sbar);
		base.add(list);
		base.add(bp1);
		list.setBounds(25, 40, 750, 380);
		bp1.setBounds(275,430, 250,30);
		sbar.setBounds(150, 10, 500, 30);
		this.reset();
		this.setMainPanel(base);;
		this.setVisible(true);
	}
	
	public void reset() throws SQLException {
		this.current_page=1;
		this.shows();
	}
	
	public void shows() throws SQLException {
		if (search==null&&searchvalue==null) {
			total_counts=cc.buyerDAO.counts_buyer();
		}else {
			total_counts=cc.buyerDAO.counts_searched_buyer(search, searchvalue);
		}
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
		ArrayList<BuyerDTO> buyer_lsit;
		if (search==null&&searchvalue==null) {
			 buyer_lsit=cc.buyerDAO.list_buyer(start,end);
		}else {
			buyer_lsit=
					cc.buyerDAO.searched_list_buyer(search, searchvalue, start, end);
		}
		
		Iterator<BuyerDTO> it = buyer_lsit.iterator();
		DefaultTableModel m=new DefaultTableModel(Data,ColName) {
			public boolean isCellEditable(int row, int column) {
				if (clicked_row==row) {
					try {
						cc.command(6, 0, 4);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					clicked_tel=(String) this.getValueAt(row, 1);
					clicked_row=row;
				}
				return false;//This causes all cells to be not editable
				}
			};
		while (it.hasNext()) {
			BuyerDTO buyerDTO=it.next();
			m.addRow(new Object[]{
					buyerDTO.getName(),
					buyerDTO.getTel(),
					buyerDTO.getBirth(),
					buyerDTO.getPoint(),
					buyerDTO.getLv(),
					buyerDTO.getJoindate()
					});
		}
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
		if (current_page!=1) {
			bp1.buts[0].setEnabled(true);
		}
		if (current_page!=endpage) {
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
