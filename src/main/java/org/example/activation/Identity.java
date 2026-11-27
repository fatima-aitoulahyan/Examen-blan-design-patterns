package org.example.activation;

public class Identity implements IActivationFunction{
    @Override
    public double activate(double x) {
        return x;
    }
}
