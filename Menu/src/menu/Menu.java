/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package menu;

import javax.swing.JOptionPane;
import hotel.Hotel;

public class Menu {

    
   
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        int opcion;

        do {
            // Muestra el menu de opciones al usuario
            
            opcion = Integer.parseInt(JOptionPane.showInputDialog("""
                SISTEMA DE GESTIÓN HOTELERA

                1. Ver habitaciones
                2. Modificar habitacion
                3. Ver resumen del hotel
                4. Salir

                Elija una opcion:
                """));

            switch (opcion) {
                case 1 -> hotel.mostrarHabitaciones();
                case 2 -> hotel.modificarHabitacion();
                case 3 -> hotel.resumenHotel();
                case 4 -> JOptionPane.showMessageDialog(null, "Gracias por usar el sistema.");
                default -> JOptionPane.showMessageDialog(null, "Opcion invalida.");
            }

        } while (opcion != 4);
    }
}