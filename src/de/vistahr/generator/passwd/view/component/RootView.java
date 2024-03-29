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
package de.vistahr.generator.passwd.view.component;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import de.vistahr.generator.passwd.model.RootViewModel;
import edu.cmu.relativelayout.BindingFactory;
import edu.cmu.relativelayout.RelativeConstraints;
import edu.cmu.relativelayout.RelativeLayout;

public class RootView implements Observer {
	
	public static final String APP_NAME = "PasswdGenerator";
	
	public static final String RES_PATH = "/res/";
	public static final String RES_ICON_APP = "key.png";
	
	private MainFrame mainFrame;
	private JSlider sldLength;
	private JTextField txtPasswdResult;
	private JButton btnCopy;
	private JButton btnGenerate;
	private JCheckBox chkNumeric;
	private JCheckBox chkAlphaLC;
	private JCheckBox chkAlphaUC;
	private JCheckBox chksepcialKeys;
	private MainMenu mainMenu;
	private JLabel lblLength;
	private JLabel lblPassword;

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


	public MainMenu getMainMenu() {
		return mainMenu;
	}
	
	
	public MainFrame getMainFrame() {
		return mainFrame;
	}


	public void setJMenuBar(JMenuBar menu) {
		mainFrame.setJMenuBar(menu);
	}
	
	


	public RootView(Observable model) {
		model.addObserver(this);
		
		initLayout();
		positionComponents();
		
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
	        
	    } catch (UnsupportedLookAndFeelException e) {
	        e.printStackTrace();
	    } catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		// mainframe
		mainFrame = new MainFrame(APP_NAME);
		
		
		//// components
		///////////////
		
		// checkbxses
		chkNumeric = new JCheckBox("Numeric");
		chkAlphaLC = new JCheckBox("Alpha lowercase");
		chkAlphaUC = new JCheckBox("Alpha uppercase");
		chksepcialKeys = new JCheckBox("SpecialKeys");
		
		// labels for passwd & strength
		lblLength = new JLabel("Password strength:");
		lblPassword = new JLabel("Password:");
				
		btnCopy = new JButton("copy");
		
		txtPasswdResult = new PasswordResult();
		
		btnGenerate = new JButton("Generate");
		
		// slider with manual labels
		sldLength = new StrengthSlider(JSlider.HORIZONTAL, 1, 30, 1);
		
		// menu
		mainMenu = new MainMenu();
		mainFrame.setJMenuBar(mainMenu);
	}
	
	
	private void positionComponents() {
		// for relative layoutmanager
		BindingFactory bf = new BindingFactory();
				
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
	}
	
	
	@Override
	public void update(Observable o, Object model) {
		getSldLength().setValue(((RootViewModel)model).getLength());
		getTxtPasswdResult().setText(((RootViewModel)model).getPassword());
		getChkAlphaLC().setSelected(((RootViewModel)model).isChkAlphaLC());
		getChkAlphaUC().setSelected(((RootViewModel)model).isChkAlphaUC());
		getChkNumeric().setSelected(((RootViewModel)model).isChkNumeric());
		getChkSepcialKeys().setSelected(((RootViewModel)model).isChkSpecial());
	}
	

}
