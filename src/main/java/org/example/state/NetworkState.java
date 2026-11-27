package org.example.state;

import org.example.model.NeuralNetwork;

public interface NetworkState {
    void train(NeuralNetwork network);

    void fit(NeuralNetwork network,
             double[][] inputs,
             double[][] expectedOutputs);

    double[] predict(NeuralNetwork network,
                     double[] input);

    String getName();
}
