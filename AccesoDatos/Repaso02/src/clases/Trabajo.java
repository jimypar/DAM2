package clases;

import java.time.LocalDate;

public class Trabajo {

	private String nombre;
	private String cliente;
	private Double presupuesto;
	private LocalDate fechaConcesion;
	private Responsable responsableTrabajo;

	public Trabajo(String nombre, String cliente, Double presupuesto) {
		super();
		this.nombre = nombre;
		this.cliente = cliente;
		this.presupuesto = presupuesto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Double getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(Double presupuesto) {
		this.presupuesto = presupuesto;
	}

	public LocalDate getFechaConcesion() {
		return fechaConcesion;
	}

	public void setFechaConcesion(LocalDate fechaConcesion) {
		this.fechaConcesion = fechaConcesion;
	}

	public Responsable getResponsableTrabajo() {
		return responsableTrabajo;
	}

	public void setResponsableTrabajo(Responsable responsableTrabajo) {
		this.responsableTrabajo = responsableTrabajo;
	}

	@Override
	public String toString() {
		return "Trabajo [nombre=" + nombre + ", cliente=" + cliente + ", presupuesto=" + presupuesto
				+ ", fechaConcesion=" + fechaConcesion + ", responsableTrabajo=" + responsableTrabajo + "]";
	}

}
