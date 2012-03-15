package de.vistahr.generator.passwd.model;

import java.util.Observable;

import javax.swing.JOptionPane;

public class PasswdViewModel extends Observable {

	private Password password;
	private int length;
	
	
	public Password getPassword() {
		return password;
	}
	
	public int getLength() {
		return length;
	}
	
	
	
	public PasswdViewModel(Password p, int l) {
		password = p;
		length = l;
	}

	
	public void setPassword(String p) {
		password = new Password(p);
		setChanged();
		notifyObservers(this);
	}
	
	public void setLength(int l) {
		if(l == 0) {
			throw new IllegalArgumentException("Length empty");
		}
		length = l;
		setChanged();
		notifyObservers(this);
	}
	
}
