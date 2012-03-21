package de.vistahr.generator.passwd.view.component;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class MainFrame extends JFrame {

	public MainFrame(String AppName) throws HeadlessException {
		super(AppName);
		
		// settings
		setPreferredSize(new Dimension(520,280));
		pack();
		setLocationRelativeTo(null);
		setResizable(true);
		
		// add icon
		try {
			Image icon = new ImageIcon(getClass().getResource(RootView.RES_PATH + RootView.RES_ICON_APP)).getImage();
				setIconImage(icon);
		} catch(NullPointerException e) {
			new MessageDialog("Cannot load resource " + RootView.RES_PATH + RootView.RES_ICON_APP);
		}
	}
	
	public void close() {
		setVisible(false);
		dispose();
	}

}
