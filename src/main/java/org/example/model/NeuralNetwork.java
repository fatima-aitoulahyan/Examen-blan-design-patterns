package org.example.model;

import org.example.state.ConstructionState;
import org.example.state.NetworkState;

import java.util.ArrayList;
import java.util.List;

public class NeuralNetwork {

    private List<Layer> layers = new ArrayList<>();

    private NetworkState state =
            new ConstructionState();

    public void setState(NetworkState state) {
        this.state = state;
        System.out.println(
                "Nouvel état : " + state.getName()
        );
    }

    public void train() {
        state.train(this);
    }

    public void fit(double[][] inputs,
                    double[][] expectedOutputs) {

        state.fit(this, inputs, expectedOutputs);
    }

    public double[] predict(double[] input) {
        return state.predict(this, input);
    }

    public void trainModel(double[][] inputs,
                           double[][] expectedOutputs) {

        // Algorithme d'apprentissage
        // Exemple : Backpropagation
    }

    public double[] forward(double[] input) {

        double[] result = input;

        for (Layer layer : layers) {
            result = layer.forward(result);
        }

        return result;
    }

    public void addLayer(Layer layer) {
        layers.add(layer);
    }
    public void executeFit() {
        // Logique de fitting du réseau
    }
}