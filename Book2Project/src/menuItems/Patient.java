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
public class Patient extends JFrame {
	JTable table;
	DefaultTableModel defaultTableModel;
	
	JLabel label1, label2, label3, label4,label5;
	JTextField field1, field2, field3, field4,field5;
	JButton button1, button2;

	public void patient_info() {
		setSize(500, 500);
		setLayout(new FlowLayout());
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		String[] columns = { "name", "age", "bill_amount", "bill_paid", "doctor" };

		defaultTableModel = new DefaultTableModel(columns, 0);

		table = new JTable(defaultTableModel);

		try {
			Statement statement = db.GetConnection.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery("select * from patient");
			while (resultSet.next()) {
				String name = resultSet.getString("name"), age = resultSet.getString("age"),
						bill_amount = resultSet.getString("bill_amount"), bill_paid = resultSet.getString("bill_paid"),doctor = resultSet.getString("doctor");
				defaultTableModel.addRow(new Object[] { name, age, bill_amount, bill_paid, doctor });
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
	
	public void bill_record() {
		setSize(500, 500);
		setLayout(new FlowLayout());
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		String []column = {"Name","Bill_amount","Bill_paid"};
		
		defaultTableModel = new DefaultTableModel(column, 0);

		table = new JTable(defaultTableModel);

		try {
			Statement statement = db.GetConnection.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT name, bill_amount, bill_paid FROM patient");
			while (resultSet.next()) {
				String name = resultSet.getString("name"), 
						bill_amount = resultSet.getString("bill_amount"), bill_paid = resultSet.getString("bill_paid");
				defaultTableModel.addRow(new Object[] { name, bill_amount, bill_paid});
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
	
	
	public void patient_insert() {
		setSize(500, 500);
		setLayout(new FlowLayout());
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		label1 = new JLabel("Name: ");
		label2 = new JLabel("age: ");
		label3 = new JLabel("bill_amount: ");
		label4 = new JLabel("bill_paid: ");
		label5 = new JLabel("doctor: ");

		field1 = new JTextField(50);
		field2 = new JTextField(50);
		field3 = new JTextField(50);
		field4 = new JTextField(50);
		field5 = new JTextField(50);
		

		button1 = new JButton("Submit");
		button2 = new JButton("Reset");

		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PreparedStatement statement;
				try {
					statement = GetConnection.getConnection()
							.prepareStatement("insert into patient values (?,?,?,?,?)");
					statement.setString(1, field1.getText());
					statement.setString(2, field2.getText());
					statement.setString(3, field3.getText());
					statement.setString(4, field4.getText());
					statement.setString(5, field5.getText());
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
		add(label5);
		add(field5);
		add(button1);
		add(button2);

	}
	
	}

