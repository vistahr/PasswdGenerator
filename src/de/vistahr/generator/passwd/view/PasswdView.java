package de.vistahr.generator.passwd.view;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import de.vistahr.generator.passwd.model.PasswdViewModel;
import edu.cmu.relativelayout.BindingFactory;
import edu.cmu.relativelayout.RelativeConstraints;
import edu.cmu.relativelayout.RelativeLayout;

public class PasswdView implements Observer {

	private JFrame mainFrame;
	private JTextField txtLength;
	private JTextField txtPasswdResult;
	private JButton btnCopy;
	private JButton btnGenerate;
	
	
	public JTextField getTxtLength() {
		return txtLength;
	}


	public JTextField getTxtPasswdResult() {
		return txtPasswdResult;
	}


	public JButton getBtnGenerate() {
		return btnGenerate;
	}


	public PasswdView(Observable model) {
		model.addObserver(this);
		initLayout();
		mainFrame.setVisible(true);
	}
	
	
	private void initLayout() {
		try {
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		
		mainFrame = new JFrame("Passwordgenerator");
		
		// set up components
		BindingFactory bf = new BindingFactory();
		
		txtPasswdResult = new JTextField();
		txtLength = new JTextField(10);
		
		JPanel mainPanel = new JPanel(new RelativeLayout());
		
		JLabel lblPassword = new JLabel("Password:");
		mainPanel.add(lblPassword, new RelativeConstraints(bf.leftEdge(), bf.topEdge()));
		mainPanel.add(txtPasswdResult, new RelativeConstraints(bf.below(lblPassword), bf.leftEdge(), bf.rightEdge()));
		
		JLabel lblLength = new JLabel("Length:");
		mainPanel.add(lblLength, new RelativeConstraints(bf.below(txtPasswdResult), bf.leftEdge()));
		mainPanel.add(txtLength, new RelativeConstraints(bf.below(lblLength), bf.leftEdge()));
		mainPanel.add(btnCopy, new RelativeConstraints(bf.rightEdge()));
		btnCopy.setText("copy");
		
		btnGenerate = new JButton("Generate");
		mainPanel.add(btnGenerate, new RelativeConstraints(bf.bottomEdge(), bf.rightEdge()));
		
		mainFrame.add(mainPanel);
		
		// frame settings
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setPreferredSize(new Dimension(300,150));
		mainFrame.pack();
		mainFrame.setLocationRelativeTo(null);
	}
	
	

	@Override
	public void update(Observable o, Object model) {
		getTxtLength().setText(String.valueOf(((PasswdViewModel)model).getLength()));
		getTxtPasswdResult().setText(((PasswdViewModel)model).getPassword().output());
	}
	

	public void showMessageDialog(String message) {
		JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.WARNING_MESSAGE);
	}
	
	
	
}
