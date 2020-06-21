package Index_GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import main.Control_Center;

public class MYButton extends JButton {
	Control_Center aa=Control_Center.getInstance();
	public MYButton(String con,int frame, int butno){
		super(con);
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aa.command(frame, butno);
			}
		});
	}
}
