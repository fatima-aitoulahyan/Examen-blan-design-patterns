package org.example.model;

public class InputLayer extends Layer {
    @Override
    public double[] forward(double[] input) {
        if (input.length != neurons.size()) {
            throw new IllegalArgumentException("Dimension d'entrée incorrecte");
        }
        for (int i = 0; i < input.length; i++) {
            neurons.get(i).setOutput(input[i]);
        }
        return input;
    }
}