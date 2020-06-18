package Pannel;

import java.awt.*;
import javax.swing.*;

public class MYPanel extends JPanel{
	public void setGridLayout(int x,int y){
		super.setLayout(new GridLayout(x,y));
	}
	public void setGridLayout(int x,int y,int a, int b){
		super.setLayout(new GridLayout(x,y,a,b));
	}
	public void setBorderLayout() {
		super.setLayout(new BorderLayout());
	}
	public void setBorderLayout(int a, int b) {
		super.setLayout(new BorderLayout(a,b));
	}
}
