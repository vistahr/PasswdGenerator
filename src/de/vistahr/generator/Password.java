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
package de.vistahr.generator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;


public class Password {
	
	
	public static String generate(int length, ArrayList<Keys> keys) {
		if(length <= 0) {
			throw new IllegalArgumentException("Non valid length");
		}
		
		StringBuilder password = new StringBuilder();
		
		for(int i=0;i<length;i++) {
			password.append(generateRandomChar(keys));
		}
		
		return password.toString();
	}

	
	public static char generateRandomChar(ArrayList<Keys> keys) {
		Iterator<Keys> iter = keys.iterator();
		
		ArrayList<Integer> totalRands = new ArrayList<Integer>();
		

		while(iter.hasNext()) {
			switch(iter.next()) {
				case ALPHA_LC:
					// >= 97 - 122 <=
					totalRands.add(randomBetween(97,122));
					break;
				case ALPHA_UC:
					// >= 65 - 90 <=
					totalRands.add(randomBetween(65,90));
					break;
				case SPECIAL:
					// >= 33 - 47 <=
					totalRands.add(randomBetween(33,47));
					// >= 58 - 64 <=
					totalRands.add(randomBetween(58,64));
					// >= 91 - 96 <=
					totalRands.add(randomBetween(91,96));
					// >= 123 - 126 <=
					totalRands.add(randomBetween(123,126));
					break;
				case NUMERIC:
					// >= 48 - 57 <=
					totalRands.add(randomBetween(48,57));
					break;
			}
		}
		int tmpIntChar = (int)totalRands.get(randomBetween(0, totalRands.size()-1));
		
		return (char)tmpIntChar;
	}
	
	
	private static int randomBetween(int min, int max) {
		Random rand = new Random();
		 return rand.nextInt(max-min+1)+min;
	}
	
}
