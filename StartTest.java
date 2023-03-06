package onlinetest;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.Timer;

public class StartTest extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	JLabel label;
	JRadioButton radioButton[] = new JRadioButton[5];
	JButton btnNext, btnBookmark, btnPrevious;
	ButtonGroup bg; // to add radio buttons
	int count = 0, question = 0, x = 1, y = 1, now = 0; // x, y and now for bookmarks
	int m[] = new int[10];
	
	StartTest(String s) {
		super(s);
		label = new JLabel();
		add(label);
		bg = new ButtonGroup(); // bz to add radiobuttons
		for (int i = 0; i < 5; i++) {
			radioButton[i] = new JRadioButton();
			add(radioButton[i]);
			bg.add(radioButton[i]);
		}
		btnNext = new JButton("Next");
		btnBookmark = new JButton("BookMark");
		btnPrevious = new JButton("Previous");
		btnNext.addActionListener(this);
		btnBookmark.addActionListener(this);

		add(btnNext);
		add(btnBookmark);
		add(btnPrevious);
		set();
		label.setBounds(30, 50, 2000, 50);
		label.setFont(new Font("italian", Font.BOLD, 20));
		radioButton[0].setBounds(50, 90, 250, 40);
		 radioButton[0].setFont(new Font("Italian",Font.PLAIN,18));
		radioButton[1].setBounds(50, 120, 200, 40);
		 radioButton[1].setFont(new Font("Italian",Font.PLAIN,18));
		radioButton[2].setBounds(50, 150, 200, 40);
		 radioButton[2].setFont(new Font("Italian",Font.PLAIN,18));
		radioButton[3].setBounds(50, 180, 200, 40);
		 radioButton[3].setFont(new Font("Italian",Font.PLAIN,18));
		btnNext.setBounds(100, 240, 100, 40);
		btnBookmark.setBounds(270, 240, 100, 40);
		btnPrevious.setBounds(450, 240, 100, 40);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // if i click on the
														// cancel button our
														// jframe will close
		setLayout(null); // it decides location on screen
		setLocation(250, 100);
		setVisible(true); // to visible it must be true
		setSize(1000, 500); // width and height of screen
	}

	// handle all actions based on event
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnNext) {
				if (check())
					count = count + 1;
				question++;
				set();
				if (question == 9) {
					btnNext.setEnabled(false);
					btnBookmark.setText("Result");
				}
			}
			if(e.getSource()==btnPrevious){
				if (check())
					count = count - 1;
				question--;
				set();
				if (question == 0) {
					btnNext.setEnabled(false);
					btnBookmark.setText("Next");
				}
			}
			if (e.getActionCommand().equals("BookMark")) {
				JButton bk = new JButton("BookMark" + x);
				bk.setBounds(700, 30+50*x , 100, 30);
				add(bk);
				bk.addActionListener(this);
				m[x] = question;
				x++;
				question++;
				set();
				if (question == 9)
					btnBookmark.setText("Result");
				setVisible(false);
				setVisible(true);
			}
			for (int i = 0, y = 1; i < x; i++, y++) {
				if (e.getActionCommand().equals("BookMark" + y)) {
					if (check())
						count = count + 1;
					now = question;
					question = m[y];
					set();
					((JButton) e.getSource()).setEnabled(false);
					question = now;
				}
			}

			if (e.getActionCommand().equals("Result")) {
				if (check())
					count = count + 1;
				question++;
				JOptionPane.showMessageDialog(this, "correct answers= " + count);
				System.exit(0);
			}
			
		}
	

	// set question with answer
	void set() {
		radioButton[4].setSelected(true);
		if (question == 0) {
			label.setText("Q1: Which component is used to compile,debug and execute the java program?");
			radioButton[0].setText("JRE");
			radioButton[1].setText("JIT");
			radioButton[2].setText("JDK");
			radioButton[3].setText("JVM");
		}
		if (question == 1) {
			label.setText("Q2: Which of the following is not java feature?");
			radioButton[0].setText("Object-oriented");
			radioButton[1].setText("use of pointers");
			radioButton[2].setText("Portable");
			radioButton[3].setText("Dynamic and Extensible");
		}
		if (question == 2) {
			label.setText("Q3: Which of these cannot be used for a variable in java?");
			radioButton[0].setText("indentifier and keyword");
			radioButton[1].setText("indentifier");
			radioButton[2].setText("keyword");
			radioButton[3].setText("none of the mentioned");
		}
		if (question == 3) {
			label.setText("Q4: What is the extension of java code files?");
			radioButton[0].setText(".js");
			radioButton[1].setText(".java");
			radioButton[2].setText(".class");
			radioButton[3].setText(".txt");
		}
		if (question == 4) {
			label.setText("Q5: Which environment variable is used to set the java path?");
			radioButton[0].setText("Maven_path");
			radioButton[1].setText("JavaPath");
			radioButton[2].setText("Java");
			radioButton[3].setText("Java_Home");
		}
		if (question == 5) {
			label.setText("Q5: Which of the following is not an OOPS concept in java?");
			radioButton[0].setText("Polymorphism");
			radioButton[1].setText("Compilation");
			radioButton[2].setText("Encapsulation");
			radioButton[3].setText("Inheritance");
		}
		if (question == 6) {
			label.setText("Q6: Which is the new method introduced in java 8 to iterate over a collection?");
			radioButton[0].setText("for (String i : StringList)");
			radioButton[1].setText("foreach (String i : StringList)");
			radioButton[2].setText("StringList.forEach()");
			radioButton[3].setText("List.for()");
		}
		if (question == 7) {
			label.setText("Q7: Which of the following option leads to the portability and security of Java?");
			radioButton[0].setText("Bytecode is executed by JVM");
			radioButton[1].setText("The applet makes the Java code secure and portable");
			radioButton[2].setText("Use of exception handling");
			radioButton[3].setText("Dynamic binding between objects");
		}
		if (question == 8) {
			label.setText("Q8: The \u0021 article referred to as a?");
			radioButton[0].setText("Unicode escape sequence");
			radioButton[1].setText("Octal escape");
			radioButton[2].setText("Hexadecimal");
			radioButton[3].setText("Line feed");
		}
		if (question == 9) {
			label.setText(
					"Q9:Evaluate the following Java expression, if x=3, y=5, and z=10: \n ++z + y - y + z + x++ ");
			radioButton[0].setText("24");
			radioButton[1].setText("23");
			radioButton[2].setText("20");
			radioButton[3].setText("25");
		}
		label.setBounds(30, 40, 2000, 50);
		for (int i = 0, j = 0; i <= 90; i += 30, j++)
			radioButton[j].setBounds(50, 80 + i, 600, 20);
	}
	boolean check() {
		if (question == 0) {
			return (radioButton[2].isSelected());
		}
		if (question == 1) {
			return (radioButton[1].isSelected());
		}
		if (question == 2) {
			return (radioButton[2].isSelected());
		}
		if (question == 3) {
			return (radioButton[1].isSelected());
		}
		if (question == 4) {
			return (radioButton[3].isSelected());
		}
		if (question == 5) {
			return (radioButton[1].isSelected());
		}
		if (question == 6) {
			return (radioButton[2].isSelected());
		}
		if (question == 7) {
			return (radioButton[0].isSelected());
		}
		if (question == 8) {
			return (radioButton[0].isSelected());
		}
		if (question == 9) {
			return (radioButton[3].isSelected());
		}
		return false;
	}

	
	public static void main(String[] args) {
		new StartTest("java test");
		
	}
}
