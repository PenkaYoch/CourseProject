package shop.mainPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ShoppingCartDialog extends JDialog{

	private static final long serialVersionUID = 1L;
	private JOptionPane optionPane;
	
	private String okLabel = "Ok";

	public ShoppingCartDialog() {
		
	}

	private void clearAndHide() {
		setVisible(false);
	}
}
