package Productos;

import java.util.*;


public class Proveedor {

	 private int id;
	    private String nombre;
	    private String contacto;
	    private String telefono;
	    
	    public Proveedor(int id, String nombre, String contacto, String telefono) {
	        this.id = id;
	        this.nombre = nombre;
	        this.contacto = contacto;
	        this.telefono = telefono;
	    }
	    public Proveedor(int id, Proveedor proveedorSeleccionado, List<Productos1Art> productosPedido) {
			// TODO Auto-generated constructor stub
		}
		public int getId() {
	        return id;
	    }
	    public String getNombre() {
	        return nombre;
	    }
	    public String getContacto() {
	        return contacto;
	    }
	    public String getTelefono() {
	        return telefono;
	    }
	    @Override
	    public String toString() {
	        return "Proveedor ID: " + id + ", Nombre: " + nombre + ", Contacto: " + contacto + ", Teléfono: " + telefono;
	    }
	

	

	
	   
	
}
