package Productos;

public class Tarea {

	   private String descripcion;
	    private boolean completada;

	    public Tarea(String descripcionTarea) {
	        this.descripcion = descripcion;
	        this.completada = false; // Por defecto, la tarea no está completada
	    }
		public String getDescripcion() {
	        return descripcion;
	    }
	    public boolean isCompletada() {
	        return completada;
	    }
	    public void marcarComoCompletada() {
	        this.completada = true; // Método para marcar la tarea como completada
	    }
	    @Override
	    public String toString() {
	        return "->Tarea : [ " +
	                "Descripcion='" + descripcion + "" +
	                ", Completada=" + completada +
	                " ]";
	    }
	
}
