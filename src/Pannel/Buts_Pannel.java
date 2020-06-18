package Pannel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Buts_Pannel extends JPanel {
	public JButton[][] buts;
	public Buts_Pannel(int m, int n,int x ,int y,String[] contents){
		buts= new JButton[m][n];
		Dimension frameSize = new Dimension(x,y);
		this.setSize(frameSize);
		GridLayout gl = new GridLayout(m,n);
		this.setLayout(gl);
		int count=0;
		for (int i = 0; i < m; i++) {
			for (int j=0; j<n; j++) {
				buts[i][j]=new JButton(contents[count]);
				
				buts[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JButton a=(JButton) e.getSource();
						
					}
				});
				buts[i][j].setEnabled(false);
				this.add(buts[i][j]);
				count++;
			}
        }
	}
}
