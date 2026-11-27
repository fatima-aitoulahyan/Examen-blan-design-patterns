package org.example.state;

import org.example.model.NeuralNetwork;

public class TrainedState implements NetworkState{
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
        return network.forward(input);   // et non network.predict (boucle infinie)
    }

    @Override
    public String getName() { return "TRAINED"; }
}
