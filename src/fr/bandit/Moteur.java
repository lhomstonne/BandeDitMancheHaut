package fr.bandit;

import java.io.IOException;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class Moteur {
	private float mise;
	
	public void miser() throws IOException, InterruptedException{
		System.out.println("Bonjour et bienvenu ! \n");
		System.out.println("Combien misez vous ?");
		Scanner scan = new Scanner(System.in);
		mise = scan.nextInt();
		System.out.println("Vous avez misé " + mise + " €.");
		Thread.sleep(1000);
		if(mise > 2000){
			System.out.println("Vous êtes un bon richard");
		}else if(mise >=100 && mise<2000){
			System.out.println("Vous êtes un bon richard");
		}else{
			System.out.println(mise + " € ? Vous êtes fort radin sur la monnaie,\nallez mettez en plus, le Seigneur vous voit!");
		}
		Thread.sleep(2500);
		System.out.println("C'est partit !");
		Thread.sleep(700);
		this.game();
	}
	
	
	public void game() throws IOException, InterruptedException{
		Roue roue1 = new Roue();
		Roue roue2 = new Roue();
		Roue roue3 = new Roue();
		
		roue1.setVitesse((int) (Math.random() *200));
		roue2.setVitesse((int) (Math.random() *200));
		roue3.setVitesse((int) (Math.random() *200));
		
		roue1.start();
		roue2.start();
		roue3.start();
		
		ClasseRoues roues = new ClasseRoues(roue1, roue2, roue3);
		
		while(!roue1.isStop() || !roue2.isStop() || !roue3.isStop()){
			ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "Run.bat");
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			
			System.out.println(roues.getResult());
			Thread.currentThread().sleep(100);
		}
		result(roue1.getRoue(), roue2.getRoue(), roue3.getRoue());
	}
	
	
	public void result(int r1, int r2, int r3){
		if(r1 == r2 && r1 == r3){
			System.out.println("\nBingo !!");
			System.out.println("\n Vous avez eu 3 x " + r1 + " au lancé .");
			this.mise = this.mise * 5;
			System.out.println("\nVous remportez " + this.mise + " €.");
		}else if(r1 == r2 || r1 == r3 || r2 == r3){
			System.out.println("\nVous avez gagné ! ");
			this.mise = this.mise * (1.5f);
			System.out.println("\nVous remportez " + this.mise + " €.");
		}else if(r1 != r2 && r2 != r3 && r3 != r1){
			System.out.println("\nDésolé, vous avez perdu!");
			this.mise = this.mise * 0;
			System.out.println("\nL'argent ne tombera pas du ciel cette fois ci. \n");
			System.out.println("Vous remportez " + this.mise + " €.");
		}
		
		this.again();
		
	}
	
	public void again(){
		String yes = "y";
		String no = "n";
		String saisie;
		
		Scanner scann = new Scanner(System.in);
		
		System.out.println("\nVoulez vous retenter votre chance de nouveaux?");
		System.out.println(" [{Oui | Yes} (Y) / (N) {Non | No}]\n");
		saisie = scann.next();
		if(saisie.equals( yes)){
			try {
				this.miser();
			} catch (IOException e) {
	
				e.printStackTrace();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}else if(saisie.equals(no)){
			System.out.println("Merci et a bientôt petit bandit");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.exit(0);
			
		}else{
			System.out.println("Merci et a bientôt petit bandit");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.exit(0);
		}
	}
}

