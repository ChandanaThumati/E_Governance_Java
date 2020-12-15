package Actions;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Apply_Petitions extends JFrame implements ItemListener {
	static JComboBox c1;
	Connection c = null;
	Statement stmt = null; 
	public void Insert(String title,String sub,String description) throws SQLException
	{
		PreparedStatement sql =c.prepareStatement( "insert into Petitions values (?,?,?);" );
		sql.setString(1,title);
		sql.setString(2,sub);
		sql.setString(3,description);
		sql.executeUpdate();
	    c.commit();
	    System.out.println( "inserted" );
	}
	public Apply_Petitions() {
		Driver.tools  u = new Driver.tools ();
		JLabel l = new JLabel();
		getContentPane().setBackground(new Color(91,215,215));
		u.l1 = new JLabel("Apply Petitions");
		u.l1.setBounds(400,10,1500,100);
		u.l1.setFont(new Font("Verdana", Font.PLAIN,80));
		u.l2 = new JLabel("Title");
		u.l2.setBounds(300,200,300,200);
		u.l2.setFont(new Font("Verdana", Font.PLAIN,30));
		u.l3 = new JLabel("Category");
		u.l3.setBounds(300,300,300,200);
		u.l3.setFont(new Font("Verdana", Font.PLAIN,30));
		u.l4 = new JLabel("Description");
		u.l4.setBounds(300,400,300,200);
		u.l4.setFont(new Font("Verdana", Font.PLAIN,30));
		u.t1 = new JTextField();
		u.t1.setBounds(520,280,300,35);
		Font font = new Font("Verdana", Font.PLAIN,20);		 		 
		u.t1.setFont(font);	
		u.t3 = new JTextField();
		u.t3.setBounds(520,480,300,35);
		u.t3.setFont(font);
		String s1[] = { "Education", "Safety", "Welfare"}; 
		c1 = new JComboBox(s1); 
		c1.setBounds(500,380,300,35);
        c1.addItemListener(this);
        u.b4 = new JButton("Create");
		u.b4.setBounds(900,600,250,50);		
		u.b4.setFont(new Font("Verdana", Font.BOLD,20));
		add(u.l1);
		add(u.l2); add(u.t1);
		add(u.l3); add(c1);
		add(u.l4); add(u.t3); add(u.b4); add(l);
		setSize(5000,5000);
		setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		u.b4.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) 
            { 
            	if (e.getSource() == u.b4) {
        	     String title = u.t1.getText();
      	         String sub = c1.getSelectedItem().toString(); 
      	         String description = u.t3.getText();
      	         
        		try {
        			  Class.forName("org.postgresql.Driver");
        	   	         c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/E-Governance", "postgres", "encrypt");
        	   	         
        		         c.setAutoCommit(false);
        		         System.out.println("Opened database successfully");
        		     
        		 	         
        		 	      Insert(title,sub,description);
        		 	     new Driver.UserPage();
          	     
        		}
        		catch (Exception e1) {       			 
                    System.out.println(e1.getMessage());         
                } finally {        
                    try {
                        if (stmt != null) {
                            stmt.close();
                        }         
                        if (c != null) {
                            c.close();
                        }                                          
                    } catch (Exception g) {
                        System.out.println(g.getMessage());
                    }
         
                }
            	}
            }
        }); 
		
	}
	public void itemStateChanged(ItemEvent e) 
    { 
        if (e.getSource() == c1) { 
  
            //l1.setText(c1.getSelectedItem() + " selected"); 
        } 
    }
	
}
