package de.vistahr.generator.passwd.view.listener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import de.vistahr.generator.passwd.model.RootViewModel;
import de.vistahr.generator.passwd.view.component.MessageDialog;
import de.vistahr.generator.passwd.view.component.RootView;

public class ChangeLengthListener extends AbstractListener implements ChangeListener {

	public ChangeLengthListener(RootViewModel m, RootView v) {
		super(m, v);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		Integer length = model.getLength();
		try {
			length = Integer.valueOf(view.getSldLength().getValue());
			
		} catch(NumberFormatException ex) {
			new MessageDialog("invalid length data");
		}
		model.setLength(length);
	}

}
