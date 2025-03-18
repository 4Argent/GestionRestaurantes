package Productos;

import java.util.List;


public class Factura {

	
	 private String nombreCliente;
	    private List<String> items;
	    private double total;
	    private String metodoPago;

	    public Factura(String nombreFactura, List<String> itemsFactura, double total2, String metodoPago2) {
			// TODO Auto-generated constructor stub
		}


		public String toString() {
	        return "->Factura : " +
	                "Nombre Cliente = " + nombreCliente + "," +
	                ", Items =  " + items +
	                ", Total = " + total +
	                ", Metodo de Pago = '" + metodoPago + " ," +
	                "]";
		}
}
