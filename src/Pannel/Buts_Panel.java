package Pannel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Index_GUI.MYButton;

public class Buts_Panel extends JPanel {
	public MYButton[][] buts;
	
	public Buts_Panel(int m, int n,String[] contents,Boolean OnOff){
		buts= new MYButton[m][n];
		GridLayout gl = new GridLayout(m,n);
		this.setLayout(gl);
		int count=0;
		for (int i = 0; i < m; i++) {
			for (int j=0; j<n; j++) {
				buts[i][j]=new MYButton(contents[count],0,i);
				
				buts[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JButton a= (JButton)e.getSource();
						
					}
				});
				buts[i][j].setEnabled(OnOff);
				this.add(buts[i][j]);
				count++;
			}
        }
	}
	
}
