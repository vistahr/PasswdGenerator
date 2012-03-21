package de.vistahr.generator.passwd.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.vistahr.generator.passwd.model.RootViewModel;
import de.vistahr.generator.passwd.view.component.RootView;

public class ExitListener extends AbstractListener implements ActionListener {

	public ExitListener(RootViewModel m, RootView v) {
		super(m, v);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		view.getMainFrame().close();
	}

}
