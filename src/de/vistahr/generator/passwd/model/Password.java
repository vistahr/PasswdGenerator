package de.vistahr.generator.passwd.model;

public class Password {

	private String password = "";
	
	public Password(final String p) {
		setPassword(p);
	}
	
	private void setPassword(String p) {
		password = p;
	}
	
	public String output() {
		return password;
	}
	
}
