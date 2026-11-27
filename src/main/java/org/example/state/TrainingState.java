package org.example.state;

import org.example.model.NeuralNetwork;

public class TrainingState implements NetworkState{
    @Override
    public void train(NeuralNetwork network) {
        throw new IllegalStateException(
                "Le réseau est déjà en cours d'entraînement."
        );
    }

    @Override
    public void fit(NeuralNetwork network, double[][] inputs, double[][] expectedOutputs) {
        throw new IllegalStateException(
                "L'entraînement est déjà en cours."
        );

    }

    @Override
    public double[] predict(NeuralNetwork network, double[] input) {
        throw new IllegalStateException(
                "Impossible de prédire pendant l'entraînement."
        );
    }

    @Override
    public String getName() {
        return "TRAINING";
    }
}
