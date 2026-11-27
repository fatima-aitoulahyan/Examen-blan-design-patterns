package org.example.adapter;

import org.example.activation.IActivationFunction;

public class ActivationAdapter implements IActivationFunction {
    private OldActivationFunction oldFunction;
    public ActivationAdapter(OldActivationFunction oldFunction) {
        this.oldFunction = oldFunction;
    }
    @Override
    public double activate(double x) {
        return oldFunction.calculate(x);
    }
}
