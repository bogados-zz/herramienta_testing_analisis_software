package ar.edu.unlam.analisisSoftware.ehims.main;

import java.io.File;

import ar.edu.unlam.analisisSoftware.ehims.utils.ClaseJava;

public class Main {

	public static void main(String[] args) {
		File file = new File("/home/snoop/greenleave/git/pyme_managment/pyme_managment/pymeManagmentWeb/src/main/java/ar/com/greenleave/pyme_managment/pymeManagmentWeb/controller/GestionPymeController.java");
		ClaseJava claseJava = new ClaseJava(file);
		System.out.println("Lineas comentadas: " + claseJava.getCantidadLineasComentadas());
		System.out.println("Lineas codigo: " + claseJava.getCantidadLineasDeCodigo());
		System.out.println("Lineas en blanco: " + claseJava.getCantidadLineasEnBlanco());
		System.out.println("Lineas cantidad de lineas: " + claseJava.getCantidadDeLineas());
	}

}
