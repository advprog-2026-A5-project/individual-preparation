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
    void testArithmeticDivision() {
        double operand1 = 20.0;
        double operand2 = 4.0;

        double result = arithmeticUtility.divide(operand1, operand2);

        assertEquals(5.0, result);
    }

    @Test
    void testArithmeticDivisionByZero() {
        double operand1 = 10.0;
        double operand2 = 0.0;

        org.junit.jupiter.api.Assertions.assertThrows(ArithmeticException.class, () -> {
            arithmeticUtility.divide(operand1, operand2);
        }, "Pembagian dengan nol");
    }
}
