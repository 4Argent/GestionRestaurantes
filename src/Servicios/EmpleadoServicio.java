package Servicios;


import java.util.ArrayList;


import java.util.List;
import java.util.Scanner;
import Productos.Empleado;
import Productos.Turno;
import Productos.Tarea;

public class EmpleadoServicio {
	

	
	  private List<Empleado> empleados;

	    public EmpleadoServicio() {
	        this.empleados = new ArrayList<>();
	    }

	    public void gestionarPersonal(Scanner scanner) {
	        while (true) {
	            try {
	            	System.out.println("-----------------------------------");
	            	System.out.println("-----------------------------------");
	                System.out.println("===   Gestión de Personal  ===");
	                System.out.println("");
	                System.out.println("      1. Agregar Empleado");
	                System.out.println("      2. Asignar Turno");
	                System.out.println("      3. Asignar Tarea");
	                System.out.println("      4. Mostrar Empleados");
	                System.out.println("      5. Volver al Menú Principal");
	                System.out.print("        -> Seleccione una opción: ");
	                int opcionPersonal = scanner.nextInt();
	                scanner.nextLine(); // Limpiar el buffer

	                switch (opcionPersonal) {
	                    case 1:
	                        agregarEmpleado(scanner);
	                        break;
	                    case 2:
	                        asignarTurno(scanner);
	                        break;
	                    case 3:
	                        asignarTarea(scanner);
	                        break;
	                    case 4:
	                        mostrarEmpleados();
	                        break;
	                    case 5:
	                        System.out.println("Saliendo del menú de ventas...");
	                        return; // Asi volvemos al menú principal
	                    default:
	                        System.out.println("Opción no válida.");
	                }
	            } catch (Exception e) {
	                System.out.println("Error: Entrada de dato invalida, valor :" + e.getMessage());
	                scanner.nextLine(); 
	            }
	        }
	    }

	    private void agregarEmpleado(Scanner scanner) {
	        System.out.println("===== Agregar Personal  ======");
	        System.out.println("------------------------------");
	        System.out.println("");
	        System.out.print("Ingrese el nombre del empleado: ");
	        String nombreEmpleado = scanner.nextLine();
	        System.out.print("Ingrese el puesto del empleado: ");
	        String puestoEmpleado = scanner.nextLine();
	        System.out.print("Ingrese el id del empleado: ");
	        String idEmpleado = scanner.nextLine();
	        Empleado empleado = new Empleado(nombreEmpleado, puestoEmpleado, idEmpleado);
	        empleados.add(empleado);
	        System.out.println("Empleado agregado: " + empleado);
	    }

	    private void asignarTurno(Scanner scanner) {
	        System.out.println("===== Asignar turno  ======");
	        System.out.println("---------------------------");
	        System.out.println("");
	        System.out.print("Ingrese el nombre del empleado: ");
	        String nombreTurno = scanner.nextLine();
	        System.out.print("Ingrese el día del turno: ");
	        String diaTurno = scanner.nextLine();
	        System.out.print("Ingrese la hora de inicio: ");
	        String horaInicio = scanner.nextLine();
	        System.out.print("Ingrese la hora de fin: ");
	        String horaFin = scanner.nextLine();
	        Turno turno = new Turno(diaTurno, horaInicio, horaFin);
	        
	        for (Empleado empleado : empleados) {     //Evalua los nombres para realizar la comparacion actual
	            if (empleado.getNombre().equalsIgnoreCase(nombreTurno)) {
	                empleado.agregarTurno(turno);
	                System.out.println("Turno asignado a " + nombreTurno + ": " + turno);
	                return;
	            }
	        }
	        System.out.println("Empleado no encontrado.");
	    }

	    private void asignarTarea(Scanner scanner) {
	        System.out.println("===== Tarea asignación  ======");
	        System.out.println("------------------------------");
	        System.out.println("");
	        System.out.print("Ingrese el nombre del empleado: ");
	        String nombreTarea = scanner.nextLine();
	        System.out.print("Ingrese la descripción de la tarea: ");
	        String descripcionTarea = scanner.nextLine();
	      
	        Tarea tarea = new Tarea(descripcionTarea);
	        
	        for (Empleado empleado : empleados) {
	            if (empleado.getNombre().equalsIgnoreCase(nombreTarea)) {
	                empleado.agregarTarea(tarea);
	                System.out.println("Tarea asignada a " + nombreTarea + ": " + tarea);
	                return;
	            }
	        }
	        System.out.println("Empleado no encontrado.");
	    }

	    private void mostrarEmpleados() {
	        System.out.println("===== Impresion  ======");
	        System.out.println("-----------------------");
	        System.out.println("");
	        System.out.println("Empleados:");
	        for (Empleado empleado : empleados) {
	            System.out.println(empleado);
	        }
	    }


}
