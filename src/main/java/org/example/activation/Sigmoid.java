package org.example.activation;

public class Sigmoid implements IActivationFunction{
    @Override
    public double activate(double x) {
        return 1.0 / (1.0 + Math.exp(-x));
    }
}
