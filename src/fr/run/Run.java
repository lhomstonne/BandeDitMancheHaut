package fr.run;

import java.io.IOException;

import fr.bandit.Moteur;

public class Run {

	public static void main(String[] args) {
		Moteur moteur = new Moteur();
		try {
			moteur.miser();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

}
