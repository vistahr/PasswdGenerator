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
package de.vistahr.generator.passwd.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.util.Hashtable;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.UIManager;

import de.vistahr.generator.passwd.model.PasswdViewModel;
import de.vistahr.generator.passwd.view.menu.PasswdMenu;
import edu.cmu.relativelayout.BindingFactory;
import edu.cmu.relativelayout.RelativeConstraints;
import edu.cmu.relativelayout.RelativeLayout;

public class PasswdView implements Observer {
	
	public static final String APP_NAME = "PasswdGenerator";
	
	public static final String RES_PATH = "/res/";
	public static final String RES_ICON_APP = "key.png";
	
	private JFrame mainFrame;
	private JSlider sldLength;
	private JTextField txtPasswdResult;
	private JButton btnCopy;
	private JButton btnGenerate;
	private JCheckBox chkNumeric;
	private JCheckBox chkAlphaLC;
	private JCheckBox chkAlphaUC;
	private JCheckBox chksepcialKeys;
	private PasswdMenu menu;

	public JTextField getTxtPasswdResult() {
		return txtPasswdResult;
	}


	public JButton getBtnGenerate() {
		return btnGenerate;
	}


	public JButton getBtnCopy() {
		return btnCopy;
	}



	public JSlider getSldLength() {
		return sldLength;
	}


	public JCheckBox getChkNumeric() {
		return chkNumeric;
	}


	public JCheckBox getChkAlphaLC() {
		return chkAlphaLC;
	}


	public JCheckBox getChkAlphaUC() {
		return chkAlphaUC;
	}


	public JCheckBox getChkSepcialKeys() {
		return chksepcialKeys;
	}


	public PasswdMenu getMainMenu() {
		return menu;
	}
	
	
	public JFrame getMainFrame() {
		return mainFrame;
	}


	public void setJMenuBar(JMenuBar menu) {
		mainFrame.setJMenuBar(menu);
	}
	
	


	public PasswdView(Observable model) {
		model.addObserver(this);
		initLayout();
		mainFrame.setVisible(true);
	}
	
	
	private void initLayout() {
		// set app name for mac
		System.setProperty("com.apple.mrj.application.apple.menu.about.name", APP_NAME);
		// use osx jmenu 
		System.setProperty("apple.laf.useScreenMenuBar", "true");
		
		// systemdesign (look)
		try {
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		
		// mainframe
		mainFrame = new JFrame(APP_NAME);
		
		// for relative layoutmanager
		BindingFactory bf = new BindingFactory();
		
		
		// components
		chkNumeric = new JCheckBox("Numeric");
		chkAlphaLC = new JCheckBox("Alpha lowercase");
		chkAlphaUC = new JCheckBox("Alpha uppercase");
		chksepcialKeys = new JCheckBox("SpecialKeys");
		
		// labels for passwd & strength
		JLabel lblLength = new JLabel("Password strength:");
		JLabel lblPassword = new JLabel("Password:");
				
		btnCopy = new JButton("copy");
		
		txtPasswdResult = new JTextField();
		txtPasswdResult.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 25));
		txtPasswdResult.setEditable(false);
		
		btnGenerate = new JButton("Generate");
		
		// slider with manual labels
		int sldLengthMaxVal = 30;
		sldLength = new JSlider(JSlider.HORIZONTAL,1,sldLengthMaxVal,1);
		sldLength.setMajorTickSpacing(sldLengthMaxVal/2);
		sldLength.setPaintTicks(true);
		sldLength.setPaintLabels(true);
		
		// sliderlabels
		Hashtable<Integer, JLabel> sldLengthLabelTable = new Hashtable<Integer, JLabel>();
		sldLengthLabelTable.put(new Integer(1), new JLabel("Low"));
		sldLengthLabelTable.put(new Integer(sldLengthMaxVal/2), new JLabel("Middle"));
		sldLengthLabelTable.put(new Integer(sldLengthMaxVal), new JLabel("High"));
		sldLength.setLabelTable(sldLengthLabelTable);		
		
		
		// mainpanel
		JPanel mainPanel = new JPanel(new RelativeLayout());
		
		mainPanel.add(chkNumeric, new RelativeConstraints(bf.leftEdge(), bf.topEdge()));
		mainPanel.add(chkAlphaLC, new RelativeConstraints(bf.rightOf(chkNumeric), bf.topEdge()));
		mainPanel.add(chkAlphaUC, new RelativeConstraints(bf.topEdge(), bf.rightOf(chkAlphaLC)));
		mainPanel.add(chksepcialKeys, new RelativeConstraints(bf.topEdge(), bf.rightOf(chkAlphaUC)));	
		
		mainPanel.add(lblPassword, new RelativeConstraints(bf.leftEdge(), bf.below(chkNumeric)));
		
		mainPanel.add(txtPasswdResult, new RelativeConstraints(bf.leftEdge(), bf.below(lblPassword), bf.leftOf(btnCopy), bf.above(lblLength)));
		mainPanel.add(btnCopy, new RelativeConstraints(bf.rightEdge(), bf.below(lblPassword)));
		
		mainPanel.add(lblLength, new RelativeConstraints(bf.above(sldLength), bf.leftEdge()));
		
		mainPanel.add(sldLength, new RelativeConstraints(bf.bottomEdge(), bf.leftEdge(), bf.leftOf(btnGenerate)));
		mainPanel.add(btnGenerate, new RelativeConstraints(bf.bottomEdge(), bf.rightEdge()));
		
		mainFrame.add(mainPanel);
		
		// frame settings
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setPreferredSize(new Dimension(520,280));
		mainFrame.pack();
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setResizable(true);
		
		// add icon
		try {
			Image icon = new ImageIcon(getClass().getResource(RES_PATH + RES_ICON_APP)).getImage();
			mainFrame.setIconImage(icon);
		} catch(NullPointerException e) {
			showMessageDialog("Cannot load resource " + RES_PATH + RES_ICON_APP);
		}
		
		// menu
		menu = new PasswdMenu();
		mainFrame.setJMenuBar(menu.getMenuBar());
		
	}
	
	
	
	

	@Override
	public void update(Observable o, Object model) {
		getSldLength().setValue(((PasswdViewModel)model).getLength());
		getTxtPasswdResult().setText(((PasswdViewModel)model).getPassword());
		
		getChkAlphaLC().setSelected(((PasswdViewModel)model).isChkAlphaLC());
		getChkAlphaUC().setSelected(((PasswdViewModel)model).isChkAlphaUC());
		getChkNumeric().setSelected(((PasswdViewModel)model).isChkNumeric());
		getChkSepcialKeys().setSelected(((PasswdViewModel)model).isChkSpecial());
	}
	
/*
	public void showMessageDialog(String message) {
		JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.WARNING_MESSAGE);
	}*/
	
	public static void showMessageDialog(String message) {
		JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.WARNING_MESSAGE);
	}	
	
}
