package org.example.decorator;

import org.example.model.Layer;
import org.example.model.Neuron;

import java.util.List;

public class NormalizationDecorator extends LayerDecorator {

    public NormalizationDecorator(Layer layer) {
        super(layer);
    }

    @Override
    public double[] forward(double[] input) {
        super.forward(input);
        System.out.println("Application de la normalisation...");

        List<Neuron> neurons = getNeurons();
        double max = neurons.stream()
                .mapToDouble(n -> Math.abs(n.getOutput()))
                .max()
                .orElse(1.0);

        if (max != 0) {
            for (Neuron n : neurons) {
                n.setOutput(n.getOutput() / max);
            }
        }
        return neurons.stream().mapToDouble(Neuron::getOutput).toArray();
    }
}