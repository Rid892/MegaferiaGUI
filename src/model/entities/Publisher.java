/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

import java.util.ArrayList;

public class Publisher {
    private String nit, nombre, direccion;
    private Person gerente;
    private ArrayList<Stand> standsComprados = new ArrayList<>();

    public Publisher(String nit, String nombre, String direccion, Person gerente) {
        this.nit = nit; this.nombre = nombre; this.direccion = direccion; this.gerente = gerente;
    }

    // getters y métodos para los stands
    public String getNit() { return nit; }
    public String getNombre() { return nombre; }
    public Person getGerente() { return gerente; }
    public void addStand(Stand s) { standsComprados.add(s); }
    public ArrayList<Stand> getStands() { return standsComprados; }
    @Override public String toString() { return nombre + " - " + nit; }
}