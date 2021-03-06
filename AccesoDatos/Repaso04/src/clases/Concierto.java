package clases;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;

public class Concierto implements Comparable<Concierto>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String codigo;
	private String nombre;
	private Time horaInicio;
	private Artista artista;
	private ArrayList<Asistente> listaAsistentes;

	public Concierto(String codigo, String nombre, String horaInicio, Artista artista) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.horaInicio = Time.valueOf(horaInicio);
		this.artista = artista;
		this.listaAsistentes = new ArrayList<Asistente>();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Time getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public ArrayList<Asistente> getListaAsistentes() {
		return listaAsistentes;
	}

	public void setListaAsistentes(ArrayList<Asistente> listaAsistentes) {
		this.listaAsistentes = listaAsistentes;
	}

	@Override
	public int compareTo(Concierto o) {
		return getHoraInicio().compareTo(o.getHoraInicio());
	}

	@Override
	public String toString() {
		return "Concierto [codigo=" + codigo + ", nombre=" + nombre + ", horaInicio=" + horaInicio + ", artista="
				+ artista + ", listaAsistentes=" + listaAsistentes + "]";
	}

}
