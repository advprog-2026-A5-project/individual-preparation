package com.example.individualprep.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class VectorUtilityTest {

    @InjectMocks
    VectorUtility vectorUtility;

    @Test
    void testVectorAdd() {
        double[] v1 = {3.5, 2.5, 70.0};
        double[] v2 = {4.5, 0.5, 2.0};

        double[] result = vectorUtility.add(v1, v2);

        assertArrayEquals(new double[] {8.0, 3.0, 72.0}, result);
    }

    @Test
    void testVectorAddLengthNotMatch() {
        double[] v1 = {3.5, 2.5, 70.0};
        double[] v2 = {4.5, 0.5};

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            vectorUtility.add(v1, v2);
        });

        assertEquals("vectors lengths do not match", exception.getMessage());
    }

    @Test
    void testVectorAddNull() {
        double[] v1 = {3.5, 2.5, 70.0};
        double[] v2 = null;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            vectorUtility.add(v1, v2);
        });

        assertEquals("Vector cannot be null", exception.getMessage());
    }

    @Test
    void testVectorDotProduct() {
        double[] v1 = {1.5, 2.0, 50.0};
        double[] v2 = {2, 0.5, 0.1};

        double result = vectorUtility.dotProduct(v1, v2);

        assertEquals(9, result);
    }

    @Test
    void testVectorDotProductEmpty() {
        double[] v1 = {};
        double[] v2 = {};

        double result = vectorUtility.dotProduct(v1, v2);

        assertEquals(0.0, result);
    }

    @Test
    void testVectorSubtract() {
        double[] v1 = {5.5, 4.0, 10.0};
        double[] v2 = {2.5, 1.0, 3.0};

        double[] result = vectorUtility.subtract(v1, v2);

        assertArrayEquals(new double[] {3.0, 3.0, 7.0}, result);
    }

    @Test
    void testVectorSubtractLengthNotMatch() {
        double[] v1 = {1.0, 2.0};
        double[] v2 = {1.0, 2.0, 3.0};

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            vectorUtility.subtract(v1, v2);
        });

        assertEquals("Panjang vektor harus sama", exception.getMessage());
    }
}
