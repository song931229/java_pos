package Controls;

import java.sql.SQLException;

import Ordering_GUI.Ordering_Add_Frame;
import Ordering_GUI.Ordering_List_Frame;
import Ordering_GUI.Ordering_Log_Frame;

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
			case 5://4-1-2
				break;
			case 6://4-1-2
				cc.ordering_add_frame= new Ordering_Add_Frame();
				cc.ordering_add_frame.setVisible(true);
				break;
			case 7://4-1-2
				break;
			case 8://4-1-2
				break;
			case 9://4-1-2
				cc.ordering_list_frame.setVisible(false);
				cc.ordering_list_frame=null;
				cc.ordering_frame.setVisible(true);
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
				cc.ordering_add_frame.current_page=Integer.parseInt(cc.product_list_frame.bp1.buts[1].getText());
				cc.ordering_add_frame.shows();
				break;
			case 3://4-4-3
				cc.ordering_add_frame.current_page=Integer.parseInt(cc.product_list_frame.bp1.buts[2].getText());
				cc.ordering_add_frame.shows();
				break;
			case 4://4-4-4
				cc.ordering_add_frame.current_page=Integer.parseInt(cc.product_list_frame.bp1.buts[3].getText());
				cc.ordering_add_frame.shows();
				break;
			case 5://4-4-5
				if (cc.ordering_add_frame.current_page<cc.product_list_frame.endpage) {
					cc.ordering_add_frame.current_page+=1;
					cc.ordering_add_frame.shows();
				}
				break;
			case 6://4-4-6
				cc.ordering_add_frame.current_page=1;
				String[] search= {"name","tel","birth","id","lv","joindate"};
				int index=cc.ordering_add_frame.sbar.searchcom.getSelectedIndex();
				cc.ordering_add_frame.search=search[index];
				cc.ordering_add_frame.searchvalue=cc.product_list_frame.sbar.searchvalue.getText();
				cc.ordering_add_frame.shows();
				break;
			case 7://4-4-7
				break;
			case 8://4-4-8
				break;
			}
			break;
		}
	}

}
