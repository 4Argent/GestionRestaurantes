package Servicios;

import java.util.*;

import Productos.Productos1Art;
import Productos.Proveedor;

public class ProveedoresService {

	
	private List<Proveedor> proveedores;
    private List<Proveedor> pedidos;
    private Scanner scanner;

    public ProveedoresService() {
        proveedores = new ArrayList<>();
        pedidos = new ArrayList<>();
        scanner = new Scanner(System.in);
        inicializarProveedores();
    }

    private void inicializarProveedores() {
        proveedores.add(new Proveedor(1, "Proveedor A", "Martha Guadalupe", "123-456-7890"));
        proveedores.add(new Proveedor(2, "Proveedor B", "Wendy Sanchez", "987-654-3210"));
        proveedores.add(new Proveedor(3, "Proveedor c", "Layeska Chavez", "992-653-3211"));

        
    }

    public void gestionarProveedores(Scanner scanner2) {
        while (true) {
        	System.out.println("-----------------------------------");
        	System.out.println("-----------------------------------");
            System.out.println("===   Gestión de Proveedores  ===");
            System.out.println("");
            System.out.println("     1. Mostrar Proveedores");
            System.out.println("     2. Realizar Pedido");
            System.out.println("     3. Mostrar Pedidos");
            System.out.println("     4. Volver al Menú Principal");
            System.out.print("     -> Ingrese su opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    mostrarProveedores();
                    break;
                case 2:
                    realizarPedido();
                    break;
                case 3:
                    mostrarPedidos();
                    break;
                case 4:
                    System.out.println("Saliendo del menú de Proveedores...");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private void mostrarProveedores() {
        System.out.println("==  Lista de Proveedores ==");
        System.out.println("");
        for (Proveedor proveedor : proveedores) {
            System.out.println(proveedor);
        }
    }

    private void realizarPedido() {
        mostrarProveedores();
        System.out.print("Ingrese el ID del proveedor: ");
        int proveedorId = scanner.nextInt();
        scanner.nextLine();

        Proveedor proveedorSeleccionado = null;
        for (Proveedor proveedor : proveedores) {
            if (proveedor.getId() == proveedorId) {
                proveedorSeleccionado = proveedor;
                break;
            }
        }
        if (proveedorSeleccionado != null) {
            List<Productos1Art> productosPedido = new ArrayList<>();
            while (true) {
                System.out.print("Ingrese el nombre del producto a pedir (o 'fin' para terminar): ");
                String nombreProducto = scanner.nextLine();
                if (nombreProducto.equalsIgnoreCase("fin")) {
                    break;
                }
                System.out.print("Ingrese la cantidad: ");
                int cantidad = scanner.nextInt();
                System.out.print("Ingrese el precio: ");
                double precio = scanner.nextDouble();
                scanner.nextLine();
                productosPedido.add(new Productos1Art(nombreProducto, cantidad, precio));
            }
            pedidos.add(new Proveedor(pedidos.size() + 1, proveedorSeleccionado, productosPedido));
            System.out.println("Pedido realizado con éxito.");
        } else {
            System.out.println("Proveedor no encontrado.");
        }
    }

    private void mostrarPedidos() {
        System.out.println("== Lista de Pedidos ==");
        System.out.println("");
        for (Proveedor pedido : pedidos) {
            System.out.println(pedido);
        }
    }
	
}
