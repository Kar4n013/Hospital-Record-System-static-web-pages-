package calcV2;

public class OperationsV2 {
	double n1 = 0, n2 = 0, temp = 0, total = 0;
	boolean isnum1 = false, isnum2 = false;
	String final_operator = " ";

	public String manager(String input, String operator) {

		if (operator.equals("<-")) {
			if (input.isBlank()) {
				return input;
			} else {
				return input.substring(0, input.length() - 1);
			}
		}
		if (operator.equals("AC")) {
			n1 = n2 = temp = total = 0;
			isnum1 = isnum2 = false;
			return "0";
		}

		if (!isnum1) {
			n1 = Double.parseDouble(input);
			isnum1 = true;
		} else if (!isnum2) {
			n2 = Double.parseDouble(input);
			isnum2 = true;
		}

		if (isnum2) {

			switch (final_operator) {
			case "+":
				total = n1 + n2;
				break;
			case "-":
				total = n1 - n2;
				break;
			case "*":
				total = n1 * n2;
				break;

			case "/":
				if (n2 == 0) {
					return "Invalid input!!";
				} else {
					total = n1 / n2;
				}
				break;

			case "%":
				if (n2 == 0) {
					return "Invalid input!!";
				} else {
					total = (n1 / n2) * 100;
				}
				break;

			default:
				total = n1;
				break;
			}
		}
		if (operator.equals("=")) {
			if (!isnum2) {
				return input;
			} else {
				n1 = 0;
				isnum1 = false;
				n2 = 0;
				isnum2 = false;
				final_operator = " ";
				return Double.toString(total);

			}

		}

		if (!operator.equals("<-") && !operator.equals("AC")) {
			final_operator = operator;
		}

		return " ";

	}

}
