package main;

import view.MegaferiaView;
import javax.swing.*;

public class App {
    public static void main(String[] args) {
        try { UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatDarkLaf()); }
        catch (Exception e) { e.printStackTrace(); }
        
        SwingUtilities.invokeLater(() -> {
            new MegaferiaView().setVisible(true);
        });
    }
}