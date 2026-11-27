package org.example;

import org.example.activation.Identity;
import org.example.activation.Sigmoid;
import org.example.adapter.ActivationAdapter;
import org.example.adapter.OldSigmoid;
import org.example.decorator.NormalizationDecorator;
import org.example.decorator.StatisticsDecorator;
import org.example.model.*;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random rnd = new Random(42);   // graine fixe : résultats reproductibles

        // ===== 1. Construction du réseau 3 - 5 - 2 =====
        NeuralNetwork nn = new NeuralNetwork();

        // Observer : le dashboard est notifié à chaque changement d'état
        nn.addObserver(new Dashboard());

        InputLayer inputLayer = new InputLayer();
        HiddenLayer hiddenLayer = new HiddenLayer();
        OutputLayer outputLayer = new OutputLayer();

        // Strategy : fonctions d'activation interchangeables
        for (int i = 0; i < 3; i++) {
            inputLayer.addNeuron(new Neuron(0.0, new Identity()));
        }
        for (int i = 0; i < 5; i++) {
            hiddenLayer.addNeuron(new Neuron(0.1, new Sigmoid()));
        }
        // Adapter : ancienne fonction utilisée via la nouvelle interface
        for (int i = 0; i < 2; i++) {
            outputLayer.addNeuron(new Neuron(0.1, new ActivationAdapter(new OldSigmoid())));
        }

        // Réseau entièrement connecté
        connect(inputLayer, hiddenLayer, rnd);
        connect(hiddenLayer, outputLayer, rnd);

        // Decorator : comportement ajouté dynamiquement à la couche cachée
        Layer decoratedHidden =
                new StatisticsDecorator(new NormalizationDecorator(hiddenLayer));

        nn.addLayer(inputLayer);
        nn.addLayer(decoratedHidden);
        nn.addLayer(outputLayer);

        double[] input = {1.0, 0.5, 0.2};

        // ===== 2. Test State : predict interdit en CONSTRUCTION =====
        System.out.println("\n--- Test 1 : predict en état CONSTRUCTION ---");
        try {
            nn.predict(input);
        } catch (IllegalStateException e) {
            System.out.println("Exception attendue : " + e.getMessage());
        }

        // ===== 3. Test State : train puis predict =====
        System.out.println("\n--- Test 2 : train() puis predict() ---");
        nn.train();
        double[] result = nn.predict(input);
        System.out.println("Sortie : " + Arrays.toString(result));

        // ===== 4. Test State : fit puis predict =====
        System.out.println("\n--- Test 3 : fit() puis predict() ---");
        double[][] inputs = {{1, 0.5, 0.2}, {0.1, 0.9, 0.4}};
        double[][] expected = {{1, 0}, {0, 1}};
        nn.fit(inputs, expected);
        System.out.println("Sortie : " + Arrays.toString(nn.predict(input)));

        // ===== 5. Test Strategy : changer la fonction d'activation =====
        System.out.println("\n--- Test 4 : changement de fonction d'activation (Strategy) ---");
        for (Neuron n : outputLayer.getNeurons()) {
            n.setActivation(new Identity());
        }
        System.out.println("Sortie avec Identity : " + Arrays.toString(nn.predict(input)));

        // ===== 6. Test erreur : dimension d'entrée incorrecte =====
        System.out.println("\n--- Test 5 : dimension d'entrée incorrecte ---");
        try {
            nn.predict(new double[]{1.0, 2.0});
        } catch (IllegalArgumentException e) {
            System.out.println("Exception attendue : " + e.getMessage());
        }
    }

    /** Connecte chaque neurone de 'from' à chaque neurone de 'to' avec un poids aléatoire dans [0,1]. */
    private static void connect(Layer from, Layer to, Random rnd) {
        for (Neuron source : from.getNeurons()) {
            for (Neuron destination : to.getNeurons()) {
                source.connectTo(destination, rnd.nextDouble());
            }
        }
    }
}