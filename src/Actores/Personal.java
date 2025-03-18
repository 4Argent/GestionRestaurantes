package Actores;

import java.util.Scanner;

import javax.swing.JOptionPane;

import Productos.Empleado;
import Servicios.EmpleadoServicio;

import Servicios.EmpleadoServicio;

public class Personal {
	
	/*	
		System.out.println(" ");
    	System.out.println("-------------------------------------------------");
    	System.out.println("==========   SYSTEMA DGeIntDeRest  ==============");
    	System.out.println(" --->°°°°° Restaurant: 'Delicias Gourmet °°°°°°<---");
    	System.out.println("-------------------------------------------------");
        System.out.println("===>          Bienvenido  Empleado           <===");
        System.out.println("    -> ¿Qué realizaras el dia de hoy? <-         ");
        
        
       
                Scanner scanner = new Scanner(System.in);
                
                // Definir el número de registros que deseas almacenar
                int numeroDeRegistros = 1 ; // Por ejemplo, 3 registros
                String[] ids = new String[numeroDeRegistros];
                String[] nombres = new String[numeroDeRegistros];
                String[] telefonos = new String[numeroDeRegistros];
                String[] direcciones = new String[numeroDeRegistros];
                String[] correos = new String[numeroDeRegistros];
                String[] contrasenas = new String[numeroDeRegistros];

                // Leer datos y guardarlos en los arreglos
                for (int i = 0; i < numeroDeRegistros; i++) {
                    System.out.println("Registro " + (i + 1) + ":");
                    
                    System.out.print("Ingresa tu ID: ");
                    ids[i] = scanner.nextLine(); // Guardar ID
                    
                    System.out.print("Ingresa tu Nombre Completo: ");
                    nombres[i] = scanner.nextLine(); // Guardar Nombre
                    
                    System.out.print("Ingresa tu Número Telefónico: ");
                    telefonos[i] = scanner.nextLine(); // Guardar Teléfono
                    
                    System.out.print("Ingresa tu Dirección de Residencia: ");
                    direcciones[i] = scanner.nextLine(); // Guardar Dirección
                    
                    System.out.print("Ingresa tu Correo Electrónico: ");
                    correos[i] = scanner.nextLine(); // Guardar Correo
                    
                    System.out.print("Ingresa tu Contraseña: ");
                    contrasenas[i] = scanner.nextLine(); // Guardar Contraseña
                    
                    System.out.println(); // Línea en blanco para separar registros
                }

                // Validación y acceso
                System.out.println("Acceso al sistema:");
                System.out.print("Ingresa tu ID para acceder: ");
                String idAcceso = scanner.nextLine();
                
                System.out.print("Ingresa tu Contraseña para acceder: ");
                String contrasenaAcceso = scanner.nextLine();
                
                boolean accesoConcedido = false;

                // Verificar si el ID y la contraseña son correctos
                 * 
                for (int i = 0; i < numeroDeRegistros; i++) {
                    if (ids[i].equals(idAcceso) && contrasenas[i].equals(contrasenaAcceso)) {
                        accesoConcedido = true;
                        System.out.println("Acceso concedido. Bienvenido, " + nombres[i] + "!");
                        break; // Salir del bucle si se concede el acceso
                    }
                }

                if (!accesoConcedido) {
                    System.out.println("Acceso denegado. ID o contraseña incorrectos.");
                }

                scanner.close(); // Cerrar el escáner
            }
        */
		
		
        EmpleadoServicio empleadoService = new EmpleadoServicio();
        Scanner scanner = new Scanner(System.in);

		private String[] datosEmpleado = new String[3]; // Arreglo para almacenar datos del empleado
		
		 public  void iniciarSesion() {
		        
		        System.out.println("==========   SYSTEMA DGeIntDeRest  ==============");
		    	System.out.println(" -->°°°°° Restaurant: 'Delicias Gourmet °°°°°°<--");
		    	System.out.println("-------------------------------------------------");
		        System.out.println(         "Iniciando sesión como Personal...       ");
		    	System.out.println("-------------------------------------------------");

		        System.out.println("Ingrese su ID de empleado :");
		        String idEmpleado = scanner.nextLine();
		        System.out.println("Ingrese su contraseña:");
		        String contraseniaEmpleado = scanner.nextLine();
		        
				 if (validarSesion(idEmpleado, contraseniaEmpleado)) {
					 
			    		JOptionPane.showMessageDialog(null, "Inicio de Sesión válido ", "Puede continuar", JOptionPane.PLAIN_MESSAGE);
			            System.out.println("-------- Sesión iniciada ----" + datosEmpleado[0]);
			            System.out.println("¿Qué quieres realizar ?");
			            int finalizar=1;
			            while (finalizar==1)  {
			        	    			System.out.println(" ");
			        	            	System.out.println("-------------------------------------------------");
			        			    	System.out.println("==========   SYSTEMA DGeIntDeRest  ==============");
			        			    
			        			    	System.out.println("-->°°°°° Restaurant: 'Delicias Gourmet' °°°°°°<--");
			        			    	System.out.println("-------------------------------------------------");
			        			        System.out.println("===>              MENÚ PRINCIPAL             <===");
			        			        System.out.println("          1. Control de Proveedores              ");
			        			        System.out.println("          2. Control de Reservas y Pedidos       ");
			        			        System.out.println("          3. Venta de Artículos                  ");
			        			        System.out.println("          4. Facturacion                         ");
			        			        System.out.println("          5. Atención a Clientes                 ");
			        			        System.out.println("          6. Control del Inventario              ");
			        			        System.out.println("          7. Gestión de Personal                 ");
			        			        System.out.println("          8. Finalizar                           ");
			        			        System.out.println("===>          Seleccione una opción:         <===");
			        			        			        			       
			        	                int opcion = scanner.nextInt();
			        	                scanner.nextLine();
			        	                switch (opcion) {
			        	                
			        	                	case 1:
			        	                		
			        	                       // admin.mostrarMenuAdmin();
			        	                        limpiarPantalla();
			        	                		proveedores.gestionarProveedores(scanner);
			        	                        break;
			        	                    case 2:
			        	                       // admin.mostrarMenuAdmin();
			        	                        limpiarPantalla();
			        	                    	reservaService.gestionarReservasYPedido(scanner);
			        	                        break;             
			        	                    case 3:
			        	                       // admin.mostrarMenuAdmin();
			        	                    	limpiarPantalla();
			        	                    	venta.gestionarVentas(scanner);
			        	                        break;
			        	                    case 4:
			        	                      //  admin.mostrarMenuAdmin();
			        	                    	limpiarPantalla();
			        	                        facturaService.gestionarFacturacion(scanner);
			        	                        break;
			        	                    case 5:
			        	                       // admin.mostrarMenuAdmin();
			        	                    	limpiarPantalla();
			        	                    	atencionCli.gestionarAtencion(scanner);
			        	                    case 6:
			        	                       // admin.mostrarMenuAdmin();
			        	                    	limpiarPantalla();
			        	                    	inventarioService.gesInventarios(scanner);
			        	                        break;
			        	                    case 7:
			        	                      //  admin.mostrarMenuAdmin();
			        	                    	limpiarPantalla();
			        	                        empleadoService.gestionarPersonal(scanner);
			        	                        break;
			        	                    default:
			        	                        System.out.println("NO existe esa opcion");
			        	                }
			        	          
			        	      System.out.println("");
			        	      System.out.println("¿Desea continuar en el sistema? Introduzca 1 para continuar :) ");
			        	      System.out.println("");
			        	      System.out.println( "Si deseas salir y concluir con el sistema   introduzca 0   :( ");
			        		  finalizar=scanner.nextInt();
			        		  
			        		  if (finalizar ==1)
			        			  System.out.println("");
			        	       }
			        	     
			        	     System.out.println("...................Finalización del Programa.");
			        		 scanner.close();
			        	}
		 }}}
			            
			            empleadoService.gestionarPersonal(scanner);
			            
			            
			             //mostrarMenuAdministrador();
			            //mostrar todos los menus 
			            
			        }else {
			            System.out.println("Error al iniciar sesión. Realiza un registro...");
			             anadirEmpleado(scanner);
			        }
	    

		 
	    public static boolean validarSesion(String idEmpleado, String contraseniaEmpleado) {
	        // Lógica para validar la sesión
	        return idEmpleado.equals("personal") && contraseniaEmpleado.equals("1234");
	    }
		
	    private void anadirEmpleado(Scanner scanner) {
	    	System.out.println("===== Agregar Personal  ======");
	        System.out.println("------------------------------");
	        System.out.println("");
	        System.out.print("Ingrese el nombre del empleado: ");
	        String nombreEmpleado = scanner.nextLine();

	        //datosEmpleado[0] = scanner.nextLine();
	        
	        System.out.println("Ingrese su ID de empleado:");
	        String idEmpleado = scanner.nextLine();

	        
	       
	        System.out.print("Ingrese el puesto del empleado: ");
	        String puestoEmpleado = scanner.nextLine();
	        
	        
	        //Empleado empleado = new Empleado( nombreEmpleado, puestoEmpleado, idEmpleado );
	        //empleados.add(empleado);
	        
	       // System.out.println("Empleado agregado: " + empleado);
	        System.out.println("Empleado añadido exitosamente.");

	    }
	    
	        /*
	        
	        System.out.println("1. Ver horarios");
	        System.out.println("2. Gestionar pedidos");*/
	        
	        
	        // Opciones adicionales
	    
	    public void validarRegistro() {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Validando registro del empleado...");

	        System.out.println("Ingrese su ID de empleado:");
	        String idEmpleado = scanner.nextLine();

	        if (validarID(idEmpleado)) {
	    		JOptionPane.showMessageDialog(null, "Registro válido ", "Puede continuar", JOptionPane.PLAIN_MESSAGE);
	    		
	        } else {
	    		JOptionPane.showMessageDialog(null, "Registro no válido..", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
	    		JOptionPane.showMessageDialog(null, "", "Añadiendo nuevo empleado...", JOptionPane.QUESTION_MESSAGE);

	            //System.out.println("Registro no válido. Añadiendo nuevo empleado...");
	            anadirEmpleado(scanner);
	        }
	    }

	    private boolean validarID(String idEmpleado) {
	        // 
	        return idEmpleado.equals("emp001");
	    }
	
	}


