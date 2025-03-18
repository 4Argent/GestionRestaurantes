package Productos;

public class Mesa {

	 private int numero;
	    private boolean ocupada;

	    public Mesa(int numero) {
	        this.numero = numero;
	        this.ocupada = false; // la mesa no está ocupada o eso podemos suponer 
	    }
	    public int getNumero() {
	        return numero;
	    }
	    public boolean isOcupada() {
	        return ocupada;
	    }
	    public void ocupar() {
	        this.ocupada = true; // Método para marcar la mesa como ocupada
	    }
	    public void liberar() {
	        this.ocupada = false; // Método para liberar la mesa
	    }

	    @Override
	    public String toString() {
	        return "Mesa: [ " +
	                "numero = " + numero +
	                ", ocupada = " + ocupada +
	                "]";
	    
	}


}
