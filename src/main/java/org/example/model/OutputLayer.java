package org.example.model;

public class OutputLayer extends Layer{
    @Override
    public double[] forward(double[] input) {
        return computeOutputs();
    }
}
