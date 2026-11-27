package org.example.state;

import org.example.model.NeuralNetwork;

public class TrainedState implements NetworkState{
    @Override
    public void train(NeuralNetwork network) {
        network.setState(new TrainingState());
    }

    @Override
    public void fit(NeuralNetwork network, double[][] inputs, double[][] expectedOutputs) {
        network.setState(new TrainingState());

        network.trainModel(inputs, expectedOutputs);

        network.setState(new TrainedState()

    }

    @Override
    public double[] predict(NeuralNetwork network, double[] input) {
        return network.predict(input);
    }

    @Override
    public String getName() {
        return "TRAINED";
    }
}
