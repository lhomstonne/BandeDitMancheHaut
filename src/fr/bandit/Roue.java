package fr.bandit;

public class Roue extends Thread{
	private int roue = 0;
	private int vitesse;
	private final int stop = 500;
	private boolean isStop = false;
	private boolean frein = false;
	
	public void run(){
		this.startRoue();
	}
	
	public Roue(){
		
	}

	public int getRoue() {
		return roue;
	}

	public void setRoue(int roue) {
		this.roue = roue;
	}

	public int getVitesse() {
		return vitesse;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

	public boolean isFrein() {
		return frein;
	}

	public void setFrein(boolean frein) {
		this.frein = frein;
	}

	public boolean isStop() {
		return isStop;
	}

	public void setStop(boolean isStop) {
		this.isStop = isStop;
	}

	public int getStop() {
		return stop;
	}
	
	public int startRoue(){
		while(true){
			roue++;
			if(roue >= 10){
				roue = 0;
			}
			try{
				Thread.currentThread().sleep(vitesse);
				vitesse += 10;
				if(vitesse > stop){
					break;
				}
			}catch(InterruptedException e){
				e.printStackTrace();
				}
		}
		Thread.currentThread().interrupt();
		this.setStop(true);
		return roue;
	}

}
