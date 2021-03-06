package main;

import java.sql.SQLException;

import clases.Festival;

public class Main {

	public static void main(String[] args) {
		
		Festival festival = new Festival();
        System.out.println("Dar de alta Artista");
        festival.altaArtista("1234", "Jesus", "Pop", "1234");
        festival.altaArtista("5678", "Maria", "Rock", "5678");
        System.out.println("Alta asistente");
        festival.altaAsistente("2222", "Asistente1", "2001-11-04", "Spain");
        System.out.println("Alta concierto");
        festival.altaConcierto("1111", "Concierto1", "07:11:00", "1234");
        System.out.println("Regisrar asistente en concierto");
        festival.registrarAsistenteConcierto("1111", "2222");
        System.out.println("Listar artista");
        festival.listarArtistas();
        System.out.println("Listar asistente");
        festival.listarAsistente();
        System.out.println("Cargar datos");
        festival.cargarDatos();
        System.out.println("Guardar datos");
        festival.guardarDatos();
        System.out.println("Concetar con la base de datos");
        festival.conectarBBDD();
        System.out.println("Guardar artista Pop");
        festival.guardarArtistasBBDD("Pop");
        System.out.println("Cargar asistentes de la base de datos");
        try {
            festival.cargarAsistentesBBDD("Spain");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Listar artista");
        festival.listarArtistas();
        System.out.println("Listar asistente");
        festival.listarAsistente();
	}

}
