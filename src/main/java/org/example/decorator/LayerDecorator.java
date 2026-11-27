package org.example.decorator;

import org.example.model.Layer;
import org.example.model.Neuron;

import java.util.List;

public abstract class LayerDecorator extends Layer {

    protected final Layer decoratedLayer;

    public LayerDecorator(Layer layer) {
        this.decoratedLayer = layer;
    }

    @Override
    public double[] forward(double[] input) {
        return decoratedLayer.forward(input);
    }

    @Override
    public List<Neuron> getNeurons() {
        return decoratedLayer.getNeurons();
    }

    @Override
    public void addNeuron(Neuron neuron) {
        decoratedLayer.addNeuron(neuron);
    }
}