package Actores;
import java.util.*;


import General.Principal;

public class Administrador {
	
	public static void mostrarMenuAdmin() { 
		
		
		Scanner sc=new Scanner(System.in);
		Principal principalmenu=new Principal();
	/*
		System.out.println(" ");
    	System.out.println("------------------------------------------------");
    	System.out.println("===========   SYSTEMA DGeIntDeRest  ============");
    	System.out.println(" --->°°°°°     Parte Administrativa    °°°°°<---");
    	System.out.println("------------------------------------------------");
        System.out.println("");
        
        System.out.println(" ¿Que se realizara?");
        System.out.println("-----> 1.- Registro de Administrador ");
        System.out.println("-----> 2.- Inicio de Sesión");
        int opcionAdmin=sc.nextInt();
        
        if (opcionAdmin==1) {
        	System.out.println("-----------------------------------");
	       	System.out.println(" -> Realiza el Registro  <-        ");
	       	System.out.println("-----------------------------------");
            System.out.println("");
            
	            System.out.println("Ingresa tu ID");
	            int id =sc.nextInt(); // ID
	            System.out.print(" ->Nombre Completo:");
	            String AdminNombre= sc.nextLine();
	            System.out.print(" ->Número Telefonico: ");
	            String AdminNumeroTel = sc.nextLine();
	            System.out.print(" ->Direccion de Residencia: ");
	            String AdminDireccion = sc.nextLine();
	            System.out.print(" ->Correo Electronico: ");
	            String AdminCorreo = sc.nextLine();
	            System.out.print(" ->Ingresa la Contraseña");
	            String AdminContrasenia = sc.nextLine();
        }else 
	        
        	 System.out.println("------------------------------------");
        	 System.out.println(" -> Realiza el inicio de sesión <- ");
        	 System.out.println("-----------------------------------");
             System.out.println("");
             System.out.println("Ingresa tu ID ");
             String id=sc.nextLine();
             System.out.println("");
             System.out.println("Ingrese la contraseña");
             String adminContrasenia=sc.nextLine();
             
             
             
       }
         public void mostrarMenuPrincipal() {
	        System.out.println(" ");
	    	System.out.println("-------------------------------------------------");
	    	System.out.println("==========   SYSTEMA DGeIntDeRest  ==============");
	    	System.out.println(" --->°°°°° Restaurant: 'Delicias Gourmet °°°°°<---");
	    	System.out.println("-------------------------------------------------");
	        System.out.println("");
	        System.out.println("===>         Bienvenido  Administrador         <===");
	
	        System.out.println("    -> ¿Qué realizaras el dia de hoy? <-         ");
        
       }  
       */
        
		
       
       
       
       
       
       //-------------------------------------------------------------------
		
	/*	System.out.println(" ");
    	System.out.println("------------------------------------------------");
    	System.out.println("===========   SYSTEMA DGeIntDeRest  ============");
    	System.out.println(" --->°°°°°                             °°°°°<---");
    	System.out.println("------------------------------------------------");
        System.out.println("");
        System.out.println(" ¿Usted interactua en el sistema como un: ?");
        System.out.println("-----> 1.- Administrador ");
        System.out.println("-----> 2.- Empleado");
        System.out.println("-----> 3.- Usuario");
        int opcionActor=sc.nextInt();
        
        switch (opcionActor) {
       /* case 1:
            Usuario usuario = new Usuario();
            usuario.realizarEncuesta();
            break;
        case 2:
            Administrador admin = new Administrador();
            admin.iniciarSesion();
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

	*/
        
       
       
		
		    private String[] datosAdmin = new String[2]; // Arreglo para almacenar datos del administrador

		    public void iniciarSesion() {
		        Scanner scanner = new Scanner(System.in);
		        System.out.println("Iniciando sesión como administrador...");

		        System.out.println("Ingrese su nombre de usuario:");
		        String usuario = scanner.nextLine();
		        System.out.println("Ingrese su contraseña:");
		        String contrasena = scanner.nextLine();
		        
		        
		        
		        
		       
		        if (validarSesion(usuario, contrasena)) {
		            System.out.println("Sesión iniciada. Accediendo al menú de administrador...");
		            mostrarMenuAdministrador();
		            //mostrar todos los menus 
		            
		            
		        } else {
		            System.out.println("Error al iniciar sesión. Realiza un registro...");
		            registrarAdministrador(scanner);
		        }
		    }

		    private boolean validarSesion(String usuario, String contrasena) {
		        // Lógica para validar la sesión
		        return usuario.equals("admin") && contrasena.equals("1234");
		    }

		    private void registrarAdministrador(Scanner scanner) {
		        System.out.println("Ingrese su nombre de usuario:");
		        datosAdmin[0] = scanner.nextLine();
		        System.out.println("Ingrese su contraseña:");
		        datosAdmin[1] = scanner.nextLine();
		        System.out.println("Ingrese su ID:");
		        datosAdmin[2] = scanner.nextLine();
		        
		        System.out.println("Administrador registrado exitosamente.");
		    }

		    private void mostrarMenuAdministrador() {
		        System.out.println("Menú del administrador:");
		        System.out.println("1. Gestionar usuarios");
		        System.out.println("2. Gestionar empleados");
		        
		        
		        // Opciones adicionales
		    }
		}
       
       
       
	}
}


