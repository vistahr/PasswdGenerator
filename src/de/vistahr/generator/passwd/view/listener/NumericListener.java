package de.vistahr.generator.passwd.view.listener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import de.vistahr.generator.passwd.model.RootViewModel;
import de.vistahr.generator.passwd.view.components.RootView;

public class NumericListener extends AbstractListener implements ChangeListener {

	public NumericListener(RootViewModel m, RootView v) {
		super(m, v);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		model.setChkNumeric(view.getChkNumeric().isSelected());
	}

}
