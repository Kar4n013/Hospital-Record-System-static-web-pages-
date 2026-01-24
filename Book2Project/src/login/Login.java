package login;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import db.GetConnection;
import master.Master;

@SuppressWarnings("serial")
public class Login extends JFrame {
	JLabel label1, label2;
	JTextField field1, field2;
	JButton button1, button2;

	public Login() {

		setLayout(new FlowLayout(FlowLayout.CENTER, 20, 15));
		label1 = new JLabel("Username");
		label2 = new JLabel("password");

		field1 = new JTextField(20);
		field2 = new JTextField(20);

		button1 = new JButton("Submit");
		button2 = new JButton("Reset");

		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					PreparedStatement statement = GetConnection.getConnection()
							.prepareStatement("select * from users where name = (?) and password = (?)");
					statement.setString(1, field1.getText());
					statement.setString(2, field2.getText());
					ResultSet resultSet = statement.executeQuery();
					if (resultSet.next()) {
						System.out.println("Logged in");
						new Master();
					} else {
						System.err.println("Wrong username or password...");
					}

				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				field1.setText("");
				field2.setText("");
			}
		});

		add(label1);
		add(field1);
		add(label2);
		add(field2);
		add(button1);
		add(button2);

		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Login();
	}

}
