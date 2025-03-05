package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@WebMvcTest(BinaryController.class)
public class BinaryControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testAddition() throws Exception {
        this.mvc.perform(post("/").param("operand1", "1101").param("operator", "+").param("operand2", "1011"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "11000"));  // Expected sum of 1101 + 1011
    }

    @Test
    public void testBitwiseAnd() throws Exception {
        this.mvc.perform(post("/").param("operand1", "1101").param("operator", "&").param("operand2", "1011"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1001"));  // Expected result for bitwise AND
    }

    @Test
    public void testBitwiseOr() throws Exception {
        this.mvc.perform(post("/").param("operand1", "1101").param("operator", "|").param("operand2", "1011"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1111"));  // Expected result for bitwise OR
    }

    @Test
    public void testMultiplication() throws Exception {
        this.mvc.perform(post("/").param("operand1", "1101").param("operator", "*").param("operand2", "10"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "11010"));  // Expected result for multiplication
    }

    @Test
    public void testMultiplicationWithZero() throws Exception {
        this.mvc.perform(post("/").param("operand1", "1101").param("operator", "*").param("operand2", "0"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "0"));  // Expected result: anything * 0 is 0
    }

    @Test
    public void testLargeBinaryAddition() throws Exception {
        this.mvc.perform(post("/").param("operand1", "110110101011").param("operator", "+").param("operand2", "101101110011"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1100100011110"));  // Expected result for large binary addition
    }
}
