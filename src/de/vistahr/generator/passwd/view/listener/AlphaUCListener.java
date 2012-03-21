package de.vistahr.generator.passwd.view.listener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import de.vistahr.generator.passwd.model.RootViewModel;
import de.vistahr.generator.passwd.view.component.RootView;

public class AlphaUCListener extends AbstractListener implements ChangeListener {

	public AlphaUCListener(RootViewModel m, RootView v) {
		super(m, v);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		model.setChkAlphaUC(view.getChkAlphaUC().isSelected());
	}

}
