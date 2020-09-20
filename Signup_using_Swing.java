import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Signup_using_Swing
{
	public static void main(String args[])
	{
		JFrame f = new JFrame("Action");
		JLabel sign = new JLabel("Sign Up");
		sign.setBounds(160,10,60,20);
		JTextField t = new JTextField();
		t.setBounds(150,37,100,20);
		JTextField t1 = new JTextField();
		t1.setBounds(150,67,100,20);
		JPasswordField p = new JPasswordField();
		p.setBounds(150,97,100,20);
		JTextField t3 = new JTextField();
		t3.setBounds(150,127,100,20);
		JLabel l = new JLabel("Name:");
		l.setBounds(50,40,60,14);
		JLabel l1 = new JLabel("ID:");
		l1.setBounds(50,70,40,14);
		JLabel p1 = new JLabel("Password:");
		p1.setBounds(50,100,100,14);
		JLabel l3 = new JLabel("Phone:");
		l3.setBounds(50,130,60,14);
		JButton b = new JButton("Sign Up");
		b.setBounds(60,200,90,30);


		
		
		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/balaji?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
				Statement st = (Statement)con.createStatement();
				String q = "insert into bal (name,id,password,phone)"+"values('"+t.getText()+"','"+t1.getText()+"','"+p.getText()+"','"+t3.getText()+"')";
				st.executeUpdate(q);	
				con.close();
				t.setText("");
				t1.setText("");
				p.setText("");
				t3.setText("");
			}catch(Exception ex){
				System.out.println("Error : "+ex);
			}
		}
	});

		f.add(sign);
		f.add(l);
		f.add(t);
		f.add(l1);
		f.add(t1);
		f.add(p1);
		f.add(p);
		f.add(l3);
		f.add(t3);
		f.add(b);
		f.setSize(400,400);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

}
