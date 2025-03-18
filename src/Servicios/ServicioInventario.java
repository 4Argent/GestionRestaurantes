package Servicios;

import java.util.ArrayList;
import General.Principal;

import java.util.List;
import java.util.Scanner;
import Productos.Productos1;

public class ServicioInventario {
	
	
	private List<Productos1> productos;

    public ServicioInventario() {
        this.productos = new ArrayList<>();
    }

    public void gesInventarios(Scanner scanner) {
    	
int finalizar=1;
    
        while (finalizar==1) {
            try {
            	System.out.println("-----------------------------------");
            	System.out.println("-----------------------------------");
                System.out.println("==>   Gestión de Inventarios   <===");
                System.out.println(" ");
                System.out.println("      1. Agregar Producto           ");
                System.out.println("      2. Actualizar Producto        ");
                System.out.println("      3. Verificar Productos Perecederos");
                System.out.println("      4. Mostrar Inventario"         );
                System.out.println("      5. Volver al Menú Principal    ");
                System.out.println("     ->   Seleccione una opción:    ");
                int opcionInventario = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                switch (opcionInventario) {
                    case 1:
                        agregarProducto(scanner);
                        break;
                    case 2:
                        actualizarProducto(scanner);
                        break;
                    case 3:
                        verificarPerecederos();
                        break;
                    case 4:
                        mostrarInventario();
                        break;
                    case 5:
                    	
                        return; // Para Volver al menú principal
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println("Error: Entrada no válida. Por favor,  Verifique el dato Ingresado: " + e.getMessage());
                scanner.nextLine(); // Limpiar el buffer en caso de error
            }
            
        }
    }

    private void agregarProducto(Scanner scanner) {
    	
        System.out.println("===== Producto Nuevo  ======");
        System.out.println("----------------------------");
        System.out.println("");

        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Ingrese la cantidad: ");
        double cantidad = scanner.nextDouble();
        
        System.out.print("Ingrese el precio: ");
        double precio = scanner.nextDouble();
        
        System.out.print("¿Es perecedero? (true/false): ");
        boolean perecedero = scanner.nextBoolean();
        int diasParaCaducar = 0;
        
        if (perecedero) {
            System.out.print("Ingrese los días para caducar: ");
            diasParaCaducar = scanner.nextInt();
        }
        Productos1 producto = new Productos1(nombre, cantidad, precio, perecedero, diasParaCaducar);
        productos.add(producto);
        System.out.println("Producto agregado: ");
        System.out.println(" " + producto);
    }

    private void actualizarProducto(Scanner scanner) {
        System.out.println("===== Actualizando Producto  ======");
        System.out.println("-----------------------------------");
        System.out.println("");

        System.out.print("Ingrese el nombre del producto a actualizar: ");
        String nombreActualizar = scanner.nextLine();
        
        System.out.print("Ingrese la nueva cantidad: ");
        double nuevaCantidad = scanner.nextDouble();
        
        for (Productos1 producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombreActualizar)) {
                producto.setCantidad(nuevaCantidad);
                
                System.out.println("");
                System.out.println("Producto actualizado: " + producto);
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    private void verificarPerecederos() {
    	 System.out.println("===== Verificando Producto  ======");
	     System.out.println("-----------------------------------");
	     System.out.println("");
	     
        for (Productos1 producto : productos) {
        	
            if (producto.isPerecedero() && producto.getDiasParaCaducar() <= 3) {
                System.out.println("Alerta: El producto " + producto.getNombre() + " está a punto de caducar en " + producto.getDiasParaCaducar() + " días.");
            }
        }
    }

    private void mostrarInventario() {
        System.out.println("===== Inventario   ======");
        System.out.println("-------------------------");
        System.out.println("");

        for (Productos1 producto : productos) {
            System.out.println(producto);
        }
    }
}
