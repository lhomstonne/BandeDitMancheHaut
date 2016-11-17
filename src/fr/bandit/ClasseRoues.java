package fr.bandit;

public class ClasseRoues {
	
	private Roue roue1 = null;
	private Roue roue2 = null;
	private Roue roue3 = null;
	
	public ClasseRoues(Roue roue1, Roue roue2, Roue roue3){
		this.roue1 = roue1;
		this.roue2 = roue2;
		this.roue3 = roue3;
	}
	
	
	public String getResult(){
		StringBuilder result = new StringBuilder();
		
		result.append(roue1.getRoue());
		result.append(" | ");
		result.append(roue2.getRoue());
		result.append(" | ");
		result.append(roue3.getRoue());
		return result.toString();
	}
	
	

}
