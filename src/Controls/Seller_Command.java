package Controls;

import java.sql.SQLException;

public class Seller_Command {
	private Command_Center cc;
	
	public void command(int butno) throws SQLException {
		cc=Command_Center.getInstance();
		switch(butno) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		}
	}
	
	public void subcommand(int subframe, int butno) throws SQLException {
		cc=Command_Center.getInstance();
	}
}
