package de.vistahr.generator.passwd.view.listener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import de.vistahr.generator.passwd.model.PasswdViewModel;
import de.vistahr.generator.passwd.view.PasswdRootView;

public class NumericListener extends AbstractListener implements ChangeListener {

	public NumericListener(PasswdViewModel m, PasswdRootView v) {
		super(m, v);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		model.setChkNumeric(view.getChkNumeric().isSelected());
	}

}
