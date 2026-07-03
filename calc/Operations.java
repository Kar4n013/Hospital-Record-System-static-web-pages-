package calc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Operations extends CalcUI {
	boolean isnum1 = false, isnum2 = false;
	int num1 = 0, num2 = 0;
	int temp = 0, total = 0;
	int j = 0;
	char final_operation;

	public void manipulator(char operation) {

		// Store current number
		if (!isnum1) {
			num1 = temp;
			isnum1 = true;
		} else {
			num2 = temp;
			isnum2 = true;
		}

		// Perform calculation only if second number exists
		if (isnum2) {
			switch (final_operation) {
			case '+':
				total = num1 + num2;
				break;

			case '-':
				total = num1 - num2;
				break;

			case '*':
				total = num1 * num2;
				break;

			case '/':
				if (num2 == 0) {
					displaylabel.setText("Cannot divide by 0");
					return;
				}
				total = num1 / num2;
				break;

			default:
				total = num1;
			}

			num1 = total;
			num2 = 0;
			isnum2 = false;
		}

		if (operation == '=') {

			displaylabel.setText(String.valueOf(num1));

			// Ready for next calculation
			total = 0;
			temp = 0;
			final_operation = ' ';
			return;
		}

		final_operation = operation;
		temp = 0;
	}

	public Operations() {
		JButton[] buttons = { button, button1, button2, button3, button4, button5, button6, button7, button8, button9 };
		for (j = 0; j < buttons.length; j++) {
			final int digit = j;
			buttons[j].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					temp = temp * 10 + digit;
					displaylabel.setText(Integer.toString(temp));
				}
			});
		}
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					manipulator('+');
				} catch (ArithmeticException e2) {
					System.err.println("Invalid Input");
				}
			}
		});
		subtract.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					manipulator('-');
				} catch (ArithmeticException e2) {
					System.err.println("Invalid Input");
				}
			}
		});
		multiply.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					manipulator('*');
				} catch (ArithmeticException e2) {
					System.err.println("Invalid Input");
				}
			}
		});
		divide.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					manipulator('/');
				} catch (ArithmeticException e2) {
					System.err.println("Invalid Input");
				}
			}
		});
		equals.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				manipulator('=');
			}
		});
		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				num1 = 0;
				num2 = 0;
				total = 0;
				temp = 0;

				isnum1 = false;
				isnum2 = false;

				final_operation = ' ';

				displaylabel.setText("0");
			}
		});

	}

	public static void main(String[] args) {
		new Operations();
	}
}
