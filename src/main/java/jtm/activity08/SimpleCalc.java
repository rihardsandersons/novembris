package jtm.activity08;

// implement basic mathematical operations with int numbers in range
// of [-10..+10] (including)
// Note that:
// 1. input range is checked using assertions (so if they are disabled, inputs can be any int)
// 2. outputs are always checked and exception is thrown if it is outside proper range

public class SimpleCalc {

	public static int add(int a, int b) throws SimpleCalcException {
		validateInput(a, b);
		return validateOutput(a, b, "+");
	}

	public static int subtract(int a, int b) throws SimpleCalcException {
		validateInput(a, b);
		return validateOutput(a, b, "-");
	}

	public static int multiply(int a, int b) throws SimpleCalcException {
		validateInput(a, b);
		return validateOutput(a, b, "*");
	}

	public static int divide(int a, int b) throws SimpleCalcException {
		validateInput(a, b);
		return validateOutput(a, b, "/");
	}

	private static void validateInput(int a, int b) {
		if (a < -10 && b < -10) {
			assert false : "input value a: " + a + " is below -10 and b: " + b + " is below -10";
		}
		if (a > 10 && b < -10) {
			assert false : "input value a: " + a + " is above 10 and b: " + b + " is below -10";
		}
		if (a < -10 && b > 10) {
			assert false : "input value a: " + a + " is below -10 and b: " + b + " is above 10";
		}
		if (a > 10 && b > 10) {
			assert false : "input value a: " + a + " is above 10 and b: " + b + " is above 10";
		}

		assert !(a < -10) : "input value a: " + a + " is below -10";
		assert !(a > 10) : "input value a: " + a + " is above 10";
		assert !(b < -10) : "input value b: " + b + " is below -10";
		assert !(b > 10) : "input value b: " + b + " is above 10";

	}

	private static String printOutputString(String operation, String aboveOrBelow, int a, int b) {
		int result = 0;
		String returnCalc = "";
		if (operation == "+") {
			result = a + b;
		}
		if (operation == "-") {
			result = a - b;
		}
		if (operation == "*") {
			result = a * b;
		}
		if (operation == "/") {
			result = a / b;
		}
		if (aboveOrBelow == "above") {
			returnCalc = "output value " + a + " " + operation + " " + b + " = " + result + " is above 10";

		} else if (aboveOrBelow == "below") {
			returnCalc = "output value " + a + " " + operation + " " + b + " = " + result + " is below -10";

		}

		return returnCalc;
	}

	private static int validateOutput(int a, int b, String operation) throws SimpleCalcException {
		if (operation == "+") {
			if (a + b > 10) {
				throw new SimpleCalcException(printOutputString("+", "above", a, b));

			} else if (a + b < -10) {
				throw new SimpleCalcException(printOutputString("+", "below", a, b));
			} else {
				return a + b;
			}
		}

		if (operation == "-") {
			if (a - b > 10) {
				throw new SimpleCalcException(printOutputString("-", "above", a, b));

			} else if (a - b < -10) {
				throw new SimpleCalcException(printOutputString("-", "below", a, b));
			} else {
				return a - b;
			}
		}

		if (operation == "*") {
			if (a * b > 10) {
				throw new SimpleCalcException(printOutputString("*", "above", a, b));

			} else if (a * b < -10) {
				throw new SimpleCalcException(printOutputString("*", "below", a, b));

			} else {
				return a * b;
			}
		}

		if (operation == "/") {
			int result;
			try {
				result = a / b;
			} catch (Exception e) {
				throw new SimpleCalcException("division by zero", e);
			}

			if (a / b > 10) {
				throw new SimpleCalcException(printOutputString("/", "above", a, b));

			} else if (a / b < -10) {
				throw new SimpleCalcException(printOutputString("/", "below", a, b));

			}

			return result;
		}

		return 0;
	}

}
