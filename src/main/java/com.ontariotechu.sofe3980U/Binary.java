package com.ontariotechu.sofe3980U;

import java.math.BigInteger;

public class Binary {

	private String value;

	// Constructor to create a Binary object from a binary string
	public Binary(String value) {
		if (!value.matches("[01]+")) {
			throw new IllegalArgumentException("Invalid binary input");
		}
		this.value = value;
	}

	// Getter for the binary value
	public String getValue() {
		return value;
	}

	// Add two Binary numbers (updated to handle large binary values)
	public static Binary add(Binary num1, Binary num2) {
		// Ensure both numbers are of equal length by padding the shorter one with leading zeros
		int maxLength = Math.max(num1.getValue().length(), num2.getValue().length());
		String paddedNum1 = String.format("%" + maxLength + "s", num1.getValue()).replace(' ', '0');
		String paddedNum2 = String.format("%" + maxLength + "s", num2.getValue()).replace(' ', '0');

		// Debugging output: Check the padded values
		System.out.println("Padded Operand 1: " + paddedNum1);
		System.out.println("Padded Operand 2: " + paddedNum2);

		// Use BigInteger to handle potentially large binary values
		BigInteger bigNum1 = new BigInteger(paddedNum1, 2);
		BigInteger bigNum2 = new BigInteger(paddedNum2, 2);

		// Add the numbers and convert back to binary
		BigInteger sum = bigNum1.add(bigNum2);

		// Trim leading zeros from the sum if necessary
		String result = sum.toString(2);
		if (result.charAt(0) == '0') {
			result = result.substring(1); // Remove leading zero if any
		}

		// Debugging output: Check the sum before returning
		System.out.println("Sum (BigInteger) in binary: " + result);

		return new Binary(result);  // Convert the sum to binary and return as a new Binary object
	}

	// Multiply two Binary numbers (updated to handle large binary values)
	public static Binary multiply(Binary num1, Binary num2) {
		// Convert the binary strings to BigIntegers
		BigInteger bigNum1 = new BigInteger(num1.getValue(), 2);
		BigInteger bigNum2 = new BigInteger(num2.getValue(), 2);

		// Perform multiplication
		BigInteger product = bigNum1.multiply(bigNum2);

		// Debugging output to verify intermediate values
		System.out.println("Operand 1 in decimal: " + bigNum1);
		System.out.println("Operand 2 in decimal: " + bigNum2);
		System.out.println("Product in decimal: " + product);
		System.out.println("Product in binary: " + product.toString(2));

		// Convert back to binary and return
		return new Binary(product.toString(2));
	}

	// Convert a Binary object to its integer value
	public static int toInt(Binary binary) {
		return Integer.parseInt(binary.getValue(), 2);
	}

	// Convert an integer to a Binary object
	public static Binary fromInt(int value) {
		return new Binary(Integer.toBinaryString(value));
	}

	// Perform bitwise AND operation on two Binary numbers
	public static Binary and(Binary num1, Binary num2) {
		int intNum1 = toInt(num1);
		int intNum2 = toInt(num2);
		int result = intNum1 & intNum2;
		return fromInt(result);
	}

	// Perform bitwise OR operation on two Binary numbers
	public static Binary or(Binary num1, Binary num2) {
		int intNum1 = toInt(num1);
		int intNum2 = toInt(num2);
		int result = intNum1 | intNum2;
		return fromInt(result);
	}
}
