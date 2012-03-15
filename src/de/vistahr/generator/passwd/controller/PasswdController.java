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

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import de.vistahr.generator.passwd.model.PasswdViewModel;
import de.vistahr.generator.passwd.view.PasswdView;


public class PasswdController {
	
	private PasswdViewModel model;
	private PasswdView view;
	
	
	public PasswdController(PasswdViewModel m, PasswdView v) {
		model = m;
		view = v;
		addListenersAction();
		
		// init settings
		model.setLength(6);
		model.setPassword("");
	}
	
	
	private void addListenersAction() {
		view.getBtnGenerate().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				generateAction();
			}
		});
		view.getTxtLength().addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent arg0) {
				changeLengthAction();
			}
			@Override
			public void focusGained(FocusEvent arg0) {}
		});
		view.getBtnCopy().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				copyPasswdToClipboardAction();
			}
		});
	}
	
	
	private void generateAction() {
		String password = "";
		int length = 0;
		
		try {
			length = Integer.valueOf(view.getTxtLength().getText());
			
		} catch(NumberFormatException e) {
			view.showMessageDialog("invalid length data");
		}

		// iterate through passwdlength
		for(int i=0;i<=length;i++) {
			double rand = 0;
			// run, while getting valid char
			while(true) {
				rand =  Math.random() * 127;
				if((rand >= 61 && rand <= 122) || (rand >= 48 && rand <= 57) || (rand >= 65 && rand <= 90) ) {
					password += (char) rand;
					break;
				}
			}	
		}
		
		model.setPassword(password);
	}
	
	
	private void changeLengthAction() {
		Integer length = model.getLength();
		try {
			length = Integer.valueOf(view.getTxtLength().getText());
			
		} catch(NumberFormatException e) {
			view.showMessageDialog("invalid length data");
		}
		model.setLength(length);
	}
	
	
	private void copyPasswdToClipboardAction() {
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(view.getTxtPasswdResult().getText()), null);
	}
	
}
