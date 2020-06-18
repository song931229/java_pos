package GUI;

import javax.swing.JFrame;

public class Base_Frame extends JFrame{
	public Base_Frame(int x, int y) {
		setTitle("-");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(x,y);
		setLocationRelativeTo(null);
	}
	
	public Base_Frame(String title, int x, int y) {
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(x,y);
		setLocationRelativeTo(null);
	}
}
