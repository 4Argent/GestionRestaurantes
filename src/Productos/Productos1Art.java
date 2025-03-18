package Productos;

public class Productos1Art {


	//public class Productos1 {
	    private String nombre;
	    private int cantidad;
	    private double precio;

	    // Constructor
	    public Productos1Art(String nombre, int cantidad, double precio) {
	        this.nombre = nombre;
	        this.cantidad = cantidad;
	        this.precio = precio;
	    }

	    // Métodos get y set
	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public int getCantidad() {
	        return cantidad;
	    }

	    public void setCantidad(int cantidad) {
	        this.cantidad = cantidad;
	    }

	    public double getPrecio() {
	        return precio;
	    }

	    public void setPrecio(double precio) {
	        this.precio = precio;
	    }

	    // Método toString
	    @Override
	    public String toString() {
	        return "Producto: " + nombre + ", Cantidad: " + cantidad + ", Precio: $" + precio;
	    }
}

	

