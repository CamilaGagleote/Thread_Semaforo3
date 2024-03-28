package controller;

import java.util.concurrent.Semaphore;

public class AviaoController extends Thread {

	private int idAviao;
	private Semaphore semaforo2;
	private int pista ;
	
	public AviaoController(int idAviao, Semaphore semaforo2) {
		this.idAviao = idAviao;
		this.semaforo2 = semaforo2;
	}
	
	public void run() {
		manobra();
		taxiar();
		try {
			semaforo2.acquire();
			decolagem();	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			semaforo2.release();
		}
		afastamento();
	}
	
	private void manobra() {
		int tempo = (int)((Math.random()*401) + 300);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("O aviao #" + idAviao + "demorou " + (tempo * 0.001)  + "s. para manobrar");
		
	}
	private void taxiar() {
		int tempo = (int)((Math.random()*501) + 500);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("O aviao #" + idAviao + "demorou " + (tempo * 0.001) + "s. para taxiar");
	}
	
	//seção crítica
	private void decolagem() {
		int tempo = (int)((Math.random()*201) + 600);
		pista = (int)((Math.random()*1.1) + 1);
		if(pista == 1) {
			System.out.println("O aviao #" + idAviao + " está na pista Norte");
		}
		else {
			System.out.println("O aviao #" + idAviao + " está na pista Sul");
		}
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("O aviao #" + idAviao + "demorou " + (tempo * 0.001)  + "s. para decolar");
	}
	//fim seção crítica
	private void afastamento() {
		int tempo = (int)((Math.random()*401) + 300);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("O aviao #" + idAviao + "demorou " + (tempo * 0.001)  + "s. para afastar");

	}
		
	

}
