package Actions;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Register extends JFrame implements ActionListener{
	Container container=getContentPane();
	JLabel userLabel=new JLabel("USERNAME");
    JLabel passwordLabel=new JLabel("PASSWORD");
    JTextField userTextField=new JTextField();
    JPasswordField passwordField=new JPasswordField();
    JLabel emailLabel=new JLabel("E-mail");
    JTextField emailTextField=new JTextField();
    JButton resetButton=new JButton("RESET");
    JButton registerButton=new JButton("REGISTER");
    JCheckBox showPassword=new JCheckBox("Show Password");
    private Statement stmt = null;
	private Connection c = null;
	private ResultSet rs = null;
	void Insert(String Username,String Password,String email) throws SQLException
	{
		PreparedStatement sql =c.prepareStatement( "insert into Users values (?,?,?);" );
		sql.setString(1,Username);
		sql.setString(2,Password);
		sql.setString(3,email);
		sql.executeUpdate();
	    c.commit();
	    System.out.println( "inserted" );
	}
	public Register()
    {
    	setTitle("Register Form");
        setVisible(true);
        setBounds(100,100,370,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }
	   public void setLocationAndSize()
	   {
	       //Setting location and Size of each components using setBounds() method.
	       userLabel.setBounds(50,150,100,30);
	       passwordLabel.setBounds(50,220,100,30);
	       emailLabel.setBounds(50,290,100,30);
	       userTextField.setBounds(150,150,150,30);
	       passwordField.setBounds(150,220,150,30);
	       emailTextField.setBounds(150,300,150,30);
	       showPassword.setBounds(150,360,150,30);
	       registerButton.setBounds(50,450,100,30);
	       resetButton.setBounds(200,450,100,30);
	 
	 
	   }
	   public void addComponentsToContainer()
	   {
	      //Adding each components to the Container
	       container.add(userLabel);
	       container.add(passwordLabel);
	       container.add(emailLabel);
	       
	       container.add(userTextField);
	       container.add(passwordField);
	       container.add(emailTextField);
	       
	       container.add(showPassword);
	       container.add(registerButton);
	       container.add(resetButton);
	   }
	 
    public void setLayoutManager()
    {
        //Setting layout manager of Container to null
        container.setLayout(null);
    }
    public void addActionEvent()
    {
       //adding Action listener to components
        registerButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == registerButton) {
            String userText;
            String pwdText,email;
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            email=emailTextField.getText();

   		 try 
   		 {
   	         Class.forName("org.postgresql.Driver");
   	         c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/E-Governance", "postgres", "encrypt");
   	         
	         c.setAutoCommit(false);
	         System.out.println("Opened database successfully");
	 	      Insert(userText,pwdText,email);
	 	     JOptionPane.showMessageDialog(this, "Registered Successful");
	 	      new Driver.UserPage();
 
        }
		 catch (Exception ex) 
		 {
	         ex.printStackTrace();
	         System.err.println(ex.getClass().getName()+": "+ex.getMessage());
	         System.exit(0);
	     }
   		finally {        
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
		else {
            JOptionPane.showMessageDialog(this, "Fill all blanks");
        }
        //Coding Part of RESET button
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
       //Coding Part of showPassword JCheckBox
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
 
 
        }
        
	}
		
	
	public static void main(String[] args) {
    Register frame = new Register();
}

}
