package Pannel;

import java.awt.event.*;
import javax.swing.*;

public class ReadonlyField extends JTextField implements KeyListener {
	
	public ReadonlyField() {
		this.addKeyListener(this);
		this.setHorizontalAlignment(JTextField.RIGHT);
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
		// Get the current character you typed...
		e.consume();
		return;
	}
}
