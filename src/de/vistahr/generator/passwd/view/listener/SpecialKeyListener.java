package de.vistahr.generator.passwd.view.listener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import de.vistahr.generator.passwd.model.PasswdViewModel;
import de.vistahr.generator.passwd.view.PasswdRootView;

public class SpecialKeyListener extends AbstractListener implements
		ChangeListener {

	public SpecialKeyListener(PasswdViewModel m, PasswdRootView v) {
		super(m, v);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		model.setChkSpecial(view.getChkSepcialKeys().isSelected());
	}

}
