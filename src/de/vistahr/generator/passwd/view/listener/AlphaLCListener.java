package de.vistahr.generator.passwd.view.listener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import de.vistahr.generator.passwd.model.RootViewModel;
import de.vistahr.generator.passwd.view.component.RootView;

public class AlphaLCListener extends AbstractListener implements ChangeListener {

	public AlphaLCListener(RootViewModel m, RootView v) {
		super(m, v);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		model.setChkAlphaLC(view.getChkAlphaLC().isSelected());
	}

}
