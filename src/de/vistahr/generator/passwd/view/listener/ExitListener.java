package de.vistahr.generator.passwd.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.vistahr.generator.passwd.model.PasswdViewModel;
import de.vistahr.generator.passwd.view.PasswdRootView;

public class ExitListener extends AbstractListener implements ActionListener {

	public ExitListener(PasswdViewModel m, PasswdRootView v) {
		super(m, v);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		view.getMainFrame().close();
	}

}
