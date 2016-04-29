package ar.edu.unlam.analisisSoftware.ehims.utils;

import java.io.File;
import java.util.ArrayList;

public class Project {
	private File carpetaPrincipal;
	private static Project instance;
	ArrayList<ClaseJava> clasesJava= new ArrayList<ClaseJava>();
	private Project(){
	}
	
	public static Project getInstance(File carpetaPrincipal){
		if(instance == null){
			instance = new Project();
		}
		
		instance.setCarpetaPrincipal(carpetaPrincipal);
		return instance;
	}
	
	private void recorrerCarpetas(File archivoPadre){
		File[] files = archivoPadre.listFiles();
		if(files != null && files.length > 0){
			for(int i=0; i<files.length; i++){
				recorrerCarpetas(files[i]);
			}
		}
		else{
			if(archivoPadre.getName().matches(".*java")){
				clasesJava.add(new ClaseJava(archivoPadre));
			}
		}
		
	}

	public File getCarpetaPrincipal() {
		return carpetaPrincipal;
	}

	public void setCarpetaPrincipal(File carpetaPrincipal) {
		this.carpetaPrincipal = carpetaPrincipal;
		recorrerCarpetas(carpetaPrincipal);
	}

	public Long getCantidadLineasDeCodigo() {
		Long cantidadLineasDeCodigo=0L;
		for (ClaseJava claseJava : clasesJava) {
			cantidadLineasDeCodigo+= claseJava.getCantidadLineasDeCodigo();
		}
		return cantidadLineasDeCodigo;
	}

	public Long getCantidadLineasEnBlanco() {
		Long cantidadLineasEnBlanco = 0L;
		for (ClaseJava claseJava : clasesJava) {
			cantidadLineasEnBlanco+=claseJava.getCantidadLineasEnBlanco();
		}
		return cantidadLineasEnBlanco;
	}

	public Long getCantidadDeLineas() {
		Long cantidadLineas = 0L;
		for (ClaseJava claseJava : clasesJava) {
			cantidadLineas+= claseJava.getCantidadDeLineas();
		}
		return cantidadLineas;
	}

	public Long getCantidadLineasComentadas() {
		Long cantidadDeLineasComentadas = 0L;
		for (ClaseJava claseJava : clasesJava) {
			cantidadDeLineasComentadas+= claseJava.getCantidadLineasComentadas();
		}
		return cantidadDeLineasComentadas;
	}
	
}
