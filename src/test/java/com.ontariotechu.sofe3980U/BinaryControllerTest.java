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
    public void getDefault() throws Exception {
        this.mvc.perform(get("/")) // Testing the default page load
                .andExpect(status().isOk())
                .andExpect(view().name("calculator"))
                .andExpect(model().attribute("operand1", ""))
                .andExpect(model().attribute("operand1Focused", false));
    }

    @Test
    public void getParameter() throws Exception {
        this.mvc.perform(get("/").param("operand1", "111")) // Testing with parameter "operand1"
                .andExpect(status().isOk())
                .andExpect(view().name("calculator"))
                .andExpect(model().attribute("operand1", "111"))
                .andExpect(model().attribute("operand1Focused", true));
    }

    @Test
    public void postParameter() throws Exception {
        this.mvc.perform(post("/").param("operand1", "111").param("operator", "+").param("operand2", "111")) // Adding two binary numbers
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1110"))  // Expected result for binary addition
                .andExpect(model().attribute("operand1", "111"));
    }

    @Test
    public void testMultiplication() throws Exception {
        this.mvc.perform(post("/").param("operand1", "111").param("operator", "*").param("operand2", "11")) // Multiplying binary numbers
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "10101"));  // Expected result for multiplication
    }

    @Test
    public void testInvalidInputHandling() throws Exception {
        // Test case for invalid input (non-binary input for operand2)
        this.mvc.perform(post("/").param("operand1", "1101").param("operator", "+").param("operand2", "abc"))
                .andExpect(status().isOk())
                .andExpect(view().name("error"))
                .andExpect(model().attribute("errorMessage", "Invalid input: operand2 must be a binary number.")); // Make sure error message is set
    }

    @Test
    public void testLargeBinaryAddition() throws Exception {
        this.mvc.perform(post("/").param("operand1", "110110101011").param("operator", "+").param("operand2", "101101110011"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1100100011110"));  // Expected result for large binary addition
    }
}
