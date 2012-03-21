package de.vistahr.generator.passwd.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.vistahr.generator.passwd.model.RootViewModel;
import de.vistahr.generator.passwd.view.components.AboutDialog;
import de.vistahr.generator.passwd.view.components.RootView;

public class AboutListener extends AbstractListener implements ActionListener {

	public AboutListener(RootViewModel m, RootView v) {
		super(m, v);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		new AboutDialog();
	}

}
