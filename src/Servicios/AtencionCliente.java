package Servicios;

import java.util.Scanner;

public class AtencionCliente {
	
	private String historialConsultas = "";
	
    public void gestionarAtencion(Scanner scanner) {
        int subopc;
        do {
            subopc = menuClientes(scanner);
            
            switch (subopc) {
                case 1:
                    registrarConsulta(scanner);
                    break;
                case 2:
                    registrarQueja(scanner);
                    break;
                case 3:
                    mostrarHistorial();
                    break;
                case 4:
                    System.out.println("Saliendo del menú de clientes...");
                    break;
                default:
                    System.out.println("No existe la opción.");
            }
        } while (subopc != 4);
    }

    private int menuClientes(Scanner scanner) {
    	System.out.println("-----------------------------------");
    	System.out.println("-----------------------------------");
        System.out.println("=== Menú de Atención al Cliente ===");
        System.out.println("");
        System.out.println("     1. Registrar consulta      ");
        System.out.println("     2. Registrar queja         ");
        System.out.println("     3. Ver historial           ");
        System.out.println("     4. Salir                   ");
        System.out.println("     -> Seleccione una opción: ");
        return scanner.nextInt();
    }

    private void registrarConsulta(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Ingrese el nombre del cliente: ");
        String nombreCliente = scanner.nextLine();
        limpiarPantalla();
        System.out.print("Ingrese la consulta del cliente: ");
        String consulta = scanner.nextLine();
        limpiarPantalla();
        historialConsultas += "Consulta de " + nombreCliente + ": " + consulta + "\n";
        System.out.println("Consulta registrada correctamente.");
    }

    private void registrarQueja(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Ingrese el nombre del cliente: ");
        String nombreCliente = scanner.nextLine();
        limpiarPantalla();
        System.out.print("Ingrese la queja del cliente: ");
        String consulta = scanner.nextLine();
        limpiarPantalla();
        historialConsultas += "Queja de " + nombreCliente + " : " + consulta + "\n";
        System.out.println("Queja registrada correctamente.");
    }

    private void mostrarHistorial() {
        System.out.println("== Historial de Atención al Cliente ==");
        System.out.println(historialConsultas.isEmpty() ? "No hay consultas registradas." : historialConsultas);
    }

    private void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();        
   }


}

	
	

