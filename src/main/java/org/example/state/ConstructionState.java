package org.example.state;

import org.example.model.NeuralNetwork;

public class ConstructionState implements NetworkState {

    @Override
    public void train(NeuralNetwork network) {
        network.setState(new TrainingState());
        network.runTraining();
        network.setState(new TrainedState());
    }

    @Override
    public void fit(NeuralNetwork network, double[][] inputs, double[][] expectedOutputs) {
        network.setState(new FittingState());
        network.executeFit(inputs, expectedOutputs);
        network.setState(new ExecutedState());
    }

    @Override
    public double[] predict(NeuralNetwork network, double[] input) {
        throw new IllegalStateException("Impossible de prédire : le réseau n'est pas entraîné.");
    }

    @Override
    public String getName() { return "CONSTRUCTION"; }
}