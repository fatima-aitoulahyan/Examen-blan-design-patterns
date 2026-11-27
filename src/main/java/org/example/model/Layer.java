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

    /** Calcul commun aux couches cachée et de sortie */
    protected double[] computeOutputs() {
        double[] outputs = new double[neurons.size()];
        for (int i = 0; i < neurons.size(); i++) {
            outputs[i] = neurons.get(i).calculate();
        }
        return outputs;
    }
}