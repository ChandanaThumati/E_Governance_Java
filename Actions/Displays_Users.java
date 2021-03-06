package Actions;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Displays_Users extends JFrame{
	public Displays_Users() {
		JTable t;
		Connection c = null;
		Statement stmt = null;
		getContentPane().setBackground(new Color(91,215,215));
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/E-Governance", "postgres", "encrypt");
	         c.setAutoCommit(false);
	         stmt = c.createStatement();
	         ResultSet rs = stmt.executeQuery("select * from Users;");
	         String[][] data = new String[50][50];
	         String[] columnNames = {"Username","Password","Email"};
	         int s=0;
	         while ( rs.next() ) {
	        	 int j=0;
		         String id = rs.getString("Username");
		         data[s][j] = id;
		         j++;
		         String  u = rs.getString("Password");
		         data[s][j] = u;
		         j++;
		         String x = rs.getString("Email");
		         data[s][j] =x;
		         j=0;
		         s++;
		            
		         }
	         	t = new JTable(data,columnNames);
				t.setRowHeight(23);
				t.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
				t.setEnabled(false);
				t.getTableHeader().setFont(new Font("SansSerif", Font.PLAIN,18));
				JScrollPane sp = new JScrollPane(t); 
			    add(sp); 
			    setSize(3000,3000);
			    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				setVisible(true);
		         rs.close();
		         stmt.close();
		         c.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	      }
	}
}

