package Controls;

import java.sql.SQLException;

import Ordering_GUI.Ordering_Add_Frame;
import Ordering_GUI.Ordering_List_Frame;
import Ordering_GUI.Ordering_Log_Frame;
import Ordering_GUI.Ordering_Popup_Frame;
import Product_GUI.Product_Info_Frame;
import Server_DATA.ProductDTO;

public class Ordering_Command {
	private Command_Center cc;
	
	void command(int butno) throws SQLException {
		cc = Command_Center.getInstance();
		switch(butno) {
		case 1://4-0-1
			cc.ordering_frame.setVisible(false);
			cc.ordering_list_frame=new Ordering_List_Frame();
			cc.ordering_list_frame.setVisible(true);
			break;
		case 2://4-0-2
			cc.ordering_frame.setVisible(false);
			cc.ordering_log_frame=new Ordering_Log_Frame();
			cc.seller_frame.setVisible(false);
			break;
		case 3://4-0-3
			cc.ordering_frame.setVisible(false);
			cc.ordering_frame=null;
			cc.index_frame.setVisible(true);
			break;
		}
	}
	
	void subcommand(int subframe, int butno) throws SQLException {
		cc = Command_Center.getInstance();
		switch(subframe) {
		case 1://4-1
			switch(butno) {
			case 1://4-1-1
				break;
			case 2://4-1-2
				break;
			case 3://4-1-3
				break;
			case 4://4-1-4
				break;
			case 5://4-1-5
				break;
			case 6://4-1-6
				cc.ordering_add_frame= new Ordering_Add_Frame();
				cc.ordering_add_frame.setVisible(true);
				break;
			case 7://4-1-7
				break;
			case 8://4-1-8
				break;
			case 9://4-1-9
				if (cc.ordering_add_frame==null) {
					cc.ordering_list_frame.setVisible(false);
					cc.ordering_list_frame=null;
					cc.ordering_frame.setVisible(true);
				}else {
					cc.popup(cc.ordering_add_frame, "경고", "주문추가 창을 먼저닫아주세요");
				}
				break;
			}
			break;
		case 2://4-2
			switch(butno) {
			case 1://4-2-1
				break;
			case 2://4-2-2
				break;
			case 3://4-2-3
				break;
			case 4://4-2-4
				cc.ordering_list_frame.setVisible(false);
				cc.ordering_list_frame=null;
				cc.ordering_frame.setVisible(true);
				break;
			}
			break;
		case 4://4-4
			switch(butno) {
			case 1://4-4-1
				if (cc.ordering_add_frame.current_page>1) {
					cc.ordering_add_frame.current_page-=1;
					cc.ordering_add_frame.shows();
				}
				break;
			case 2://4-4-2
				cc.ordering_add_frame.current_page=Integer.parseInt(cc.ordering_add_frame.bp1.buts[1].getText());
				cc.ordering_add_frame.shows();
				break;
			case 3://4-4-3
				cc.ordering_add_frame.current_page=Integer.parseInt(cc.ordering_add_frame.bp1.buts[2].getText());
				cc.ordering_add_frame.shows();
				break;
			case 4://4-4-4
				cc.ordering_add_frame.current_page=Integer.parseInt(cc.ordering_add_frame.bp1.buts[3].getText());
				cc.ordering_add_frame.shows();
				break;
			case 5://4-4-5
				if (cc.ordering_add_frame.current_page<cc.ordering_add_frame.endpage) {
					cc.ordering_add_frame.current_page+=1;
					cc.ordering_add_frame.shows();
				}
				break;
			case 6://4-4-6
				cc.ordering_add_frame.current_page=1;
				String[] search= {"name","company","pqty","barcode"};
				int index=cc.ordering_add_frame.sbar.searchcom.getSelectedIndex();
				cc.ordering_add_frame.search=search[index];
				cc.ordering_add_frame.searchvalue=cc.ordering_add_frame.sbar.searchvalue.getText();
				cc.ordering_add_frame.shows();
				break;
			case 7://4-4-7
				cc.ordering_add_frame.current_page=1;
				cc.ordering_add_frame.sbar.searchcom.setSelectedIndex(0);
				cc.ordering_add_frame.sbar.searchvalue.setText("");
				cc.ordering_add_frame.search=null;
				cc.ordering_add_frame.searchvalue=null;
				cc.ordering_add_frame.shows();
				break;
			case 8://4-4-8
				if (cc.ordering_popup_frame==null) {
					cc.ordering_add_frame.setVisible(false);
					cc.ordering_add_frame=null;
				}else {
					cc.popup(cc.ordering_popup_frame, "경고", "주문수량창을 먼저 닫아주세요.");
				}
			
				break;
			case 9://4-4-9
				if(cc.ordering_popup_frame==null) {
					cc.ordering_popup_frame=new Ordering_Popup_Frame(cc.ordering_add_frame.clicked_barcode);
				}else {
					cc.popup(cc.ordering_popup_frame,"경고","이미 정보창이 열려있습니다.");
				}
				break;
			}
			break;
		case 5://4-5
			int count= Integer.parseInt(cc.ordering_popup_frame.jtf_count.getText());
			switch(butno) {
			case 1://4-5-1
				cc.ordering_popup_frame.addingProduct.setPqty(Integer.parseInt(cc.ordering_popup_frame.jtf_count.getText()));
				ProductDTO order=cc.ordering_popup_frame.addingProduct;
				cc.ordering_list_frame.order_products.add(order);
				cc.ordering_popup_frame.setVisible(false);
				cc.ordering_popup_frame=null;
				cc.ordering_list_frame.shows();
				cc.popup("상품추가", "상품을 추가하였습니다.");
				break;
			case 2://4-5-2
				cc.ordering_popup_frame.setVisible(false);
				cc.ordering_popup_frame=null;
				break;
			case 3://4-5-3
				if(count>0) {
					count-=1;
					cc.ordering_popup_frame.jtf_count.setText(Integer.toString(count));
					int totalprice = count*cc.ordering_popup_frame.orderprice;
					cc.ordering_popup_frame.jtf_totalprice.setText(Integer.toString(totalprice));
				}
				break;
			case 4://4-5-4
				if(count<100) {
					count+=1;
					cc.ordering_popup_frame.jtf_count.setText(Integer.toString(count));
					int totalprice = count*cc.ordering_popup_frame.orderprice;
					cc.ordering_popup_frame.jtf_totalprice.setText(Integer.toString(totalprice));
				}
				break;
			}
			break;
		case 6:
			switch(butno) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			}
		}
	}

}
