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
public class BinaryAPIControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testAPI_Addition() throws Exception {
        this.mvc.perform(get("/binaryAPI?operand1=1101&operator=+&operand2=1011"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value("11000"));  // Expected sum of 1101 + 1011
    }

    @Test
    public void testAPI_BitwiseAnd() throws Exception {
        this.mvc.perform(get("/binaryAPI?operand1=1101&operator=&&operand2=1011"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value("1001"));  // Expected AND result
    }

    @Test
    public void testAPI_BitwiseOr() throws Exception {
        this.mvc.perform(get("/binaryAPI?operand1=1101&operator=|&operand2=1011"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value("1111"));  // Expected OR result
    }

    @Test
    public void testAPI_Multiplication() throws Exception {
        this.mvc.perform(get("/binaryAPI?operand1=1101&operator=*&operand2=10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value("11010"));  // Expected multiplication result
    }

    @Test
    public void testAPI_LargeBinaryAddition() throws Exception {
        this.mvc.perform(get("/binaryAPI?operand1=110110101011&operator=+&operand2=101101110011"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value("1100100011110"));  // Expected result for large binary addition
    }

    @Test
    public void testAPI_LargeBinaryMultiplication() throws Exception {
        this.mvc.perform(get("/binaryAPI?operand1=1010101010101010&operator=*&operand2=10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value("10101010101010100"));  // Expected multiplication result
    }
}
