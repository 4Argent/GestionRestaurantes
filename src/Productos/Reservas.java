package Productos;

import Productos.Mesa;
public class Reservas {
	
    private String nombreCliente;
    private int numeroMesa;
    private String fechaHora;

    public Reservas(String nombreCliente, int numeroMesa, String fechaHora) {
        this.nombreCliente = nombreCliente;
        this.numeroMesa = numeroMesa;
        this.fechaHora = fechaHora;
    }

    @Override
    public String toString() {
        return "Reserva : " + 
                "--> Nombre del Cliente =  " + nombreCliente + " " +
                ", Numero de Mesa = " + numeroMesa +
                ", Fecha y Hora =' " + fechaHora + "  " +
                " ]";
    }
    
    
    
}
