package Servicios;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;
import Productos.Productos1;
//import Servicios.PedidoService;
import Productos.Productos1Art;

import java.util.Scanner;

public class ArticulosServicio {
	
	private String historialVentas = "";
	
    public void gestionarVentas(Scanner scanner) {
        int subopc;
        do {
            subopc = menuArticulos(scanner);
            switch (subopc) {
                case 1:
                    registrarVenta(scanner);
                    break;
                case 2:
                    mostrarHistorial();
                    break;
                case 3:
                    System.out.println("Saliendo del menú de ventas...");
                    break;
                default:
                    System.out.println("No existe la opción.");
            }
        } while (subopc != 3);
    }

    public int menuArticulos(Scanner scanner) {
    	System.out.println(" "); //---------------------------------------------------
		System.out.println("-----------------------------------");
		System.out.println("-----------------------------------");
        System.out.println("==>      Venta de Articulos   <===");
        System.out.println(" ");
        System.out.println("      1. Hacer un Registro          ");
        System.out.println("      2. Consultar Historial de Ventas  ");
        System.out.println("      3. Volver al Menú Principal   ");
        System.out.println("     ->   Seleccione una opción:    ");
        return scanner.nextInt();
    }

    private void registrarVenta(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Ingrese el nombre del artículo vendido: ");
        String articulo = scanner.nextLine();
        double cantidad, precio;
        do {
            System.out.print("Ingrese la cantidad vendida: ");
            cantidad = scanner.nextDouble();
        } while (cantidad <= 0);
        do {
            System.out.print("Ingrese el precio del artículo: ");
            precio = scanner.nextDouble();
        } while (precio <= 0);
        double totalVenta = cantidad * precio;
        historialVentas += articulo + " - Cantidad: " + cantidad + " - Precio: " + precio + " - Total: " + totalVenta + "\n";
        System.out.println("Venta registrada correctamente.");
    }

    private void mostrarHistorial() {
        System.out.println("== Historial de Ventas ==");
        System.out.println(historialVentas.isEmpty() ? "No hay ventas registradas." : historialVentas);
    }
}



	
	

