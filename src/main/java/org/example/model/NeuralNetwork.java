package org.example.model;

import org.example.observer.NetworkObserver;
import org.example.state.ConstructionState;
import org.example.state.NetworkState;

import java.util.ArrayList;
import java.util.List;

public class NeuralNetwork {

    private final List<Layer> layers = new ArrayList<>();
    private final List<NetworkObserver> observers = new ArrayList<>();
    private NetworkState state = new ConstructionState();

    // ---------- State ----------
    public void setState(NetworkState state) {
        this.state = state;
        System.out.println("Nouvel état : " + state.getName());
        notifyObservers();
    }

    public void train() {
        state.train(this);
    }

    public void fit(double[][] inputs, double[][] expectedOutputs) {
        state.fit(this, inputs, expectedOutputs);
    }

    public double[] predict(double[] input) {
        return state.predict(this, input);
    }

    // ---------- Opérations internes appelées par les états ----------
    public void runTraining() {
        // Algorithme d'apprentissage (ex. rétropropagation)
        System.out.println("Entraînement en cours...");
    }

    public void executeFit(double[][] inputs, double[][] expectedOutputs) {
        // Logique de fitting du réseau
        System.out.println("Fitting en cours...");
    }

    public double[] forward(double[] input) {
        double[] result = input;
        for (Layer layer : layers) {
            result = layer.forward(result);
        }
        return result;
    }

    // ---------- Construction ----------
    public void addLayer(Layer layer) {
        layers.add(layer);
    }

    public List<Layer> getLayers() {
        return layers;
    }

    // ---------- Observer ----------
    public void addObserver(NetworkObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(NetworkObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (NetworkObserver observer : observers) {
            observer.update(state.getName());
        }
    }
}