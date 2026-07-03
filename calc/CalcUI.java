package calc;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalcUI {
	JFrame frame;
	JPanel jPanel;
	JLabel displaylabel;
	JPanel displaypannel;
	JLabel label;
	
	JButton button, button1, button2, button3, button4, button5, button6, button7, button8, button9, add, subtract,
			multiply, divide, equals, clear;

	public CalcUI() {
		frame = new JFrame();	
		jPanel = new JPanel();
		jPanel.setLayout(null);
		label = new JLabel("Calculator");
		jPanel.add(label);

		displaypannel = new JPanel();
		displaylabel = new JLabel();
		displaylabel.setFont(new Font("Arial", Font.PLAIN, 24));
		displaylabel.setText("0");
		displaylabel.setForeground(Color.WHITE);
		displaypannel.add(displaylabel);

		displaypannel.setBackground(Color.BLACK);
		displaypannel.setForeground(Color.white);
		displaypannel.setBounds(200, 20, 400, 60);
		jPanel.add(displaypannel);

		button = new JButton();
		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		button4 = new JButton();
		button5 = new JButton();
		button6 = new JButton();
		button7 = new JButton();
		button8 = new JButton();
		button9 = new JButton();
		add = new JButton();
		subtract = new JButton();
		multiply = new JButton();
		divide = new JButton();
		equals = new JButton();
		clear = new JButton();

		JButton[] buttons = { button1, button2, button3, clear, button4, button5, button6, add, button7, button8,
				button9, subtract, divide, button, multiply, equals };

		int u = 100, v = 100, fixer = 0;
		for (int i = 0; i < buttons.length; i++) {
			if (i == 4 || i == 8 || i == 12) {
				u = 100;
				v += 100;
				fixer--;
			}
			buttons[i].setText(Integer.toString(i + fixer + 1));
			u += 100;
			buttons[i].setBounds(u, v, 100, 100);
			// System.out.println(i + " at " + u + " " + v);
			jPanel.add(buttons[i]);
		}
		button.setText("0");
		add.setText("+");
		subtract.setText("-");
		multiply.setText("*");
		divide.setText("/");
		equals.setText("=");
		clear.setText("AC");

		frame.add(jPanel);
		frame.setVisible(true);
		frame.setSize(800, 800);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
//	public static void main(String[] args) {
//		new CalcUI();
//	}
}
