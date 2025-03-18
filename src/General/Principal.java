package General;
import java.util.Scanner;    // Permite la entrada de datos

import Servicios.ProveedoresService;//Importamos nuestras clases primordiales
import Servicios.ReservasServicio;
import Servicios.FacturaServicio;
import Servicios.EmpleadoServicio;
import Servicios.ServicioInventario;
import Servicios.AtencionCliente;
import Servicios.ArticulosServicio;
import Actores.Administrador;
import Actores.Administrador;
import Actores.Personal;
import Actores.Usuario;

public class Principal {
	public static void main(String[] args) {
		/*
		 *      Proyecto en Desarrollo 
		 *      		
		 * Sistema de Gestión Integral en un Restaurant
		 * 
		 *      --->  SysGIR   <----
		 */
	
		 Scanner scanner = new Scanner(System.in); 
		 
	     ServicioInventario inventarioService = new ServicioInventario();
	     ReservasServicio reservaService = new ReservasServicio();
	   //  Pedido pedidoService = new Pedido();
	     FacturaServicio facturaService = new FacturaServicio();
	     EmpleadoServicio empleadoService = new EmpleadoServicio();
	     ProveedoresService proveedores =new ProveedoresService();
	     AtencionCliente atencionCli = new AtencionCliente();
	     ArticulosServicio venta= new ArticulosServicio();
	     
	     
	     int finalizar=1;
	     
	   //  Admin admin = new Admin(); //instancia de la clase Admin
	     
	     System.out.println(" ");
	    	System.out.println("------------------------------------------------");
	    	System.out.println("===========   SYSTEMA DGeIntDeRest  ============");
	    	System.out.println(" -->°°°°° Restaurant: 'Delicias Gourmet' °°°°°<--");
	    	System.out.println("------------------------------------------------");
	        System.out.println("");
	        System.out.println("  ¿Usted interactua en el sistema como un: ... ?");
	        System.out.println("-----> 1.- Administrador ");
	        System.out.println("-----> 2.- Empleado");
	        System.out.println("-----> 3.- Usuario");
	        int opcionActor=scanner.nextInt();
	        
	        switch (opcionActor) {
	        case 1:
	        	  Administrador admin = new Administrador();
		          admin.iniciarSesion();
		          break;
	            
	        case 2:
	        	 Personal personalEmpleado = new Personal();
		         personalEmpleado.iniciarSesion();
		         break;
	        case 3:
	        	//Personal personal = new Personal();
	        	//personal.iniciarSesion();
	        	//Usuario usuario = new Usuario();
	            //usuario.realizar();
	            break;
	        default:
	            System.out.println("Opción no válida.");
	    }

	    scanner.close();
	     
	     
 //------------------------------------------------------------------------------------------
          
	     while (finalizar==1)  {
	    // try {

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
			        

			        // inventario ,reservas pedido,facturacion y pagos ,personal
			       
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
	           /* } catch (Exception e) {
	                System.out.println("Error: Entrada no válida. Por favor, ingrese un número valido de lo contrario sera: " + e.getMessage());
	                scanner.nextLine(); 
	            }*/
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
	public static void limpiarPantalla() {
	    System.out.print("\033[H\033[2J");
	    System.out.flush();
	}
}  