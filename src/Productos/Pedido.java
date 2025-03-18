package Productos;


import java.util.List;
import java.util.Scanner;

public class Pedido {
	
	private String nombreCliente;
    private List<String> items;
    private String tipo; // "comer" o "llevar"

    public Pedido(String nombreCliente, List<String> items, String tipo) {
        this.nombreCliente = nombreCliente;
        this.items = items;
        this.tipo = tipo;
    }
	public Pedido(int numeroMesa, String descripcion) {
		// TODO Auto-generated constructor stub
	}
	public String toString() {
        return "Pedido [ " +
                "nombreCliente = " + nombreCliente + " " +
                ", items=" + items +
                ", tipo='" + tipo + " " +
                " ]";
    }

	public void gestionarVentas(Scanner scanner) {
		// TODO Auto-generated method stub
		
	}

}

