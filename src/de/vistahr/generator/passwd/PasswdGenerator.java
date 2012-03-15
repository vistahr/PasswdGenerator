package de.vistahr.generator.passwd;

import de.vistahr.generator.passwd.controller.PasswdController;
import de.vistahr.generator.passwd.model.PasswdViewModel;
import de.vistahr.generator.passwd.model.Password;
import de.vistahr.generator.passwd.view.PasswdView;

public class PasswdGenerator {

	
	
	public static void main(String[] args) {
		PasswdViewModel model = new PasswdViewModel(new Password(""), 0);
		PasswdView view = new PasswdView(model);
		
		new PasswdController(model, view);
	}
	
}
