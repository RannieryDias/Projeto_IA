package beans;

import java.io.IOException;
import java.util.Random;

public class Principal {

	public static void main(String[] args) {
		
	}
	public void ImagensAleatórias() throws NumberFormatException, IOException {
		Random gerador = new Random();
		KNN knn = new KNN();
		Imagem[] imgs = new Imagem[7944];
		imgs = knn.LerArquivo();
		
	}
}
	
