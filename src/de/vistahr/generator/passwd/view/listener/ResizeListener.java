package de.vistahr.generator.passwd.view.listener;

import java.awt.Font;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JTextField;

import de.vistahr.generator.passwd.model.PasswdViewModel;
import de.vistahr.generator.passwd.view.PasswdRootView;

public class ResizeListener extends AbstractListener implements ComponentListener {

	
	public ResizeListener(PasswdViewModel m, PasswdRootView v) {
		super(m, v);
	}

	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentResized(ComponentEvent ev) {
		Integer newHeigth = Integer.valueOf(((JTextField)ev.getSource()).getHeight()/2);
		view.getTxtPasswdResult().setFont(new Font(Font.SANS_SERIF, Font.PLAIN, newHeigth));
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub

	}

}
