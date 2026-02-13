package com.example.individualprep.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ArithmeticUtilityTest {

    @InjectMocks
    ArithmeticUtility arithmeticUtility;

    @Test
    void testArithmeticSubstraction() {
        double operand1 = 256.5;
        double operand2 = 189.5;

        double result = arithmeticUtility.subtract(operand1, operand2);

        assertEquals(67.0, result);
    }

    @Test
    void testArithmeticMultiplication() {
        double operand1 = 100.0;
        double operand2 = 25.0;

        double result = arithmeticUtility.multiply(operand1, operand2);

        assertEquals(2500, result);
    }
  
    @Test
    void testArithmeticExponent() {
        double operand1 = 9.0;
        int n = 3;

        double operand2 = 2;
        int n2 = -2;

        double result = arithmeticUtility.exponent(operand1, n);
        double result2 = arithmeticUtility.exponent(operand2, n2);

        assertEquals(729, result);
        assertEquals(0.25, result2);
    }

}
