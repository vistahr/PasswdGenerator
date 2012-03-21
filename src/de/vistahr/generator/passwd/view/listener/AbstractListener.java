package de.vistahr.generator.passwd.view.listener;

import de.vistahr.generator.passwd.model.PasswdViewModel;
import de.vistahr.generator.passwd.view.PasswdRootView;

public abstract class AbstractListener {

	protected PasswdRootView view;
	protected PasswdViewModel model;
	
	
	public AbstractListener(PasswdViewModel m, PasswdRootView v) {
		view = v;
		model = m;
	}
	
	
}
