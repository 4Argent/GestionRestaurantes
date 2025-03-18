package Actores;

import java.util.Scanner;

public class Usuario {

		
	    private String[] datosUsuario = new String[3]; // Arreglo para almacenar datos del usuario

        Scanner scanner = new Scanner(System.in);

        
		/*System.out.println(" ");
    	System.out.println("-------------------------------------------------");
    	System.out.println("==========   SYSTEMA DGeIntDeRest  ==============");
    
    	System.out.println(" --->°°°°° Restaurant: 'Delicias Gourmet °°°°°°<---");
    	System.out.println("-------------------------------------------------");
        System.out.println("===>         Bienvenido  Usuario         <===");
       
            
        System.out.println("¿Ya tiene una cuenta? (si/no)");
        String respuesta = scanner.nextLine();

        if (respuesta.equalsIgnoreCase("si")) {
            System.out.println("Realiza el Inico de Sesión");
            
         //   System.out.println("Ya tienes una cuenta. Accediendo al menú...");
 //           mostrarMenuUsuario();
        } else {
            System.out.println("Creando una nueva cuenta: ");
            
 //          crearCuenta(scanner);
 //           mostrarMenuUsuario();
        } */
        
        
        //Debemos realizar un registro 
        

        public void realizar() {
            Scanner scanner = new Scanner(System.in);

            
            
            System.out.println("¿Tiene una cuenta? (si/no)");
            String respuesta = scanner.nextLine();
            
            

            if (respuesta.equalsIgnoreCase("si")) {
                System.out.println("Ya tienes una cuenta. Inicia Sesión...");
                
                mostrarMenuUsuario();
            } else {
                System.out.println("No tienes una cuenta. Creando una nueva cuenta...");
                crearCuenta(scanner);
                mostrarMenuUsuario();
            }
        }

        private void crearCuenta(Scanner scanner) {
            System.out.println("Ingrese su nombre:");
            datosUsuario[0] = scanner.nextLine();
            System.out.println("Ingrese su correo electrónico:");
            datosUsuario[1] = scanner.nextLine();
            System.out.println("Ingrese su número de teléfono:");
            datosUsuario[2] = scanner.nextLine();

            System.out.println("Cuenta creada exitosamente.");
        }

        private void mostrarMenuUsuario() {
        	//Mandar a traer los accesos 
            System.out.println("Menú del usuario:");
            System.out.println("1. Pedir");
            System.out.println("2. Ordenar");
            // Opciones adicionales
        }
        
        

        System.out.println("Ingrese su nombre de usuario:");
        String usuario = scanner.nextLine();
        System.out.println("Ingrese su contraseña:");
        String contrasena = scanner.nextLine();

        if (validarSesion(usuario, contrasena)) {
            System.out.println("Sesión iniciada. Accediendo al menú de administrador...");
            mostrarMenuAdministrador();
        } else {
            System.out.println("Error al iniciar sesión. Registrando nuevo administrador...");
            registrarAdministrador(scanner);
        }
    }

        
        
        
        
        
        
        
        
        
        
        
        
        
        
                
        /*        // Definir el tamaño del arreglo
                int tamaño = 5; // Por ejemplo, queremos almacenar 5 nombres
                String[] nombres = new String[tamaño]; // Crear un arreglo de Strings
                
                // Leer datos y guardarlos en el arreglo
                for (int i = 0; i < tamaño; i++) {
                    System.out.print("Ingresa el nombre " + (i + 1) + ": ");
                    nombres[i] = scanner.nextLine(); // Leer el dato y guardarlo en el arreglo
                }
                // Mostrar los datos ingresados
                System.out.println("\nNombres ingresados:");
                for (String nombre : nombres) {
                    System.out.println(nombre);
                }
                
                scanner.close(); // Cerrar el escáner
            }
        */
        
		
	}


