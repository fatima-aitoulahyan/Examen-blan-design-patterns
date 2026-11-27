package org.example.model;

import org.example.observer.NetworkObserver;

public class Dashboard implements NetworkObserver {

    @Override
    public void update(String state) {
        System.out.println("===== DASHBOARD =====");
        System.out.println("Nouvel état du réseau : " + state);
        System.out.println("=====================");
    }
}
