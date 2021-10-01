package clases;

import java.util.ArrayList;
import java.util.Collections;

import com.mysql.jdbc.Connection;

public class Festival {

	private ArrayList<Concierto> listaConciertos;
	private ArrayList<Personal> listaPersonal;
	private Connection conexion;

	public Festival() {
		super();
	}

	public Festival(ArrayList<Concierto> listaConciertos, ArrayList<Personal> listarPersonal, Connection conexion) {
		super();
		this.listaConciertos = listaConciertos;
		this.listaPersonal = listarPersonal;
		this.conexion = conexion;
	}

	public ArrayList<Concierto> getListaConciertos() {
		return listaConciertos;
	}

	public void setListaConciertos(ArrayList<Concierto> listaConciertos) {
		this.listaConciertos = listaConciertos;
	}

	public ArrayList<Personal> getListarPersonal() {
		return listaPersonal;
	}

	public void setListarPersonal(ArrayList<Personal> listarPersonal) {
		this.listaPersonal = listarPersonal;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}


	//registrar asistente concierto
	
	//listar artistas
	
	//listar asistentes
	
	//guardar datos en fichero
	
	//cargar datos desde fichero
	
	//conecta BBDD
	
	//guardar artistas en BBDD
	
	//cargar asistentes desde BBDD
	
	
	
	
	// alta artista
	public void altaArtista(String dni, String nombre, String estiloMusica, String cache) {

		if (!compruebaArtista(dni)) {

			Artista artista = new Artista(dni, nombre, estiloMusica, Float.valueOf(cache));
			Collections.sort(listaPersonal);
			listaPersonal.add(artista);
		}

	}

	// alta asistente
	public void altaAsistente(String dni, String nombre, String fechaNacimiento, String nacionalidad) {

		listaPersonal.add(new Asistente(dni, nombre, fechaNacimiento, nacionalidad));
		Collections.sort(listaPersonal);

	}

	// alta concierto
	public void altaConcierto(String codigo, String nombre, String horaInicio, String dniArtista) {

		if (!compruebaConcierto(codigo) && compruebaArtista(dniArtista)) {

			listaConciertos.add(new Concierto(codigo, nombre, horaInicio, buscarArtista(dniArtista)));
			Collections.sort(listaConciertos);
		} else {
			System.out.println("Error");
		}

	}

	// Comprueba concierto
	public boolean compruebaConcierto(String codigo) {

		for (Concierto concierto : listaConciertos) {
			if (concierto.getCodigo().equals(codigo)) {
				return true;
			}
		}
		return false;

	}

	// Comprueba artista
	public boolean compruebaArtista(String dni) {

		for (Personal artista : listaPersonal) {
			if (artista instanceof Artista) {
				if (artista.getDni().equals(dni)) {
					return true;
				}
			}

		}
		return false;
	}

	// Comprueba asistente
	public boolean compruebaAsistente(String dni) {

		for (Personal artista : listaPersonal) {
			if (artista instanceof Asistente) {
				if (artista.getDni().equals(dni)) {
					return true;
				}
			}

		}
		return false;
	}

	public Artista buscarArtista(String dni) {

		for (Personal artista : listaPersonal) {
			if (artista instanceof Artista) {
				if (artista.getDni().equals(dni)) {
					return (Artista) artista;
				}
			}

		}
		return null;

	}

	public Asistente buscarAsistente(String dni) {

		for (Personal asistente : listaPersonal) {
			if (asistente instanceof Asistente) {
				if (asistente.getDni().equals(dni)) {
					return (Asistente) asistente;
				}
			}

		}
		return null;

	}

	public Concierto buscarConcierto(String dni) {

		for (Concierto concierto : listaConciertos) {
			if (concierto instanceof Concierto) {
				if (concierto.getCodigo().equals(dni)) {
					return (Concierto) concierto;
				}
			}

		}
		return null;

	}
	

}