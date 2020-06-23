package Pannel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Index_GUI.MYButton;

public class Buts_Panel extends JPanel {
	public MYButton[] buts;
	
	public Buts_Panel(int n,int frame,int subframe,String[] contents,Boolean OnOff, int k){
		buts = new MYButton[n];
		GridLayout gl = new GridLayout(1,n);
		this.setLayout(gl);
		int count=0;
		for (int i = 0; i < n; i++) {
			buts[i]=new MYButton(contents[count],frame,subframe,i+k);
			buts[i].setEnabled(OnOff);
			this.add(buts[i]);
			count++;
		}
	}
	
	public Buts_Panel(int n,int frame,int subframe,String[] contents,Boolean OnOff){
		buts = new MYButton[n];
		GridLayout gl = new GridLayout(1,n);
		this.setLayout(gl);
		int count=0;
		for (int i = 0; i < n; i++) {
			buts[i]=new MYButton(contents[count],frame,subframe,i+1);
			buts[i].setEnabled(OnOff);
			this.add(buts[i]);
			count++;
		}
	}
	
	public Buts_Panel(Boolean m, int n,int frame,int subframe,String[] contents,Boolean OnOff){
		if (m==true) {
			buts = new MYButton[n];
			GridLayout gl = new GridLayout(1,n);
			this.setLayout(gl);
			int count=0;
			for (int i = 0; i < n; i++) {
				buts[i]=new MYButton(contents[count],frame,subframe,i+1);
				buts[i].setEnabled(OnOff);
				this.add(buts[i]);
				count++;
			}
		}else {
			buts = new MYButton[n];
			GridLayout gl = new GridLayout(n,1);
			this.setLayout(gl);
			int count=0;
			for (int i = 0; i < n; i++) {
				buts[i]=new MYButton(contents[count],frame,subframe,i+1);
				buts[i].setEnabled(OnOff);
				this.add(buts[i]);
				count++;
			}
		}
	}
}
