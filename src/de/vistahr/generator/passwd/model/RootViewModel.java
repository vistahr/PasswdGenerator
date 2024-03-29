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
package de.vistahr.generator.passwd.model;

import java.util.Observable;

public class RootViewModel extends Observable {

	private String password;
	private int length;
	
	private boolean chkAlphaLC;
	private boolean chkAlphaUC;
	private boolean chkSpecial;
	private boolean chkNumeric;
	
	
	public RootViewModel(String p, int l) {
		password = p;
		length = l;
	}
	
	
	public String getPassword() {
		return password;
	}
	
	public int getLength() {
		return length;
	}
		
	
	
	public void setPassword(String p) {
		password = new String(p);
		setChanged();
		notifyObservers(this);
	}
	
	public void setLength(int l) {
		// only positive
		if(l <= 0) {
			throw new IllegalArgumentException("Length empty");
		}
		length = l;
		setChanged();
		notifyObservers(this);
	}


	public boolean isChkAlphaLC() {
		return chkAlphaLC;
	}


	public void setChkAlphaLC(boolean chkAlphaLC) {
		this.chkAlphaLC = chkAlphaLC;
		setChanged();
		notifyObservers(this);
	}


	public boolean isChkAlphaUC() {
		return chkAlphaUC;
	}


	public void setChkAlphaUC(boolean chkAlphaUC) {
		this.chkAlphaUC = chkAlphaUC;
		setChanged();
		notifyObservers(this);
	}


	public boolean isChkSpecial() {
		return chkSpecial;
	}


	public void setChkSpecial(boolean chkSpecial) {
		this.chkSpecial = chkSpecial;
		setChanged();
		notifyObservers(this);
	}


	public boolean isChkNumeric() {
		return chkNumeric;
	}


	public void setChkNumeric(boolean chkNumeric) {
		this.chkNumeric = chkNumeric;
		setChanged();
		notifyObservers(this);
	}
	
	
}
