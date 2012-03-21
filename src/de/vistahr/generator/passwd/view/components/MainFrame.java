package de.vistahr.generator.passwd.view.components;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import de.vistahr.generator.passwd.view.PasswdRootView;

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
			Image icon = new ImageIcon(getClass().getResource(PasswdRootView.RES_PATH + PasswdRootView.RES_ICON_APP)).getImage();
				setIconImage(icon);
		} catch(NullPointerException e) {
			new MessageDialog("Cannot load resource " + PasswdRootView.RES_PATH + PasswdRootView.RES_ICON_APP);
		}
	}
	
	public void close() {
		setVisible(false);
		dispose();
		System.exit(0);
	}

}
