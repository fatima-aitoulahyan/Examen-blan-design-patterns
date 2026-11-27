package org.example.model;

public class OutputLayer extends Layer{
    @Override
    public double[] forward(double[] input) {

        double[] outputs = new double[neurons.size()];

        for (int i = 0; i < neurons.size(); i++) {
            outputs[i] = neurons.get(i).calculate();
        }

        return outputs;
    }
}
