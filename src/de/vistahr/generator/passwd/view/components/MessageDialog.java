package de.vistahr.generator.passwd.view.components;

import javax.swing.JOptionPane;

public class MessageDialog extends JOptionPane {

	
	public MessageDialog(String message, int type) {
		showMessageDialog(null, message, "Error", type);
	}
	
	public MessageDialog(String message) {
		showMessageDialog(null, message, "Error", JOptionPane.WARNING_MESSAGE);
	}
	
}
