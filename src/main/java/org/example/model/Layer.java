package org.example.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Layer {

    protected List<Neuron> neurons = new ArrayList<>();

    public void addNeuron(Neuron neuron) {
        neurons.add(neuron);
    }

    public List<Neuron> getNeurons() {
        return neurons;
    }

    public abstract double[] forward(double[] input);
}
