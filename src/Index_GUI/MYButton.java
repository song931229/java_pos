package Index_GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

import Controls.Command_Center;

public class MYButton extends JButton {
	Command_Center aa=Command_Center.getInstance();
	
	public MYButton(String con,int frame,int subframe, int butno){
		super(con);
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					aa.command(frame,subframe, butno);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	
}
