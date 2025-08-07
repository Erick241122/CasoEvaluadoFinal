/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel;

import javax.swing.JOptionPane;

public class Hotel {

    
    private Habitacion[][] habitaciones;

    
    //Constructor del hotel
    
    public Hotel() {
        habitaciones = new Habitacion[5][5];

        // Piso 5
        habitaciones[4][0] = new Habitacion(501, "Libre", "Simple", 50);
        habitaciones[4][1] = new Habitacion(502, "Libre", "Doble", 60);
        habitaciones[4][2] = new Habitacion(503, "Libre", "Simple", 40);
        habitaciones[4][3] = new Habitacion(504, "Libre", "Doble", 40);
        habitaciones[4][4] = new Habitacion(505, "Sucia", "Simple", 40);

        // Piso 4
        habitaciones[3][0] = new Habitacion(401, "Ocupada", "Simple", 50);
        habitaciones[3][1] = new Habitacion(402, "Libre", "Doble", 60);
        habitaciones[3][2] = new Habitacion(403, "Libre", "Simple", 40);
        habitaciones[3][3] = new Habitacion(404, "Libre", "Doble", 40);
        habitaciones[3][4] = new Habitacion(405, "Sucia", "Simple", 40);

        // Piso 3
        habitaciones[2][0] = new Habitacion(301, "Sucia", "Doble", 50);
        habitaciones[2][1] = new Habitacion(302, "Libre", "Doble", 60);
        habitaciones[2][2] = new Habitacion(303, "Libre", "Simple", 40);
        habitaciones[2][3] = new Habitacion(304, "Libre", "Doble", 30);
        habitaciones[2][4] = new Habitacion(305, "Sucia", "Simple", 40);

        // Piso 2
        habitaciones[1][0] = new Habitacion(201, "Libre", "Simple", 40);
        habitaciones[1][1] = new Habitacion(202, "Libre", "Doble", 40);
        habitaciones[1][2] = new Habitacion(203, "Libre", "Simple", 40);
        habitaciones[1][3] = new Habitacion(204, "Libre", "Doble", 40);
        habitaciones[1][4] = new Habitacion(205, "Sucia", "Simple", 40);

        // Piso 1
        habitaciones[0][0] = new Habitacion(101, "Libre", "Simple", 30);
        habitaciones[0][1] = new Habitacion(102, "Libre", "Doble", 30);
        habitaciones[0][2] = new Habitacion(103, "Libre", "Simple", 30);
        habitaciones[0][3] = new Habitacion(104, "Libre", "Doble", 30);
        habitaciones[0][4] = new Habitacion(105, "Sucia", "Simple", 40);
    }

    
    //Muestra todas las habitaciones del hotel 
    
    public void mostrarHabitaciones() {
        StringBuilder sb = new StringBuilder();

        for (int piso = habitaciones.length - 1; piso >= 0; piso--) {
            sb.append("Piso ").append(piso + 1).append(":\n");
            for (int hab = 0; hab < habitaciones[piso].length; hab++) {
                sb.append(habitaciones[piso][hab].toLinea()).append("\n");
            }
            sb.append("\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }

    
    //Permite modificar los datos de una habitacion
     
    public void modificarHabitacion() {
        try {
            int numeroHab = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de la habitacion a modificar:"));

            Habitacion habitacionMod = null;
            int pisoEncontrado = -1, indexEncontrado = -1;

            for (int piso = 0; piso < habitaciones.length; piso++) {
                for (int i = 0; i < habitaciones[piso].length; i++) {
                    if (habitaciones[piso][i].getNumero() == numeroHab) {
                        habitacionMod = habitaciones[piso][i];
                        pisoEncontrado = piso;
                        indexEncontrado = i;
                        break;
                    }
                }
                if (habitacionMod != null) break;
            }

            if (habitacionMod == null) {
                JOptionPane.showMessageDialog(null, "Habitacion no encontrada.");
                return;
            }

            String nuevoEstado = JOptionPane.showInputDialog("Estado actual: " + habitacionMod.getEstado()
                    + "\nIngrese nuevo estado (Libre, Ocupada, Sucia):");
            String nuevoTipo = JOptionPane.showInputDialog("Tipo actual: " + habitacionMod.getTipo()
                    + "\nIngrese nuevo tipo (Simple, Doble, etc):");
            double nuevoPrecio = Double.parseDouble(JOptionPane.showInputDialog("Precio actual: " + habitacionMod.getPrecio()
                    + "\nIngrese nuevo precio por noche:"));

            habitaciones[pisoEncontrado][indexEncontrado].setEstado(nuevoEstado);
            habitaciones[pisoEncontrado][indexEncontrado].setTipo(nuevoTipo);
            habitaciones[pisoEncontrado][indexEncontrado].setPrecio(nuevoPrecio);

            JOptionPane.showMessageDialog(null, "Habitacion modificada exitosamente.");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada invalida.");
        }
    }

    
    //Muestra un resumen del estado del hotel
    
    public void resumenHotel() {
        int libres = 0, ocupadas = 0, sucias = 0;
        double ganancia = 0;
        int total = 0;

        for (Habitacion[] piso : habitaciones) {
            for (Habitacion hab : piso) {
                total++;
                switch (hab.getEstado().toLowerCase()) {
                    case "libre" -> libres++;
                    case "ocupada" -> {
                        ocupadas++;
                        ganancia += hab.getPrecio();
                    }
                    case "sucia" -> sucias++;
                }
            }
        }

        double porcLibres = libres * 100.0 / total;
        double porcOcupadas = ocupadas * 100.0 / total;
        double porcSucias = sucias * 100.0 / total;

        String resumen = String.format("""
                Resumen del Hotel:

                Total habitaciones: %d
                Libres: %d (%.2f%%)
                Ocupadas: %d (%.2f%%)
                Sucias: %d (%.2f%%)

                Ganancia actual (habitaciones ocupadas): $%.2f
                """, total, libres, porcLibres, ocupadas, porcOcupadas, sucias, porcSucias, ganancia);

        JOptionPane.showMessageDialog(null, resumen);
    }
}
