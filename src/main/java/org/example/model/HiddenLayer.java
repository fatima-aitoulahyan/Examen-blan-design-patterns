package org.example.model;

public class HiddenLayer extends Layer {
    @Override
    public double[] forward(double[] input) {
        return computeOutputs();
    }
}