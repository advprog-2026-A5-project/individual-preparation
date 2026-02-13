package com.example.individualprep.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class VectorUtilityTest {

    @InjectMocks
    VectorUtility vectorUtility;

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

}
