import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddPane {

	JPanel addp;
	JLabel idl,namel,desigl,sall;
	JTextField idt,namet,desigt,salt;
	JButton ok;
	
	public AddPane() {
		addp = new JPanel();
		idl = new JLabel("ID   :  ");
		namel = new JLabel("Name   :  ");
		desigl = new JLabel("Designation  :  ");
	    sall = new JLabel("Salary   :  ");
		idt = new JTextField();
		namet = new JTextField();
		desigt = new JTextField();
		salt = new JTextField();
		ok = new JButton("ADD");
		addp.setLayout(null);
		addp.add(idl);
		idl.setBounds(400, 60, 200, 60);
		idl.setHorizontalAlignment(JTextField.RIGHT);
		idl.setFont(new Font("Verdana",Font.ITALIC,25));
		addp.add(namel);
		namel.setBounds(400, 120, 200, 60);
		namel.setHorizontalAlignment(JTextField.RIGHT);
		namel.setFont(new Font("Verdana",Font.ITALIC,25));
		addp.add(desigl);
		desigl.setBounds(400, 180, 200, 60);
		desigl.setHorizontalAlignment(JTextField.RIGHT);
		desigl.setFont(new Font("Verdana",Font.ITALIC,25));
		addp.add(sall);
		sall.setBounds(400, 240, 200, 60);
		sall.setHorizontalAlignment(JTextField.RIGHT);
		sall.setFont(new Font("Verdana",Font.ITALIC,25));
		addp.add(idt);
		idt.setBounds(650, 60, 300, 50);
		idt.setHorizontalAlignment(JTextField.CENTER);
		idt.setFont(new Font("Calibri",Font.PLAIN,25));
		addp.add(namet);
		namet.setBounds(650, 120, 300, 50);
		namet.setHorizontalAlignment(JTextField.CENTER);
		namet.setFont(new Font("Calibri",Font.PLAIN,25));
		addp.add(desigt);
		desigt.setBounds(650, 180, 300, 50);
		desigt.setHorizontalAlignment(JTextField.CENTER);
		desigt.setFont(new Font("Calibri",Font.PLAIN,25));
		addp.add(salt);
		salt.setBounds(650, 240, 300, 50);
		salt.setHorizontalAlignment(JTextField.CENTER);
		salt.setFont(new Font("Calibri",Font.PLAIN,25));
		addp.add(ok);
		ok.setBounds(520, 350, 300, 55);
        ok.addActionListener(al->{
            try {
            	MyFrame.e.add(Integer.parseInt(idt.getText()), namet.getText(), desigt.getText(),Integer.parseInt(salt.getText()));
            	JOptionPane.showMessageDialog(MyFrame.splitPane,"Record successfully added!"); 
            	MyFrame.restoreMain();
            } catch(Exception e) {
            	idt.setText("");
            	namet.setText("");
            	desigt.setText("");
            	salt.setText("");
            	JOptionPane.showMessageDialog(addp,"Please enter valid data for all the fields!");
            }
        });
	}
	
	public JPanel getAddPane() {
		return addp;
	}
	
	public void restoreAddPane() {
		MyFrame.splitPane.setDividerLocation(150);
		MyFrame.choosel.setText("ADD RECORDS!");
		MyFrame.splitPane.setBottomComponent(addp);
		idt.setText("");
    	namet.setText("");
    	desigt.setText("");
    	salt.setText("");
	}
	
}
