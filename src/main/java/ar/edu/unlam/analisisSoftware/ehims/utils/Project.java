package ar.edu.unlam.analisisSoftware.ehims.utils;

public class Project {
	
	private static Project instance;
	
	private Project(){
	}
	
	public static Project getInstance(){
		if(instance == null){
			instance = new Project();
		}
		return instance;
	}
	
	
}
