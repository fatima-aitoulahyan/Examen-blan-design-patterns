package org.example.model;

import org.example.activation.IActivationFunction;

import java.util.ArrayList;
import java.util.List;

public class Neuron {

    private double bias;
    private double output;

    private IActivationFunction activation;

    private List<Connection> incomingConnections = new ArrayList<>();

    public Neuron(double bias, IActivationFunction activation) {
        this.bias = bias;
        this.activation = activation;
    }

    public void addConnection(Connection connection) {

        if (connection.getDestination() != this) {
            throw new IllegalArgumentException(
                    "Cette connexion ne cible pas ce neurone"
            );
        }

        incomingConnections.add(connection);
    }

    public void connectTo(Neuron destination, double weight) {

        Connection connection =
                new Connection(this, destination, weight);

        destination.addConnection(connection);
    }

    public double calculate() {

        double sum = bias;

        for (Connection connection : incomingConnections) {

            double x = connection.getSource().getOutput();

            sum += x * connection.getWeight();
        }

        output = activation.activate(sum);

        return output;
    }

    public double getOutput() {
        return output;
    }

    public void setOutput(double output) {
        this.output = output;
    }

    public void setActivation(IActivationFunction activation) {
        this.activation = activation;
    }

    public double getBias() {
        return bias;
    }
}