package fr.bandit;

import java.util.Scanner;

public class Frein extends Thread{
	private String stop;
	private Roue roue;
	private ClasseRoues classeroues;
	
	public void run(){
		this.decceleration();
	}

	public String getStop() {
		return stop;
	}

	public void setStop(String stop) {
		this.stop = stop;
	}

	public Roue getRoue() {
		return roue;
	}

	public void setRoue(Roue roue) {
		this.roue = roue;
	}

	public ClasseRoues getClasseroues() {
		return classeroues;
	}

	public void setClasseroues(ClasseRoues classeroues) {
		this.classeroues = classeroues;
	}
	
	public void decceleration(){
		while(true){
			System.out.println(classeroues.getResult());
			Scanner scann = new Scanner(System.in);
			String entrer = scann.nextLine();
			if(entrer == stop){
				roue.setFrein(true);
				Thread.currentThread().interrupt();
				break;
			}
		}
	}
}
