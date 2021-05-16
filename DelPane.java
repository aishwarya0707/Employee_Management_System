import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class DelPane {
	
	JPanel delp,delp1;
	JLabel choicel,oinputl,inputl;
	JButton ok,delb;
	JRadioButton idrb,namerb,desigrb,salrb;
	JTextField oinputt,inputt;
	
	public DelPane() {
		delp = new JPanel();
    	delp1 = new JPanel();
		delp.setLayout(null);  
		choicel = new JLabel("Choose one to delete");
		ok = new JButton("OK");
		delb = new JButton("DELETE");
    	idrb = new JRadioButton("Id");
    	namerb = new JRadioButton("Name");
    	desigrb = new JRadioButton("Designation");
        salrb = new JRadioButton("Salary");
    	inputl = new JLabel();
		inputt = new JTextField();
		delp.add(choicel);
		delp.add(idrb);
		delp.add(namerb);
		delp.add(desigrb);
		delp.add(salrb);
		delp.add(ok);
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
    		if(idrb.isSelected())
    			inputl.setText("Id  :  ");
    		else if(namerb.isSelected())
    			inputl.setText("Name  :  ");
    		else if(desigrb.isSelected())
    			inputl.setText("Designation  :  ");
    		else if(salrb.isSelected())
    			inputl.setText("Salary  :  ");
    		else {
    			JOptionPane.showMessageDialog(delp,"Please select one field!");
    			return;
    		}
    		MyFrame.splitPane.setDividerLocation(150);
    		MyFrame.splitPane.setBottomComponent(delp1);
    		delp1.add(inputl);
    		inputl.setBounds(400, 150, 260, 60);
    		inputl.setHorizontalAlignment(JTextField.RIGHT);
    		inputl.setFont(new Font("Verdana",Font.ITALIC,25));
    		delp1.add(inputt);
    		inputt.setBounds(650, 150, 300, 50);
    		inputt.setHorizontalAlignment(JTextField.CENTER);
    		inputt.setFont(new Font("Calibri",Font.PLAIN,25));
    		delp1.setLayout(null);
    		delp1.add(delb);
    		delb.setBounds(520, 350, 300, 55);
        });
    	delb.addActionListener(al->{
    		boolean res;
    		try {
    		if(idrb.isSelected())
    			res = MyFrame.e.delete(Integer.parseInt(inputt.getText()), null, null, 0, 1);
    		else if(namerb.isSelected()) 
    			res = MyFrame.e.delete(0, inputt.getText(), null, 0, 2);
    		else if(desigrb.isSelected())
    			res = MyFrame.e.delete(0, null,inputt.getText(), 0, 3);
    		else if(salrb.isSelected())
    			res = MyFrame.e.delete(0, null, null, Integer.parseInt(inputt.getText()), 4);
    		else
    			throw new Exception();
    		if(res)
    			JOptionPane.showMessageDialog(delp,"Record successfuly deleted!");
    		else
    			JOptionPane.showMessageDialog(delp,"No such record is found!");
    		MyFrame.restoreMain();
    		}catch(Exception e) {
    			JOptionPane.showMessageDialog(delp,"Please enter valid data for all the fields!");
    		}
    	});
	}
	
	public void restoreDelPane() {
		MyFrame.splitPane.setDividerLocation(150);
		MyFrame.choosel.setText("DELETE RECORDS!");
		MyFrame.splitPane.setBottomComponent(delp);
		idrb.setSelected(false);
		namerb.setSelected(false);
		desigrb.setSelected(false);
		salrb.setSelected(false);
		inputt.setText("");
	}
}
