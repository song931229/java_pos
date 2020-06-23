package Pannel;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public class SearchBar extends MYPanel {
	
	String[] Search_Con= {"검색","리셋","종료"};
	Buts_Panel buts;
	public JComboBox searchcom;
	public JTextField searchvalue= new JTextField();

	public SearchBar(String[] coms,int frame,int subframe){
		this.setLayout(null);
		this.setSize(500, 30);
		searchcom = new JComboBox(coms);
		this.add(searchcom);
		this.add(searchvalue);
		
		buts = new Buts_Panel(3,frame,subframe,Search_Con,true,6);
		this.add(buts);
		searchcom.setBounds(0,0, 100, 20);
		searchvalue.setBounds(100,0,200,20);
		buts.setBounds(300,0,200,20);
		
	}
}
