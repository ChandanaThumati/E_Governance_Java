package Actions;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Search_Information extends JFrame{
	public Search_Information() {
		JTable t;
		Connection c = null;
		Statement stmt = null;
		getContentPane().setBackground(new Color(91,215,215));
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/E-Governance", "postgres", "encrypt");
	         c.setAutoCommit(false);
	         stmt = c.createStatement();
	         ResultSet rs = stmt.executeQuery("select * from govt_information;");
	         String[][] data = new String[50][50];
	         String[] columnNames = {"information_id","information_name","information_type","information_description"};
	         int s=0;
	         while ( rs.next() ) {
	        	 int j=0;
		         String id = rs.getString("information_id");
		         data[s][j] = id;
		         j++;
		         String  u = rs.getString("information_name");
		         data[s][j] = u;
		         j++;
		         String  y = rs.getString("information_type");
		         data[s][j] = y;
		         j++;
		         String x = rs.getString("information_description");
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

