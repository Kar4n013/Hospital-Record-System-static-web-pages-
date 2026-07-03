package calcV2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalcUI2 extends OperationsV2 {
	String[] buttons = { "AC", "%", "<-", "/", "1", "2", "3", "+", "4", "5", "6", "-", "7", "8", "9", "*", ".", "0",
			"00", "=" };
	String[] topbuttons = { "AC", "=", "<-" };
	String[] rightbuttons = { "/", "+", "-", "*", "%" };

	Font font = new Font("Arial", Font.PLAIN, 30);

	JFrame frame;
	JPanel mainpanel;
	JPanel displaypanel;
	JLabel displaylabel;
	JPanel buttonpanel;
	JButton button;

	public CalcUI2() {
		mainpanel = new JPanel();
		displaypanel = new JPanel();
		buttonpanel = new JPanel();
		displaylabel = new JLabel();
		frame = new JFrame("Calculator");

		displaylabel.setText("0");
		displaylabel.setFont(font);
		displaylabel.setForeground(Color.white);
		displaypanel.setBackground(Color.black);

		displaypanel.add(displaylabel);
		mainpanel.add(displaypanel, BorderLayout.NORTH);
		mainpanel.add(buttonpanel, BorderLayout.CENTER);

		mainpanel.setLayout(new BorderLayout());

		displaypanel.setPreferredSize(new Dimension(0, 80));

		buttonpanel.setLayout(new GridLayout(5, 4, 5, 5));

		mainpanel.add(displaypanel, BorderLayout.NORTH);
		mainpanel.add(buttonpanel, BorderLayout.CENTER);

		frame.add(mainpanel);
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		for (int i = 0; i < buttons.length; i++) {
			button = new JButton();
			buttonpanel.add(button);
			button.setText(buttons[i]);
			button.setName(buttons[i]);
			button.setFont(font);

			button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					JButton jButton = (JButton) e.getSource();
					String buttonvalue = jButton.getText();
					if (Arrays.asList(topbuttons).contains(buttonvalue)
							|| Arrays.asList(rightbuttons).contains(buttonvalue)) {
						displaylabel.setText(manager(displaylabel.getText(), buttonvalue));

					} else if (Arrays.asList(rightbuttons).contains(buttonvalue)) {
						displaylabel.setText(manager(displaylabel.getText(), buttonvalue) + buttonvalue);

					}

					else {
						if (buttonvalue == ".") {
							displaylabel.setText(displaylabel.getText() + buttonvalue);
						} else {
							if (displaylabel.getText().equals("0")) {
								displaylabel.setText(buttonvalue);
							} else
								displaylabel.setText(displaylabel.getText() + buttonvalue);
						}
					}
				}
			});
		}
	}
}
