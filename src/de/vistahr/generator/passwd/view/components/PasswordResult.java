package de.vistahr.generator.passwd.view.components;

import java.awt.Font;

import javax.swing.JTextField;

public class PasswordResult extends JTextField {

	
	public PasswordResult() {
		setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 25));
		setEditable(false);
	}
	
}
