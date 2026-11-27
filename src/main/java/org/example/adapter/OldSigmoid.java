package org.example.adapter;

public class OldSigmoid implements OldActivationFunction{
    @Override
    public double calculate(double x) {
        return 1.0 / (1.0 + Math.exp(-x));
    }
}
