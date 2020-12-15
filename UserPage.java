package Driver;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;import java.io.IOException;
public class UserPage extends JFrame implements ItemListener{
	static JComboBox c1;
	public UserPage(){	
		//Color c = new Color(152,230,230);
		getContentPane().setBackground(new Color(91,215,215));
		tools F = new tools();
		F.l1 = new JLabel("E-Governance");
		F.l1.setBounds(300,10,1500,150);
		F.l1.setFont(new Font("sitka", Font.ITALIC,60));
		
		JLabel l = new JLabel("UserMode");
		l.setBounds(400,400,300,200);
		l.setFont(new Font("sitka", Font.ITALIC,30));
		F.b3 = new JButton("PayBills");
		F.b3.setBounds(400,600,250,50);
		F.b3.setFont(new Font("Verdana", Font.ITALIC,20));
		F.b4 = new JButton("Payments");
		F.b4.setBounds(400,730,250,50);		
		F.b4.setFont(new Font("Verdana", Font.ITALIC,20));
		F.b5 = new JButton("Apply Petitions");
		F.b5.setBounds(1000,400,250,50);
		F.b5.setFont(new Font("Verdana", Font.ITALIC,20));
		F.b6 = new JButton("Search Petitions");
		F.b6.setBounds(1000,500,250,50);
		F.b6.setFont(new Font("Verdana", Font.ITALIC,20));
		F.b7 = new JButton("Search Services");
		F.b7.setBounds(1000,600,250,50);
		F.b7.setFont(new Font("Verdana", Font.ITALIC,20));
		F.b8 = new JButton("Search Information");
		F.b8.setBounds(1000,730,250,50);
		F.b8.setFont(new Font("Verdana", Font.ITALIC,20));
		add(F.l1);  
		add(l);
		add(F.b4); add(F.b3);add(F.b4);add(l); add(F.b5);add(F.b6);add(l);add(F.b7);add(F.b8);add(l);		 
		setSize(5000,5000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true); 
		F.b3.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) 
            { 
                new Actions.PayBills();
            } 
        });
		F.b4.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) 
            { 
                new Actions.Payments_History();
            } 
        }); 
		F.b6.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) 
            { 
                new Actions.Search_Petitions();
            } 
        }); 
		F.b5.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) 
            { 
                new Actions.Apply_Petitions();
            } 
        }); 
		F.b8.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) 
            { 
                new Actions.Search_Information();
            } 
        }); 
		F.b7.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) 
            { 
                new Actions.Search_Services();
            } 
        }); 

}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {		
		// TODO Auto-generated method stub
		new UserPage();
	}
}
