package de.vistahr.generator.passwd.view.listener;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.vistahr.generator.passwd.model.RootViewModel;
import de.vistahr.generator.passwd.view.component.RootView;

public class CopyListener extends AbstractListener implements ActionListener {

	
	public CopyListener(RootViewModel m, RootView v) {
		super(m, v);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(view.getTxtPasswdResult().getText()), null);
	}

}
