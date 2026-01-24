package menuItems;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import db.GetConnection;

@SuppressWarnings("serial")
public class Doctor extends JFrame {
	JTable table;
	DefaultTableModel defaultTableModel;

	JLabel label1, label2, label3, label4;
	JTextField field1, field2, field3, field4;
	JButton button1, button2;

	public void doctor_info() {
		setSize(500, 500);
		setLayout(new FlowLayout());
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		String[] columns = { "name", "specialization", "phone", "email" };

		defaultTableModel = new DefaultTableModel(columns, 0);

		table = new JTable(defaultTableModel);

		try {
			Statement statement = db.GetConnection.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery("select * from doctor_info");
			while (resultSet.next()) {
				String name = resultSet.getString("name"), specialization = resultSet.getString("specialization"),
						phone = resultSet.getString("phone"), email = resultSet.getString("email");
				defaultTableModel.addRow(new Object[] { name, specialization, phone, email });
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			db.GetConnection.getConnection().close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		add(new JScrollPane(table));
	}

	public void insertDoctor() {
		setSize(300, 300);
		setLayout(new FlowLayout());
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		label1 = new JLabel("Name: ");
		label2 = new JLabel("specialization: ");
		label3 = new JLabel("phone: ");
		label4 = new JLabel("email: ");

		field1 = new JTextField(30);
		field2 = new JTextField(30);
		field3 = new JTextField(30);
		field4 = new JTextField(30);

		button1 = new JButton("Submit");
		button2 = new JButton("Reset");

		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PreparedStatement statement;
				try {
					statement = GetConnection.getConnection()
							.prepareStatement("insert into doctor_info values (?,?,?,?)");
					statement.setString(1, field1.getText());
					statement.setString(2, field2.getText());
					statement.setString(3, field3.getText());
					statement.setString(4, field4.getText());
					statement.execute();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
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
		add(label3);
		add(field3);
		add(label4);
		add(field4);
		add(button1);
		add(button2);

	}
	
	public void doctor_accounts() {
		
	}
}
