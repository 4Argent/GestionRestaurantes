package Productos;

public class Turno {

	
	 private String dia;
	    private String horaInicio;
	    private String horaFin;

	    public Turno(String dia, String horaInicio, String horaFin) {
	        this.dia = dia;
	        this.horaInicio = horaInicio;
	        this.horaFin = horaFin;
	    }

	  
		@Override
	    public String toString() {
	        return "-> Turno : [ " +
	                "Dia= " + dia + "" +
	                ", Hora Inicio= '" + horaInicio + " " +
	                ", hora Fin= " + horaFin + " " +
	                " ]";
	    
	}

}
