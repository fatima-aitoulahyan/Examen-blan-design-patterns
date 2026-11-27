package org.example.state;

import org.example.model.NeuralNetwork;

public class ExecutedState implements NetworkState {

    @Override
    public void train(NeuralNetwork network) {
        network.setState(new TrainingState());
    }

    @Override
    public void fit(NeuralNetwork network,
                    double[][] inputs,
                    double[][] expectedOutputs) {
        network.setState(new FittingState());
        network.executeFit();
        network.setState(new ExecutedState());
    }

    @Override
    public double[] predict(NeuralNetwork network, double[] input) {
        return network.forward(input);
    }

    @Override
    public String getName() {
        return "Executed";
    }
}