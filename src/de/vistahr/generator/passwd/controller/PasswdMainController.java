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
package de.vistahr.generator.passwd.controller;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import de.vistahr.generator.Keys;
import de.vistahr.generator.Password;
import de.vistahr.generator.passwd.model.PasswdViewModel;
import de.vistahr.generator.passwd.view.PasswdView;
import de.vistahr.generator.passwd.view.menu.PasswdMenu;


public class PasswdMainController {
	
	private PasswdViewModel model;
	private PasswdView view;
	
	
	public PasswdMainController(PasswdViewModel m, PasswdView v) {
		model = m;
		view = v;
		addListenersAction();
		initDataAction();
		
		// init
		PasswdMenu pmView = new PasswdMenu();
		new PasswdMenuController(pmView);
		// connect with main view
		view.setJMenuBar(pmView.getMainMenu());
	}
	
	
	private void initDataAction() {
		// init componentdata
		model.setLength(6);
		model.setPassword("");
		// set all boxes checked
		model.setChkAlphaLC(true);
		model.setChkAlphaUC(true);
		model.setChkNumeric(true);
		model.setChkSpecial(true);
		// focus to generate button
		view.getBtnGenerate().requestFocus();
	}
	
	
	private void addListenersAction() {
		view.getBtnGenerate().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					generateAction();
				} catch(IllegalArgumentException e) {
					PasswdView.showMessageDialog(e.getMessage());
				}
			}
		});
		view.getBtnCopy().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				copyPasswdToClipboardAction();
			}
		});
		view.getSldLength().addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				changeLengthAction();
			}
		});
		view.getTxtPasswdResult().addComponentListener(new ComponentListener() {@Override
			public void componentShown(ComponentEvent e) {}
			@Override
			public void componentResized(ComponentEvent e) {
				resizeTxtPasswdResultAction(e);
			}
			@Override
			public void componentMoved(ComponentEvent e) {}
			@Override
			public void componentHidden(ComponentEvent e) {}
		});
		view.getChkAlphaLC().addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				model.setChkAlphaLC(view.getChkAlphaLC().isSelected());
			}
		});
		view.getChkAlphaUC().addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				model.setChkAlphaUC(view.getChkAlphaUC().isSelected());
			}
		});
		view.getChkNumeric().addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				model.setChkNumeric(view.getChkNumeric().isSelected());
			}
		});
		view.getChkSepcialKeys().addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				model.setChkSpecial(view.getChkSepcialKeys().isSelected());
			}
		});
	}
	
	
	private void generateAction() {
		int length = 0;
		
		// get the views length
		try {
			length = Integer.valueOf(view.getSldLength().getValue());
		} catch(NumberFormatException e) {
			PasswdView.showMessageDialog("invalid length data");
		}
		
		// get view data and set the arraylist
		ArrayList<Keys> keys = new ArrayList<Keys>();
		if(model.isChkAlphaLC()) {
			keys.add(Keys.ALPHA_LC);
		}
		if(model.isChkAlphaUC()) {
			keys.add(Keys.ALPHA_UC);
		}
		if(model.isChkNumeric()) {
			keys.add(Keys.NUMERIC);
		}
		if(model.isChkSpecial()) {
			keys.add(Keys.SPECIAL);
		}
		
		// keysize should not <= 0		
		if(keys.size()<=0) {
			throw new IllegalArgumentException("no keyset is selected");
		}

		// generate Password and set the model
		model.setPassword(Password.generate(length, keys));
	}
	
	
	private void changeLengthAction() {
		Integer length = model.getLength();
		try {
			length = Integer.valueOf(view.getSldLength().getValue());
			
		} catch(NumberFormatException e) {
			PasswdView.showMessageDialog("invalid length data");
		}
		model.setLength(length);
	}
	
	
	public void copyPasswdToClipboardAction() {
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(view.getTxtPasswdResult().getText()), null);
	}
	
	
	private void resizeTxtPasswdResultAction(ComponentEvent ev) {
		Integer newHeigth = Integer.valueOf(((JTextField)ev.getSource()).getHeight()/2);
		view.getTxtPasswdResult().setFont(new Font(Font.SANS_SERIF, Font.PLAIN, newHeigth));
	}
	
}
