package ar.edu.unlam.analisisSoftware.ehims.utils;

import java.io.File;
import java.util.ArrayList;

public class Project {
	private File carpetaPrincipal;
	private static Project instance;
	ArrayList<ClaseJava> clasesJava;
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
	}
	
}
