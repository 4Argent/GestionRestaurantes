package Servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Productos.Reservas;
import Productos.Mesa;
import Productos.Pedido;

public class ReservasServicio {

    private List<Mesa> mesas;
    private List<Reservas> reservas;
    private List<Pedido> pedidos;


    public ReservasServicio() {
        mesas = new ArrayList<>();
        reservas = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            mesas.add(new Mesa(i));
        }
    }

    public void gestionarReservasYPedido(Scanner scanner) {
        while (true) {
            try {
            	System.out.println("-----------------------------------");
            	System.out.println("-----------------------------------");
                System.out.println("=== Gestión de Reservas y Pedidos ==");
                System.out.println("                                    ");
                System.out.println("      1. Hacer Reserva");
                System.out.println("      2. Liberar Mesa");
                System.out.println("      3. Realizar Pedido");
                System.out.println("      4. Mostrar Reservas");
                System.out.println("      5. Mostrar Pedidos");
                System.out.println("      6. Volver al Menú Principal");
                System.out.println("   -> Seleccione una opción: ");
                int opcionReservas = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcionReservas) {
                    case 1:
                        hacerReserva(scanner);
                        break;
                    case 2:
                        liberarMesa(scanner);
                        break;
                    case 3:
                        realizarPedido(scanner);
                        break;
                    case 4:
                        mostrarReservas();
                        break;
                    case 5:
                    	mostrarPedidos();
                        // Mostrar pedidos (implementación pendiente)
                        break;
                    case 6:
                        return; // Volver al menú principal
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println("Error: Entrada no válida. Por favor, ingrese un número. " + e.getMessage());
                scanner.nextLine(); // Limpiar el buffer en caso de error
            }
        }
    }

    private void hacerReserva(Scanner scanner) {
        System.out.println("===== Realizar Reserva  ======");
        System.out.println("------------------------------");
        System.out.println("");

        System.out.print("Ingrese su nombre: ");
        String nombreCliente = scanner.nextLine();
        System.out.print("Ingrese el número de mesa: ");
        int numeroMesa = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Ingrese la fecha y hora de la reserva: ");
        String fechaHora = scanner.nextLine();
        
        
        for (Mesa mesa : mesas) {
            if (mesa.getNumero() == numeroMesa && !mesa.isOcupada()) {
                mesa.ocupar();
                Reservas reserva = new Reservas(nombreCliente, numeroMesa, fechaHora);
                reservas.add(reserva);
                System.out.println("Reserva confirmada: " + reserva);
                return;
            }
        }
        System.out.println("La mesa " + numeroMesa + " no está disponible.");
    }

    private void liberarMesa(Scanner scanner) {
        System.out.println("===== Historial Mezas   ======");
        System.out.println("------------------------------");
        System.out.println("");
        System.out.print("Ingrese el número de mesa a liberar: ");
        int mesaLiberar = scanner.nextInt();
        
      /*  for (Mesa mesa : mesas) {
            if (mesa.getNumero() == mesaLiberar) {
                mesa.liberar();
                System.out.println("Mesa " + mesaLiberar + " liberada.");
                return;
            }
        }
        System.out.println("Mesa no encontrada.");*/
        //_-----------------------
        
        Mesa mesa = obtenerMesa(mesaLiberar);
        if (mesa != null) {
            mesa.liberar();
            System.out.println("Mesa " + mesaLiberar + " liberada.");
        } else {
            System.out.println("Mesa no encontrada.");
        }
        
    }
    private Mesa obtenerMesa(int numeroMesa) {
        for (Mesa mesa : mesas) {
            if (mesa.getNumero() == numeroMesa) {
                return mesa;
            }
        }
        return null;
    }


	private void realizarPedido(Scanner scanner) {
    	//Podemos mandar a traer la clase de registro 
        // Implementación de realizar pedido (pendiente)---> queda pendiente a desarrollar 
		
		 System.out.println("===== Realizar Pedido =====");
	        System.out.print("Ingrese el número de mesa: ");
	        int numeroMesa = scanner.nextInt();
	        scanner.nextLine(); // Limpiar el buffer

	        Mesa mesa = obtenerMesa(numeroMesa);
	        if (mesa != null && mesa.isOcupada()) {
	            System.out.print("Ingrese la descripción del pedido: ");
	            String descripcion = scanner.nextLine();
	            Pedido pedido = new Pedido(numeroMesa, descripcion);
	            pedidos.add(pedido);
	            System.out.println("Pedido realizado: " + pedido);
	        } else {
	            System.out.println("La mesa " + numeroMesa + " no está ocupada o no existe.");
	        }
	    }
		
	 private void mostrarPedidos() {
	        System.out.println("===== Pedidos =====");
	        System.out.println("Pedidos:");
	        for (Pedido pedido : pedidos) {
	            System.out.println(pedido);
	        }
	    }
	 
    private void mostrarReservas() {
        System.out.println("===== Visualizacion de la Reserva  ====");
        System.out.println("---------------------------------------");
        System.out.println("");

        System.out.println("Reservas:");
        for (Reservas reserva : reservas) {
        	System.out.println("");
            System.out.println(reserva);
        }
    }

}

