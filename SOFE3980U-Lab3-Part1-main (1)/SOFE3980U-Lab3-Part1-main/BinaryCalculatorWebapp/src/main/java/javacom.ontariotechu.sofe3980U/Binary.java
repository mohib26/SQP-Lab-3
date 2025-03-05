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

    // Add two Binary numbers
    public static Binary add(Binary num1, Binary num2) {
        BigInteger bigNum1 = new BigInteger(num1.getValue(), 2);
        BigInteger bigNum2 = new BigInteger(num2.getValue(), 2);
        BigInteger sum = bigNum1.add(bigNum2);
        return new Binary(sum.toString(2)); // Convert result back to binary string
    }

    // Multiply two Binary numbers
    public static Binary multiply(Binary num1, Binary num2) {
        BigInteger bigNum1 = new BigInteger(num1.getValue(), 2);
        BigInteger bigNum2 = new BigInteger(num2.getValue(), 2);
        BigInteger product = bigNum1.multiply(bigNum2);
        return new Binary(product.toString(2)); // Convert result back to binary string
    }

    // Perform bitwise AND operation on two Binary numbers
    public static Binary and(Binary num1, Binary num2) {
        BigInteger bigNum1 = new BigInteger(num1.getValue(), 2);
        BigInteger bigNum2 = new BigInteger(num2.getValue(), 2);
        BigInteger result = bigNum1.and(bigNum2);
        return new Binary(result.toString(2));
    }

    // Perform bitwise OR operation on two Binary numbers
    public static Binary or(Binary num1, Binary num2) {
        BigInteger bigNum1 = new BigInteger(num1.getValue(), 2);
        BigInteger bigNum2 = new BigInteger(num2.getValue(), 2);
        BigInteger result = bigNum1.or(bigNum2);
        return new Binary(result.toString(2));
    }
}
