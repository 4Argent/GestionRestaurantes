package Productos;

public class Productos1 {

	
    private String nombre;
    private double cantidad;
    private double precio;
    private boolean perecedero;
    private int diasParaCaducar;

    public Productos1(String nombre, double cantidad, double precio, boolean perecedero, int diasParaCaducar) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.perecedero = perecedero;
        this.diasParaCaducar = diasParaCaducar;
    }

    public String getNombre() {
        return nombre;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean isPerecedero() {
        return perecedero;
    }

    public int getDiasParaCaducar() {
        return diasParaCaducar;
    }

    @Override
    public String toString() {
        return "Producto ---> " +
                "Nombre = [ " + nombre + "" +
                ", Cantidad = " + cantidad +
                ", Precio = " + precio +
                ", Perecedero = " + perecedero +
                ", Dias Para Caducar = " + diasParaCaducar +
                " ]";
    }
    
}
