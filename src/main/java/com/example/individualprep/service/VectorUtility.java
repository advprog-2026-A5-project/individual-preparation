package com.example.individualprep.service;

import org.springframework.stereotype.Service;

@Service
public class VectorUtility {
    
    public double[] add(double[] v1, double[] v2) {
        // TODO: Implement me properly!
        return new double[] { 0.0, 0.0, 0.0 };
    }

    public double[] subtract(double[] v1, double[] v2) {
        // Validasi ukuran v1 dan v2
        if (v1.length != v2.length) {
            throw new IllegalArgumentException("Panjang vektor harus sama");
        }
        double[] result = new double[v1.length];

        // Pemrosesan substraction
        for (int i = 0; i < v1.length; i++) {
            result[i] = v1[i] - v2[i];
        }

        return result;
    }

    public double[] multiply(double[] v1, int x) {
        double[] result = new double[v1.length];
        for (int i = 0; i < v1.length; i++){
            result[i] = v1[i] * x;
        }
        return result;
    }
    
    public double dotProduct(double[] v1, double[] v2) {
        double result = 0.0;
        for (int i = 0; i < v1.length; i++) {
            result += v1[i] * v2[i];
        }
        return result;
    }
    
    public double norm(double[] v1) {
        // TODO: Implement me properly!
        return 0.0;
    }
}