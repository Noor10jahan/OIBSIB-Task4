package onlinetest;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class Submit extends JFrame implements ActionListener {
	String username;
	JButton startTest;

	
	
	Submit(String username) {
		this.username=username;
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel heading= new JLabel("Welcome!"+username+" to java quize" );
		heading.setBounds(50, 20, 700, 30);
		heading.setFont(new Font("Italian",Font.BOLD,30));
		heading.setForeground(Color.BLACK);
		add(heading);
		startTest=new JButton("Start Test");
		startTest.setBounds(450, 280, 120, 30);
		startTest.setBackground(Color.CYAN);
		startTest.setForeground(Color.black);
		startTest.addActionListener(this);
		add(startTest);
		
		
		setSize(800,650);
		setLocation(300,100);
		setVisible(true);

	}
		
		public static void main(String[] args) {
			new Submit("user");
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==startTest){
				setVisible(false);
				new StartTest("StartTest");
			}
		}
}
