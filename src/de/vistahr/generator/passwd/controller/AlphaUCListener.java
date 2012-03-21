package de.vistahr.generator.passwd.controller;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import de.vistahr.generator.passwd.model.PasswdViewModel;
import de.vistahr.generator.passwd.view.PasswdRootView;
import de.vistahr.generator.passwd.view.listener.AbstractListener;

public class AlphaUCListener extends AbstractListener implements ChangeListener {

	public AlphaUCListener(PasswdViewModel m, PasswdRootView v) {
		super(m, v);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		model.setChkAlphaUC(view.getChkAlphaUC().isSelected());
	}

}
