/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

public class Stand {
    private String id;
    private double precio;

    public Stand(String id, double precio) {
        this.id = id;
        this.precio = precio;
    }

    public String getId() { return id; }
    public double getPrecio() { return precio; }
    @Override public String toString() { return id + " ($" + precio + ")"; }
}