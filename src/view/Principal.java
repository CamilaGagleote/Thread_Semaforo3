package view;

import java.util.concurrent.Semaphore;
import controller.CavaleiroController;
import controller.AviaoController;
import controller.TriatloController;

public class Principal {

	public static void main(String[] args) {

		int permissao1 = 2;
		Semaphore semaforo1 = new Semaphore(permissao1);
	
		for(int idAviao = 0; idAviao < 12; idAviao++) {
			Thread aviao = new AviaoController(idAviao, semaforo1);
			aviao.start();
		}
//		int permissao2 = 2;
//		Semaphore semaforo2 = new Semaphore(permissao2);
//	
//		for(int idAviao = 0; idAviao < 12; idAviao++) {
//			Thread aviao = new AviaoController(idAviao, semaforo2);
//			aviao.start();
		
//		int permissao3 = 5 ;
//		Semaphore semaforo3 = new Semaphore(permissao3);
//	
//		for(int idAtleta = 0; idAtleta < 25; idAtleta++) {
//			Thread circuito = new TriatloController(idAtleta, semaforo3);
//			circuito.start();
//		}
		
	}
}


