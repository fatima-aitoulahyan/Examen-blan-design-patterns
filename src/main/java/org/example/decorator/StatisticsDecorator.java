package org.example.decorator;

import org.example.model.Layer;
import org.example.model.Neuron;

import java.util.List;

public class StatisticsDecorator extends LayerDecorator {

    public StatisticsDecorator(Layer layer) {
        super(layer);
    }

    @Override
    public double[] forward(double[] input) {
        double[] result = super.forward(input);

        List<Neuron> neurons = getNeurons();
        double average = neurons.stream()
                .mapToDouble(Neuron::getOutput)
                .average()
                .orElse(0);

        System.out.println("Moyenne des sorties : " + average);
        return result;
    }
}