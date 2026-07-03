package menuItems;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.net.URI;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class Home extends JFrame {

	public void aboutUs() {
		setSize(800, 800);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		JTextArea area = new JTextArea();
		area.setEditable(false);

		area.setFont(new Font("Arial", Font.PLAIN, 15));

		area.setText("ABC MULTI-SPECIALITY HOSPITAL\n\n" + "Established: 2010\n\n"
				+ "We are committed to providing high-quality healthcare services "
				+ "with modern medical facilities and experienced doctors.\n\n" + "Departments:\n"
				+ "- General Medicine\n" + "- Cardiology\n" + "- Neurology\n" + "- Pediatrics\n" + "- Orthopedics\n\n"
				+ "Facilities:\n" + "- 24/7 Emergency Services\n" + "- Advanced Diagnostic Labs\n"
				+ "- ICU & Operation Theatres\n" + "- Pharmacy & Ambulance Services\n\n" + "Contact:\n"
				+ "Phone: +91-XXXXXXXXXX\n" + "Email: info@abchospital.com\n\n" + "© 2026 ABC Hospital");

		JScrollPane jScrollPane = new JScrollPane(area);
		add(jScrollPane, CENTER_ALIGNMENT);
	}

	public void services() {
		setSize(800, 800);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);

		String rows[][] = {
			    { "Blood Sugar Test", "Diabetes check", "150" },
			    { "Blood Pressure", "BP monitoring", "100" },
			    { "ECG", "Heart checkup", "500" },
			    { "X-Ray", "Radiology service", "800" },
			    { "MRI Scan", "Advanced imaging", "3500" },
			    { "CT Scan", "Detailed body scan", "2500" },
			    { "Blood Test", "Complete blood count", "300" },
			    { "Urine Test", "Urine analysis", "200" }
			};

			String column[] = { "Services", "Description", "Cost" };

			JTable table = new JTable(rows, column);
			table.setFont(new Font("Arial", Font.PLAIN, 15));
			table.setRowHeight(25);

			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setPreferredSize(new Dimension(480, 300));

			add(scrollPane);
	}
	
	public void locate() {
	    try {
	        Desktop.getDesktop().browse(
	            new URI("https://www.google.com/maps/search/ABC+Hospital+Mumbai")
	        );
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
