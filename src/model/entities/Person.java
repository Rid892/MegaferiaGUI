/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

public class Person {
    private String id, nombre, apellido;
    private String tipo; // "Autor", "Gerente", "Narrador"

    public Person(String id, String nombre, String apellido, String tipo) {
        this.id = id; this.nombre = nombre; this.apellido = apellido; this.tipo = tipo;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getTipo() { return tipo; }
    @Override public String toString() { return nombre + " " + apellido + " (" + tipo + ")"; }
}