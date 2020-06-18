package GUI;

import java.awt.*;
import javax.swing.*;
import Pannel.MYPanel;

public class Base_Frame extends JFrame{
	
	MYPanel base = new MYPanel();
	
	public Base_Frame(int x, int y) {
		setTitle("-");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(x,y);
		setLocationRelativeTo(null);
		base.setBorderLayout();
		setContentPane(base);
	}
	
	public Base_Frame(String title, int x, int y) {
		JLabel lb_title = new JLabel(title,JLabel.CENTER);
		Font f1 = new Font("돋움", Font.PLAIN, 25);
		lb_title.setFont(f1);
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(x,y+30);
		setLocationRelativeTo(null);
		base.setBorderLayout();
		setTitlePanel(lb_title);
	}
	
	public void setTitlePanel(JLabel title) {
		base.add(title,BorderLayout.NORTH);
	}
	
	public void setMainPanel(JPanel main) {
		base.add(main,BorderLayout.CENTER);
		setContentPane(base);
	}
	

}
