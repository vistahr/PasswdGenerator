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
import java.awt.Image;
import java.util.Hashtable;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.UIManager;

import de.vistahr.generator.passwd.model.PasswdViewModel;
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


	public PasswdView(Observable model) {
		model.addObserver(this);
		initLayout();
		mainFrame.setVisible(true);
	}
	
	
	private void initLayout() {
		try {
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		
		mainFrame = new JFrame(APP_NAME);
		
		// set up components
		BindingFactory bf = new BindingFactory();
		
		txtPasswdResult = new JTextField();
		btnCopy 		= new JButton("copy");
		btnGenerate 	= new JButton("Generate");
		
		// slider
		int sldLengthMaxVal = 30;
		sldLength		= new JSlider(JSlider.HORIZONTAL,1,sldLengthMaxVal,1);
		sldLength.setMajorTickSpacing(sldLengthMaxVal/2);
		sldLength.setPaintTicks(true);
		sldLength.setPaintLabels(true);
		// sliderlabels
		Hashtable sldLengthLabelTable = new Hashtable();
		sldLengthLabelTable.put(new Integer(1), new JLabel("Low"));
		sldLengthLabelTable.put(new Integer(sldLengthMaxVal/2), new JLabel("Middle"));
		sldLengthLabelTable.put(new Integer(sldLengthMaxVal), new JLabel("High"));
		sldLength.setLabelTable(sldLengthLabelTable);
		
		
		JPanel mainPanel = new JPanel(new RelativeLayout());
		
		JLabel lblPassword = new JLabel("Password:");
		mainPanel.add(lblPassword, new RelativeConstraints(bf.leftEdge(), bf.topEdge()));
		mainPanel.add(txtPasswdResult, new RelativeConstraints(bf.below(lblPassword), bf.leftEdge(), bf.leftOf(btnCopy)));
		
		mainPanel.add(btnCopy, new RelativeConstraints(bf.rightEdge(), bf.below(lblPassword)));
		
		JLabel lblLength = new JLabel("Password strength:");
		mainPanel.add(lblLength, new RelativeConstraints(bf.below(txtPasswdResult), bf.leftEdge()));
		mainPanel.add(sldLength, new RelativeConstraints(bf.below(lblLength), bf.leftEdge()));
		
		
		
		mainPanel.add(btnGenerate, new RelativeConstraints(bf.bottomEdge(), bf.rightEdge()));
		
		mainFrame.add(mainPanel);
		
		// frame settings
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setPreferredSize(new Dimension(400,170));
		mainFrame.pack();
		mainFrame.setLocationRelativeTo(null);
		
		
		// icon - frame
		try {
			Image icon = new ImageIcon(getClass().getResource(RES_PATH + RES_ICON_APP)).getImage();
			mainFrame.setIconImage(icon);
		} catch(NullPointerException e) {
			showMessageDialog("Cannot load resource " + RES_PATH + RES_ICON_APP);
		}
	}
	
	

	@Override
	public void update(Observable o, Object model) {
		getSldLength().setValue(((PasswdViewModel)model).getLength());
		getTxtPasswdResult().setText(((PasswdViewModel)model).getPassword());
	}
	

	public void showMessageDialog(String message) {
		JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.WARNING_MESSAGE);
	}
	
	
	
}
