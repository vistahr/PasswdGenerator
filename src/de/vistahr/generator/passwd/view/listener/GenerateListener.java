package de.vistahr.generator.passwd.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import de.vistahr.generator.core.Keys;
import de.vistahr.generator.core.Password;
import de.vistahr.generator.passwd.model.RootViewModel;
import de.vistahr.generator.passwd.view.components.MessageDialog;
import de.vistahr.generator.passwd.view.components.RootView;

public class GenerateListener extends AbstractListener implements ActionListener {
	
	
	public GenerateListener(RootViewModel m, RootView v) {
		super(m, v);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		try {
			int length = 0;
			
			// get the views length
			try {
				length = Integer.valueOf(view.getSldLength().getValue());
			} catch(NumberFormatException e) {
				new MessageDialog("invalid length data");
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
			
		} catch(IllegalArgumentException e) {
			new MessageDialog(e.getMessage());
		}
	}

}
