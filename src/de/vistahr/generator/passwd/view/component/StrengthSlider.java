package de.vistahr.generator.passwd.view.component;

import java.util.Hashtable;

import javax.swing.JLabel;
import javax.swing.JSlider;

public class StrengthSlider extends JSlider {

	
	public StrengthSlider(int orientation, int min, int max, int value) {
		super(orientation, min, max, value);
		
		setMajorTickSpacing(max/2);
		setPaintTicks(true);
		setPaintLabels(true);
		
		// sliderlabels
		Hashtable<Integer, JLabel> sldLengthLabelTable = new Hashtable<Integer, JLabel>();
		sldLengthLabelTable.put(new Integer(1), new JLabel("Low"));
		sldLengthLabelTable.put(new Integer(max/2), new JLabel("Middle"));
		sldLengthLabelTable.put(new Integer(max), new JLabel("High"));
		setLabelTable(sldLengthLabelTable);
	}
	
}
