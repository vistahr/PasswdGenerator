package de.vistahr.generator.passwd.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
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
	
	
	public void addListenersAction() {
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
	}
	
	
	public void generateAction() {
		String password = "";
		
		int length = Integer.valueOf(view.getTxtLength().getText());
		
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
	
	
	public void changeLengthAction() {
		Integer length = model.getLength();
		try {
			length = Integer.valueOf(view.getTxtLength().getText());
			
		} catch(NumberFormatException e) {
			view.showMessageDialog("invalid length data");
		}
		model.setLength(length);
	}
	
	
}
