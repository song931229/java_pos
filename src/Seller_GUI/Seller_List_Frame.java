package Seller_GUI;

import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;
import javax.swing.table.*;

import Controls.Command_Center;
import Index_GUI.Base_Frame;
import Pannel.*;
import Server_DATA.*;

public class Seller_List_Frame extends Base_Frame {
	private SellerDAO sellerDAO=new SellerDAO();

	public int current_page=1;
	private int pagesize=30;
	public int endpage;
	private int total_counts;
	private String [] ColName = {"이름","전화","생년","ID","cash_C","cash_N","Lv","가입일"};
	private String [][] Data ;
	
	private JTable table = new JTable();
	private MYPanel base= new MYPanel();
	
	private MYPanel list= new MYPanel();
	
	private String[] sbar_S= {"이름","전화","생년","ID","Lv","가입일"};
	public SearchBar sbar = new SearchBar(sbar_S,5,2);
	
	String[] bp_S= {"<","1","2","3",">"};
	public Buts_Panel bp1= new Buts_Panel(5,5,2,bp_S,false);
	
	public Seller_List_Frame() throws SQLException {
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
		this.reset();
		this.setMainPanel(base);;
		this.setVisible(true);
	}
	
	public void reset() throws SQLException {
		this.current_page=1;
		this.shows();
	}
	
	public void shows() throws SQLException {
		this.pagecal();
		if (current_page>endpage) {
			return;
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
		ArrayList<SellerDTO> seller_lsit=sellerDAO.list_seller(start,end);
		Iterator<SellerDTO> it = seller_lsit.iterator();
		DefaultTableModel m=new DefaultTableModel(Data,ColName);
		
		while (it.hasNext()) {
			SellerDTO sellerDTO=it.next();
			m.addRow(new Object[]{
					sellerDTO.getName(),
					sellerDTO.getTel(),
					sellerDTO.getBirth(),
					sellerDTO.getId(),
					sellerDTO.getC_cash(),
					sellerDTO.getN_cash(),
					sellerDTO.getLv(),
					sellerDTO.getJoindate()
					});
		}
		table.setModel(m);
		this.ButtonOn();
	}
	

	public void searched_show() throws SQLException {
		// TODO Auto-generated method stub
		this.pagecal();
		if (current_page>endpage) {
			return;
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
		int searchindex= this.sbar.searchcom.getSelectedIndex();
		String searchvalue= this.sbar.searchvalue.getText();
		String[] searchS= {"name","tel","birth","id","lv","joindate"};
		ArrayList<SellerDTO> seller_lsit=sellerDAO.searched_list_seller(searchS[searchindex],searchvalue,start,end);
		Iterator<SellerDTO> it = seller_lsit.iterator();
		DefaultTableModel m=new DefaultTableModel(Data,ColName);
		
		while (it.hasNext()) {
			SellerDTO sellerDTO=it.next();
			m.addRow(new Object[]{
					sellerDTO.getName(),
					sellerDTO.getTel(),
					sellerDTO.getBirth(),
					sellerDTO.getId(),
					sellerDTO.getC_cash(),
					sellerDTO.getN_cash(),
					sellerDTO.getLv(),
					sellerDTO.getJoindate()
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
	
	public void pagecal() throws SQLException {
		total_counts=sellerDAO.counts_seller();
		endpage=total_counts/pagesize;
		if (total_counts%pagesize!=0) {
			endpage+=1;
		}
	}
}
