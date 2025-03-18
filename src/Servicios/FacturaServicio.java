package Servicios;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;
import Productos.Factura;

public class FacturaServicio {

	
	private List<Factura> facturas;

    public FacturaServicio() {
        this.facturas = new ArrayList<>();
    }

    public void gestionarFacturacion(Scanner scanner) {
        while (true) {
            try {
            	System.out.println("-------------------------------------");
            	System.out.println("-------------------------------------");
            	System.out.println("== Gestión de Facturación y Pagos ==");
                System.out.println("");
                System.out.println("       1. Generar Factura");
                System.out.println("       2. Mostrar Facturas");
                System.out.println("       3. Volver al Menú Principal");
                System.out.println("     ->  Seleccione una opción: ");
                int opcionFacturacion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                switch (opcionFacturacion) {
                    case 1:
                        generarFactura(scanner);
                        break;
                    case 2:
                        mostrarFacturas();
                        break;
                    case 3:
                        return; // Volvermos  al menú principal
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println("Error Error Error Verifique el dato Ingresado: " + e.getMessage());
                scanner.nextLine(); // Limpiar el buffer en caso de error
            }
        }
    }

    private void generarFactura(Scanner scanner) {
        System.out.println("===== Factura  ======");
        System.out.println("---------------------");
        System.out.println("");
        
        System.out.print("Ingrese su nombre: ");
        String nombreFactura = scanner.nextLine();
        
        System.out.print("Ingrese los items de la factura (separados por comas): ");
        String[] itemsFacturaArray = scanner.nextLine().split(",");
        
        List<String> itemsFactura = new ArrayList<>();
        for (String item : itemsFacturaArray) {
            itemsFactura.add(item.trim());
        }
        System.out.print("Ingrese el total de la factura  ($ 000.00): ");
        double total = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.print("Ingrese el método de pago (Efectivo /Tarjeta de Crédito): ");
        String metodoPago = scanner.nextLine();
        
        Factura factura = new Factura(nombreFactura, itemsFactura, total, metodoPago);
        facturas.add(factura);
        System.out.println("Factura generada: ");
        System.out.println( "-> "+factura);
    }

    private void mostrarFacturas() {
        System.out.println("===== Facturas Generadadas  ======");
        System.out.println("----------------------------------");
        System.out.println("");

        for (Factura factura : facturas) {
            System.out.println(factura);
        }
    }
}





