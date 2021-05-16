import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

public class ModPane {
	
	JPanel modp,modp1;
	JLabel choicel,oinputl,inputl;
	JButton ok,modb;
	JRadioButton idrb,namerb,desigrb,salrb;
	JTextField oinputt,inputt;
	
	public ModPane() {
		
		modp = new JPanel();
    	modp1 = new JPanel();
		modp.setLayout(null);
		choicel = new JLabel("Choose one to modify");
		ok = new JButton("OK");
		modb = new JButton("MODIFY");
    	idrb = new JRadioButton("Id");
    	namerb = new JRadioButton("Name");
    	desigrb = new JRadioButton("Designation");
    	salrb = new JRadioButton("Salary");
    	inputl = new JLabel();
		oinputl = new JLabel();
		inputt = new JTextField();
		oinputt = new JTextField();
		modp.add(choicel);
		modp.add(idrb);
		modp.add(namerb);
		modp.add(desigrb);
		modp.add(salrb);
		modp.add(ok);
		choicel.setBounds(550, 75, 500, 30);
		choicel.setFont(new Font("Courier new",Font.PLAIN,25));
		idrb.setBounds(600, 150, 100, 30);
		idrb.setFont(new Font("Calibri",Font.ITALIC,25));
		namerb.setBounds(600, 200, 100, 30);
		namerb.setFont(new Font("Calibri",Font.ITALIC,25));
		desigrb.setBounds(600, 250, 200, 30);
		desigrb.setFont(new Font("Calibri",Font.ITALIC,25));
		salrb.setBounds(600, 300, 100, 30);
		salrb.setFont(new Font("Calibri",Font.ITALIC,25));
		ok.setBounds(600, 375, 120, 45);
    	ok.addActionListener(al->{
    		if(idrb.isSelected()) {
    			oinputl.setText("Old Id  :  ");
    			inputl.setText("New Id  :  ");
    		}
    		else if(namerb.isSelected()) {
    			oinputl.setText("Old Name  :  ");
    			inputl.setText("New Name  :  ");
    		}
    		else if(desigrb.isSelected()) {	
    			oinputl.setText("Old Designation  :  ");
    			inputl.setText("New Designation  :  ");
    		}
    		else if(salrb.isSelected()) {	
    			oinputl.setText("Old Salary  :  ");
    			inputl.setText("New Salary  :  ");
    		}else {
    			JOptionPane.showMessageDialog(modp,"Please select one field!");
    			return;
    		}
    		MyFrame.splitPane.setDividerLocation(150);
    		MyFrame.splitPane.setBottomComponent(modp1);
    		modp1.add(oinputl);
    		oinputl.setBounds(400, 100, 260, 60);
    		oinputl.setHorizontalAlignment(JTextField.RIGHT);
    		oinputl.setFont(new Font("Verdana",Font.ITALIC,25));
    		modp1.add(inputl);
    		inputl.setBounds(400, 200, 260, 60);
    		inputl.setHorizontalAlignment(JTextField.RIGHT);
    		inputl.setFont(new Font("Verdana",Font.ITALIC,25));
    		modp1.add(oinputt);
    		oinputt.setBounds(650, 100, 300, 50);
    		oinputt.setHorizontalAlignment(JTextField.CENTER);
    		oinputt.setFont(new Font("Calibri",Font.PLAIN,25));
    		modp1.add(inputt);
    		inputt.setBounds(650, 200, 300, 50);
    		inputt.setHorizontalAlignment(JTextField.CENTER);
    		inputt.setFont(new Font("Calibri",Font.PLAIN,25));
    		modp1.setLayout(null);
    		modp1.add(modb);
    		modb.setBounds(520, 350, 300, 55);
        });
    	modb.addActionListener(al->{
    		boolean res;
    		try {
    		if(idrb.isSelected())
    			res = MyFrame.e.modify(Integer.parseInt(oinputt.getText()), null, null, 0, Integer.parseInt(inputt.getText()), 1);
    		else if(namerb.isSelected())
    			res = MyFrame.e.modify(0, oinputt.getText(), null, 0,inputt.getText(), 2);
    		else if(desigrb.isSelected())
    			res = MyFrame.e.modify(0, null, oinputt.getText(), 0, inputt.getText(), 3);
    		else if(salrb.isSelected())
    			res = MyFrame.e.modify(0, null, null, Integer.parseInt(oinputt.getText()), Integer.parseInt(inputt.getText()), 4);
    		else 
    			throw new Exception();
    		if(res)
    			JOptionPane.showMessageDialog(modp,"Record successfuly updated!");
    		else
    			JOptionPane.showMessageDialog(modp,"No such record is found!");
    		MyFrame.restoreMain();
    		}catch(Exception e) {
    			JOptionPane.showMessageDialog(modp,"Please enter valid data for all the fields!");
    		}
    	});
	}
	
	public JPanel getModPane() {
		return modp;
	}
	
	public void restoreModPane() {
		MyFrame.splitPane.setDividerLocation(150);
		MyFrame.choosel.setText("MODIFY RECORDS!");
		MyFrame.splitPane.setBottomComponent(modp);
		idrb.setSelected(false);
		namerb.setSelected(false);
		desigrb.setSelected(false);
		salrb.setSelected(false);
		inputt.setText("");
		oinputt.setText("");
	}
}
