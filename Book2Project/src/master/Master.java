package master;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import menuItems.Doctor;
import menuItems.Home;
import menuItems.Patient;

@SuppressWarnings("serial")
public class Master extends JFrame {
	JMenuBar bar;
	JMenu menu1, menu2, menu3, menu4;
	JMenuItem item1, item2, item3, item4;
	JMenuItem item2_1, item2_2, item2_3, item2_4;
	JMenuItem item3_1, item3_2, item3_3;
	JMenuItem item4_1, item4_2, item4_3;
	
	Home home = new Home();
	Doctor doctor = new Doctor();
	Patient patient = new Patient();


	public Master() {
		setSize(500, 500);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		bar = new JMenuBar();
		setJMenuBar(bar);

		setVisible(true);

		menu1 = new JMenu("Home");
		menu2 = new JMenu("Doctor");
		menu3 = new JMenu("Patient");
		menu4 = new JMenu("Accounts");

		bar.add(menu1);
		bar.add(menu2);
		bar.add(menu3);
		bar.add(menu4);

		item1 = new JMenuItem("About Us");
		item2 = new JMenuItem("Services");
		item3 = new JMenuItem("Location");
		item4 = new JMenuItem("Exit");

		menu1.add(item1);
		menu1.add(item2);
		menu1.add(item3);
		menu1.add(item4);

		item1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("About Us is running");
				home.aboutUs();
			}
		});

		item2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Services is running");
				home.services();
			}
		});

		item3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Location is running");
				home.locate();
			}
		});

		item4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Exit is running");
				dispose();
			}
		});

		item2_1 = new JMenuItem("Doctor Info");
		item2_2 = new JMenuItem("Doctor Registration");
		item2_3 = new JMenuItem("Accounts");

		menu2.add(item2_1);
		menu2.add(item2_2);
		menu2.add(item2_3);

		item2_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				doctor.doctor_info();
			}
		});

		item2_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				doctor.insertDoctor();
			}
		});

		item3_1 = new JMenuItem("Patient Details");
		item3_2 = new JMenuItem("Billing");
		item3_3 = new JMenuItem("Registration");
		

		menu3.add(item3_1);
		menu3.add(item3_2);
		menu3.add(item3_3);
		
		item3_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				patient.patient_info();
			}
		});
		
		item3_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				patient.patient_insert();
			}
		});

		item4_1 = new JMenuItem("GST");
		item4_2 = new JMenuItem("NGO Accounts");
		item4_3 = new JMenuItem("Payement Details");

		menu4.add(item4_1);
		menu4.add(item4_2);
		menu4.add(item4_3);

		add(bar);

		Font menuFont = new Font("Arial", Font.PLAIN, 18);

		JMenuBar bar = new JMenuBar();
		bar.setFont(menuFont);

		JMenu fileMenu = new JMenu("Master");
		fileMenu.setFont(menuFont);

		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.setFont(menuFont);

		fileMenu.add(exitItem);
		bar.add(fileMenu);

		setJMenuBar(bar);

	}

}
