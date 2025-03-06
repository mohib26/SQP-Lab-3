package com.ontariotechu.sofe3980U;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BinaryTest {

    @Test
    public void testAddition() {
        Binary a = new Binary("101");
        Binary b = new Binary("11");
        assertEquals("1000", Binary.add(a, b).getValue());
    }

    @Test
    public void testMultiplication() {
        Binary a = new Binary("101");
        Binary b = new Binary("11");
        assertEquals("1111", Binary.multiply(a, b).getValue());
    }

    @Test
    public void testBitwiseAnd() {
        Binary binary1 = new Binary("1101");
        Binary binary2 = new Binary("1011");

        // Perform bitwise AND
        Binary result = Binary.and(binary1, binary2);

        // Verify the result is correct
        assertEquals("1001", result.getValue());
    }

    @Test
    public void testBitwiseOr() {
        Binary binary1 = new Binary("1101");
        Binary binary2 = new Binary("1011");

        // Perform bitwise OR
        Binary result = Binary.or(binary1, binary2);

        // Verify the result is correct
        assertEquals("1111", result.getValue());
    }

    @Test
    public void testAdditionWithZero() {
        Binary a = new Binary("0");
        Binary b = new Binary("1010");
        assertEquals("1010", Binary.add(a, b).getValue());
    }

    @Test
    public void testMultiplicationWithZero() {
        Binary a = new Binary("0");
        Binary b = new Binary("1010");
        assertEquals("0", Binary.multiply(a, b).getValue());
    }

    @Test
    public void testMultiplicationWithOne() {
        Binary a = new Binary("1");
        Binary b = new Binary("1010");
        assertEquals("1010", Binary.multiply(a, b).getValue());
    }

    @Test
    public void testBitwiseAndWithZero() {
        Binary a = new Binary("0");
        Binary b = new Binary("1010");
        assertEquals("0", Binary.and(a, b).getValue());
    }

    @Test
    public void testBitwiseOrWithZero() {
        Binary a = new Binary("0");
        Binary b = new Binary("1010");
        assertEquals("1010", Binary.or(a, b).getValue());
    }

    @Test
    public void testLargeBinaryNumbers() {
        Binary a = new Binary("110110101011");
        Binary b = new Binary("101101110011");
        assertEquals("1100100011110", Binary.add(a, b).getValue());
    }



    @Test(expected = IllegalArgumentException.class)
    public void testInvalidBinaryInput() {
        new Binary("abc"); // Expect an exception for non-binary string
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddWithInvalidInput() {
        Binary a = new Binary("101");
        Binary b = new Binary("abc");
        Binary.add(a, b); // Should throw exception due to invalid operand
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMultiplyWithInvalidInput() {
        Binary a = new Binary("101");
        Binary b = new Binary("xyz");
        Binary.multiply(a, b); // Should throw exception due to invalid operand
    }
}
