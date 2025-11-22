package main;

import view.MegaferiaView;

public class App {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new MegaferiaView().setVisible(true);
        });
    }
}