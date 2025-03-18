package Productos;

import java.util.ArrayList;

import java.util.List;
import Productos.Turno;
import Productos.Tarea;

public class Empleado {

	  private String nombre;
	    private String puesto;
	    private List<Turno> turnos;
	    private List<Tarea> tareas;
		private String id;

	    public Empleado(String nombre, String puesto, String id) {
	    	this.id=id;
	        this.nombre = nombre;
	        this.puesto = puesto;
	        this.turnos = new ArrayList<>();
	        this.tareas = new ArrayList<>();
	    }
	    
	    public String getId() {
	        return id;
	    }
	    
	    public String getNombre() {
	        return nombre;
	    }

	    public String getPuesto() {
	        return puesto;
	    }

	    public void agregarTurno(Turno turno) {
	        turnos.add(turno);
	    }

	    public void agregarTarea(Tarea tarea) {
	        tareas.add(tarea);
	    }

	    public List<Turno> getTurnos() {
	        return turnos;
	    }

	    public List<Tarea> getTareas() {
	        return tareas;
	    }

	    @Override
	    public String toString() {
	        return "Empleado [ " +
	                "-> Nombre = '" + nombre + "'" +
	                ", Puesto= '" + puesto + "'" +
	                ", Turnos= " + turnos +
	                ", Tareas= " + tareas +
	                "]";
	    }

		
	
}
