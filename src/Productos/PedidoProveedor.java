package Productos;

import java.util.List;
import Productos.Productos1Art;

import Productos.Proveedor;

public class PedidoProveedor {
	
	 private int id;
	    private Proveedor proveedor;
	    private List<Productos1Art> productos;
	    private double total;

	    public void Proveedor(int id, Proveedor proveedor, List<Productos1Art> productos) {
	        this.id = id;
	        this.proveedor = proveedor;
	        this.productos = productos;
	        this.total = calcularTotal();
	    }

	    private double calcularTotal() {
	        double total = 0.0;
	        for (Productos1Art producto : productos) {
	            total += producto.getPrecio();
	        }
	        return total;
	    }

	    public int getId() {
	        return id;
	    }

	    public Proveedor getProveedor() {
	        return proveedor;
	    }

	    public List<Productos1Art> getProductos() {
	        return productos;
	    }

	    public double getTotal() {
	        return total;
	    }

	    @Override
	    public String toString() {
	        return "Pedido ID: " + id + ", Proveedor: " + proveedor.getNombre() + ", Total: $" + total;
	    }

}
