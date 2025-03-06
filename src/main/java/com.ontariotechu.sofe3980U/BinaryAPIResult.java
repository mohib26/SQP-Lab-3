package com.ontariotechu.sofe3980U;

public class BinaryAPIResult {
	private String operand1;
	private String operator;
	private String operand2;
	private String result;

	// Constructor converts Binary objects to String values for response
	public BinaryAPIResult(Binary operand1, String operator, Binary operand2, Binary result) {
		this.operand1 = operand1.getValue(); // Converts Binary to its String value
		this.operator = operator;            // Just uses the operator string (add, multiply)
		this.operand2 = operand2.getValue(); // Converts Binary to its String value
		this.result = result.getValue();     // Converts Binary to its String value
	}

	// Getter methods for all fields
	public String getOperand1() {
		return operand1;
	}

	public String getOperator() {
		return operator;
	}

	public String getOperand2() {
		return operand2;
	}

	public String getResult() {
		return result;
	}
}
