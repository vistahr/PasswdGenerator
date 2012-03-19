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
package de.vistahr.generator.passwd.view.menu;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class PasswdMenu {
	
	// bar
	JMenuBar mainMenu;
	// main menu
	JMenu fileMenu;
	JMenu helpMenu;
	//items
	JMenuItem copyItem;
	JMenuItem aboutItem;
	
	
	public JMenuBar getMainMenu() {
		return mainMenu;
	}
	

	public JMenuItem getAboutItem() {
		return aboutItem;
	}


	public JMenuItem getCopyItem() {
		return copyItem;
	}


	public PasswdMenu() {
		mainMenu = new JMenuBar();
		buildMenu();
	}
	
	
	private void buildMenu() {
		// file menu
		fileMenu = new JMenu("File");
		copyItem = new JMenuItem("Copy");
		fileMenu.add(copyItem);
		
		
		// Help menu
		helpMenu = new JMenu("Help");
		//items
		aboutItem = new JMenuItem("About");
		helpMenu.add(aboutItem);
		
		mainMenu.add(fileMenu);
		mainMenu.add(helpMenu);
	}
	
	
}
