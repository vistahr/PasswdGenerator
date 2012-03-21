/**
 * 
 * 	Copyright 2012 Vince. All rights reserved.
 * 	
 * 	Redistribution and use in source and binary forms, with or without modification, are
 * 	permitted provided that the following conditions are met:
 * 	
 * 	   1. Redistributions of source code must retain the above copyright notice, this list of
 * 	      conditions and the following disclaimer.
 * 	
 * 	   2. Redistributions in binary form must reproduce the above copyright notice, this list
 * 	      of conditions and the following disclaimer in the documentation and/or other materials
 * 	      provided with the distribution.
 * 	
 * 	THIS SOFTWARE IS PROVIDED BY Vince ``AS IS'' AND ANY EXPRESS OR IMPLIED
 * 	WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * 	FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL Vince OR
 * 	CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * 	CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * 	SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * 	ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * 	NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * 	ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 	
 * 	The views and conclusions contained in the software and documentation are those of the
 * 	authors and should not be interpreted as representing official policies, either expressed
 * 	or implied, of Vince.
 */
package de.vistahr.generator.passwd.controller;

import de.vistahr.generator.passwd.model.RootViewModel;
import de.vistahr.generator.passwd.view.components.RootView;
import de.vistahr.generator.passwd.view.listener.AboutListener;
import de.vistahr.generator.passwd.view.listener.AlphaLCListener;
import de.vistahr.generator.passwd.view.listener.AlphaUCListener;
import de.vistahr.generator.passwd.view.listener.ChangeLengthListener;
import de.vistahr.generator.passwd.view.listener.CopyListener;
import de.vistahr.generator.passwd.view.listener.ExitListener;
import de.vistahr.generator.passwd.view.listener.GenerateListener;
import de.vistahr.generator.passwd.view.listener.RootWindowListener;
import de.vistahr.generator.passwd.view.listener.NumericListener;
import de.vistahr.generator.passwd.view.listener.ResizeListener;
import de.vistahr.generator.passwd.view.listener.SpecialKeyListener;


public class RootController {
	
	private RootViewModel model;
	private RootView view;

	
	public RootController(RootViewModel m, RootView v) {
		model = m;
		view = v;
		
		addListeners();
		initData();	
		initStatus();
	}
	
	
	private void initData() {
		// init componentdata
		model.setLength(6);
		model.setPassword("");
		// set all boxes checked
		model.setChkAlphaLC(true);
		model.setChkAlphaUC(true);
		model.setChkNumeric(true);
		model.setChkSpecial(true);
	}
	
	private void initStatus() {
		// focus to generate button
		view.getBtnGenerate().requestFocus();
	}
	
	
	private void addListeners() {
		view.getBtnGenerate().addActionListener(new GenerateListener(model, view));
		view.getBtnCopy().addActionListener(new CopyListener(model, view));
		view.getSldLength().addChangeListener(new ChangeLengthListener(model, view));
		view.getTxtPasswdResult().addComponentListener(new ResizeListener(model, view));
		view.getChkAlphaLC().addChangeListener(new AlphaLCListener(model, view));
		view.getChkAlphaUC().addChangeListener(new AlphaUCListener(model, view));
		view.getChkNumeric().addChangeListener(new NumericListener(model, view));
		view.getChkSepcialKeys().addChangeListener(new SpecialKeyListener(model, view));
		view.getMainMenu().getExitItem().addActionListener(new ExitListener(model, view));
		view.getMainMenu().getCopyItem().addActionListener(new CopyListener(model, view));
		view.getMainMenu().getGenerateItem().addActionListener(new GenerateListener(model, view));
		view.getMainMenu().getAboutItem().addActionListener(new AboutListener(model, view));
		view.getMainFrame().addWindowListener(new RootWindowListener(model, view));
	}
	



}
