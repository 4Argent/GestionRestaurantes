package Actores;
import Actores.Admin;

import java.util.Scanner;

public class prueba {
    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al sistema de gestión de restaurante.");
        System.out.println("Usted interactua como un: ");
        System.out.println("Por favor, seleccione una opción:");
        System.out.println("1. Usuario");
        System.out.println("2. Administrador");
        System.out.println("3. Empleado");

        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                Usuario usuario = new Usuario(); //mandamos a traer a la clase de usuarios
                
                usuario.realizar();
                break;
            case 2:
                Admin admin = new Admin();
                Admin.iniciarSesion();
                break;
            case 3:
                Empleado empleado = new Empleado();
                empleado.validarRegistro();
                break;
            default:
                System.out.println("Opción no válida.");
        }

        scanner.close();
    }

}
