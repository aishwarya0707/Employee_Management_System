import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame{

    static JSplitPane splitPane; 
    static JPanel bottomPanel,topPanel;                
    static JButton button,addb,modb,delb,showb,exit;
    static JLabel choosel;
    static SerializableEmployee e;
    static AddPane addp;
    static ModPane modp;
    static DelPane delp;

    public MyFrame(){
    	try {
			e = new SerializableEmployee();
			addp = new AddPane();
			modp = new ModPane();
			delp = new DelPane();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	setTitle("Employee Records");
        setDefaultCloseOperation(EXIT_ON_CLOSE);  
        setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height)); 
    	splitPane = new JSplitPane();
        add(splitPane);
    	splitPane.setLayout(new GridLayout()); 
    	splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);  
        splitPane.setDividerLocation(150);             
    	addb = new JButton("Add a Record");
  		modb = new JButton("Modify a Record");
  		delb = new JButton("Delete a Record");
  		showb = new JButton("Show all Records");
        button = new JButton("EXIT"); 
        topPanel = new JPanel(); 
        splitPane.setTopComponent(topPanel);
        topPanel.setBackground(Color.LIGHT_GRAY);
        topPanel.setLayout(null);
  		choosel = new JLabel();
  		choosel.setText("CHOOSE ONE!");
  		choosel.setHorizontalAlignment(JTextField.CENTER);
    	choosel.setFont(new Font("Viner Hand ITC",Font.BOLD,34));
    	choosel.setBounds(0, 0,Toolkit.getDefaultToolkit().getScreenSize().width, 150);
    	topPanel.add(choosel);
        bottomPanel = new JPanel();
      	splitPane.setBottomComponent(bottomPanel);
        bottomPanel.setLayout(null); 
        bottomPanel.add(addb);
        bottomPanel.add(modb);
        bottomPanel.add(delb);
        bottomPanel.add(showb);
        bottomPanel.add(button);
        addb.setBounds(180, 100, 400, 60);
        modb.setBounds(800, 100, 400, 60);
        delb.setBounds(180, 250, 400, 60);
        showb.setBounds(800, 250, 400, 60);  
        button.setBounds(520, 400, 350, 55);
        addb.addActionListener(al->addp.restoreAddPane());
        modb.addActionListener(al->modp.restoreModPane());
        delb.addActionListener(al->delp.restoreDelPane());
        showb.addActionListener(al->showPane());
        button.addActionListener(al->{
        	JOptionPane.showMessageDialog(splitPane,"Program Exited!");
        	this.dispose();
        });
        pack();
        
    }	 
    public static void showPane() {
    	splitPane.setDividerLocation(150);
    	choosel.setText("ALL RECORDS!");
    	JScrollPane showp = new JScrollPane();
		splitPane.setBottomComponent(showp);
		String [] columns = {"ID","NAME","DESIGNATION","SALARY"};
		JTable tab= new JTable(e.showRecords(),columns);
		showp.setLayout(null);  
		JScrollPane sp = new JScrollPane(tab);
		tab.setRowHeight(50);
		showp.add(sp);
		sp.setBounds(380, 60, 600, 280);
        JButton back = new JButton("BACK");
        showp.add(back);
        back.setBounds(600, 400, 120, 50);
		back.addActionListener(al->restoreMain());
    }
    
    public static void restoreMain() {
        splitPane.setDividerLocation(150);
    	choosel.setText("CHOOSE ONE!");
    	splitPane.setBottomComponent(bottomPanel);
    }
    

    public static void main(String args[]){
        EventQueue.invokeLater(()->new MyFrame().setVisible(true));
    }
}
