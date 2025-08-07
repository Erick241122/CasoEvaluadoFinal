/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel;

public class Habitacion {

    private int numero;
    private String estado;  // Libre, Ocupada, Sucia
    private String tipo;    // Simple, Doble, etc.
    private double precio;  // Precio por noche

    
    //Constructor para crear una habitacion
     
    public Habitacion(int numero, String estado, String tipo, double precio) {
        this.numero = numero;
        this.estado = estado;
        this.tipo = tipo;
        this.precio = precio;
    }

   
    public int getNumero() { return numero; }
    public String getEstado() { return estado; }
    public String getTipo() { return tipo; }
    public double getPrecio() { return precio; }

   
    public void setEstado(String estado) { this.estado = estado; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setPrecio(double precio) { this.precio = precio; }

    
    //Muestra la habitación
    
    public String toLinea() {
        return String.format("Hab %d | Estado: %s | Tipo: %s | Precio: $%.2f",
                             numero, estado, tipo, precio);
    }

    @Override
    public String toString() {
        return String.format("Habitación %d\nEstado: %s\nTipo: %s\nPrecio por noche: $%.2f\n",
                             numero, estado, tipo, precio);
    }
}
