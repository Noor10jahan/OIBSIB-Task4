package onlinetest;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {
	JButton submit,back;
	JTextField tfield,txfield;
	
	Login(){
		getContentPane().setBackground(Color.WHITE);
		JLabel jl=new JLabel();
		setLayout(null);
		
		JLabel heading= new JLabel("Online Quize");
		heading.setBounds(400, 60, 300, 45);
		heading.setFont(new Font("Italian",Font.BOLD,40));
		heading.setForeground(Color.BLUE);
		add(heading);
		
		JLabel name= new JLabel("Login");
		name.setBounds(500, 150, 300, 45);
		name.setFont(new Font("Mangolian Baiti",Font.BOLD,20));
		name.setForeground(Color.black);
		add(name);
		
		JLabel username=new JLabel("Username");
		username.setBounds(380, 200, 300, 20);
		add(username);
		 tfield=new JTextField();
		tfield.setBounds(450, 200, 250, 25);
		tfield.setFont(new Font("Times new roman",Font.BOLD,20));
		add(tfield);
		
		JLabel password=new JLabel("Password");
		password.setBounds(380, 250, 300, 20);
		add(password);
		 txfield=new JTextField();
		txfield.setBounds(450, 250, 250, 25);
		txfield.setFont(new Font("Times new roman",Font.BOLD,20));
		add(txfield);
		
		 submit=new JButton("Submit");
		submit.setBounds(450, 280, 120, 30);
		submit.setBackground(Color.CYAN);
		submit.setForeground(Color.black);
		submit.addActionListener(this);
		add(submit);
		
		 back=new JButton("Back");
		back.setBounds(600, 280, 120, 30);
		back.setBackground(Color.CYAN);
		back.setForeground(Color.black);
		back.addActionListener(this);
		add(back);
		
		jl.setBounds(0, 0, 600, 500);
		setSize(1200,500);
		setLocation(200, 150);
		setVisible(true);
	}
	
	
 public static void main(String[] args) {
	new Login();
}


@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==submit){
		String username=tfield.getText();
		setVisible(false);
	new Submit("Noor");
	}else if(e.getSource()==back){
		setVisible(false); //to came back
	}
}
}
