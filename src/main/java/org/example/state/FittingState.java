package org.example.state;

import org.example.model.NeuralNetwork;

public class FittingState implements NetworkState {

    @Override
    public void train(NeuralNetwork network) {
        throw new IllegalStateException(
                "Le réseau est déjà en cours de fitting."
        );
    }

    @Override
    public void fit(NeuralNetwork network,
                    double[][] inputs,
                    double[][] expectedOutputs) {
        throw new IllegalStateException(
                "Le réseau est déjà en cours de fitting."
        );
    }

    @Override
    public double[] predict(NeuralNetwork network, double[] input) {
        throw new IllegalStateException(
                "Impossible de prédire pendant le fitting."
        );
    }

    @Override
    public String getName() {
        return "Fitting";
    }
}