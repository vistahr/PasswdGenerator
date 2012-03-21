package de.vistahr.generator.passwd.view.listener;

import de.vistahr.generator.passwd.model.RootViewModel;
import de.vistahr.generator.passwd.view.components.RootView;

public abstract class AbstractListener {

	protected RootView view;
	protected RootViewModel model;
	
	
	public AbstractListener(RootViewModel m, RootView v) {
		view = v;
		model = m;
	}
	
	
}
