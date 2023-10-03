package com.concretepage;

import com.conceretepage.CalculatorService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(classes = CalculatorService.class)
@AutoConfigureMockMvc
public class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @InjectMocks
    private CalculatorService calculatorService;
//    @Test
//    public void testAdditions() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/calculator"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().string("4"));
//    }

    @Test
    public void testAddition() throws Exception {
         assertEquals(4, calculatorService.add(2, 2));
    }
    @Test
    public void testSubtraction() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/calculator/subtract?a=4&b=2"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("2"));
    }

    @Test
    public void testMultiplication() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/calculator/multiply?a=2&b=3"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("6"));
    }

}