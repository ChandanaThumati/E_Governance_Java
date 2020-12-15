package Actions;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Payments_History extends JFrame{
	public Payments_History() {
		JTable t;
		Connection c = null;
		Statement stmt = null;
		getContentPane().setBackground(new Color(91,215,215));
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/E-Governance", "postgres", "encrypt");
	         c.setAutoCommit(false);
	         stmt = c.createStatement();
	         ResultSet rs = stmt.executeQuery("select * from Bills;");
	         String[][] data = new String[50][50];
	         String[] columnNames = {"BillId","Username","Cateogry","Ammount"};
	         int s=0;
	         while ( rs.next() ) {
	        	 int j=0;
		         String id = rs.getString("BillId");
		         data[s][j] = id;
		         j++;
		         String  u = rs.getString("Username");
		         data[s][j] = u;
		         j++;
		         String x = rs.getString("Cateogry");
		         data[s][j] =x;
		         j++;
		         String y = rs.getString("Ammount");
		         data[s][j] = y;
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

