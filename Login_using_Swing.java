import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Login
{
	public static void main(String args[])
	{
		JFrame f = new JFrame("LOGIN");
		JLabel l = new JLabel("Login");
		l.setBounds(160,5,50,20);
		JLabel l1 = new JLabel("ID:");
		l1.setBounds(64,49,76,14);                 
		JTextField t = new JTextField();
		t.setBounds(150,46,86,20);		
		JLabel l2 = new JLabel("Password:");
		l2.setBounds(64,75,76,14);
		JPasswordField p = new JPasswordField();
		p.setBounds(150,72,86,20);
		JButton b = new JButton("Login");
		b.setBounds(150,117,76,34);
		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/balaji?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select id,password from bal");
				while (rs.next())
				{
					if(Integer.parseInt(t.getText()) == rs.getInt(1))
					{	if(p.getText() == rs.getString(2))
						{
							t.setText("Successfully Logged in");
						}
						else
						{
							t.setText("Invalid Password");
							p.setText("");
					}	}
					else
					{
						t.setText("Invalid Id or password");
						p.setText("");
					}
						
				}
				
				con.close();
			}catch(Exception ex)
				{
					System.out.println("Error : "+ex);
				}
			}
		});
		f.add(l);				
		f.add(l1);
		f.add(t);
		f.add(l2);
		f.add(p);
		f.add(b);
		f.setSize(400,400);
		f.setLayout(null);
		f.setVisible(true); 	
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}
