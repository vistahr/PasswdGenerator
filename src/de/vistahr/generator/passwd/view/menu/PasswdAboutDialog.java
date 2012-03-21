/**
 * 
 * 	Copyright 2012 Vince. All rights reserved.
 * 	
 * 	Redistribution and use in source and binary forms, with or without modification, are
 * 	permitted provided that the following conditions are met:
 * 	
 * 	   1. Redistributions of source code must retain the above copyright notice, this list of
 * 	      conditions and the following disclaimer.
 * 	
 * 	   2. Redistributions in binary form must reproduce the above copyright notice, this list
 * 	      of conditions and the following disclaimer in the documentation and/or other materials
 * 	      provided with the distribution.
 * 	
 * 	THIS SOFTWARE IS PROVIDED BY Vince ``AS IS'' AND ANY EXPRESS OR IMPLIED
 * 	WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * 	FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL Vince OR
 * 	CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * 	CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * 	SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * 	ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * 	NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * 	ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 	
 * 	The views and conclusions contained in the software and documentation are those of the
 * 	authors and should not be interpreted as representing official policies, either expressed
 * 	or implied, of Vince.
 */
package de.vistahr.generator.passwd.view.menu;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import de.vistahr.generator.passwd.view.PasswdView;

public class PasswdAboutDialog {

	JDialog about;
	
	
	public PasswdAboutDialog() {
		about = new JDialog();
		// set dialog components
		initDialog();
		about.setLocationRelativeTo(null);
		about.setPreferredSize(new Dimension(300,250));
		about.pack();
		about.setVisible(true);
	}
	
	
	private void initDialog() {
		JPanel mainPanel = new JPanel();
		
		ImageIcon logo = null;
		// add icon
		try {
			logo = new ImageIcon(getClass().getResource(PasswdView.RES_PATH + PasswdView.RES_ICON_APP));
		} catch(NullPointerException e) {
			PasswdView.showMessageDialog("Cannot load resource " + PasswdView.RES_PATH + PasswdView.RES_ICON_APP);
		}
		
		//picture
		JLabel lblLogo = new JLabel(logo);
		
		//name
		JLabel lblName = new JLabel();
		lblName.setText("<html><b>PasswdGenerator</b><br /><br /></html>");
		
		// about
		JLabel lblAbout = new JLabel();
		lblAbout.setText("<html>developed by vistahr <br /> version 0.1 (stable release)</html>");
		
		mainPanel.add(lblLogo);
		mainPanel.add(lblName);
		mainPanel.add(lblAbout);
		
		about.add(mainPanel);
	}
	
}
