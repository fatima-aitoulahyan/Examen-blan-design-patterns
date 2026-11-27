package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class NeuralNetwork {
    private List<Layer> layers = new ArrayList<>();

    public void addLayer(Layer layer) {
        layers.add(layer);
    }

    public double[] predict(double[] input) {

        if (layers.isEmpty()) {
            throw new IllegalStateException(
                    "Le réseau ne contient aucune couche"
            );
        }

        double[] result = input;

        for (Layer layer : layers) {
            result = layer.forward(result);
        }

        return result;
    }

    public List<Layer> getLayers() {
        return layers;
    }
}
