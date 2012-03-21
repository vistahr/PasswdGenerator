package de.vistahr.generator.passwd.view.listener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import de.vistahr.generator.passwd.model.RootViewModel;
import de.vistahr.generator.passwd.view.components.RootView;

public class SpecialKeyListener extends AbstractListener implements
		ChangeListener {

	public SpecialKeyListener(RootViewModel m, RootView v) {
		super(m, v);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		model.setChkSpecial(view.getChkSepcialKeys().isSelected());
	}

}
